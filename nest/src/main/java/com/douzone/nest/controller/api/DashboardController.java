package com.douzone.nest.controller.api;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.ProjectService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController

public class DashboardController {
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/api/dashboard")
	public JsonResult dashboard() {
		JSONObject proVo = projectService.selectProject();
		return JsonResult.success(proVo);
	}
	
}
