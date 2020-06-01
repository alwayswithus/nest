package com.douzone.nest.vo;

import java.util.List;

public class TaskReOrderVo {
	private Long startTaskListNo; // 시작 리스트번호
	private Long endTaskListNo;// 끝 리스트 번호
	private List<TaskVo> startTasks; // 시작 테스크 리스트
	private List<TaskVo> endTasks; // 끝 테스크 리스트
	private Long reOrderTask; // taskListNo를 수정 할 taskNo

	public Long getReOrderTask() {
		return reOrderTask;
	}

	public void setReOrderTask(Long reOrderTask) {
		this.reOrderTask = reOrderTask;
	}

	public Long getStartTaskListNo() {
		return startTaskListNo;
	}

	public void setStartTaskListNo(Long startTaskListNo) {
		this.startTaskListNo = startTaskListNo;
	}

	public Long getEndTaskListNo() {
		return endTaskListNo;
	}

	public void setEndTaskListNo(Long endTaskListNo) {
		this.endTaskListNo = endTaskListNo;
	}

	public List<TaskVo> getStartTasks() {
		return startTasks;
	}

	public void setStartTasks(List<TaskVo> startTasks) {
		this.startTasks = startTasks;
	}

	public List<TaskVo> getEndTasks() {
		return endTasks;
	}

	public void setEndTasks(List<TaskVo> endTasks) {
		this.endTasks = endTasks;
	}

	@Override
	public String toString() {
		return "TaskReOrderVo [startTaskListNo=" + startTaskListNo + ", endTaskListNo=" + endTaskListNo
				+ ", startTasks=" + startTasks + ", endTasks=" + endTasks + ", reOrderTask=" + reOrderTask + "]";
	}

}
