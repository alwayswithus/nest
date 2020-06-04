package com.douzone.nest.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.UserRepository;
import com.douzone.nest.vo.UserVo;
import com.douzone.util.MailHandler;
import com.douzone.util.TempKey;

@Service
public class UserService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserRepository userRepository;
	
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
		int userInvite = userRepository.userInvite(userVo);
		
		// 인증 이메일 발송 코드...
        String key = new TempKey().getKey(50, false);
        userVo.setUserPassword(key);
        userRepository.setEmailConfirm(userVo);
        try {
            MailHandler sendMail = new MailHandler(mailSender);
            sendMail.setSubject("[이메일 인증]");
			sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
			        .append("<a href='http://localhost:8080/nest/user/emailConfirm?key=")
			        .append(key)
			        .append("' target='_blenk'>이메일 인증 확인</a>")
			        .toString());
	        sendMail.setFrom("alwayswithusneat@gmail.com", "동행-둥지프로젝트");
	        sendMail.setTo(userVo.getUserEmail());
	        sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        //이메일 발송 확인
        System.out.println("메일발송!");
        
		return userInvite == 1;
	}

	/*
	 * 작성자 : 허길행
	 * 설명 : 회원 가입용 메일 보내기
	 */
	public void signUpSendMail(UserVo userVo)
			throws MessagingException, 
			       UnsupportedEncodingException {

		//userRepository.insertUser(userVo);
        String key = new TempKey().getKey(50, false);
        //userRepository.insertEmailConfirm(userVo.getUserNo(), key);
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("[이메일 인증]");
        sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
                .append("<a href='http://localhost:8080/nest/user/emailConfirm?key=")
                .append(key)
                .append("' target='_blenk'>이메일 인증 확인</a>")
                .toString());
        sendMail.setFrom("alwayswithusneat@gmail.com", "동행-둥지프로젝트");
        sendMail.setTo(userVo.getUserEmail());
        sendMail.send();
        System.out.println("메일발송!");
		
	}
}
