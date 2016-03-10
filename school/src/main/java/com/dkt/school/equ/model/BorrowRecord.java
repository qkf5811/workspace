package com.dkt.school.equ.model;

import java.util.Date;

public class BorrowRecord {
    private Integer id;

    private Integer itemId;

    private Integer borrowUserId;

    private Date borrowDate;

    private Date borrowDealine;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Integer borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getBorrowDealine() {
        return borrowDealine;
    }

    public void setBorrowDealine(Date borrowDealine) {
        this.borrowDealine = borrowDealine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}