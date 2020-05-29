package com.douzone.nest.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.nest.vo.FileVo;

@Service
public class FileUploadService {
	private static final String SAVE_PATH="/nest-uploads";
	private static final String URL="/assets/upimages";
	
	public String restore(FileVo fileVo, MultipartFile multipartFile) {
		
		String url = "";
		
		try {
			String originFileName = multipartFile.getOriginalFilename();
			String extName = originFileName.substring(originFileName.lastIndexOf('.')+1);
			
			String saveFileName = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();
			
			System.out.println("### " + originFileName );
			System.out.println("### " + fileSize);
			System.out.println("### " + saveFileName);
			fileVo.setChangeName(saveFileName);
			
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(fileData);
			os.close();
			
			url = URL + "/"+saveFileName;
			
		} catch(IOException e) {
			throw new RuntimeException("file upload error:"+e);
		}
		return url;
	}
	
	private String generateSaveFilename(String extName) {
		String fileName="";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
		
		return fileName;
	}

}
