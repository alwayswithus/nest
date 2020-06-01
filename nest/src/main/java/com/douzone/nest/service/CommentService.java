package com.douzone.nest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CommentRepository;
import com.douzone.nest.vo.CommentVo;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public boolean insertComment(CommentVo commentVo) {
			return 1 == commentRepository.insertComment(commentVo);
	}

	public boolean updateComment(Long commentNo, CommentVo commentVo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("commentNo", commentNo);
		map.put("commentContents", commentVo.getCommentContents());
		map.put("commentLike", commentVo.getCommentLike()+1);
		
		return 1 == commentRepository.updateComment(map);
	}

	public boolean deleteComment(Long commentNo) {
		return 1 == commentRepository.deleteComment(commentNo);
	}
	
	
}
