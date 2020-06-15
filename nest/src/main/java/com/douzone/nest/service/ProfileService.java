package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProfileRepository;
import com.douzone.nest.vo.UserVo;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	/*
	 * 작성자:김우경
	 * 설명:회원에 대한 프로필 정보
	 */
	public UserVo userSelect(Long userNo) {
		return profileRepository.userSelect(userNo);
	}
	
	/*
	 * 작성자:김우경
	 * 설명:회원에 대한 프로필 정보 업데이트
	 */
	public boolean updateUser(UserVo userVo) {
		return 1 == profileRepository.updateUser(userVo);
	}

	public boolean PassUpdate(UserVo userVo) {
		return 1==profileRepository.updatePass(userVo);
	}

	/*
	 * 작성자:김우경
	 * 설명:회원에 대한 프로젝트정보
	 */
	@SuppressWarnings("unchecked")
	public JSONObject select(Long userNo) {
		JSONObject obj = new JSONObject();
		List<HashMap> list = profileRepository.select(userNo);
		
		JSONArray userProjectArray = new JSONArray();
		for(HashMap map : list) {
			JSONObject userProject = new JSONObject();
			userProject.put("projectNo",map.get("project_no"));
			userProject.put("roleNo",map.get("role_no"));
			userProject.put("projectTitle",map.get("project_title"));
			userProject.put("userName",map.get("user_name"));
			
			userProjectArray.add(userProject);
		}
		
		obj.put("userProject", userProjectArray);
		return obj;
	}
	
}
