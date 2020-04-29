package com.douzone.nest.vo;

public class NoticeSetVo {
	private Long userNo;				// 회원번호
	private String noticesetAssing;		// 배정알림
	private String noticesetLike;		// 좋아요알림
	private String noticesetComment;	// 코멘트알림
	private String noticesetMention;	// 맨션알림
	private String noticesetSlack;		// 슬랙알림
	private String noticesetGit;		// 깃알림
	private String noticesetCalender;	// 구글캘린더알림
	private String noticesetEmail;		// 구글이메일알림
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getNoticesetAssing() {
		return noticesetAssing;
	}
	public void setNoticesetAssing(String noticesetAssing) {
		this.noticesetAssing = noticesetAssing;
	}
	public String getNoticesetLike() {
		return noticesetLike;
	}
	public void setNoticesetLike(String noticesetLike) {
		this.noticesetLike = noticesetLike;
	}
	public String getNoticesetComment() {
		return noticesetComment;
	}
	public void setNoticesetComment(String noticesetComment) {
		this.noticesetComment = noticesetComment;
	}
	public String getNoticesetMention() {
		return noticesetMention;
	}
	public void setNoticesetMention(String noticesetMention) {
		this.noticesetMention = noticesetMention;
	}
	public String getNoticesetSlack() {
		return noticesetSlack;
	}
	public void setNoticesetSlack(String noticesetSlack) {
		this.noticesetSlack = noticesetSlack;
	}
	public String getNoticesetGit() {
		return noticesetGit;
	}
	public void setNoticesetGit(String noticesetGit) {
		this.noticesetGit = noticesetGit;
	}
	public String getNoticesetCalender() {
		return noticesetCalender;
	}
	public void setNoticesetCalender(String noticesetCalender) {
		this.noticesetCalender = noticesetCalender;
	}
	public String getNoticesetEmail() {
		return noticesetEmail;
	}
	public void setNoticesetEmail(String noticesetEmail) {
		this.noticesetEmail = noticesetEmail;
	}
	
	@Override
	public String toString() {
		return "NoticeSetVo [userNo=" + userNo + ", noticesetAssing=" + noticesetAssing + ", noticesetLike="
				+ noticesetLike + ", noticesetComment=" + noticesetComment + ", noticesetMention=" + noticesetMention
				+ ", noticesetSlack=" + noticesetSlack + ", noticesetGit=" + noticesetGit + ", noticesetCalender="
				+ noticesetCalender + ", noticesetEmail=" + noticesetEmail + "]";
	}
}
