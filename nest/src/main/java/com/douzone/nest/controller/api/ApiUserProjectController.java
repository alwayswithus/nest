package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.UserProjectService;
import com.douzone.nest.vo.UserProjectVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiUserProjectController {

	@Autowired
	private UserProjectService userProjectService;
	
	@PostMapping("api/userproject")
	public JsonResult selectRoleNo(@RequestBody UserProjectVo userProjectVo) {
		JSONObject userProject = userProjectService.selectUserProject(userProjectVo);
		return JsonResult.success(userProject);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : member role 수정하기
	 */	
	@PostMapping("api/userproject/rolechange")
	public JsonResult roleChange(@RequestBody UserProjectVo userProjectVo) {
		boolean result = userProjectService.roleChange(userProjectVo);
		return JsonResult.success(result ? userProjectVo : -1);
	}
}
