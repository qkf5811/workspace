package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.UseRecord;

public class UseRecordDto extends UseRecord {

	public String codes;

	public String useDateStr;

	public String useDealineStr;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String itemName;
	private String useDateSTime;
	private String useDealineSTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUseDateSTime() {
		return useDateSTime;
	}

	public void setUseDateSTime(String useDateSTime) {
		this.useDateSTime = useDateSTime;
	}

	public String getUseDealineSTime() {
		return useDealineSTime;
	}

	public void setUseDealineSTime(String useDealineSTime) {
		this.useDealineSTime = useDealineSTime;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public String getUseDateStr() {
		return useDateStr;
	}

	public void setUseDateStr(String useDateStr) {
		this.useDateStr = useDateStr;
	}

	public String getUseDealineStr() {
		return useDealineStr;
	}

	public void setUseDealineStr(String useDealineStr) {
		this.useDealineStr = useDealineStr;
	}

}
