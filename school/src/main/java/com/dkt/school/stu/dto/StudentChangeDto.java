package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.StudentChange;

public class StudentChangeDto extends StudentChange{
	private String name;
	private String code;
	private String intoClassDateStr;
	private String outClassDateStr;
    private String outClassName;
    private String intoClassName;
    private String changeTypeStr;
    private String OutClassMajorName;
    private String IntoClassMajorName;
    private String studentStatus;
        
	public String getStudentStatus() {
		return studentStatus;
	}
	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getIntoClassDateStr() {
		return intoClassDateStr;
	}
	public void setIntoClassDateStr(String intoClassDateStr) {
		this.intoClassDateStr = intoClassDateStr;
	}
	public String getOutClassDateStr() {
		return outClassDateStr;
	}
	public void setOutClassDateStr(String outClassDateStr) {
		this.outClassDateStr = outClassDateStr;
	}
	public String getOutClassName() {
		return outClassName;
	}
	public void setOutClassName(String outClassName) {
		this.outClassName = outClassName;
	}
	public String getIntoClassName() {
		return intoClassName;
	}
	public void setIntoClassName(String intoClassName) {
		this.intoClassName = intoClassName;
	}
	public String getChangeTypeStr() {
		return changeTypeStr;
	}
	public void setChangeTypeStr(String changeTypeStr) {
		this.changeTypeStr = changeTypeStr;
	}
	public String getOutClassMajorName() {
		return OutClassMajorName;
	}
	public void setOutClassMajorName(String outClassMajorName) {
		OutClassMajorName = outClassMajorName;
	}
	public String getIntoClassMajorName() {
		return IntoClassMajorName;
	}
	public void setIntoClassMajorName(String intoClassMajorName) {
		IntoClassMajorName = intoClassMajorName;
	}
	
	
	

}
