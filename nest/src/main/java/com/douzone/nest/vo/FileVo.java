package com.douzone.nest.vo;

public class FileVo {
	private Long fileNo; // 파일번호
	private String originName; // 원본이름
	private String changeName; // 변경이름
	private String filePath; // 파일경로
	private String fileRegdate; // 파일 등록일
	private Long taskNo; //업무번호
	
	public Long getFileNo() {
		return fileNo;
	}
	public void setFileNo(Long fileNo) {
		this.fileNo = fileNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileRegdate() {
		return fileRegdate;
	}
	public void setFileRegdate(String fileRegdate) {
		this.fileRegdate = fileRegdate;
	}
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}

	@Override
	public String toString() {
		return "FileVo [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName + ", filePath="
				+ filePath + ", fileRegdate=" + fileRegdate + ", taskNo=" + taskNo + "]";
	}
}