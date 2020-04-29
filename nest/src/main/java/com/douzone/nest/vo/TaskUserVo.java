package com.douzone.nest.vo;

public class TaskUserVo {

	private Long userNo;	// 회원번호
	private Long taskNo;	// 업무번호 
	
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
	
	@Override
	public String toString() {
		return "TaskUserVo [userNo=" + userNo + ", taskNo=" + taskNo + "]";
	}
}
