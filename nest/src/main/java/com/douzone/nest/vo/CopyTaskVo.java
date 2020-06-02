package com.douzone.nest.vo;

import java.util.List;

public class CopyTaskVo {
	private Long originalTaskNo; 
	private Long taskNo;
	private Long taskWriter;
	private List<TagListVo> tagList; 
	private List<UserVo> memberList; 
	private List<CheckListVo> checkList; 

	public Long getTaskWriter() {
		return taskWriter;
	}

	public void setTaskWriter(Long taskWriter) {
		this.taskWriter = taskWriter;
	}

	public Long getOriginalTaskNo() {
		return originalTaskNo;
	}

	public void setOriginalTaskNo(Long originalTaskNo) {
		this.originalTaskNo = originalTaskNo;
	}

	public Long getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(Long taskNo) {
		this.taskNo = taskNo;
	}

	public List<TagListVo> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagListVo> tagList) {
		this.tagList = tagList;
	}

	public List<UserVo> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<UserVo> memberList) {
		this.memberList = memberList;
	}

	public List<CheckListVo> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<CheckListVo> checkList) {
		this.checkList = checkList;
	}

	@Override
	public String toString() {
		return "CopyTaskVo [originalTaskNo=" + originalTaskNo + ", taskNo=" + taskNo + ", taskWriter=" + taskWriter
				+ ", tagList=" + tagList + ", memberList=" + memberList + ", checkList=" + checkList + "]";
	}

}
