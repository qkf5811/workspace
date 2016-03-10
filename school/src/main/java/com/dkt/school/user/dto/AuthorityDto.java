package com.dkt.school.user.dto;

import com.dkt.school.user.model.Authority;

/*
 *@Title: AuthorityDto.java
 *@Package com.dkt.school.user.dto
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午2:46:07
 */
public class AuthorityDto extends Authority {
	
	private boolean isChecked=false;

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
}

