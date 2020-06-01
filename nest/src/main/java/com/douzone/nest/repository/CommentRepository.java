package com.douzone.nest.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.nest.vo.CommentVo;

@Repository
public class CommentRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertComment(CommentVo commentVo) {
		System.out.println(commentVo.getFileNo());
		System.out.println(commentVo.getOriginName());
		return sqlSession.insert("comment.insertComment", commentVo);
	}

	public int updateComment(Map<String,Object> map) {
		return sqlSession.update("comment.updateComment", map);
	}

	public int deleteComment(Long commentNo) {
		return sqlSession.delete("comment.deleteComment", commentNo);
	}

}
