package com.easyrent.controller;

import com.easyrent.pojo.Realnameinformation;
import com.easyrent.pojo.User;
import com.easyrent.pojo.UserLoginResult;
import com.easyrent.pojo.UserRegisterRessult;
import com.easyrent.service.UserService;
import com.easyrent.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户账号相关
 */
@Controller
public class UserController {
    @Autowired
    public UserService userService;

    /**
     * 用户登录
     * @param account 账号
     * @param password 密码
     * @param response
     * @return
     */
   @PostMapping("/login")
    @ResponseBody()
    public UserLoginResult login(@RequestParam("account") String account,@RequestParam("password")  String password, HttpServletResponse response){
        UserLoginResult login = userService.login(account, password,response);
        return login;
    }

    /**
     * 用户注册
     * @param user 用户信息
     * @param realnameinformation 实名信息
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public UserRegisterRessult register(User user, Realnameinformation realnameinformation){
        return  userService.register(user,realnameinformation);
    }

    /**
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/uploadfile")
    @ResponseBody
    public String upload(MultipartFile[] file, HttpServletRequest request){
       String path =  request.getSession().getServletContext().getRealPath("/upload");
        FileUploadUtils.upload(path,file,null);
        return "/upload/"+file[0].getOriginalFilename();
    }

}
