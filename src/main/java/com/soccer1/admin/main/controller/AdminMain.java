package com.soccer1.admin.main.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soccer1.member.entity.User;

@Controller
public class AdminMain {

	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String adminMain(ModelAndView mv) {
		return "admin/index";
	}
	
	@RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
	public String dashboard(ModelAndView mv, @AuthenticationPrincipal User memberVO) {
		return "admin/dashboard";
	}
	
	
}
