package com.dkt.school.equ.dto;

import com.dkt.school.equ.model.ScrapRecord;

public class ScrapRecordDto extends ScrapRecord{
	private String itemCode;
	private String equName;
	private String equBrand;
	private String equModel;
	private String scrapUserName;
	private String scrapRecordSTime;
	
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
	public void setScrapUserName(String scrapUserName) {
		this.scrapUserName = scrapUserName;
	}
	public void setScrapRecordSTime(String scrapRecordSTime) {
		this.scrapRecordSTime = scrapRecordSTime;
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
	public String getScrapUserName() {
		return scrapUserName;
	}
	public String getScrapRecordSTime() {
		return scrapRecordSTime;
	}
	
	
	
}
