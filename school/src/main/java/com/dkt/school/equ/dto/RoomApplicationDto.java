package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.RoomApplication;

public class RoomApplicationDto extends RoomApplication{
	private String useFromDateStr;
	private String useToDateStr;
	public String getUseFromDateStr() {
		return useFromDateStr;
	}
	public void setUseFromDateStr(String useFromDateStr) {
		this.useFromDateStr = useFromDateStr;
	}
	public String getUseToDateStr() {
		return useToDateStr;
	}
	public void setUseToDateStr(String useToDateStr) {
		this.useToDateStr = useToDateStr;
	}
	
	
	
}
