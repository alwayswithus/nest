package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public boolean transferRoleAndDelete(JSONObject projectUserJson, Long userNo) {
		int result = -1;
		//allProjectUser []
		List<JSONObject> allProjectUser = (List)projectUserJson.get("array");
		
		for(int i = 0; i < allProjectUser.size(); i++) {

			HashMap<String,Object> projectUser =  allProjectUser.get(i);
			
			Map<String, Object> projectUserMap = new HashMap<>();
			
			
			projectUserMap.put("projectNo", projectUser.get("projectNo"));
			projectUserMap.put("userNo", projectUser.get("userNo"));
			
			result = userProjectRepository.transferRoleAndDelete(projectUserMap);
			if(result != 1) {
				return false;
			}
		}
		
		int delete = userProjectRepository.userDelete(userNo);
		return result == 1;
	}
}
