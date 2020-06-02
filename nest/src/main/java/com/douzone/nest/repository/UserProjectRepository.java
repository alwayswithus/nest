package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.UserProjectVo;

@Repository
public class UserProjectRepository {

	@Autowired
	private SqlSession sqlSession;
	
	/*
	 * 작성자 : 한해용
	 * 설명 : authUser projectNo와 roleNo 가져오기
	 */	
	public UserProjectVo selectUserProject(UserProjectVo userProjectVo) {
		return sqlSession.selectOne("userproject.selectUserProject", userProjectVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : member role 수정하기
	 */	
	public int roleChange(UserProjectVo userProjectVo) {
		return sqlSession.update("userproject.roleChange", userProjectVo);
	}
}
