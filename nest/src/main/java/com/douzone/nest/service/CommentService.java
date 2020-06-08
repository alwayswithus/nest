package com.douzone.nest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CommentRepository;
import com.douzone.nest.repository.FileRepository;
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

	public boolean updateComment(Long commentNo, CommentVo commentVo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("commentNo", commentNo);
		map.put("commentContents", commentVo.getCommentContents());
		map.put("commentLike", commentVo.getCommentLike()+1);
		
		return 1 == commentRepository.updateComment(map);
	}

	public boolean deleteComment(Long fileNo, Long commentNo) {
		
		System.out.println(commentNo + " : 코멘트 삭제 전 ");
		int comment = commentRepository.deleteComment(commentNo);
		System.out.println(comment+" : 코멘트 삭제 후");
		int file = 0;
		if(fileNo != 0) {
			System.out.println("파일 삭제전");
			file = fileRepository.deleteFile(fileNo);
			System.out.println("파일 삭제 후");
		}
			
		return comment + file > 0;
	}
	
	
}
