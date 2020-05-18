package com.douzone.nest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.ProjectRepository;
import com.douzone.nest.vo.ProjectVo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public List<ProjectVo> selectProject() {
		return projectRepository.selectProject();
	}

}
