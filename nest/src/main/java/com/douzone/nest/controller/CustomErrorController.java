package com.douzone.nest.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	// error 편집중
//	@RequestMapping("/error")
//	public String handleError() {
//		return "index";
//	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}