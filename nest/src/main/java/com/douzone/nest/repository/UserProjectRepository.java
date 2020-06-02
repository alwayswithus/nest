package com.douzone.nest.repository;

import java.util.List;

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
	public List<UserProjectVo> selectUserProject(Long authUserNo) {
		return sqlSession.selectList("userproject.selectUserProject", authUserNo);
	}
}
