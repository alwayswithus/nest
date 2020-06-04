package com.douzone.nest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.nest.PathSetting;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class MainController {
	
	@RequestMapping({"","/"})
	public String main(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser!=null){
//			System.out.println("이미 로그인 되있음...");
//			return "redirect:"+PathSetting.PATH_AND_PORT+"/dashboard";
		}
		
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
	
	@RequestMapping("/dashboard/{projectNo}/kanbanboard/**")
	public String setting() {
		return "index";
	}
	
//	@RequestMapping("/comment")
//	public String comment() {
//		return "index";
//	}
//	
//	@RequestMapping("/file")
//	public String file() {
//		return "index";
//	}
	
	@RequestMapping("/projectset")
	public String projectset() {
		return "index";
	}
	
//	@RequestMapping("/kanbanMain")
//	public String kanbanMain() {
//		return "index";
//	}
	
//	@RequestMapping("/gantt")
//	public String gantt() {
//		return "index";
//	}
	
	@RequestMapping("/errors")
	public String errors() {
		return "index";
	}
	
	@RequestMapping("/calendar")
	public String calendar() {
		return "index";
	}
}
