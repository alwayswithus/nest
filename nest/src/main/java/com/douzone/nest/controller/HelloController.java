package com.douzone.nest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class HelloController {
	
	@RequestMapping({"","/"})
	public String hello() {
		System.out.println("!!!!!!!!");
		return "/index.jsp";
	}
	
	@RequestMapping("/pwfind")
	public String hello01() {
		return "/index.jsp";
	}
	
	@RequestMapping("/signup")
	public String hello02() {
		return "/index.jsp";
	}

	@RequestMapping("/dashboard")
	public String hello03() {
		return "/index.jsp";
	}
	
	@RequestMapping("/profile")
	public String hello04() {
		return "/index.jsp";
	}
	
	@RequestMapping("/profileset")
	public String hello05() {
		return "/index.jsp";
	}
	
	@RequestMapping("/notification")
	public String hello06() {
		return "/index.jsp";
	}
	
	@RequestMapping("/setting")
	public String hello07() {
		return "/index.jsp";
	}
	
	@RequestMapping("/comment")
	public String hello08() {
		return "/index.jsp";
	}
	
	@RequestMapping("/file")
	public String hello09() {
		return "/index.jsp";
	}
	
	@RequestMapping("/projectset")
	public String hello10() {
		return "/index.jsp";
	}
	
	@RequestMapping("/kanbanMain")
	public String hello11() {
		return "/index.jsp";
	}
	
	@RequestMapping("/gantt")
	public String hello12() {
		return "/index.jsp";
	}
}
