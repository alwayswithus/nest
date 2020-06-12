package com.douzone.nest.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CommentLikeUserVo;
import com.douzone.nest.vo.CommentVo;

@Repository
public class CommentRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertComment(CommentVo commentVo) {
		return sqlSession.insert("comment.insertComment", commentVo);
	}

	public int updateCommentContents(Map<String,Object> map) {
		return sqlSession.update("comment.updateCommentContents", map);
	}

	public int deleteComment(Long commentNo) {
		return sqlSession.delete("comment.deleteComment", commentNo);
	}

	public CommentLikeUserVo selectLikeUser(Map<String,Object> map) {
		return sqlSession.selectOne("comment.selectLikeUser", map);
	}

	public int insertLikeUser(Map<String, Object> map) {
		return sqlSession.insert("comment.insertLikeUser",map);
	}

	public int deleteLikeUser(Map<String, Object> map) {
		return sqlSession.delete("comment.deleteLikeUser", map);
	}

	public int deleteUserLikeByCommentNo(Long commentNo) {
		return sqlSession.delete("comment.deleteUserLikeByCommentNo", commentNo);
	}

	public int updateCommentLike(Map<String, Object> map) {
		return sqlSession.update("comment.updateCommentLike", map);
	}

}
