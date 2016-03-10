package com.dkt.school.sch.dto;

import com.dkt.school.sch.model.Building;

public class BuildingDto extends Building {

	private String campusName;

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
}
