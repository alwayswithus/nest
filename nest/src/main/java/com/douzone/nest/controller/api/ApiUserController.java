package com.douzone.nest.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiUserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/user/{authUserNo}")
	public JsonResult user(@PathVariable("authUserNo") long authUserNo) {
		JSONObject userVo = userService.getAllUser(authUserNo);
		return JsonResult.success(userVo);
	}
	
	
	/*
	 * 작성자 : 허길행
	 * 기능 : 로그인 정보 요청시 값 반환
	 * 출력 : json (success면 data, fail면 message)
	 * */
	@SuppressWarnings("unchecked")
	@PostMapping("/api/login")
	public JsonResult login(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		vo.setUserPassword(password);
		
		UserVo authUser = userService.getUser(vo);
		if(authUser == null) {
			request.setAttribute("userVo", vo);
			return JsonResult.fail("Fail of login...!");
		}
		
		JSONObject userVo = new JSONObject();
		userVo.put("userNo", authUser.getUserNo());
		userVo.put("userName", authUser.getUserName());
		userVo.put("userEmail", authUser.getUserEmail());
		userVo.put("userPhoto", authUser.getUserPhoto());
		userVo.put("userBg", authUser.getUserBg());

		
		return JsonResult.success(userVo);
	}
	
	// 백 그라운드 적용
	@PostMapping("/api/user/backgroundChange")
	public JsonResult backgroundChange(@RequestBody UserVo userVo) {
		boolean result = userService.backgroundChange(userVo);
		return JsonResult.success(result ? userVo : -1);
	}
	
	@PostMapping("api/user/invite")
	public JsonResult userInvite(@RequestBody UserVo userVo) {
		boolean result = userService.userInvite(userVo);
		return JsonResult.success(result ? userVo : -1);
	}
}
