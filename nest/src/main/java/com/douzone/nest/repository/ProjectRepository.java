package com.douzone.nest.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.ProjectVo;

@Repository
public class ProjectRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProjectVo> selectProject() {
		return sqlSession.selectList("project.selectPro");
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 추가
	 */
	public int projectAdd(ProjectVo projectVo) {
		//int project = sqlSession.insert("project.projectAdd", projectVo);
		
		System.out.println(projectVo);
		
		//int userProject = sqlSession.insert("userproject.userProjectAdd", projectVo);
		return 1 + 1;
	}

}
