package com.sample.restapi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sample.restapi.utils.AccessDeniedException;
import com.sample.restapi.utils.JwtUtils;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	
	@Autowired
	JwtUtils jwtutil;

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
	    // your code
		
		System.out.print("JwtInterceptor called......."+request.getRequestURI());
		
		if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("register")))
			{
				String Token=request.getHeader("Authorization");
				if(Token !=null && !Token.isEmpty()) {
					jwtutil.validate(Token);
				}else {
					throw new AccessDeniedException("please send bearer token in header,'Authorization':'bearer your_token'");
				}
			}
		
	    return true; 
	}
}
