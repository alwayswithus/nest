package com.douzone.nest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.ProfileService;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/api/profile/{userNo}")
	public JsonResult userSelect(@PathVariable("userNo") Long userNo) {
		System.out.println(userNo);
		UserVo userVo = profileService.userSelect(userNo);

		return JsonResult.success(userVo);
	}
}
