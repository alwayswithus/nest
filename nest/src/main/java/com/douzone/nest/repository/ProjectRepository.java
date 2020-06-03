package com.douzone.nest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.ProjectVo;
import com.douzone.nest.vo.UserProjectVo;
import com.douzone.nest.vo.UserVo;

@Repository
public class ProjectRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProjectVo> selectProject(long authUserNo) {
		return sqlSession.selectList("project.selectPro", authUserNo);
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
	public List<UserVo> selectUser(Map<String, Object> map) {
		return sqlSession.selectList("project.selectUser", map);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : userproject 추가
	 */
	public int insertUserProject(Map<String, Object> map) {
		return sqlSession.insert("project.insertUserProject", map);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : authUser project 추가
	 */
	public int insertAuthUser(Map<String, Object> map) {
		return sqlSession.insert("project.insertAuthUser", map);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 추가
	 */
	public int userAdd(UserProjectVo userProjectVo) {
		return sqlSession.insert("project.userAdd", userProjectVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 삭제
	 */
	public int userDelete(UserProjectVo userProjectVo) {
		return sqlSession.delete("project.userDelete", userProjectVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 추가
	 */
	public int userInsert(UserVo userVo) {
		return sqlSession.insert("project.userInsert", userVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 추가
	 */
	public int userProjectJoin(UserVo userVo) {
		return sqlSession.insert("project.userProjectJoin", userVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 제목 수정
	 */
	public int titleUpdate(ProjectVo projectVo) {
		return sqlSession.update("project.titleUpdate", projectVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 설명 수정
	 */
	public int descUpdate(ProjectVo projectVo) {
		return sqlSession.update("project.descUpdate", projectVo);
	}
	
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 프로젝트 상태 수정
	 */
	public int stateUpdate(ProjectVo projectVo) {
		return sqlSession.update("project.stateUpdate", projectVo);
  }
  
	public List<UserVo> projectMemberSelect(Long projectNo) {
		return sqlSession.selectList("project.selectProjectMember", projectNo);
	}

	/*
	 * 작성자 : 최인효
	 * 설명 : 프로젝트 마감 날짜 수정
	 */
	public int projectDateUpdate(ProjectVo projectVo) {
		return sqlSession.update("project.projectDateUpdate", projectVo);
	}
}
