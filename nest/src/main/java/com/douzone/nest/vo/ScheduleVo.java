package com.douzone.nest.vo;

public class ScheduleVo {
	private Long scheduleNo;		 // 일정번호
	private String scheduleStart;	 // 개인일정시작일
	private String scheduleEnd;		 // 개인일정마감일
	private String scheduleContents; // 개인일정내용
	private Long userNo;			 // 회원번호
	
	public Long getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(Long scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public String getScheduleStart() {
		return scheduleStart;
	}
	public void setScheduleStart(String scheduleStart) {
		this.scheduleStart = scheduleStart;
	}
	public String getScheduleEnd() {
		return scheduleEnd;
	}
	public void setScheduleEnd(String scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	public String getScheduleContents() {
		return scheduleContents;
	}
	public void setScheduleContents(String scheduleContents) {
		this.scheduleContents = scheduleContents;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "ScheduleVo [scheduleNo=" + scheduleNo + ", scheduleStart=" + scheduleStart + ", scheduleEnd="
				+ scheduleEnd + ", scheduleContents=" + scheduleContents + ", userNo=" + userNo + "]";
	}
}
