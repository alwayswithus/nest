package com.douzone.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.nest.PathSetting;
import com.douzone.nest.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler) throws Exception {
		
		//1. handler 종류 확인
		if(handler instanceof HandlerMethod == false) {
			// DefaultServletHandler가 처리하는 경우(보통, assets의 정적 자원 접근) 
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. Method에 @Auth가 없으면 Type에 붙어 있는 지 확인한다(과제)
		if(auth == null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		//5. Type이나 Method 둘 다 @Auth가 적용이 안되어 있는 경우,
		if(auth == null) {
			return true;
		}
		
		//6. @Auth가 붙어 있기 때문 인증(Authentification) 여부 확인
		HttpSession session = request.getSession();
		if(session == null) {
			//response.sendRedirect(request.getContextPath() + "/login");
			response.sendRedirect(PathSetting.PATH_AND_PORT+"/");
			return false;
		}
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			//response.sendRedirect(request.getContextPath() + "/login");
			response.sendRedirect(PathSetting.PATH_AND_PORT+"/");
			return false;
		}
		
		//6. 권한(Authorization) 체크를 위해서 @Auth의 role 가져오기 ("USER", "ADMIN")
		String role = auth.value();

		//7. @Auth의 role이 "GUEST" 인 경우에는 authUser의 role이 어떤것 이든 상관이 없음.
		if("GUEST".equals(role)) { 
			return true;
		} 
		// 만약 "GUEST"가 아닌경우 회원 상태들 확인
		else {
			if("준회원".equals(authUser.getUserGrade())) {
				response.sendRedirect(PathSetting.PATH_AND_PORT+"/dashboard");
				return false;
			}
			return true;
		}
//		//8. @Auth의 role이 "ADMIN" 인 경우에는  반드시 authUser의 role이 "ADMIN" 여야 한다.
//		if("ADMIN".equals(authUser.getRoleNo()) == false) { 
//			response.sendRedirect(request.getContextPath());
//			return false;
//		}
//		
//		// @Auth의 role => "ADMIN"
//		// authUser의 role => "ADMIN"
//		// 관리자 권한이 확인
//		return true;
	}
}
