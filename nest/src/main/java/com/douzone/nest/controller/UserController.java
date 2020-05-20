package com.douzone.nest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {
	
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
