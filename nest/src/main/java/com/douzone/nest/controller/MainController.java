package com.douzone.nest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class MainController {
	
	@RequestMapping({"","/"})
	public String main() {
		return "index";
	}


	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "index";
	}
	
	@RequestMapping("/profileset")
	public String profileset() {
		return "index";
	}
	
	@RequestMapping("/notification")
	public String notification() {
		return "index";
	}
	
	@RequestMapping("/kanbanMain/**")
	public String setting() {
		return "index";
	}
	
	@RequestMapping("/comment")
	public String comment() {
		return "index";
	}
	
	@RequestMapping("/file")
	public String file() {
		return "index";
	}
	
	@RequestMapping("/projectset")
	public String projectset() {
		return "index";
	}
	
//	@RequestMapping("/kanbanMain")
//	public String kanbanMain() {
//		return "index";
//	}
	
	@RequestMapping("/gantt")
	public String gantt() {
		return "index";
	}
	
	@RequestMapping("/errors")
	public String errors() {
		return "index";
	}
	
	@RequestMapping("/calendar")
	public String calendar() {
		return "index";
	}
}
