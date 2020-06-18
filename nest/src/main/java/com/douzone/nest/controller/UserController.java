package com.douzone.nest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.nest.PathSetting;
import com.douzone.nest.service.UserService;
import com.douzone.nest.vo.UserVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인...
//	@RequestMapping("/login")
//	public String login() {
//		return "/login";
//	}
	
	// 비밀번호 찾기
	@RequestMapping("/pwfind")
	public void pwFind() {}
	
	// 회원 가입
	@RequestMapping("/signup")
	public void signUp() {}
	
	// 로그인
	@PostMapping("/auth")
	public void auth() {}
	
	// 로그아웃
	@PostMapping("/logout/")
	public void logout() {}
	
	@RequestMapping(value="emailConfirm", method=RequestMethod.GET)
    public String emailConfirm(String key){
		
		return "index";
    }
	
	// 회원가입 이메일 발송...
	@PostMapping("/sendmail")
	public void sendToMailSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String mode = request.getParameter("mode");
		String email = request.getParameter("email");
		
		System.out.println(email);
		System.out.println("이메일 발송준비 완료");
		
		UserVo vo = new UserVo();
		vo.setUserEmail(email);
		
		UserVo userVo = userService.checkUserEmail(vo);
		
		switch (mode) {
		case "signup":
			if(userVo==null) {
				userVo = new UserVo();
				userVo.setUserName(email);
				userVo.setUserEmail(email);
				userVo.setUserPhoto("/nest/assets/images/unnamed.jpg");
				userService.userInvite(userVo);
				
				System.out.println("새 회원보내기");
				
			}else {
				userService.signUpSendMail(userVo);
				
				System.out.println("기존 준회원 보내기");
			}
			
			break;

		case "findpw":
			System.out.println(mode + " 비밀번호 찾는중...");
			if(userVo!=null) {
				userService.pwFindSendMail(userVo);
			}
			break;

		default:
			break;
		}
    
		response.sendRedirect(PathSetting.PATH_AND_PORT+"/sendmail/"+mode);
	}
	
	@PostMapping("/signupset")
	public void signUpSet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Long no = Long.parseLong(request.getParameter("no"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		UserVo userVo = new UserVo();
		userVo.setUserNo(no);
		userVo.setUserName(name);
		userVo.setUserPassword(password);
		
		userService.signUserUpdate(userVo);
		
		response.sendRedirect(PathSetting.PATH_AND_PORT+"/signupdone/");
	}
	
	@PostMapping("/pwupdate")
	public void pwUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		
		UserVo userVo = new UserVo();
		userVo.setUserNo(no);
		userVo.setUserPassword(password);
		
		userService.pwUpdate(userVo);
		
		response.sendRedirect(PathSetting.PATH_AND_PORT+"/pwfinddone/");
	}
}


