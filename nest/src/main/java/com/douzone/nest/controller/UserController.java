package com.douzone.nest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	//로그인...
	@PostMapping("/login")
	public String login() {
		System.out.println("로그인 시도중...");
		return "redirect:/dashboard";
	}
	
	
	// 비밀번호 찾기
	@RequestMapping("/pwfind")
	public String pwFind() {
		return "index";
	}
	
	// 회원 가입
	@RequestMapping("/signup")
	public String signUp() {
		return "index";
	}
	
}
