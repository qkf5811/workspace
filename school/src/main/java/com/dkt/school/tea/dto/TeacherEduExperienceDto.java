package com.dkt.school.tea.dto;

import com.dkt.school.tea.model.TeacherEduExperience;

public class TeacherEduExperienceDto extends TeacherEduExperience {

	private String startDateStr;
	
	private String endDateStr;

	private String educationTypeStr;
	
	private String degreeTypeStr;
	
	public String getEducationTypeStr() {
		return educationTypeStr;
	}

	public void setEducationTypeStr(String educationTypeStr) {
		this.educationTypeStr = educationTypeStr;
	}

	public String getDegreeTypeStr() {
		return degreeTypeStr;
	}

	public void setDegreeTypeStr(String degreeTypeStr) {
		this.degreeTypeStr = degreeTypeStr;
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
}
