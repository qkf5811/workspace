package com.dkt.school.pe.model;

public class PeWorkTask {
    private Integer id;

    private Integer workInfoId;

    private Integer personInfoId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkInfoId() {
        return workInfoId;
    }

    public void setWorkInfoId(Integer workInfoId) {
        this.workInfoId = workInfoId;
    }

    public Integer getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(Integer personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}