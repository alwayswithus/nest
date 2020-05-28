package com.douzone.nest.repository;

import java.util.List;

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
	
	/*
	 * 작성자 : 한해용
	 * 설명 : user 전부 가져오기 
	 */
	public List<UserVo> getAllUser() {
		return sqlSession.selectList("user.getAllUser");
	}

}
