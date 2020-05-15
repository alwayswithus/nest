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
	
	public List<ProjectVo> SelectProject() {
		return sqlSession.selectList("project.SelectPro");
	}

}
