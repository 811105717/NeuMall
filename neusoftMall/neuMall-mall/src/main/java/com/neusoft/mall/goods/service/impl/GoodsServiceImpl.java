package com.neusoft.mall.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.StringUtil;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.goods.entity.Goods;
import com.neusoft.mall.goods.entity.GoodsPic;
import com.neusoft.mall.goods.entity.param.*;
import com.neusoft.mall.goods.entity.returnParam.GoodsReturn;
import com.neusoft.mall.goods.mapper.GoodsMapper;
import com.neusoft.mall.goods.mapper.GoodsPicMapper;
import com.neusoft.mall.goods.service.GoodsService;
import com.neusoft.mall.goods.util.FastDFSFile;
import com.neusoft.mall.goods.util.FastDfsUtil;
import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsPicMapper goodsPicMapper;
    @Autowired
    private RedisUtil<CustomerInfo> redisUtil;
    @Value("${fdfs.racker_server}")
    private String serverFdfs;


    /**
     * 添加商品
     *  分段添加数据库，
     *      先添加到商品图片表，然后添加商品
     * @param addGoods 前台传递添加商品的参数
     * @return 添加条数
     */
    @Override
    public AppResponse addGoods(AddGoods addGoods) {
        CustomerInfo currCustomer = redisUtil.getData(addGoods.getCustomer().getTokenFront());
        String user=currCustomer.getCustomerId();
        int retGoodPics = 0,retGoods;
        Goods goods=changeAddGoodsProperty(addGoods,user);
        if(addGoods.getPictureList()!=null){
            List<GoodsPic> pic=setAddGoodsPicList(addGoods.getPictureList(),user,goods);
            goods.setCommodityFirstPicture(pic.get(0).getPictureAddress());
            retGoodPics=goodsPicMapper.insertGoodsPics(pic);
        }
        retGoods=goodsMapper.insertSelective(goods);
        if (retGoods!=0){
            return AppResponse.success("添加商品成功","goods:"+retGoods+"   goodsPic:"+retGoodPics);
        }
        return AppResponse.bizError("添加商品失败");
    }
    /*

     */

    /**
     *  修改商品信息
     *      先删除图片对应 商品所有图片，然后重新添加
     * @param alterGoods 客户端传递修改商品的参数
     * @return 更改条数
     */
    @Override
    public AppResponse AlterGoods(AlterGoods alterGoods) {
        CustomerInfo currCustomer = redisUtil.getData(alterGoods.getCustomer().getTokenFront());
        String user=currCustomer.getCustomerId();
        int retGoods,retGoodPics = 0;
        Goods temGoods=goodsMapper.selectByPrimaryKey(alterGoods.getCommodityId());
        if (temGoods == null) {
            return AppResponse.bizError("修改商品失败，没有指定商品");
        }
        Goods goods=changeAlterGoodsProperty(alterGoods,user);

        if (alterGoods.getPictureList()!=null){
            //暴利删除所有对应图片
            for (int i=0;i<alterGoods.getPictureList().size();i++){
                goodsPicMapper.deleteByCommodityId(alterGoods.getCommodityId());
            }
            for (int i=0;i<alterGoods.getPictureList().size();i++){
                    GoodsPic goodsPic=setAddGoodsPic(alterGoods.getPictureList().get(i),user,goods);
                    goodsPicMapper.insertSelective(goodsPic);
                    retGoodPics++;
            }
            if (!(alterGoods.getPictureList().isEmpty())){
                goods.setCommodityFirstPicture(alterGoods.getPictureList().get(0).getPictureAddress());
            }
        }
        retGoods=goodsMapper.updateByPrimaryKeySelective(goods);
        if (retGoods!=0){
            return AppResponse.success("修改商品成功","goods:"+retGoods+"   goodsPic:"+retGoodPics);
        }
        return AppResponse.bizError("修改商品失败");
    }

    /**
     *  更新对应商品删除栏位
     * @param commodityId 商品id
     * @return 更新条数
     */
    @Override
    public AppResponse deleteGoods(String commodityId) {
        int ret=goodsMapper.deleteGoods(commodityId);
        if (ret!=0){
            return AppResponse.success("删除商品成功！",ret);
        }
        return AppResponse.bizError("删除商品失败");
    }

    /**
     * 更新商品上架与下架
     * @param params 商品上架下架参数
     * @return 更新条数
     */
    @Override
    public AppResponse updateGoodsIsSell(UpdateIsSell params) {
        CustomerInfo currCustomer = redisUtil.getData(params.getCustomer().getTokenFront());
        String user=currCustomer.getCustomerId();
        Goods goods=new Goods();
        goods.setCommodityId(params.getCommodityId());
        goods.setCommodityIsSold(params.getCommodityIsSold());
        goods.setVersion(params.getVersion());
        goods.setLastModifiedBy(user);
        goods.setGmtModified(new Date());
        int ret=goodsMapper.updateByPrimaryKeySelective(goods);
        if (ret!=0){
            return AppResponse.success("上架/下架成功",ret);
        }
        return AppResponse.bizError("上架/下架失败");
    }

    /**
     * 单个商品的详细信息
     * @param commodityId 商品id
     * @return 单个商品信息
     */
    @Override
    public GoodsReturn getGoodsDetail(String commodityId) {
        GoodsReturn ret=goodsMapper.selectGoodsById(commodityId);
        return ret;
    }

    /**
     * 分页获取商品列表
     * @param pageParam 分页参数
     * @return 分页的商品列表
     */
    @Override
    public PageVo<Goods> getGoodsPage(getGoodsPageParam pageParam) {
        PageVo<Goods> goodsPageVo=new PageVo<>();
        PageHelper.offsetPage((pageParam.getPageNum()-1) * pageParam.getPageSize(),pageParam.getPageSize());
        List<Goods> goodsList=goodsMapper.getGoodsPage(pageParam);
        PageInfo<Goods> pageInfo=new PageInfo<>(goodsList);
        goodsPageVo.setTotalRecords((int) pageInfo.getTotal());
        goodsPageVo.setList(goodsList);
        return goodsPageVo;
    }


    /**
     * 上传图片
     * @param param 图片参数
     * @return 图片地址
     */
    @Override
    public Map<String, String> uploadFile(Map<String, Object> param) {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("code", "0");//1成功
        try {
            String url = "";
            FastDFSFile fastDFSFile = new FastDFSFile();
            MultipartFile multipartFile[] = (MultipartFile[]) param.get("files");
            for (int i = 0; i < multipartFile.length; i++) {
                FastDFSFile file = new FastDFSFile();
                file.setAuthor("authorStt");
                String ext = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".") + 1);
                file.setContent(multipartFile[i].getBytes());
                file.setName(multipartFile[i].getOriginalFilename());
                file.setExt(ext);
                String filePath[] = FastDfsUtil.upload(file);
                resultMap.put("fileUrl", serverFdfs + filePath[0] + "/" + filePath[1]);
                //url =
                System.out.println(filePath);
            }
        } catch (Exception e) {
            resultMap.put("code", "1");//0失败
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 将客户端添加的商品参数转换成商品实体
     * @param addGoods
     * @param user
     * @return
     */
    private Goods changeAddGoodsProperty(AddGoods addGoods,String user){
        Goods goods=new Goods();
        BeanUtils.copyProperties(addGoods,goods);
        goods.setCommodityId(UUIDUtil.uuidStr());
        goods.setCommodityCode(StringUtil.initNo());
        goods.setCommodityIsRecommend(0);
        goods.setCreatedBy(user);
        goods.setGmtCreate(new Date());
        goods.setLastModifiedBy(user);
        goods.setGmtModified(new Date());
        goods.setIsDeleted(0);
        goods.setSortNo(1);
        goods.setVersion(1);
        goods.setCommodityIsLack(0);
        goods.setCommodityTotalcount(0);
        return goods;
    }
    /**
     * 将客户端修改的商品参数转换成商品实体
     * @param alterGoods
     * @param user
     * @return
     */
    private Goods changeAlterGoodsProperty(AlterGoods alterGoods,String user){
        Goods goods=new Goods();
        BeanUtils.copyProperties(alterGoods,goods);
        goods.setLastModifiedBy(user);
        goods.setGmtModified(new Date());
        return goods;
    }

    /**
     * 设置添加商品图片参数
     * @param pic
     * @param user
     * @param goods
     * @return
     */
    private List<GoodsPic> setAddGoodsPicList(List<PictureParam> pic,String user,Goods goods){
        Random random=new Random();
        List<GoodsPic> goodsPics=new ArrayList<>();
        for (int i=0;i<pic.size();i++){
            GoodsPic goodsPic=new GoodsPic();
            BeanUtils.copyProperties(pic.get(i),goodsPic);
            goodsPic.setPictureId(random.nextInt(Integer.MAX_VALUE ));
            goodsPic.setCommodityId(goods.getCommodityId());
            goodsPic.setCreatedBy(user);
            goodsPic.setGmtCreate(new Date());
            goodsPic.setLastModifiedBy(user);
            goodsPic.setGmtModified(new Date());
            goodsPic.setIsDeleted(0);
            goodsPic.setSortNo(1);
            goodsPic.setVersion(1);
            goodsPics.add(goodsPic);
        }
        return goodsPics;
    }

    /**
     * 单个设置图片参数
     * @param pic
     * @param user
     * @param goods
     * @return
     */
    private GoodsPic setAddGoodsPic(PictureParam pic, String user, Goods goods){
        Random random=new Random();//随机生成图片id
        GoodsPic goodsPic=new GoodsPic();
        BeanUtils.copyProperties(pic,goodsPic);
        goodsPic.setPictureId(random.nextInt(Integer.MAX_VALUE ));
        goodsPic.setCommodityId(goods.getCommodityId());
        goodsPic.setCreatedBy(user);
        goodsPic.setGmtCreate(new Date());
        goodsPic.setLastModifiedBy(user);
        goodsPic.setGmtModified(new Date());
        goodsPic.setIsDeleted(0);
        goodsPic.setSortNo(1);
        goodsPic.setVersion(1);
        return goodsPic;
    }
}
