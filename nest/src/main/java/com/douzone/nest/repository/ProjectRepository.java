package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.ProjectVo;
import com.douzone.nest.vo.UserVo;

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
	public int insertProjectNotMember(ProjectVo projectVo) {
		return sqlSession.insert("project.insertProjectNotMember", projectVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : member 가져오기
	 */
	public List<UserVo> selectUser(Long projectNo) {
		return sqlSession.selectList("project.selectUser", projectNo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : userproject 추가
	 */
	public int insertUserProject(Map<String, Object> map) {
		return sqlSession.insert("project.insertUserProject", map);
	}

}
