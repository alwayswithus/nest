package com.douzone.nest.vo;

public class TagListVo {
	private Long tagNo; //태그번호
	private String tagName; //태그이름
	private String tagColor; //태그 색상
	
	public String getTagColor() {
		return tagColor;
	}
	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}
	public Long getTagNo() {
		return tagNo;
	}
	public void setTagNo(Long tagNo) {
		this.tagNo = tagNo;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	@Override
	public String toString() {
		return "TagListVo [tagNo=" + tagNo + ", tagName=" + tagName + ", tagColor=" + tagColor + "]";
	}
}
