package com.douzone.nest.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CommentRepository;
import com.douzone.nest.repository.FileRepository;
import com.douzone.nest.vo.CommentLikeUserVo;
import com.douzone.nest.vo.CommentVo;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	public boolean insertComment(CommentVo commentVo) {
			return 1 == commentRepository.insertComment(commentVo);
	}

	public boolean updateCommentContents(Long commentNo, CommentVo commentVo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("commentNo", commentNo);
		map.put("commentContents", commentVo.getCommentContents());
		
		return 1 == commentRepository.updateCommentContents(map);
	}

	public boolean deleteComment(Long fileNo, Long commentNo) {
		
		int userlike = commentRepository.deleteUserLikeByCommentNo(commentNo);
		int comment = commentRepository.deleteComment(commentNo);
		
		int file = 0;
		if(fileNo != 0) {
			file = fileRepository.deleteFile(fileNo);
		}
			
		return comment + file + userlike > 1;
	}

	public CommentLikeUserVo selectLikeUser(Long userNo, Long commentNo) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("userNo", userNo);
		map.put("commentNo", commentNo);
		
		return commentRepository.selectLikeUser(map);
	}

	public boolean insertLikeUser(Long userNo, Long commentNo) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("userNo", userNo);
		map.put("commentNo", commentNo);
		
		return 1 == commentRepository.insertLikeUser(map);
	}

	public boolean deleteLikeUser(Long userNo, Long commentNo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("userNo", userNo);
		map.put("commentNo", commentNo);
		
		return 1 == commentRepository.deleteLikeUser(map);
		
	}

	public Map<String, Object> updateCommentLike(CommentLikeUserVo userlike, Long userNo, Long commentNo, int commentLike) {
		
		Map<String, Object> map = new HashMap<>();
		CommentVo commentVo = new CommentVo();
		boolean result = false;
		
		map.put("commentNo", commentNo);
		map.put("userNo", userNo);
		
		if(userlike == null) {
			//코멘트 수 증가하기
			commentRepository.insertLikeUser(map);
			commentVo.setCommentLike(commentLike + 1);
			map.put("commentLike", commentVo.getCommentLike());
			System.out.println("insert + " + commentVo.getCommentLike());
		} else {
			//코멘트 수 감소하기
			commentRepository.deleteLikeUser(map);
			commentVo.setCommentLike(commentLike - 1);
			map.put("commentLike", commentVo.getCommentLike());
			System.out.println("delete + " + commentVo.getCommentLike());
		}
		result = 1 == commentRepository.updateCommentLike(map);
		
		map.put("result", result);
		
		return map;
	}
	
	
}
