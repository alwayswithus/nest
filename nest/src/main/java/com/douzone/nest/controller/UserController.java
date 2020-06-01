package com.douzone.nest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.nest.PathSetting;
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
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
		
		System.out.println(email+" / "+password);
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		vo.setUserPassword(password);
		
		UserVo authUser = userService.getUser(vo);
		
		System.out.println(authUser);
		
		if(authUser == null) {
			request.setAttribute("userVo", vo);
			//response.sendRedirect(request.getContextPath()+"/");
			return "redirect:"+PathSetting.PATH_AND_PORT+"/";
		}
		
		//session 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
//		session.setAttribute("authUserNo", authUser.getUserNo());
//		session.setAttribute("authUserEmail", authUser.getUserEmail());
//		session.setAttribute("authUserName", authUser.getUserName());
//		session.setAttribute("authUserPhoto", authUser.getUserPhoto());
//		session.setAttribute("authUserBg", authUser.getUserBg());
		//response.sendRedirect(request.getContextPath()+"/dashboard");
		
		return "redirect:"+PathSetting.PATH_AND_PORT+"/dashboard";
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout (HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser!=null){
			System.out.println("세션제거...");
			
			session.removeAttribute("authUser");
			session.invalidate();
		}
		return "redirect:/";
	}
}
