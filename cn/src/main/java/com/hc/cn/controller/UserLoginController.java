package com.hc.cn.controller;

import com.hc.cn.entity.User;
import com.hc.cn.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserLoginController {

    @Resource
    UserRepository userLoginDAO;

    @RequestMapping("/userLogin")
    @ResponseBody
    public String login(String userName, String password){
        if (userName==null || password == null || "".equals(userName.trim()) || "".equals(password.trim())){
            return "noright";
        }
        List<User> userList = userLoginDAO.findByLoginName(userName);
        /*String result = "";
        Iterable<UserLogin> it = userLoginDAO.findAll();
        for(UserLogin ul:it){
            result += ul.getLogin_name();
        }*/

        if(userList==null || userList.get(0) ==  null )
        {
            return "noright";
        }
         User user = userList.get(0);
         if (password.equals(user.getLoginPassword()))
        {
         return "/upload";
        }
        return "noright";
    }

}