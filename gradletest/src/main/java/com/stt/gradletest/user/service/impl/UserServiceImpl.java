package com.stt.gradletest.user.service.impl;

import com.stt.gradletest.user.dao.UserDao;
import com.stt.gradletest.user.model.UserVo;
import com.stt.gradletest.user.service.UserService;
import com.stt.gradletest.util.file.FastDFSFile;
import com.stt.gradletest.util.file.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Value("${fdfs.racker_server}")
    private String serverFdfs;
    @Autowired
    private UserDao userdao;
    @Override
    public Map<String, Object> getUserList() {
        return userdao.getUserList();
    }

    @Override
    public List<Map<String, Object>> getUserListById(Map<String, Object> param) {
        return userdao.getUserListById(param);
    }

    @Override
    public List<UserVo> getUserListByModel(UserVo userVo) {
        return userdao.getUserListByModel();
    }

    @Override
    public Map<String, String> uploadTest(Map<String, Object> param, HttpServletRequest request) {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("code","1");//1成功
        try {
            String url= "";
            FastDFSFile fastDFSFile=new FastDFSFile();
            MultipartFile multipartFile[]=(MultipartFile[])param.get("files");
            for(int i=0;i<multipartFile.length;i++){
                FastDFSFile file=new FastDFSFile();
                file.setAuthor("authorStt");
                String ext = multipartFile[i].getOriginalFilename().substring(multipartFile[i].getOriginalFilename().lastIndexOf(".")+1);
                file.setContent(multipartFile[i].getBytes());
                file.setName(multipartFile[i].getOriginalFilename());
                file.setExt(ext);
                String filePath[]= FastDfsUtil.upload(file);
                resultMap.put("fileUrl",serverFdfs+filePath[0]+"/"+filePath[1]);
                //url =
                System.out.println(filePath);
            }
        }catch (Exception e){
            resultMap.put("code","0");//0失败
            e.printStackTrace();
        }
        return resultMap;
    }
}
