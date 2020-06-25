package com.douzone.nest.vo;

import java.util.List;

public class TaskUserVo {

	private Long userNo;	// 회원번호
	private Long taskNo;	// 업무번호 
	private List<Long> multiTask;
	
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
	
	public List<Long> getMultiTask() {
		return multiTask;
	}
	public void setMultiTask(List<Long> multiTask) {
		this.multiTask = multiTask;
	}
	
	@Override
	public String toString() {
		return "TaskUserVo [userNo=" + userNo + ", taskNo=" + taskNo + ", multiTask=" + multiTask + "]";
	}
}
