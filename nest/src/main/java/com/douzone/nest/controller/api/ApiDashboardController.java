package com.douzone.nest.controller.api;


import java.util.List;

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
import com.douzone.nest.vo.UserVo;

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
	
	/*
	 * 작성자:김우경
	 * project member select
	 * */
//	@GetMapping("/api/dashboard/{projectNo}")
//	public String projectMember(@PathVariable("projectNo") Long projectNo) {
//		
//		List<UserVo> userVo = projectService.projectMemberSelect(projectNo);
//		System.out.println(userVo);
//		return "";
//	}
	
	@PostMapping("/api/dashboard/add/{authUserNo}")
	public JsonResult projectAdd(@RequestBody ProjectVo projectVo, @PathVariable("authUserNo") long authUserNo) {
		boolean result = projectService.projectAdd(projectVo, authUserNo);
		return JsonResult.success(result ? projectVo : -1);
	}
}
