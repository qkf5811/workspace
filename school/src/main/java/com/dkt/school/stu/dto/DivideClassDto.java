package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.StudentInfo;

public class DivideClassDto extends StudentInfo{
	private String fieldName;
	private String studentCount;
	private String classCount;
	private String divided_studentCount;
	private String not_divided_studentCount;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(String studentCount) {
		this.studentCount = studentCount;
	}
	public String getClassCount() {
		return classCount;
	}
	public void setClassCount(String classCount) {
		this.classCount = classCount;
	}
	public String getDivided_studentCount() {
		return divided_studentCount;
	}
	public void setDivided_studentCount(String divided_studentCount) {
		this.divided_studentCount = divided_studentCount;
	}
	public String getNot_divided_studentCount() {
		return not_divided_studentCount;
	}
	public void setNot_divided_studentCount(String not_divided_studentCount) {
		this.not_divided_studentCount = not_divided_studentCount;
	} 
}
