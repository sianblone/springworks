package com.biz.sec.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/admin")
@Controller
public class AdminController {
	
	private final UserService userSvc;
	
	//@ResponseBody
	@RequestMapping(value="", method=RequestMethod.GET)
	public String admin() {
		return "admin/admin_main";
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET)
	public String user_list(Model model) {
		List<UserDetailsVO> userList = userSvc.selectAll();
		
		model.addAttribute("USER_LIST", userList);
		return "admin/user_list";
	}
	
	@RequestMapping(value="/user_detail_view/{username}", method=RequestMethod.GET)
	public String user_detail_view(@PathVariable("username")String username, Model model) {
		UserDetailsVO userVO = userSvc.findByUserName(username);
		model.addAttribute("USER_VO", userVO);
		return "admin/user_detail_view";
	}
	
	@RequestMapping(value="/user_detail_view", method=RequestMethod.POST)
	public String mypage(UserDetailsVO userVO, String[] auth, Model model) {
		
		int ret = userSvc.updateInfo(userVO, auth);
		
		return "redirect:/admin/user_detail_view/" + userVO.getUsername();
	}

}
