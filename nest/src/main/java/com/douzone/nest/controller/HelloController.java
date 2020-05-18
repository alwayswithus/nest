package com.douzone.nest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.douzone.nest.service.ProjectService;
import com.douzone.nest.vo.ProjectVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class HelloController {
	
	@Autowired
	private ProjectService projectService;
	
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
		List<ProjectVo> proVo = projectService.SelectProject();
		System.out.println(proVo);
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
