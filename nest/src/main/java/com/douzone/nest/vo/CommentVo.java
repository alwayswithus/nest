package com.douzone.nest.vo;

public class CommentVo {
	private Long commentNo;			// 코멘트 번호
	private String commentRegdate;	// 코멘트 등록일
	private String commentContents; // 코멘트 내용
	private int commentLike; 		// 코멘트 좋아요
	
	private Long userNo;			// 회원 번호
	private String userName; 		//회원 이름
	private String userPhoto; 		//회원 프로필
	private String userEmail; 		//회원 이메일
	
	private String commentState; // 코멘트 상태
	private Long taskNo;			// 업무 번호
	
	private Long fileNo;			// 파일 번호
	private String originName; 		// 원본이름
	private String filePath; 		// 파일 경로
	private String fileRegdate;		// 파일 등록일
	
	private String fileState; // 파일 상태

	public String getFileState() {
		return fileState;
	}
	public void setFileState(String fileState) {
		this.fileState = fileState;
	}
	public String getCommentState() {
		return commentState;
	}
	public void setCommentState(String commentState) {
		this.commentState = commentState;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
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
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentRegdate() {
		return commentRegdate;
	}
	public void setCommentRegdate(String commentRegdate) {
		this.commentRegdate = commentRegdate;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public int getCommentLike() {
		return commentLike;
	}
	public void setCommentLike(int commentLike) {
		this.commentLike = commentLike;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}
	public Long getFileNo() {
		return fileNo;
	}
	public void setFileNo(Long fileNo) {
		this.fileNo = fileNo;
	}
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", commentRegdate=" + commentRegdate + ", commentContents="
				+ commentContents + ", commentLike=" + commentLike + ", userNo=" + userNo + ", userName=" + userName
				+ ", userPhoto=" + userPhoto + ", userEmail=" + userEmail + ", commentState=" + commentState
				+ ", taskNo=" + taskNo + ", fileNo=" + fileNo + ", originName=" + originName + ", filePath=" + filePath
				+ ", fileRegdate=" + fileRegdate + ", fileState=" + fileState + "]";
	}
	
}
