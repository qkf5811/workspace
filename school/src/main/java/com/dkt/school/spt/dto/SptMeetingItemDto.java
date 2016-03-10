package com.dkt.school.spt.dto;

import com.dkt.school.spt.model.SptMeetingItem;

public class SptMeetingItemDto extends SptMeetingItem{
	
	// 负责人姓名
	private String chargePersonName;
	// 负责人工号
	private String code;
	// 项目类型
	private String typeStr;
	
	public String getChargePersonName() {
		return chargePersonName;
	}
	public void setChargePersonName(String chargePersonName) {
		this.chargePersonName = chargePersonName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}
	
}
