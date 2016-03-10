package com.dkt.school.spt.model;

public class SptMeetingItem {
    private Integer id;

    private String name;

    private Integer type;

    private Integer account;

    private String requirement;

    private Integer chargePerson;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(Integer chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}