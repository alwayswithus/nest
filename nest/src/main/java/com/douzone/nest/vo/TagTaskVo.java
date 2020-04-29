package com.douzone.nest.vo;

public class TagTaskVo {
	private Long tagNo; // 태그번호
	private Long taskNo; //업무번호
	
	public Long getTagNo() {
		return tagNo;
	}
	public void setTagNo(Long tagNo) {
		this.tagNo = tagNo;
	}
	public Long getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}
	
	@Override
	public String toString() {
		return "TagTaskVo [tagNo=" + tagNo + ", taskNo=" + taskNo + "]";
	}
}
