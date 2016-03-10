package com.dkt.school.pe.dto;

import java.util.Date;

import com.dkt.school.pe.model.PeWorkTask;

public class PeWorkTaskDto extends PeWorkTask {
	//负责人
	private String name;
	//任务
	private String mission;
	private Date startDatetime;
	private Date endDatetime;
	
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(Date startDatetime) {
		this.startDatetime = startDatetime;
	}
	public Date getEndDatetime() {
		return endDatetime;
	}
	public void setEndDatetime(Date endDatetime) {
		this.endDatetime = endDatetime;
	}
	
}
