package com.douzone.nest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.vo.ProjectVo;
import com.douzone.nest.vo.UserVo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@SuppressWarnings("unchecked")
	public JSONObject selectProject() {
		
		// 메인 {}
		JSONObject obj = new JSONObject();
		
		// allProject []
		JSONArray allProjectArray = new JSONArray();
		List<ProjectVo> allProjectList = projectRepository.selectProject();
		for(ProjectVo projectVo : allProjectList) {
			// 하나의 project {}
			JSONObject project = new JSONObject();
			project.put("projectNo", projectVo.getProjectNo());
			project.put("projectTitle", projectVo.getProjectTitle());
			project.put("projectDesc", projectVo.getProjectDesc());
			project.put("projectStart", projectVo.getProjectStart());
			project.put("projectEnd", projectVo.getProjectEnd());
			project.put("projectState", projectVo.getProjectState());
			
			// members []
			JSONArray memberArray = new JSONArray();
			List<UserVo> userList = projectRepository.selectUser(projectVo.getProjectNo());
			for(UserVo userVo : userList) {
				// 하나의 member {}
				JSONObject member = new JSONObject();
				member.put("userNo", userVo.getUserNo());
				member.put("roleNo", userVo.getRoleNo());
				member.put("userName", userVo.getUserName());
				member.put("userEmail", userVo.getUserEmail());
				member.put("userPhoto", userVo.getUserPhoto());
			
				memberArray.add(member);
			}
			project.put("members", memberArray);
			
			allProjectArray.add(project);
		}
		
		obj.put("allProject", allProjectArray);
		
		return obj;
	}
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 추가
	 */
	public boolean projectAdd(ProjectVo projectVo) {
		
		// 프로젝트 먼저 insert (member X) => projectNo를 가져오기 위해서
		int projectNotMember = projectRepository.insertProjectNotMember(projectVo);
		int projectWithMember = 0;
		
		for(UserVo member : projectVo.getMembers()) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("projectNo", projectVo.getProjectNo());
			map.put("userNo", member.getUserNo());
			
			// userproject 테이블에 insert
			projectWithMember = projectRepository.insertUserProject(map);
		}
		return (projectNotMember + projectWithMember) == 2;
	}
}
