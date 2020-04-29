package com.douzone.nest.vo;

public class CommentVo {
	private Long commentNo;			// 코멘트 번호
	private String commentRegdate;	// 코멘트 등록일
	private String commentContents; // 코멘트 내용
	private Long commentLike; 		// 코멘트 좋아요
	
	private Long userNo;			// 회원 번호
	private Long taskNo;			// 업무 번호
	private Long fileNo;			// 파일 번호
	
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
	public Long getCommentLike() {
		return commentLike;
	}
	public void setCommentLike(Long commentLike) {
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
				+ commentContents + ", commentLike=" + commentLike + ", userNo=" + userNo + ", taskNo=" + taskNo
				+ ", fileNo=" + fileNo + "]";
	}
	
}
