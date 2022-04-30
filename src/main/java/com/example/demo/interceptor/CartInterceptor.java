package com.example.demo.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class CartInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object Handler) throws IOException {
		String referer = request.getHeader("referer");
		if(referer==null) {
			response.sendRedirect("/homepage");
			return false;
		}
		return true;
		
	}
}
