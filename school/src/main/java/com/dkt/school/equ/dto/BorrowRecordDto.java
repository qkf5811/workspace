package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.BorrowRecord;

public class BorrowRecordDto extends BorrowRecord{

	public String codes;
	
	public String borrowDateStr;
	
	public String borrowDealineStr;
	private String name;
	private String email;
	private String mobile;
	private String address;
	private String itemName;
	private String borrowDateSTime;
	private String borrowDealineSTime;
	
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

	public String getBorrowDateSTime() {
		return borrowDateSTime;
	}

	public void setBorrowDateSTime(String borrowDateSTime) {
		this.borrowDateSTime = borrowDateSTime;
	}

	public String getBorrowDealineSTime() {
		return borrowDealineSTime;
	}

	public void setBorrowDealineSTime(String borrowDealineSTime) {
		this.borrowDealineSTime = borrowDealineSTime;
	}

	public String getBorrowDateStr() {
		return borrowDateStr;
	}

	public void setBorrowDateStr(String borrowDateStr) {
		this.borrowDateStr = borrowDateStr;
	}

	public String getBorrowDealineStr() {
		return borrowDealineStr;
	}

	public void setBorrowDealineStr(String borrowDealineStr) {
		this.borrowDealineStr = borrowDealineStr;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

}
