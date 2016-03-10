package com.dkt.school.equ.model;

import java.util.Date;

public class UseRecord {
    private Integer id;

    private Integer itemId;

    private Integer useUserId;

    private Date useDate;

    private Date useDealine;

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

    public Integer getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(Integer useUserId) {
        this.useUserId = useUserId;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Date getUseDealine() {
        return useDealine;
    }

    public void setUseDealine(Date useDealine) {
        this.useDealine = useDealine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}