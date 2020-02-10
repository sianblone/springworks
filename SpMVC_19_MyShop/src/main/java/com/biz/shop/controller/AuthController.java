package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="auth/test", method=RequestMethod.GET)
	public String test() {
		return "auth/test";
	}

}
