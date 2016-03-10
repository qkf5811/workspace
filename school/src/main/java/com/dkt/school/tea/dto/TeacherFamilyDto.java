package com.dkt.school.tea.dto;

import com.dkt.school.tea.model.TeacherFamily;

public class TeacherFamilyDto extends TeacherFamily{
	private String sex;
	private String birthdayStr;
	private String relationTypeStr;
	private String sexInFamilyStr;
	private String relationTypeInFamilyStr;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getRelationTypeStr() {
		return relationTypeStr;
	}

	public void setRelationTypeStr(String relationTypeStr) {
		this.relationTypeStr = relationTypeStr;
	}

	public String getSexInFamilyStr() {
		return sexInFamilyStr;
	}

	public void setSexInFamilyStr(String sexInFamilyStr) {
		this.sexInFamilyStr = sexInFamilyStr;
	}

	public String getRelationTypeInFamilyStr() {
		return relationTypeInFamilyStr;
	}

	public void setRelationTypeInFamilyStr(String relationTypeInFamilyStr) {
		this.relationTypeInFamilyStr = relationTypeInFamilyStr;
	}
	
}
