package com.hc.cn.controller;
import com.hc.cn.entity.User;
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

import java.util.List;

@Controller
public class UserInfoController {
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
		mav.setViewName("index");
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
			List<User> userlist = userRepository.findByUserName(username);
			if (userlist.size()>0){
				mav.setViewName("error");
				return mav;
			}
			User user = new User();
			user.setUserName(username);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String pass = passwordEncoder.encode(password);

			user.setPassword(password);
			userRepository.save(user);

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