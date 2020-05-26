package com.douzone.nest.vo;

public class TaskListVo {
	private Long tasklistNo;	// 업무리스트 번호
	private String tasklistName;// 업무리스트 이름
//	private Long tasklistOrder; // 업무리스트 정렬번호
	
//	private Long projectNo;		// 프로젝트 번호
	
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
//	public Long getTasklistOrder() {
//		return tasklistOrder;
//	}
//	public void setTasklistOrder(Long tasklistOrder) {
//		this.tasklistOrder = tasklistOrder;
//	}
//	public Long getProjectNo() {
//		return projectNo;
//	}
//	public void setProjectNo(Long projectNo) {
//		this.projectNo = projectNo;
//	}
	@Override
	public String toString() {
		return "TaskListVo [tasklistNo=" + tasklistNo + ", tasklistName=" + tasklistName +"]";
	}
	
	
}
