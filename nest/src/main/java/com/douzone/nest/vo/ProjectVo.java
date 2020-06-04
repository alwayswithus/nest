package com.douzone.nest.vo;

import java.util.List;

public class ProjectVo {
	private Long projectNo;		 	// 프로젝트 번호
	private String projectTitle; 	// 프로젝트 이름
	private String projectDesc; 	// 프로젝트 설명
	private String projectStart; 	// 프로젝트 시작일
	private String projectEnd; 		// 프로젝트 마감일
	private String projectState;	// 프로젝트 상태
	private String projectRegDate;	// 프로젝트 작성일
	private Long projectWriter;		// 프로젝트 작성자
	
	private Long userNo; // 프로젝트 작성자
	
	private List<UserVo> members;			// 프로젝트 멤버
	private String projectWriterName;		// 프로젝트 작성자 이름
	private int taskCount;					// 업무 개수
	private int completedTask;				// 완료된 업무 개수
	private Long roleNo;					// 세션 사용자의 프로젝트에서의 권한번호
	
	private Long sessionUserNo;				// 세션 사용자 번호
	
	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

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

	public String getProjectRegDate() {
		return projectRegDate;
	}

	public void setProjectRegDate(String projectRegDate) {
		this.projectRegDate = projectRegDate;
	}

	public Long getProjectWriter() {
		return projectWriter;
	}

	public void setProjectWriter(Long projectWriter) {
		this.projectWriter = projectWriter;
	}

	public String getProjectWriterName() {
		return projectWriterName;
	}

	public void setProjectWriterName(String projectWriterName) {
		this.projectWriterName = projectWriterName;
	}

	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}

	public int getCompletedTask() {
		return completedTask;
	}

	public void setCompletedTask(int completedTask) {
		this.completedTask = completedTask;
	}

	public Long getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(Long roleNo) {
		this.roleNo = roleNo;
	}

	public Long getSessionUserNo() {
		return sessionUserNo;
	}

	public void setSessionUserNo(Long sessionUserNo) {
		this.sessionUserNo = sessionUserNo;
	}

	@Override
	public String toString() {
		return "ProjectVo [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectDesc=" + projectDesc
				+ ", projectStart=" + projectStart + ", projectEnd=" + projectEnd + ", projectState=" + projectState
				+ ", projectRegDate=" + projectRegDate + ", projectWriter=" + projectWriter + ", userNo=" + userNo
				+ ", members=" + members + ", projectWriterName=" + projectWriterName + ", taskCount=" + taskCount
				+ ", completedTask=" + completedTask + ", roleNo=" + roleNo + ", sessionUserNo=" + sessionUserNo + "]";
	}
}
