package com.douzone.nest.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.CommentService;
import com.douzone.nest.service.FileService;
import com.douzone.nest.service.FileUploadService;
import com.douzone.nest.vo.FileVo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiFileController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/api/upload")
    public JsonResult File(
    		@RequestParam("file") MultipartFile multipartFile,
    		@RequestParam("taskNo") Long taskNo,
    		@RequestParam("userNo") Long userNo) throws IOException {    
    
	FileVo fileVo = new FileVo();
	String url = fileUploadService.restore(fileVo, multipartFile);
	fileVo.setFilePath(url);
	fileVo.setOriginName(multipartFile.getOriginalFilename());
	fileVo.setTaskNo(taskNo);
	
    fileService.insertFile(fileVo, userNo); //파일 insert
    
	System.out.println(fileVo);
	return JsonResult.success(fileVo);
	}
}
