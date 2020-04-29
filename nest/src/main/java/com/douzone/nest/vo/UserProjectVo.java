package com.douzone.nest.vo;

public class UserProjectVo {

	private Long projectNo;	// 프로젝트번호
	private Long userNo;	// 회원번호
	private Long roleNo;	// 권한번호
	
	public Long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public Long getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(Long roleNo) {
		this.roleNo = roleNo;
	}
	
	@Override
	public String toString() {
		return "UserProjectVo [projectNo=" + projectNo + ", userNo=" + userNo + ", roleNo=" + roleNo + "]";
	}
}
