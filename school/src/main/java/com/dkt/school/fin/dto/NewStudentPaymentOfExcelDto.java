package com.dkt.school.fin.dto;

import com.dkt.school.fin.model.NewStudentPayment;

public class NewStudentPaymentOfExcelDto extends NewStudentPayment {

	private String idCard; //身份证号码

	private String admissionNumber; //录取号码
	
	private String majorField;  //专业
	
	private String name;  //姓名
	
	private String payTypeStr;
	
	private String timeStr;  //缴费时间字符串
	
	public String getPayTypeStr() {
		return payTypeStr;
	}

	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajorField() {
		return majorField;
	}

	public void setMajorField(String majorField) {
		this.majorField = majorField;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	
}
