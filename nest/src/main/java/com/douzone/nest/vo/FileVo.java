package com.douzone.nest.vo;

public class FileVo {
	private Long fileNo; // 파일번호
	private String originName; // 원본이름
	private String changeName; // 변경이름
	private String filePath; // 파일경로
	private String fileRegdate; // 파일 등록일
	private Long taskNo; //업무번호
	
	private String taskContents; //업무 내용
	private String projectNo; // 프로젝트 번호
	private String projectTitle; // 프로젝트 이름
	private Long userNo; // 회원 번호
	private String userName; //회원 이름
	
	private Long tasklistNo; // 태스트리스트 번호
	private String tasklistName; // 테스트리스트 이름
	
	private Long commentNo; // 코멘트 번호
	
	private String fileState; // 파일 상태
	
	public String getFileState() {
		return fileState;
	}
	public void setFileState(String fileState) {
		this.fileState = fileState;
	}
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getTasklistName() {
		return tasklistName;
	}
	public void setTasklistName(String tasklistName) {
		this.tasklistName = tasklistName;
	}
	public Long getTasklistNo() {
		return tasklistNo;
	}
	public void setTasklistNo(Long tasklistNo) {
		this.tasklistNo = tasklistNo;
	}
	public String getTaskContents() {
		return taskContents;
	}
	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
				+ filePath + ", fileRegdate=" + fileRegdate + ", taskNo=" + taskNo + ", taskContents=" + taskContents
				+ ", projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", userNo=" + userNo + ", userName="
				+ userName + ", tasklistNo=" + tasklistNo + ", tasklistName=" + tasklistName + ", commentNo="
				+ commentNo + ", fileState=" + fileState + "]";
	}
}