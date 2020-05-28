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
		System.out.println(result);
		return result;
	}

	/*
	 * 작성자 : 한해용
	 * 설명 : user 전부 가져오기 
	 */
	@SuppressWarnings("unchecked")
	public JSONObject getAllUser() {
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// allUser []
		JSONArray allUserArray = new JSONArray();
		List<UserVo> allUserList = userRepository.getAllUser();
		for(UserVo userVo : allUserList) {
			JSONObject user = new JSONObject();
			user.put("userNo", userVo.getUserNo());
			user.put("userName", userVo.getUserName());
			user.put("userPhoto", userVo.getUserPhoto());
			
			allUserArray.add(user);
		}
		obj.put("allUser", allUserArray);
		
		return obj;
	}
}
