package com.dkt.school.spt.model;

import java.util.Date;

public class SptMeeting {
    private Integer id;

    private String theme;

    private Date launchDatetime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getLaunchDatetime() {
        return launchDatetime;
    }

    public void setLaunchDatetime(Date launchDatetime) {
        this.launchDatetime = launchDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}