package com.hc.cn.controller;
import com.hc.cn.entity.Role;
import com.hc.cn.entity.User;
import com.hc.cn.repository.RoleRepository;
import com.hc.cn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hc.cn.service.IUserService;

import java.util.*;

@Controller

public class UserInfoController {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	IUserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private IUserService userInfoService;
	@GetMapping("login")
	public ModelAndView login() {
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("login");
		    return mav;
    }
    @PostMapping("loginPost")
	public ModelAndView loginPost() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upload");
		return mav;
	}

	@GetMapping("signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		return mav;
	}
	@PostMapping("signup")
	public ModelAndView signupPost(String username,String password) {
		ModelAndView mav = new ModelAndView();
		if (null != username && password!=null && !username.trim().equals("") && !password.trim().equals("")){
			User user = userRepository.findByUsername(username);
			if (user != null){
				mav.setViewName("error");
				return mav;
			}
			User usernew = new User();
			usernew.setUsername(username);
			usernew.setPassword(bCryptPasswordEncoder.encode(password));
            usernew.setRoles(new HashSet<>(roleRepository.findAll()));
			userRepository.save(usernew);
			mav.setViewName("login");
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}
	@GetMapping("secure/article-details")
	public ModelAndView getAllUserArticles() {
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("userArticles", userInfoService.getAllUserArticles());
		    mav.setViewName("uploadForm");
		    return mav;
    }
	@GetMapping("error")
	public ModelAndView error() {
		    ModelAndView mav = new ModelAndView();
		    String errorMessage= "You are not authorized for the requested data.";
		    mav.addObject("errorMsg", errorMessage);
		    mav.setViewName("403");
		    return mav;
    }		
} 