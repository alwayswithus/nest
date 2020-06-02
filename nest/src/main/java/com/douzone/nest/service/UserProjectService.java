package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.UserProjectRepository;
import com.douzone.nest.vo.UserProjectVo;

@Service
public class UserProjectService {
	
	@Autowired
	private UserProjectRepository userProjectRepository;

	/*
	 * 작성자 : 한해용
	 * 설명 : authUser projectNo와 roleNo 가져오기
	 */
	@SuppressWarnings("unchecked")
	public JSONObject selectUserProject(Long authUserNo) {
		
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// authUserNo []
		JSONArray ProjectAndRoleNoArray = new JSONArray();
		List<UserProjectVo> userProjectList = userProjectRepository.selectUserProject(authUserNo);
		for(UserProjectVo userProjectVo : userProjectList) {
			// 하나의 {}
			JSONObject projectAndRoleNo = new JSONObject();
			projectAndRoleNo.put("projectNo", userProjectVo.getProjectNo());
			projectAndRoleNo.put("roleNo", userProjectVo.getRoleNo());
			
			ProjectAndRoleNoArray.add(projectAndRoleNo);
		}
		
		obj.put("ProjectAndRoleNo", ProjectAndRoleNoArray);
		
		return obj;
	}
}
