package com.hc.cn.controller;

/**
 * Created by Charlie on 2017-07-12.
 */

import com.hc.cn.config.WebSecurityConfig;
import com.hc.cn.entity.User;
import com.hc.cn.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Resource
    UserRepository userLoginDAO;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "app/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/loginPost")
    public @ResponseBody
    Map<String, Object> loginPost(String username, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if (username==null || password == null || "".equals(username.trim()) || "".equals(password.trim())){
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }
        List<User> userList = userLoginDAO.findByLoginName(username);
        /*String result = "";
        Iterable<UserLogin> it = userLoginDAO.findAll();
        for(UserLogin ul:it){
            result += ul.getLogin_name();
        }*/

        if(userList==null || userList.get(0) ==  null )
        {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }
        User user = userList.get(0);
        if (password.equals(user.getLoginPassword()))
        {
            // 设置session
            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);

            map.put("success", true);
            map.put("message", "登录成功");
        }
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

}
