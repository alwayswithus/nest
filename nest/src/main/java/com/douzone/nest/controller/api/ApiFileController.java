package com.douzone.nest.controller.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.internet.ContentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.nest.dto.JsonResult;
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
	private ApplicationContext applicationContext;
	
	@PostMapping("/api/upload")
    public JsonResult FileUpload(
    		@RequestParam("file") MultipartFile multipartFile,
    		@RequestParam("taskNo") Long taskNo,
    		@RequestParam("userNo") Long userNo) throws IOException {    
    
	FileVo fileVo = new FileVo();
	String url = fileUploadService.restore(fileVo, multipartFile);
	
	fileVo.setFilePath(url);
	fileVo.setOriginName(multipartFile.getOriginalFilename());
	fileVo.setTaskNo(taskNo);
	
    fileService.insertFile(fileVo, userNo); //파일 insert
    
	return JsonResult.success(fileVo);
	}
	

	@GetMapping("/api/download/{fileNo}")
	@CrossOrigin(value= {"*"}, exposedHeaders = {"Content-Disposition"})
	public ResponseEntity<Resource> downloadFile(@PathVariable("fileNo") Long fileNo) throws IOException {
		String changeName = fileService.findByFileNo(fileNo);
		
		Path path = Paths.get("/nest-uploads/" + changeName);
		
		String contentType = Files.probeContentType(path);
		HttpHeaders headers = new HttpHeaders();
		
		headers.add(HttpHeaders.CONTENT_TYPE, contentType); // content type을 조사하여 response header에 세팅
		headers.set("Content-Disposition", "attachment; filename=" + path.getFileName()); // 브라우저에서 url 호출
		Resource resource = new InputStreamResource(Files.newInputStream(path));
		
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}
}
