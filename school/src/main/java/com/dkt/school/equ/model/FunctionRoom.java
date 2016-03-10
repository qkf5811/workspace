package com.dkt.school.equ.model;

import java.util.Date;

public class FunctionRoom {
    private Integer id;

    private String name;

    private Integer buildingId;

    private Integer roomId;

    private Integer useUserId;

    private Date useFromDate;

    private Date useToDate;

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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(Integer useUserId) {
        this.useUserId = useUserId;
    }

    public Date getUseFromDate() {
        return useFromDate;
    }

    public void setUseFromDate(Date useFromDate) {
        this.useFromDate = useFromDate;
    }

    public Date getUseToDate() {
        return useToDate;
    }

    public void setUseToDate(Date useToDate) {
        this.useToDate = useToDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}