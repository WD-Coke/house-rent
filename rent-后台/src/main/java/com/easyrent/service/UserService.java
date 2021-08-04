package com.easyrent.service;

import com.easyrent.pojo.Realnameinformation;
import com.easyrent.pojo.User;
import com.easyrent.pojo.UserLoginResult;
import com.easyrent.pojo.UserRegisterRessult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    public UserLoginResult login(String account, String password ,HttpServletResponse  response);
    public UserRegisterRessult register(User user,Realnameinformation realnameinformation);
    public UserLoginResult selectByAccount(String account);
}
