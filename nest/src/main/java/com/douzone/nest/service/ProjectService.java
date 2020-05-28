package com.douzone.nest.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.vo.ProjectVo;

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
		return projectRepository.projectAdd(projectVo) == 2;
	}
}
