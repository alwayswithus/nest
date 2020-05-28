package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.UserService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiUserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/user")
	public JsonResult user() {
		JSONObject userVo = userService.getAllUser();
		return JsonResult.success(userVo);
	}
	
}
