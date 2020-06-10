package com.douzone.nest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.FileUploadService;
import com.douzone.nest.service.ProfileService;
import com.douzone.nest.vo.FileVo;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping("/api/profile/{userNo}")
	public JsonResult userSelect(@PathVariable("userNo") Long userNo) {
	
		UserVo userVo = profileService.userSelect(userNo);

		return JsonResult.success(userVo);
	}
	
	@PostMapping("/api/profile/update")
	public JsonResult updateUser(@RequestBody UserVo userVo) {
		System.out.println(userVo);
		
		profileService.updateUser(userVo);
		
		return JsonResult.success(userVo);
	}
	
	@PostMapping("/api/profile/photoupload")
	public JsonResult userPhotoUrl(@RequestParam("file") MultipartFile multipartFile) {
		FileVo fileVo = new FileVo();
		
		String url = fileUploadService.restore(fileVo, multipartFile);		
		
		return JsonResult.success(url);
	}
}
