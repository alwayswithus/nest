package com.douzone.nest.vo;

public class TaskVo {
	private Long taskNo;      // 업무 번호
	private String taskStart;    // 업무 시작일
	private String taskEnd;    // 업무 마감일
	private Long taskPoint;    // 업무 중요도
	private String taskLabel;    // 업무 라벨
	private String taskState;   // 업무 상태
	private String taskContents;// 업무 내용
	private Long taskOrder;      // 업무 정렬 번호
	private Long taskListNo; // 업무 리스트 번호
	private String taskRegdate; // 업무 생성일
	private Long taskWriter; // 업무 작성자
	private Long taskListOrder; // 업무리스트 정렬번호
	private Long projectNo;	   // 프로젝트번호

	public String getTaskRegdate() {
		return taskRegdate;
	}
	public void setTaskRegdate(String taskRegdate) {
		this.taskRegdate = taskRegdate;
	}
	public Long getTaskWriter() {
		return taskWriter;
	}
	public void setTaskWriter(Long taskWriter) {
		this.taskWriter = taskWriter;
	}
	public Long getTaskListNo() {
		return taskListNo;
	}
	public void setTaskListNo(Long taskListNo) {
		this.taskListNo = taskListNo;
	}
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
		return "TaskVo [taskNo=" + taskNo + ", taskStart=" + taskStart + ", taskEnd=" + taskEnd + ", taskPoint="
				+ taskPoint + ", taskLabel=" + taskLabel + ", taskState=" + taskState + ", taskContents=" + taskContents
				+ ", taskOrder=" + taskOrder + ", taskListNo=" + taskListNo + ", taskRegdate=" + taskRegdate
				+ ", taskWriter=" + taskWriter + ", taskListOrder=" + taskListOrder + ", projectNo=" + projectNo + "]";
	}
}
