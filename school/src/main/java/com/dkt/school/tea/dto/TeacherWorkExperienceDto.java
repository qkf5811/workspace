package com.dkt.school.tea.dto;

import com.dkt.school.tea.model.TeacherWorkExperience;

public class TeacherWorkExperienceDto extends TeacherWorkExperience{

	//编号
	private String code;
	//姓名
	private String name;
	//开始时间
	private String startDateStr;
	//结束时间
	private String endDateStr;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	@Override
	public String toString() {
		return 	super.toString() + System.lineSeparator() + 
				"TeacherWorkExperienceDto [code=" + code + ", name=" + name + ", startDateStr="
				+ startDateStr + ", endDateStr=" + endDateStr + "]";
	}
	
	
}
