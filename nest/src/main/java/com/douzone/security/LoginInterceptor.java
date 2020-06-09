package com.douzone.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.nest.PathSetting;
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// System.out.println("로그인!?");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		vo.setUserPassword(password);
		
		UserVo authUser = userService.getUser(vo);
		if(authUser == null) {
			// System.out.println("로그인 실패");
//			request.setAttribute("userVo", vo);
			response.sendRedirect(PathSetting.PATH_AND_PORT+"?error");
			return false;
		}
		
		
		// session 처리
//		HttpSession session = request.getSession(true);
//		session.setAttribute("authUser", authUser);
//		session.setAttribute("authUserNo", authUser.getUserNo());
//		session.setAttribute("authUserEmail", authUser.getUserEmail());
//		session.setAttribute("authUserName", authUser.getUserName());
//		session.setAttribute("authUserPhoto", authUser.getUserPhoto());
//		session.setAttribute("authUserBg", authUser.getUserBg());
		response.sendRedirect(PathSetting.PATH_AND_PORT+"/dashboard");
		return false;
	}

}
