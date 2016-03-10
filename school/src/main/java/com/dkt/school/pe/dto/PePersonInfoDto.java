package com.dkt.school.pe.dto;

import com.dkt.school.pe.model.PePersonInfo;

public class PePersonInfoDto extends PePersonInfo {
	private String code;
	private String name;
	private String sex;
	private String positionStr;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPositionStr() {
		return positionStr;
	}
	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}
	@Override
	public String toString() {
		return "PePersonInfoDto [code=" + code + ", name=" + name + ", sex=" + sex + ", positionStr=" + positionStr + "]";
	}
}
