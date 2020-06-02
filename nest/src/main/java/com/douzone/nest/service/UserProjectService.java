package com.douzone.nest.service;

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
	public JSONObject selectUserProject(UserProjectVo userProjectVo) {
		
		// 하나의 {}
		JSONObject obj = new JSONObject();
		UserProjectVo userProject = userProjectRepository.selectUserProject(userProjectVo);
		
		obj.put("projectNo", userProject.getProjectNo());
		obj.put("userNo", userProject.getUserNo());
		obj.put("roleNo", userProject.getRoleNo());
		
		return obj;
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : member role 수정하기
	 */	
	public boolean roleChange(UserProjectVo userProjectVo) {
		int roleChange = userProjectRepository.roleChange(userProjectVo);
		return roleChange == 1;
	}
}
