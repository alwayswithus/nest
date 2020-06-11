package com.douzone.nest.vo;

public class CommentLikeUserVo {
	private Long userNo; // 좋아요 한 회원번호
	private Long commentNo; // 좋아요 한 코멘트 번호
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	
	@Override
	public String toString() {
		return "CommentLikeUserVo [userNo=" + userNo + ", commentNo=" + commentNo + "]";
	}
	
}
