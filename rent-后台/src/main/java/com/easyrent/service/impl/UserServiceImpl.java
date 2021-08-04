package com.easyrent.service.impl;

import com.easyrent.mapper.RealnameinformationMapper;
import com.easyrent.mapper.UserMapper;
import com.easyrent.pojo.*;
import com.easyrent.service.UserService;
import com.easyrent.utils.AccountGenerateUtils;
import com.easyrent.utils.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easyrent.pojo.UserExample.Criteria;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    private RealnameinformationMapper realnameinformationMapper;
    /**
     * 用户登录
     * @param account 账号
     * @param password 密码
     * @return
     */
    @Override
    public UserLoginResult login(String account, String password ,HttpServletResponse response) {
        UserLoginResult userLoginResult =new UserLoginResult();
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        if (account.length()==11){
            criteria.andCellphoneEqualTo(account);
        }else
        {
            criteria.andAccountEqualTo(account);
        }
        criteria.andPasswordEqualTo(password);
        List<User> result = userMapper.selectByExample(userExample);
      if (result.size()==0){
          userLoginResult.setMessage("账号或密码不正确");
          userLoginResult.setStatus("401");
      }else if (result.size()>1){
          userLoginResult.setMessage("服务器异常");
          userLoginResult.setStatus("500");
      }else if (result.get(0).getJuisdiction()==2){
          userLoginResult.setMessage("账号或密码不正确");
          userLoginResult.setStatus("401");
      }
      else if (result.get(0).getJuisdiction()==1){

          userLoginResult.setMessage("该账号已被冻结");
          userLoginResult.setStatus("401");
      }
     else
          {
          userLoginResult.setMessage("登录成功");
          userLoginResult.setStatus("200");
          Cookie cookie = new Cookie("account",result.get(0).getAccount());
          cookie.setMaxAge(1000);
          response.addCookie(cookie);
          userLoginResult.setData((User)result.get(0));
          String s1 = RsaUtils.generateKey();
          Cookie cookie1 = new Cookie("token",s1);
          cookie1.setMaxAge(30*60);
          response.addCookie(cookie);
          userLoginResult.setToken(s1);
      }
      return userLoginResult;
    }

    /**
     * 用户注册
     * @param user 用户信息
     * @param realnameinformation 实名认证信息
     * @return
     */
    @Override
    public UserRegisterRessult register(User user, Realnameinformation realnameinformation) {
        UserRegisterRessult userRegisterRessult = new UserRegisterRessult();
        user.setJuisdiction(0);
        user.setCreatetime(new Date());
        String account= AccountGenerateUtils.account(10);
        realnameinformation.setAccount(account);
        user.setAccount(account);
        int insert = userMapper.insert(user);
        if (insert==1){
            userRegisterRessult.setAccount(user.getAccount());
            userRegisterRessult.setMessage("注册成功");
            userRegisterRessult.setStatus("201");
        }
        realnameinformationMapper.insert(realnameinformation);
        return userRegisterRessult;
    }

    /**
     * 根据account查找用户
     * @param account 账号
     * @return
     */
    @Override
    public UserLoginResult selectByAccount(String account) {
        UserLoginResult userLoginResult =new UserLoginResult();
        User user = null;
        user = userMapper.selectByPrimaryKey(account);
        if (user==null){
            userLoginResult.setMessage("服务器异常");
            userLoginResult.setStatus("500");
        }else{
            userLoginResult.setMessage("查询成功");
            userLoginResult.setStatus("200");
            userLoginResult.setData(user);
        }

        return userLoginResult;
    }
}
