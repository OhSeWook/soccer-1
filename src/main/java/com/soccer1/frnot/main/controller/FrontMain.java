package com.soccer1.frnot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontMain {
	
	@RequestMapping(value = "/user/user", method = RequestMethod.GET)
	public String user(ModelAndView mv) {
		return "user/user";
	}
	
	
}
