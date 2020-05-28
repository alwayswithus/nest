package com.douzone.nest.vo;

import java.util.Arrays;
import java.util.List;

public class ProjectVo {
	private Long projectNo;		 	// 프로젝트 번호
	private String projectTitle; 	// 프로젝트 이름
	private String projectDesc; 	// 프로젝트 설명
	private String projectStart; 	// 프로젝트 시작일
	private String projectEnd; 		// 프로젝트 마감일
	private String projectState;	// 프로젝트 상태
	
	private List<UserVo> members;			// 프로젝트 멤버
	
	public Long getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectStart() {
		return projectStart;
	}

	public void setProjectStart(String projectStart) {
		this.projectStart = projectStart;
	}

	public String getProjectEnd() {
		return projectEnd;
	}

	public void setProjectEnd(String projectEnd) {
		this.projectEnd = projectEnd;
	}

	public String getProjectState() {
		return projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	public List<UserVo> getMembers() {
		return members;
	}

	public void setMembers(List<UserVo> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "ProjectVo [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectDesc=" + projectDesc
				+ ", projectStart=" + projectStart + ", projectEnd=" + projectEnd + ", projectState=" + projectState
				+ ", members=" + members + "]";
	}
}
