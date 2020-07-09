package com.douzone.nest.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;
import com.douzone.security.Auth;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiUserController {
	
	@Autowired
	private ProjectService projectService;

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

		//session 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		// 세션받아쓰기
		// UserVo aa = (UserVo) session.getAttribute("authUser");
		
		return JsonResult.success(userVo);
	}
	
	// 이메일 체크
	@SuppressWarnings("unchecked")
	@PostMapping("/api/emailcheck")
	public JsonResult emailCheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("이메일 체크중");
		
		String email = request.getParameter("email");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		
		JSONObject userVo = new JSONObject();
		
		UserVo user = userService.checkUserEmail(vo);
		if(user != null) {
			userVo.put("userNo", user.getUserNo());
			userVo.put("userName", user.getUserName());
			userVo.put("userEmail", user.getUserEmail());
			userVo.put("userGrade", user.getUserGrade());
			
			System.out.println("이메일 있음");
			System.out.println(user.getUserGrade()+" !!!!");
			return JsonResult.success(userVo);
		}else {
			System.out.println("이메일 없음");
			//return JsonResult.fail("This email is not in the database.");
			return JsonResult.success(userVo);
		}
	}
	// 이메일 이름 체크
	@SuppressWarnings("unchecked")
	@PostMapping("/api/emailnamecheck")
	public JsonResult emailnameCheck(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("이메일 체크중");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		vo.setUserName(name);
		
		JSONObject userVo = new JSONObject();
		
		UserVo user = userService.checkUserEmailName(vo);
		if(user != null) {
			userVo.put("userEmail", user.getUserEmail());
			userVo.put("userGrade", user.getUserGrade());
			
			System.out.println("이메일 있음");
			System.out.println(user.getUserGrade()+" !!!!");
			return JsonResult.success(userVo);
		}else {
			System.out.println("이메일 없음");
			//return JsonResult.fail("This email is not in the database.");
			return JsonResult.success(userVo);
		}
	}
	
	// 인증키 체크!
	@SuppressWarnings("unchecked")
	@PostMapping("/api/emailConfirm")
	public JsonResult emailConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		String key = request.getParameter("key");
		
		UserVo vo = new UserVo();
		vo.setUserKey(key);
		
		JSONObject userVo = new JSONObject();
		
		UserVo user = userService.checkUserKey(vo);
		
		if(user != null) {
			userVo.put("userNo", user.getUserNo());
			userVo.put("userGrade", user.getUserGrade());
			userVo.put("userEmail", user.getUserEmail());
			
			return JsonResult.success(userVo);
		}else {
			return JsonResult.fail("This key is not in the database.");
		}
	}
	
	@Auth
	// 백 그라운드 적용
	@PostMapping("/api/user/backgroundChange")
	public JsonResult backgroundChange(@RequestBody UserVo userVo) {
		boolean result = userService.backgroundChange(userVo);
		return JsonResult.success(result ? userVo : -1);
	}
	
	@PostMapping("api/user/invite")
	public JsonResult userInvite(@RequestBody UserVo userVo) {
		UserVo exUser = projectService.userCk(userVo);
		boolean result = userService.userInvite(userVo);
		return JsonResult.success(result ? userVo : exUser);
	}
}
