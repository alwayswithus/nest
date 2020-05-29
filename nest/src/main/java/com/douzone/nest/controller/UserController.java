package com.douzone.nest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.nest.PathSetting;
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인...
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	
	// 비밀번호 찾기
	@RequestMapping("/pwfind")
	public void pwFind() {
		//return "index";
	}
	
	// 회원 가입
	@RequestMapping("/signup")
	public void signUp() {
		//return "index";
	}
	
	// 
	@PostMapping("/auth")
	public String auth(HttpServletRequest request, HttpServletResponse response){
		System.out.println("로그인 시도중... auth..!");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		vo.setUserPassword(password);
		
		UserVo authUser = userService.getUser(vo);
		if(authUser == null) {
			request.setAttribute("userVo", vo);
			//response.sendRedirect(request.getContextPath()+"/");
			return "redirect:"+PathSetting.PATH_AND_PORT+"/";
		}
		
		System.out.println("------>authUser:" + authUser);
		
		//session 처리
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);
		//response.sendRedirect(request.getContextPath()+"/dashboard");
		
		return "redirect:"+PathSetting.PATH_AND_PORT+"/dashboard";
		
	}
}
