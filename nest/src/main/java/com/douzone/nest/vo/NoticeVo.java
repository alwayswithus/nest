package com.douzone.nest.vo;

public class NoticeVo {
	private Long noticeNo;			// 알림번호
	private String noticeMessage;	// 알림메시지
	private String noticeRead;		// 알림읽음
	private String noticeType;		// 알림타입
	private Long userNo;			// 회원번호
	
	public Long getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(Long noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeMessage() {
		return noticeMessage;
	}
	public void setNoticeMessage(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}
	public String getNoticeRead() {
		return noticeRead;
	}
	public void setNoticeRead(String noticeRead) {
		this.noticeRead = noticeRead;
	}
	public String getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeMessage=" + noticeMessage + ", noticeRead=" + noticeRead
				+ ", noticeType=" + noticeType + ", userNo=" + userNo + "]";
	}
}
