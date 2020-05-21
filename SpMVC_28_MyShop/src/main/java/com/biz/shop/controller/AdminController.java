package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String admin() {
		return "admin/admin_main";
	}
	
}
