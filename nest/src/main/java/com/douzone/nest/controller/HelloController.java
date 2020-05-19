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
		return "index";
	}
	
	@RequestMapping("/pwfind")
	public String hello01() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String hello02() {
		return "index";
	}

	@RequestMapping("/dashboard")
	public String hello03() {
		return "index";
	}
	
	@RequestMapping("/profile")
	public String hello04() {
		return "index";
	}
	
	@RequestMapping("/profileset")
	public String hello05() {
		return "index";
	}
	
	@RequestMapping("/notification")
	public String hello06() {
		return "index";
	}
	
	@RequestMapping("/setting")
	public String hello07() {
		return "index";
	}
	
	@RequestMapping("/comment")
	public String hello08() {
		return "index";
	}
	
	@RequestMapping("/file")
	public String hello09() {
		return "index";
	}
	
	@RequestMapping("/projectset")
	public String hello10() {
		return "index";
	}
	
	@RequestMapping("/kanbanMain")
	public String hello11() {
		return "index";
	}
	
	@RequestMapping("/gantt")
	public String hello12() {
		return "index";
	}
}
