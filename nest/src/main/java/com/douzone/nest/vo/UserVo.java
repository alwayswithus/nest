package com.douzone.nest.vo;

public class UserVo {

	private Long userNo;			// 회원번호
	private String userRegdate;		// 가입일
	private String userEmail;		// 이메일
	private String userName;		// 이름
	private String userPassword;	// 비밀번호
	private String userNumber;		// 전화번호
	private String userBirth;		// 생년월일
	private String userTitle;		// 직함
	private String userDept;		// 부서
	private String userTimezone;	// 시간설정
	private String userPhoto;		// 프로필사진
	private String userBg;			// 배경사진

	private String userGrade;		// 회원등급
	private String userKey;		// 회원등급
	
	private Long projectNo; 		// 프로젝트 번호

	private Long roleNo;			// 권한번호
	
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserTimezone() {
		return userTimezone;
	}
	public void setUserTimezone(String userTimezone) {
		this.userTimezone = userTimezone;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserBg() {
		return userBg;
	}
	public void setUserBg(String useBg) {
		this.userBg = useBg;
	}
	public Long getRoleNo() {
		return roleNo;
	}
	public void setRoleNo(Long roleNo) {
		this.roleNo = roleNo;
	}
	public String getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public Long getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Long projectNo) {
		this.projectNo = projectNo;
	}
	
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userRegdate=" + userRegdate + ", userEmail=" + userEmail + ", userName="
				+ userName + ", userPassword=" + userPassword + ", userNumber=" + userNumber + ", userBirth="
				+ userBirth + ", userTitle=" + userTitle + ", userDept=" + userDept + ", userTimezone=" + userTimezone
				+ ", userPhoto=" + userPhoto + ", userBg=" + userBg + ", userGrade=" + userGrade + ", projectNo="
				+ projectNo + ", roleNo=" + roleNo + "]";
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
}
