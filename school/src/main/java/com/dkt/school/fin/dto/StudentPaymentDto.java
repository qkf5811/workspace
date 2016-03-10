package com.dkt.school.fin.dto;

import com.dkt.school.fin.model.StudentPayment;

public class StudentPaymentDto extends StudentPayment {

	//缴费学生id
	private Integer stuPayId;
	//学期
	private String termTypeStr;
	//缴费学生姓名
	private String stuPayName;
	//缴费学生户主姓名
	private String stuAccountName;
	//缴费学生学号
	private String stuPayCode;
	//缴费学生账号
	private String stuPayAccount;
	//缴费方式
	private String payTypeStr;
	//应缴学生学费
	private Float tuitionFee;
	//应缴学生住宿费
	private Float roomFee;
	//应缴学生书费
	private Float bookFee;
	//应缴合计费用
	private Float totalFee; 
	//已交学费
	private Float paidTuitionFee;
	//已交住宿费
	private Float paidRoomFee;
	//已交书费
	private Float paidBookFee;
	//已交费用合计
	private Float paidTotalFee;
	//非扣税费备注
	private String deductRemark;
	
	public Integer getStuPayId() {
		return stuPayId;
	}
	public void setStuPayId(Integer stuPayId) {
		this.stuPayId = stuPayId;
	}
	public String getTermTypeStr() {
		return termTypeStr;
	}
	public void setTermTypeStr(String termTypeStr) {
		this.termTypeStr = termTypeStr;
	}
	public String getStuPayName() {
		return stuPayName;
	}
	public void setStuPayName(String stuPayName) {
		this.stuPayName = stuPayName;
	}
	public String getStuPayCode() {
		return stuPayCode;
	}
	public void setStuPayCode(String stuPayCode) {
		this.stuPayCode = stuPayCode;
	}
	public String getStuPayAccount() {
		return stuPayAccount;
	}
	public void setStuPayAccount(String stuPayAccount) {
		this.stuPayAccount = stuPayAccount;
	}
	public String getPayTypeStr() {
		return payTypeStr;
	}
	public void setPayTypeStr(String payTypeStr) {
		this.payTypeStr = payTypeStr;
	}
	public Float getTuitionFee() {
		return tuitionFee;
	}
	public void setTuitionFee(Float tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	public Float getRoomFee() {
		return roomFee;
	}
	public void setRoomFee(Float roomFee) {
		this.roomFee = roomFee;
	}
	public Float getBookFee() {
		return bookFee;
	}
	public void setBookFee(Float bookFee) {
		this.bookFee = bookFee;
	}
	public Float getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}
	public Float getPaidTuitionFee() {
		return paidTuitionFee;
	}
	public void setPaidTuitionFee(Float paidTuitionFee) {
		this.paidTuitionFee = paidTuitionFee;
	}
	public Float getPaidRoomFee() {
		return paidRoomFee;
	}
	public void setPaidRoomFee(Float paidRoomFee) {
		this.paidRoomFee = paidRoomFee;
	}
	public Float getPaidBookFee() {
		return paidBookFee;
	}
	public void setPaidBookFee(Float paidBookFee) {
		this.paidBookFee = paidBookFee;
	}
	public Float getPaidTotalFee() {
		return paidTotalFee;
	}
	public void setPaidTotalFee(Float paidTotalFee) {
		this.paidTotalFee = paidTotalFee;
	}
	public String getDeductRemark() {
		return deductRemark;
	}
	public void setDeductRemark(String deductRemark) {
		this.deductRemark = deductRemark;
	}
	public void setStuAccountName(String stuAccountName) {
		this.stuAccountName = stuAccountName;
	}
	public String getStuAccountName() {
		return stuAccountName;
	}
}
