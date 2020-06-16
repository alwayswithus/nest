package com.douzone.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.nest.PathSetting;
import com.douzone.nest.vo.UserVo;

public class LogoutInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		HttpSession session = request.getSession();
		
		System.out.println("로그아웃!");
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser!=null){
			System.out.println("세션제거...");
			
			session.removeAttribute("authUser");
			session.invalidate();
		}
		response.sendRedirect(PathSetting.PATH_AND_PORT+"/");
		
		return false;
	}
}