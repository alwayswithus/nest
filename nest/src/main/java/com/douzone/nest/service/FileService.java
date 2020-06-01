package com.douzone.nest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.CommentRepository;
import com.douzone.nest.repository.FileRepository;
import com.douzone.nest.vo.CommentVo;
import com.douzone.nest.vo.FileVo;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public boolean insertFile(FileVo fileVo, Long userNo) {
		
		CommentVo commentVo = new CommentVo();
		
		int file = fileRepository.insertFile(fileVo);
//		
//		commentVo.setOriginName(fileVo.getOriginName());
//		commentVo.setUserNo(userNo);
//		commentVo.setTaskNo(fileVo.getTaskNo());
//		commentVo.setFileNo(fileVo.getFileNo());
//		
//		int comment = commentRepository.insertComment(commentVo);
//		System.out.println(commentVo);
		return file == 1;
	}
	
}
