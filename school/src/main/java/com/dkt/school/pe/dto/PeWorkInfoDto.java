package com.dkt.school.pe.dto;

import com.dkt.school.pe.model.PeWorkInfo;

public class PeWorkInfoDto extends PeWorkInfo {
	
	private String startDatetimeStr;
	
	private String endDatetimeStr;
	
	private String mission;
	

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getStartDatetimeStr() {
		return startDatetimeStr;
	}

	public void setStartDatetimeStr(String startDatetimeStr) {
		this.startDatetimeStr = startDatetimeStr;
	}

	public String getEndDatetimeStr() {
		return endDatetimeStr;
	}

	public void setEndDatetimeStr(String endDatetimeStr) {
		this.endDatetimeStr = endDatetimeStr;
	}
	
}
