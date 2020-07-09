package com.douzone.nest.service;

import java.util.List;

import javax.mail.MessagingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.repository.UserRepository;
import com.douzone.nest.vo.UserVo;
import com.douzone.util.MailController;
import com.douzone.util.MailHandler;
import com.douzone.util.TempKey;

@Service
public class UserService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	// DB에서 유저 가저오기
	public UserVo getUser(UserVo vo) {
		UserVo result = userRepository.findByEmailAndPassword(vo);
		return result;
	}

	/*
	 * 작성자 : 한해용
	 * 설명 : user 전부 가져오기 (authUser 제외)
	 */
	@SuppressWarnings("unchecked")
	public JSONObject getAllUser(long authUserNo) {
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// allUser []
		JSONArray allUserArray = new JSONArray();
		List<UserVo> allUserList = userRepository.getAllUser(authUserNo);
		for(UserVo userVo : allUserList) {
			JSONObject user = new JSONObject();
			user.put("userNo", userVo.getUserNo());
			user.put("userName", userVo.getUserName());
			user.put("userEmail", userVo.getUserEmail());
			user.put("userPhoto", userVo.getUserPhoto());
			user.put("userGrade", userVo.getUserGrade());
			
			allUserArray.add(user);
		}
		obj.put("allUser", allUserArray);
		
		return obj;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 세션 사용자 배경화면 설정
	 */
	public boolean backgroundChange(UserVo userVo) {
		int authUser = userRepository.backgroundChange(userVo);
		return authUser == 1;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 초대
	 */
	public boolean userInvite(UserVo userVo) {
		UserVo cc = projectRepository.userCC(userVo);
		System.out.println("CC= "+cc);
		if(null!=cc) {
			return false;
		}
		else {
			int userInvite = userRepository.userInvite(userVo);

			/* 인증 이메일 발송 코드...*/
			// 인증키 생성
			String key = new TempKey().getKey(50, false);
			// 데이터 베이스에 인증키 세팅
			userVo.setUserKey(key);
			userRepository.setEmailConfirm(userVo);
			// 메일 발송용 컨트롤러 생성 및 발송 메서드 실행...
			try {
				MailController mailController = new MailController(new MailHandler(mailSender));
				mailController.userInviteMailSend(userVo.getUserEmail(), key);
			} catch (MessagingException e) { e.printStackTrace(); }
			//이메일 발송 확인
			System.out.println("새 프로젝트 맴버 초대 메일발송!");

			return userInvite == 1;
		}
	}

	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 가입용 메일 보내기
	 */
	public boolean signUpSendMail(UserVo userVo) {
		
		/* 인증 이메일 발송 코드...*/
		// 인증키 생성
        String key = new TempKey().getKey(50, false);
        // 데이터 베이스에 인증키 세팅
        userVo.setUserKey(key);
        int i = userRepository.setEmailConfirm(userVo);
        // 메일 발송용 컨트롤러 생성 및 발송 메서드 실행...
        try {
        	MailController mailController = new MailController(new MailHandler(mailSender));
        	mailController.userInviteMailSend(userVo.getUserEmail(), key);
		} catch (MessagingException e) { e.printStackTrace(); }
        //이메일 발송 확인
        System.out.println("회원 가입용 메일발송!");
		
        return i == 1;
	}
	
	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 비밀번호 찾기용 메일 보내기
	 */
	public boolean pwFindSendMail(UserVo userVo) {
		
		/* 인증 이메일 발송 코드...*/
		// 인증키 생성
        String key = new TempKey().getKey(50, false);
        // 데이터 베이스에 인증키 세팅
        userVo.setUserKey(key);
        int i = userRepository.setEmailConfirm(userVo);
        // 메일 발송용 컨트롤러 생성 및 발송 메서드 실행...
        try {
        	MailController mailController = new MailController(new MailHandler(mailSender));
        	mailController.userFindPwMailSend(userVo.getUserEmail(), key);
		} catch (MessagingException e) { e.printStackTrace(); }
        //이메일 발송 확인
        System.out.println("비밀번호 찾기용 메일발송!");
        return i == 1;
	}
		
       

	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 이메일 체크.
	 */
	public UserVo checkUserEmail(UserVo userVo) {
		return userRepository.findByEmail(userVo);
	}

	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 이메일 이름 체크.
	 */
	public UserVo checkUserEmailName(UserVo userVo) {
		return userRepository.findByEmailAndName(userVo);
	}

	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 인증키 체크.
	 */
	public UserVo checkUserKey(UserVo userVo) {
		return userRepository.findByKey(userVo);
	}
	
	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 가입 데이터 입력.
	 */
	public boolean signUserUpdate(UserVo userVo) {
		int i = userRepository.signUserNamePwUpdate(userVo);
		return i==1;
	}
	
	/*
	 * 작성자 : 허길행
	 * 설명 : 비밀번호 수정.
	 */
	public boolean pwUpdate(UserVo userVo) {
		int i = userRepository.passwordUpdate(userVo);
		return i==1;
	}
}
