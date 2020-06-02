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
import com.douzone.nest.vo.UserProjectVo;

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
	@GetMapping("/api/dashboard/member/{projectNo}")
	public JsonResult projectMember(@PathVariable("projectNo") Long projectNo) {
		
		List<UserVo> userVo = projectService.projectMemberSelect(projectNo);

		return JsonResult.success(userVo);
	}
	
	@PostMapping("/api/dashboard/add/{authUserNo}")
	public JsonResult projectAdd(@RequestBody ProjectVo projectVo, @PathVariable("authUserNo") long authUserNo) {
		boolean result = projectService.projectAdd(projectVo, authUserNo);
		return JsonResult.success(result ? projectVo : -1);
	}
	
	@PostMapping("api/user/add")
	public JsonResult userAdd(@RequestBody UserProjectVo userProjectVo) {
		boolean result = projectService.userAdd(userProjectVo);
		return JsonResult.success(result ? userProjectVo : -1);
	}
	
	@PostMapping("api/user/delete")
	public JsonResult userDelete(@RequestBody UserProjectVo userProjectVo) {
		boolean result = projectService.userDelete(userProjectVo);
		return JsonResult.success(result ? userProjectVo : -1);
	}
	
	@PostMapping("api/settinguser/invite")
	public JsonResult userInvite(@RequestBody UserVo userVo) {
		boolean result = projectService.userInvite(userVo);
		return JsonResult.success(result ? userVo : -1);
	}
	
	@PostMapping("api/projectsetting/title")
	public JsonResult titleUpdate(@RequestBody ProjectVo projectVo) {
		boolean result = projectService.titleUpdate(projectVo);
		return JsonResult.success(result ? projectVo : -1);
	}
	
	@PostMapping("api/projectsetting/desc")
	public JsonResult descUpdate(@RequestBody ProjectVo projectVo) {
		boolean result = projectService.descUpdate(projectVo);
		return JsonResult.success(result ? projectVo : -1);
	}
	
	@PostMapping("api/projectsetting/state")
	public JsonResult stateUpdate(@RequestBody ProjectVo projectVo) {
		boolean result = projectService.stateUpdate(projectVo);
		return JsonResult.success(result ? projectVo : -1);
	}
}
