package com.neusoft.mall.category.service.impl;

import com.neusoft.common.entity.UserInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.UUIDUtil;
import com.neusoft.mall.category.entity.Category;
import com.neusoft.mall.category.entity.ReturnParam.Tree;
import com.neusoft.mall.category.entity.param.AddCategory;
import com.neusoft.mall.category.entity.param.DeleteCategory;
import com.neusoft.mall.category.entity.param.UpdateCategory;
import com.neusoft.mall.category.mapper.CategoryMapper;
import com.neusoft.mall.category.service.CategoryService;
import com.neusoft.mall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisUtil<UserInfo> redisUtil;
    @Value("${rootId}")
    private String rootId;


    /**
     * 判断分类名重复，不可以添加，
     * 先查询父级分类有没有，没有不可以，
     * @param record Category类型
     * @return
     */
    @Override
    public AppResponse addCategory(AddCategory  record) {
         UserInfo currCustomer = redisUtil.getData(record.getTokenBackend());
        if(null == currCustomer){
            return AppResponse.bizError("token 失效");
        }
        String username=currCustomer.getUserName();
        Category category=new Category();
        category.setCategoryId(UUIDUtil.uuidStr());
        category.setCategoryName(record.getCategoryName());
        category.setCategoryTreeCode("00");
        category.setCreatedBy(username);
        category.setGmtCreate(new Date());
        category.setLastModifiedBy(username);
        category.setGmtModified(new Date());
        category.setCategoryParentId(record.getCategoryParentId());
        category.setCategoryRemark(record.getCategoryRemark());
        category.setIsDeleted(0);
        category.setSortNo(record.getSortNo());
        category.setVersion(record.getVersion());
        List<Category> name=categoryMapper.getCategoryName(category.getCategoryName());
        if (!(name.isEmpty())){
            return AppResponse.versionError("插入失败,分类名称重复");
        }
        if (!(category.getCategoryParentId().equals("0"))){
            Category parent=categoryMapper.getCategoryParent(category.getCategoryParentId());
            if (parent==null){
                return AppResponse.versionError("插入失败,没有对应父类");
            }
        }
        int res=categoryMapper.insertSelective(category);
        return AppResponse.success("插入成功",res);
    }

    /**
     * 更新分类信息
     *   如果更新数据库失败返回失败信息
     * @param record
     * @return
     */
    @Override
    public AppResponse updateCategory(UpdateCategory record) {
        UserInfo currCustomer = redisUtil.getData(record.getTokenBackend());
        if(null == currCustomer){
            return AppResponse.bizError("token 失效");
        }
        String user=currCustomer.getUserName();//session获取
        Category category=new Category();
        category.setVersion(record.getVersion());
        category.setCategoryName(record.getCategoryName());
        category.setCategoryId(record.getCategoryId());
        category.setCategoryRemark(record.getCategoryRemark());
        category.setSortNo(record.getSortNo());
        category.setLastModifiedBy(user);
        category.setGmtModified(new Date());
        int ret=categoryMapper.updateByPrimaryKeySelective(category);
        if (ret!=0){
            return AppResponse.success("更新分类成功",ret);
        }
        return AppResponse.bizError("更新分类失败");
    }
    /**
     *  删除分类，
     *      根据id更新删除栏位
     * @param record 包含主键id，后端token
     * @return
     */
    @Override
    public AppResponse deleteCategory(DeleteCategory record) {
        UserInfo currCustomer = redisUtil.getData(record.getTokenBackend());
        if(null == currCustomer){
            return AppResponse.bizError("token 失效");
        }
        String user=currCustomer.getUserName();//session获取
        Category category=new Category();
        category.setLastModifiedBy(user);
        category.setGmtModified(new Date());
        category.setCategoryId(record.getCategoryId());
        int ret=categoryMapper.deleteByPrimaryKey(category);
        if (ret!=0){
            return AppResponse.success("删除操作成功",ret);
        }
        return AppResponse.bizError("删除操作失败");
    }


    /**
     * 查询所有商品分类信息，并且返回树状信息
     * @return 树状信息
     */
    @Override
    public Tree getCategory() {
        List<Category> categoryList=categoryMapper.getCategory();
        Tree tree=new Tree();
        init(categoryList,tree,rootId);
        return tree;
    }

    /**
     *   私有方法
     *      初始化自定义生成树
     * @param categoryList 原始数据
     * @param Tree  接受返回的树
     * @param rootId  根节点
     */
    private void init(List<Category> categoryList,Tree Tree,String rootId){
        Iterator<Category> Iterator=categoryList.iterator();
        Tree rootTree =null;
        while (Iterator.hasNext()){
            Category temp=Iterator.next();
            if (temp.getCategoryParentId().equals(rootId)){
                rootTree=new Tree();
                CategoryToTree(temp,rootTree);
                Tree.getChildren().add(rootTree);
            }else {
                Iterator<Tree> it=Tree.getChildren().iterator();
                while (it.hasNext()){
                    Tree tempCate=it.next();
                    if (tempCate.getId().equals(temp.getCategoryParentId())){
                        Tree childTree=new Tree();
                        CategoryToTree(temp,childTree);
                        tempCate.getChildren().add(childTree);
                    }
                }


            }
        }
    }

    /**
     *  私有方法
     *      将单个分类类型添加到树中
     * @param category 单个分类
     * @param tree  父级树
     */
    private void CategoryToTree(Category category,Tree tree){
        tree.setId(category.getCategoryId());
        tree.setLabel(category.getCategoryName());
        tree.setAttributes(category);
        tree.setCcpid(category.getCategoryParentId());
        tree.setType(category.getCategoryLevel());
    }
}
