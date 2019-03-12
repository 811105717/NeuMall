package com.stt.gradletest.user.controller;

import com.stt.gradletest.user.model.CustVo;
import com.stt.gradletest.user.model.UserVo;
import com.stt.gradletest.user.service.UserService;
import com.stt.gradletest.util.file.FastDFSFile;
import com.stt.gradletest.util.file.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${NAME}")
    private String name;
    @Value("${CONTENT}")
    private String content;

    @Value("${cust.content}")
    private String contenttwo;
    //属性封装到对象中提取
    @Autowired
    private CustVo custVo;

    @RequestMapping(value = "hello" , method = RequestMethod.GET)
    public String hello(){
        return  "Hello SpringBoot !"+name;
    }

    @RequestMapping(value = "helloMan" , method = RequestMethod.GET)
    public String helloMan(){
        return  content;
    }

    @RequestMapping(value = "helloWomanContent" , method = RequestMethod.GET)
    public String helloWomanContent(){
        return  contenttwo;
    }

    @RequestMapping(value = "helloWoman" , method = RequestMethod.GET)
    public CustVo helloWoman(){
        return custVo;
    }

    /**
     * 部门：南京软件研发中心
     * 功能：查询用户列表
     * 描述：略
     * 作成者：盛婷婷
     * 作成时间：2019/3/4
     */
    @RequestMapping("/userList")
    public Map<String,Object> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping(value = "getUserListById" , method = RequestMethod.GET)
    public List<Map<String,Object>> getUserListById(@RequestParam("id") String id){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        param.put("name",name);
        return userService.getUserListById(param);
    }

    @RequestMapping(value = "getUserListByModel" , method = RequestMethod.GET)
    public List<UserVo> getUserListByModel(UserVo userVo){
        userVo.setUserName(name);
        return userService.getUserListByModel(userVo);
    }

    /**
     * 部门：南京软件研发中心
     * 功能：略 fast DFS
     * 描述：略
     * 作成者：祁晨康
     * 作成时间：2019/2/22 16:54
     */
    @RequestMapping("/uploadFile")
    public  void uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){
        try {
            FastDFSFile file=new FastDFSFile();
            //Map<String,String> loginUser = (Map<String, String>)request.getSession().getAttribute(GlobalConstant.LOGIN_USER);
            file.setAuthor("authorStt");

            String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1);
            file.setContent(multipartFile.getBytes());
            file.setName(multipartFile.getOriginalFilename());
            file.setExt(ext);
            String filePath[]= FastDfsUtil.upload(file);
            System.out.println(filePath[0]+" AND "+filePath[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/downLoadFile")
    public ResponseEntity<byte[]> downLoadFile(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpHeaders headers = new HttpHeaders();
            FastDFSFile file=new FastDFSFile();
            //Map<String,String> loginUser = (Map<String, String>)request.getSession().getAttribute(GlobalConstant.LOGIN_USER);
            file.setAuthor("authorStt");
            //FastDfsUtil.downFile("group1","M00/00/00/wKiAgFx--_KAJnD2AABOsY4GRK8481.jpg");
            byte[] io=FastDfsUtil.downByte("group1","M00/00/00/wKiAgFx--_KAJnD2AABOsY4GRK8481.jpg");
            headers.setContentDispositionFormData("attachment",  new String("test".getBytes("UTF-8"),"iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(io, headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/uploadTest")
    public Map<String,String> uploadTest(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile multipartFile[]) throws Exception {
        try{
            Map<String, Object> param = new HashMap<>();
            param.put("files",multipartFile);
            Map<String,String> resultParam = userService.uploadTest(param,request);
            return resultParam;
        }catch(Exception e){
            throw new Exception(this.getClass()+"updateApplyPass() Exception:"+e);
        }
    }

}
