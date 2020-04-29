package com.douzone.nest.vo;

public class CheckListVo {
	private Long checklistNo; // 체크리스트번호
	private String checklistContents; //하부할일내용
	private String checklistState; // 체크리스트상태('do','done')
	private Long taskNo; //업무번호
	
	public Long getChecklistNo() {
		return checklistNo;
	}
	public void setChecklistNo(Long checklistNo) {
		this.checklistNo = checklistNo;
	}
	public String getChecklistContents() {
		return checklistContents;
	}
	public void setChecklistContents(String checklistContents) {
		this.checklistContents = checklistContents;
	}
	public String getChecklistState() {
		return checklistState;
	}
	public void setChecklistState(String checklistState) {
		this.checklistState = checklistState;
	}
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}
	
	@Override
	public String toString() {
		return "CheckListVo [checklistNo=" + checklistNo + ", checklistContents=" + checklistContents
				+ ", checklistState=" + checklistState + ", taskNo=" + taskNo + "]";
	}
}
