package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.Clazz;

public class ClazzDto extends Clazz{
	private String gradeName;
	private String majorFieldName;
	private String className;
	private String majorFieldClassName;
	private String teacherName;
	private Integer majorId;

	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getMajorFieldName() {
		return majorFieldName;
	}
	public void setMajorFieldName(String majorFieldName) {
		this.majorFieldName = majorFieldName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMajorFieldClassName() {
		return majorFieldClassName;
	}
	public void setMajorFieldClassName(String majorFieldClassName) {
		this.majorFieldClassName = majorFieldClassName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
}
