package com.douzone.nest.vo;

public class TaskListVo {
	private Long tasklistNo;	// 업무 번호
	private String tasklistName;// 업무 시작일
	private Long tasklistOrder; // 업무 중요도
	
	private Long projectNo;		// 프로젝트 번호
	
	public Long getTasklistNo() {
		return tasklistNo;
	}
	public void setTasklistNo(Long tasklistNo) {
		this.tasklistNo = tasklistNo;
	}
	public String getTasklistName() {
		return tasklistName;
	}
	public void setTasklistName(String tasklistName) {
		this.tasklistName = tasklistName;
	}
	public Long getTasklistOrder() {
		return tasklistOrder;
	}
	public void setTasklistOrder(Long tasklistOrder) {
		this.tasklistOrder = tasklistOrder;
	}
	public Long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}
	
	@Override
	public String toString() {
		return "TaskListVo [tasklistNo=" + tasklistNo + ", tasklistName=" + tasklistName + ", tasklistOrder="
				+ tasklistOrder + ", projectNo=" + projectNo + ", getTasklistNo()=" + getTasklistNo()
				+ ", getTasklistName()=" + getTasklistName() + ", getTasklistOrder()=" + getTasklistOrder()
				+ ", getProjectNo()=" + getProjectNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
