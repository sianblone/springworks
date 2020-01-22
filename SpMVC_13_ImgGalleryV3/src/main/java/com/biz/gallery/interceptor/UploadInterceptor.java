package com.biz.gallery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UploadInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession httpSession = request.getSession();
		Object memberVO = httpSession.getAttribute("MEMBER");
		if(memberVO == null) {
			request.setAttribute("MODAL", "LOGIN");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

	

	
	
}
