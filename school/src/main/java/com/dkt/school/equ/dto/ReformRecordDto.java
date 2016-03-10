package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.ReformRecord;

public class ReformRecordDto extends ReformRecord{
	private String itemCode;
	private String equName;
	private String equBrand;
	private String equModel;
	private String reformUserName;
	private String reformRecordSTime;
	
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
	public void setReformUserName(String reformUserName) {
		this.reformUserName = reformUserName;
	}
	public void setReformRecordSTime(String reformRecordSTime) {
		this.reformRecordSTime = reformRecordSTime;
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
	public String getReformUserName() {
		return reformUserName;
	}
	public String getReformRecordSTime() {
		return reformRecordSTime;
	}
	
	
	
}
