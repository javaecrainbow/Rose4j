package com.rose4j.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class HandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		String url = request.getRequestURI();
//		if(url.endsWith("logon"))
//			return true;
//		
//		response.sendRedirect(request.getContextPath() + "/screen/logon.jsp");	
		return true;
			
	}
	
}
