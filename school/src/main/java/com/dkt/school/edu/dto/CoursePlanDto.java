package com.dkt.school.edu.dto;

import com.dkt.school.edu.model.CoursePlan;

public class CoursePlanDto extends CoursePlan {

	//添加课程计划扩展属性
	private String termTypeStr;
	private String courseTypeStr;
	private String examineTypeStr;
	
	
	//添加edu_course表属性
	private String courseName;
	private String courseCode;
	
	//添加sch_major表属性
	private String majorName;
	
	//添加sch_major_field表属性
	private String majorFieldName;

	
	//添加sch_grade表属性
	private String gradeName;


	private Integer classId;
	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getMajorName() {
		return majorName;
	}


	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}


	public String getMajorFieldName() {
		return majorFieldName;
	}


	public void setMajorFieldName(String majorFieldName) {
		this.majorFieldName = majorFieldName;
	}


	public String getGradeName() {
		return gradeName;
	}


	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}


	public String getTermTypeStr() {
		return termTypeStr;
	}


	public void setTermTypeStr(String termTypeStr) {
		this.termTypeStr = termTypeStr;
	}


	public String getCourseTypeStr() {
		return courseTypeStr;
	}


	public void setCourseTypeStr(String courseTypeStr) {
		this.courseTypeStr = courseTypeStr;
	}


	public String getExamineTypeStr() {
		return examineTypeStr;
	}


	public void setExamineTypeStr(String examineTypeStr) {
		this.examineTypeStr = examineTypeStr;
	}


	public Integer getClassId() {
		return classId;
	}


	public void setClassId(Integer classId) {
		this.classId = classId;
	}


	
	 
	
	
}
