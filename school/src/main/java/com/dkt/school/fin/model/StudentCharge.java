package com.dkt.school.fin.model;

import java.util.Date;

public class StudentCharge {
    private Integer id;

    private Integer gradeId;

    private Integer studyYear;

    private Integer termType;

    private Integer studentId;

    private Integer accountId;

    private Float tuitionFee;

    private Float roomFee;

    private Float bookFee;

    private Float totalFee;

    private Float paidTuitionFee;

    private Float paidRoomFee;

    private Float paidBookFee;

    private Float paidTotalFee;

    private Date payTime;

    private String deductRemark;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(Integer studyYear) {
        this.studyYear = studyYear;
    }

    public Integer getTermType() {
        return termType;
    }

    public void setTermType(Integer termType) {
        this.termType = termType;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getDeductRemark() {
        return deductRemark;
    }

    public void setDeductRemark(String deductRemark) {
        this.deductRemark = deductRemark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}