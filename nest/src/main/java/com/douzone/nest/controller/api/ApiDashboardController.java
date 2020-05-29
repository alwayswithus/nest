package com.douzone.nest.controller.api;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/api/dashboard/{authUserNo}")
	public JsonResult dashboard(@PathVariable("authUserNo") long authUserNo) {
		JSONObject proVo = projectService.selectProject(authUserNo);
		return JsonResult.success(proVo);
	}
	
	@PostMapping("/api/dashboard/add/{authUserNo}")
	public JsonResult projectAdd(@RequestBody ProjectVo projectVo, @PathVariable("authUserNo") long authUserNo) {
		boolean result = projectService.projectAdd(projectVo, authUserNo);
		return JsonResult.success(result ? projectVo : -1);
	}
}
