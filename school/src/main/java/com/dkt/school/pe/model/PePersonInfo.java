package com.dkt.school.pe.model;

public class PePersonInfo {
    private Integer id;

    private Integer teaInfoId;

    private Integer position;

    private String duty;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeaInfoId() {
        return teaInfoId;
    }

    public void setTeaInfoId(Integer teaInfoId) {
        this.teaInfoId = teaInfoId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}