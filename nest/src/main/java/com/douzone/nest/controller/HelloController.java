package com.douzone.nest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping({"","/"})
	public String hello() {
		return "/index.jsp";
	}
	
	@RequestMapping("/pwfind")
	public String hello01() {
		return "";
	}
	
	@RequestMapping("/signup")
	public String hello02() {
		return "";
	}

	@RequestMapping("/dashboard")
	public String hello03() {
		return "";
	}
	
	@RequestMapping("/profile")
	public String hello04() {
		return "";
	}
	
	@RequestMapping("/profileset")
	public String hello05() {
		return "";
	}
	
	@RequestMapping("/notification")
	public String hello06() {
		return "";
	}
	
	@RequestMapping("/setting")
	public String hello07() {
		return "";
	}
	
	@RequestMapping("/comment")
	public String hello08() {
		return "";
	}
	
	@RequestMapping("/file")
	public String hello09() {
		return "";
	}
	
	@RequestMapping("/projectset")
	public String hello10() {
		return "";
	}
	
	@RequestMapping("/kanbanMain")
	public String hello11() {
		return "";
	}
	
	@RequestMapping("/gantt")
	public String hello12() {
		return "";
	}
}
