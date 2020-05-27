package com.douzone.nest.vo;

public class TaskListVo {
	private Long taskListNo;	// 업무리스트 번호
	private String taskListName;// 업무리스트 이름
	private Long taskListOrder; // 업무리스트 정렬번호
	
	private Long projectNo;		// 프로젝트 번호
	
	public Long getTaskListNo() {
		return taskListNo;
	}
	public void setTaskListNo(Long taskListNo) {
		this.taskListNo = taskListNo;
	}
	public String getTaskListName() {
		return taskListName;
	}
	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}
	public Long getTaskListOrder() {
		return taskListOrder;
	}
	public void setTaskListOrder(Long taskListOrder) {
		this.taskListOrder = taskListOrder;
	}
	public Long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}
	
	@Override
	public String toString() {
		return "TaskListVo [taskListNo=" + taskListNo + ", taskListName=" + taskListName + ", taskListOrder="
				+ taskListOrder + ", projectNo=" + projectNo + "]";
	}

	

	
	
}
