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
import org.springframework.stereotype.Controller;
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

@Controller
public class UploadController {

    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public String getIndex(){
        return "uploadTest";
    }

}
