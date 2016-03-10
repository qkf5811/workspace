package com.dkt.school.spt.dto;

import com.dkt.school.spt.model.SptMeeting;

public class SptMeetingDto extends SptMeeting {
	private String launchDatetimeStr;

	public String getLaunchDatetimeStr() {
		return launchDatetimeStr;
	}

	public void setLaunchDatetimeStr(String launchDatetimeStr) {
		this.launchDatetimeStr = launchDatetimeStr;
	}
	
}
