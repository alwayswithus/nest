package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.UserProjectService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiUserProjectController {

	@Autowired
	private UserProjectService userProjectService;
	
	@GetMapping("api/userproject/{authUserNo}")
	public JsonResult userProject(@PathVariable("authUserNo") Long authUserNo) {
		JSONObject ProjectAndRoleNo = userProjectService.selectUserProject(authUserNo);
		return JsonResult.success(ProjectAndRoleNo);
	}
}
