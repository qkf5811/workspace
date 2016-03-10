package com.dkt.school.tea.dto;

import com.dkt.school.tea.model.TeacherChange;

public class TeaChangeDto extends TeacherChange{
	private String name;
	private String code;
	private String changeDateStr;
    private String changeTypeStr;
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
	public String getChangeDateStr() {
		return changeDateStr;
	}
	public void setChangeDateStr(String changeDateStr) {
		this.changeDateStr = changeDateStr;
	}
	public String getChangeTypeStr() {
		return changeTypeStr;
	}
	public void setChangeTypeStr(String changeTypeStr) {
		this.changeTypeStr = changeTypeStr;
	}
    
}
