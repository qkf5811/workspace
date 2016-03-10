package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.MaintainRecord;

public class MaintainRecordDto extends MaintainRecord{
	private String itemCode;
	private String equName;
	private String equBrand;
	private String equModel;
	private String maintainUserName;
	private String maintainRecordSTime;
	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
	public void setEquBrand(String equBrand) {
		this.equBrand = equBrand;
	}
	public void setEquModel(String equModel) {
		this.equModel = equModel;
	}
	public void setMaintainUserName(String maintainUserName) {
		this.maintainUserName = maintainUserName;
	}
	public void setMaintainRecordSTime(String maintainRecordSTime) {
		this.maintainRecordSTime = maintainRecordSTime;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	public String getEquName() {
		return equName;
	}
	public String getEquBrand() {
		return equBrand;
	}
	public String getEquModel() {
		return equModel;
	}
	public String getMaintainUserName() {
		return maintainUserName;
	}
	public String getMaintainRecordSTime() {
		return maintainRecordSTime;
	}
	
	
}
