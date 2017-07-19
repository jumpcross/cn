package com.hc.cn.controller;

import com.hc.cn.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@Autowired
	private IUserInfoService userInfoService;
	@GetMapping("app-login")
	public ModelAndView login() {
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("test");
		    return mav;
    }	

} 