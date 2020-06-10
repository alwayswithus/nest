package com.douzone.util;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.douzone.nest.PathSetting;

public class MailController {
	
	private MailHandler sendMail;
	
	public MailController(MailHandler setSendMail) {
		this.sendMail = setSendMail;
	}

	public boolean userInviteMailSend(String ToEmail,String key) {
        try {
            sendMail.setSubject("[이메일 인증] nest 회원가입 안내 이메일");
			sendMail.setText(new StringBuffer().append("<h1>회원가입 메일 인증</h1>")
			        .append("<a href='"+PathSetting.PATH_AND_PORT+"/user/emailConfirm/")
			        .append(key)
			        .append("' target='_blenk'>이메일 인증 확인, 회원가입</a>")
			        .append("<br><br> 위의 링크를 클릭하여 회원가입을 진행해 주세요. <br> 감사합니다. <br> 당신의 비상을 위한 보금자리, 둥지(Nest) 프로젝트 올림.")
			        .toString());
	        sendMail.setFrom("alwayswithusneat@gmail.com", "동행-둥지프로젝트");
	        sendMail.setTo(ToEmail);
	        sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
        
        return true;
	}
	
	public boolean userFindPwMailSend(String ToEmail,String key) {
        try {
            sendMail.setSubject("[이메일 인증] 회원 이메일 인증 및 비밀번호 변경 안내 이메일");
			sendMail.setText(new StringBuffer().append("<h1>비밀번호 변경 메일 인증</h1>")
					.append("<a href='"+PathSetting.PATH_AND_PORT+"/user/emailConfirm/")
			        .append(key)
			        .append("' target='_blenk'>이메일 인증 확인, 비밀번호 변경</a>")
			        .append("<br><br> 위의 링크를 클릭하여 비밀번호 변경을 진행해 주세요. <br> 감사합니다. <br> 당신의 비상을 위한 보금자리, 둥지(Nest) 프로젝트 올림.")
			        .toString());
	        sendMail.setFrom("alwayswithusneat@gmail.com", "동행-둥지프로젝트");
	        sendMail.setTo(ToEmail);
	        sendMail.send();
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
        
        return true;
	}
}
