package com.douzone.nest.vo;

public class ProjectVo {
	private Long projectNo;		 	// 프로젝트 번호
	private String projectTitle; 	// 프로젝트 이름
	private String projectDesc; 	// 프로젝트 설명
	private String projectStart; 	// 프로젝트 시작일
	private String projectEnd; 		// 프로젝트 마감일
	private String projectState;	// 프로젝트 상태

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

	@Override
	public String toString() {
		return "ProjectVo [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectDesc=" + projectDesc
				+ ", projectStart=" + projectStart + ", projectEnd=" + projectEnd + ", projectState=" + projectState
				+ "]";
	}

}
