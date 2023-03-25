package com.soccer1.user.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soccer1.user.entity.User;
import com.soccer1.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserContorller {

	private UserService userSerivce;
	
	@RequestMapping(value = "/user/get", method = RequestMethod.GET)
	public void userGet(ModelAndView mv) {
		userSerivce.loadUserByUsername("");
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public void userAdd(ModelAndView mv, @AuthenticationPrincipal User memberVO) {
		userSerivce.loadUserByUsername("");
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public void userSave(ModelAndView mv, @AuthenticationPrincipal User memberVO) {
		userSerivce.loadUserByUsername("");
	}
	
	
}
