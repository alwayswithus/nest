package com.douzone.nest.controller.api;

import org.json.simple.JSONObject;
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
	
	// 비밀번호 업데이트 기능
	@SuppressWarnings("unchecked")
	@PostMapping("/api/profile/passUpdate")
	public JsonResult userPassUpdate(@RequestBody UserVo userVo) {
		if(profileService.PassUpdate(userVo)) {
			JSONObject vo = new JSONObject();
			vo.put("userNo", userVo.getUserNo());
			System.out.println(vo.toJSONString());

			return JsonResult.success(vo);
		}
		else {
			return JsonResult.fail("비밀번호 찾기 실패..");
		}
	}
}
