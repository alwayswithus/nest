package com.douzone.nest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.ProjectService;
import com.douzone.nest.vo.ProjectVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class HelloController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping({"","/"})
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/pwfind")
	public String hello01() {
		return "";
	}
	
	@RequestMapping("/signup")
	public String hello02() {
		return "";
	}
	
	@GetMapping("/dashboard")
	public JsonResult hello03() {
		List<ProjectVo> proVo = projectService.SelectProject();
		System.out.println(proVo);
		return JsonResult.success(proVo);
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
