package com.douzone.nest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.nest.vo.UserVo;
import com.douzone.security.Auth;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class MainController {
	
	@RequestMapping({"","/"})
	public String main(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if(authUser!=null){
			System.out.println("이미 로그인 되있음...");
//			return "redirect:"+PathSetting.PATH_AND_PORT+"/dashboard";
		}
		
		return "index";
	}
	@Auth
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}
	@Auth
	@RequestMapping("/profile")
	public String profile() {
		return "index";
	}
	@Auth
	@RequestMapping("/profileset")
	public String profileset() {
		return "index";
	}
	@Auth
	@RequestMapping("/notification")
	public String notification() {
		return "index";
	}
	@Auth
	@RequestMapping("/dashboard/{projectNo}/kanbanboard/**")
	public String setting() {
		return "index";
	}
	
	@Auth
	@RequestMapping("/dashboard/{projectNo}/file/**")
	public String file() {
		return "index";
	}
	
	@Auth
	@RequestMapping("/calendar/**")
	public String calendarSetting() {
		return "index";
	}
	
//	@RequestMapping("/comment")
//	public String comment() {
//		return "index";
//	}
//	@RequestMapping("/file")
//	public String file() {
//		return "index";
//	}
	@Auth
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
	@Auth
	@RequestMapping("/calendar")
	public String calendar() {
		return "index";
	}
	
}
