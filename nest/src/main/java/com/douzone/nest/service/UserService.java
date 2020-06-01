package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.UserRepository;
import com.douzone.nest.vo.UserVo;

@Service
public class UserService {

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
		return userInvite == 1;
	}
}
