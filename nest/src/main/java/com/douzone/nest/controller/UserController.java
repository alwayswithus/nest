package com.douzone.nest.controller;

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
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	
	// 비밀번호 찾기
	@RequestMapping("/pwfind")
	public void pwFind() {
		//return "index";
	}
	
	// 회원 가입
	@RequestMapping("/signup")
	public void signUp() {
		//return "index";
	}
	
	// 회원가입 이메일 발송...
	@RequestMapping("/signup/sendmail")
	public void signUpSendMail() throws Exception {
		
		//UserVo userVo = new UserVo();
		//userVo.setUserEmail("hgh8401@gmail.com");
		//userService.signUpSendMail(userVo);
		
		//return "index";
	}
	
	// 
	@PostMapping("/auth")
	public void auth() {}
//	public String auth(HttpServletRequest request, HttpServletResponse response){
//		
//		System.out.println("로그인 시도중... auth..!");
//		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		System.out.println(email+" / "+password);
//		
//		UserVo vo = new UserVo();
//		vo.setUserEmail(email);
//		vo.setUserPassword(password);
//		
//		UserVo authUser = userService.getUser(vo);
//		
//		System.out.println(authUser);
//		
//		if(authUser == null) {
//			request.setAttribute("userVo", vo);
//			//response.sendRedirect(request.getContextPath()+"/");
//			return "redirect:"+PathSetting.PATH_AND_PORT+"/";
//		}
//		
//		//session 처리
//		HttpSession session = request.getSession(true);
//		session.setAttribute("authUser", authUser);
//		session.setAttribute("authUserNo", authUser.getUserNo());
//		session.setAttribute("authUserEmail", authUser.getUserEmail());
//		session.setAttribute("authUserName", authUser.getUserName());
//		session.setAttribute("authUserPhoto", authUser.getUserPhoto());
//		session.setAttribute("authUserBg", authUser.getUserBg());
//		//response.sendRedirect(request.getContextPath()+"/dashboard");
//		
//		return "redirect:"+PathSetting.PATH_AND_PORT+"/dashboard";
//	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public void logout() {}
//	public String logout (HttpServletRequest request, HttpServletResponse response) {
//		
//		HttpSession session = request.getSession();
//		UserVo authUser = (UserVo) session.getAttribute("authUser");
//		if(authUser!=null){
//			System.out.println("세션제거...");
//			
//			session.removeAttribute("authUser");
//			session.invalidate();
//		}
//		return "redirect:"+PathSetting.PATH_AND_PORT+"/";
//	}
	
	@RequestMapping(value="emailConfirm", method=RequestMethod.GET)
    public String emailConfirm(String key){
		
		
		return "index";
    }
	
	
	@PostMapping("/sendmail")
	public String sendToMailSignUp(HttpServletRequest request, HttpServletResponse response) {
		
		String mode = request.getParameter("mode");
		String email = request.getParameter("email");
		
		System.out.println(email);
		System.out.println("이메일 발송준비 완료");
		
		UserVo userVo = new UserVo();
		userVo.setUserEmail(email);
		
		switch (mode) {
		case "signup":
			userService.signUpSendMail(userVo);
			break;

		case "findpw":
			System.out.println(mode + " 비밀번호 찾는중...");
			break;

		default:
			break;
		}
		
		return "redirect:"+PathSetting.PATH_AND_PORT+"/sendmail/"+mode;
	}
}
