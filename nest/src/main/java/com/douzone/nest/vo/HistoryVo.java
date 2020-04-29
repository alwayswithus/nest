package com.douzone.nest.vo;

public class HistoryVo {
	private Long logNo; 		// 로그번호
	private String logDate; 	// 로그일자
	private String logContents; // 로그내용
	private Long projectNo;		// 프로젝트번호
	
	public Long getLogNo() {
		return logNo;
	}
	public void setLogNo(Long logNo) {
		this.logNo = logNo;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getLogContents() {
		return logContents;
	}
	public void setLogContents(String logContents) {
		this.logContents = logContents;
	}
	public Long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}
	
	@Override
	public String toString() {
		return "HistoryVo [logNo=" + logNo + ", logDate=" + logDate + ", logContents=" + logContents + ", projectNo="
				+ projectNo + "]";
	}
}
