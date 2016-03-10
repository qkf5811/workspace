package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.Student;

public class StudentDto extends Student{
	private String classIdStr;
	private String className;
	private String stuStatus;
	private String stuIsFreeTuition;
	private String majorFieldClassName;
	private String gradeName;
	private String majorFieldName;
	private String majorName;
	private String finClassName;
	public String getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	public String getStuIsFreeTuition() {
		return stuIsFreeTuition;
	}

	public void setStuIsFreeTuition(String stuIsFreeTuition) {
		this.stuIsFreeTuition = stuIsFreeTuition;
	}

	public String getFinClassName() {
		return finClassName;
	}

	public void setFinClassName(String finClassName) {
		this.finClassName = finClassName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassIdStr() {
		return classIdStr;
	}

	public void setClassIdStr(String classIdStr) {
		this.classIdStr = classIdStr;
	}

	public String getMajorFieldClassName() {
		return majorFieldClassName;
	}

	public void setMajorFieldClassName(String majorFieldClassName) {
		this.majorFieldClassName = majorFieldClassName;
	}

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

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}


}
