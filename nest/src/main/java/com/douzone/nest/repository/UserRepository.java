package com.douzone.nest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVo findByEmailAndPassword(UserVo inputVo) {
		
		UserVo result = sqlSession.selectOne("user.findByEmailAndPassword",inputVo);
		
		return result;
	}

}
