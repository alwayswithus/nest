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
	 * 설명 : user 전부 가져오기 (authUser 제외)
	 */
	public List<UserVo> getAllUser(long authUserNo) {
		return sqlSession.selectList("user.getAllUser", authUserNo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 세션 사용자 배경화면 설정
	 */
	public int backgroundChange(UserVo userVo) {
		return sqlSession.update("user.backgroundChange", userVo);
	}
	
	/*
	 * 작성자 : 한해용
	 * 설명 : 멤버 초대 
	 */
	public int userInvite(UserVo userVo) {
		return sqlSession.insert("user.userInvite", userVo);
	}

	/*
	 * 작성자 : 허길행
	 * 설명 : 이메일 인증키 세팅...
	 */
	public int setEmailConfirm(UserVo userVo) {
		return sqlSession.update("user.setEmailConfirm", userVo);
	}
}
