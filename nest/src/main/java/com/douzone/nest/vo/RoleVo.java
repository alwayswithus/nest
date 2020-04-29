package com.douzone.nest.vo;

public class RoleVo {

	private Long roleNo;		// 권한번호
	private String roleName;	// 권한이름
	
	public Long getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(Long roleNo) {
		this.roleNo = roleNo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "RoleVo [roleNo=" + roleNo + ", roleName=" + roleName + "]";
	}
}
