package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.UserVo;

@Repository
public class ProfileRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public UserVo userSelect(Long userNo) {
		return sqlSession.selectOne("profile.selectUser", userNo);
	}

	public int updateUser(UserVo userVo) {
		return sqlSession.update("profile.updateUser", userVo);
	}

	public int updatePass(UserVo userVo) {
		return sqlSession.update("profile.updatePass", userVo);
	}
	
}
