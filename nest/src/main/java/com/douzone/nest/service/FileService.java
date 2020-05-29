package com.douzone.nest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.nest.repository.FileRepository;
import com.douzone.nest.vo.FileVo;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	public boolean insertFile(FileVo fileVo) {
		return 1 == fileRepository.insertFile(fileVo);
	}
	
}
