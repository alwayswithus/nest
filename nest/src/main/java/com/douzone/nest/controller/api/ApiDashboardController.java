package com.douzone.nest.controller.api;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.ProjectService;
import com.douzone.nest.vo.ProjectVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiDashboardController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/api/dashboard")
	public JsonResult dashboard() {
		JSONObject proVo = projectService.selectProject();
		return JsonResult.success(proVo);
	}
	
	@PostMapping("/api/dashboard/add")
	public JsonResult projectAdd(@RequestBody ProjectVo projectVo) {
		boolean result = projectService.projectAdd(projectVo);
		return JsonResult.success(result ? projectVo : -1);
	}
}
