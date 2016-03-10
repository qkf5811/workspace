package com.dkt.school.edu.dto;

public class CoursePlanOfCourseScheduleDto {
	
	private int planId;
	
	private int majorId;
	
	private int fieldId;
	
	private String majorName;
	
	private String fieldName;
		
	private int gradeId;
	
	private int courseId;
	
	private String courseName;
	
	private String code;
	
	private int teachCourseId;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int plainId) {
		this.planId = plainId;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getTeachCourseId() {
		return teachCourseId;
	}

	public void setTeachCourseId(int teachCourseId) {
		this.teachCourseId = teachCourseId;
	}

	@Override
	public String toString() {
		return "CoursePlanOfCourseScheduleDto [plainId=" + planId
				+ ", majorId=" + majorId + ", fieldId=" + fieldId
				+ ", majorName=" + majorName + ", fieldName=" + fieldName
				+ ", gradeId=" + gradeId + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", code=" + code
				+ ", teachCourseId=" + teachCourseId + "]";
	}
	
	
}
