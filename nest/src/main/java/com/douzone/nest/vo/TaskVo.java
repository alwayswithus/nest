package com.douzone.nest.vo;

public class TaskVo {
	private Long taskNo;		// 업무 번호
	private String taskStart; 	// 업무 시작일
	private String taskEnd; 	// 업무 마감일
	private Long taskPoint; 	// 업무 중요도
	private String taskLabel; 	// 업무 라벨
	private String taskState;	// 업무 상태
	private String taskContents;// 업무 내용
	private Long taskOrder;		// 업무 정렬 번호
	
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}
	public String getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}
	public String getTaskEnd() {
		return taskEnd;
	}
	public void setTaskEnd(String taskEnd) {
		this.taskEnd = taskEnd;
	}
	public Long getTaskPoint() {
		return taskPoint;
	}
	public void setTaskPoint(Long taskPoint) {
		this.taskPoint = taskPoint;
	}
	public String getTaskLabel() {
		return taskLabel;
	}
	public void setTaskLabel(String taskLabel) {
		this.taskLabel = taskLabel;
	}
	public String getTaskState() {
		return taskState;
	}
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	public String getTaskContents() {
		return taskContents;
	}
	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}
	public Long getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(Long taskOrder) {
		this.taskOrder = taskOrder;
	}

	@Override
	public String toString() {
		return "TaskVo [taskNo=" + taskNo + ", taskStart=" + taskStart + ", taskEnd=" + taskEnd + ", taskPoint="
				+ taskPoint + ", taskLabel=" + taskLabel + ", taskState=" + taskState + ", taskContents=" + taskContents
				+ ", taskOrder=" + taskOrder + "]";
	}
	
}
