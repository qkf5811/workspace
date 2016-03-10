package com.dkt.school.sch.dto;

import com.dkt.school.sch.model.ClassRoom;

/**
 * Created with com.dkt.school.sch.dto by Harry on 2015/8/17 12:01.
 */
public class ClassRoomDto  extends ClassRoom{

    private String buildingName;
    private String roomTypeString;
    private String campusName;
    private int campusId;

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomTypeString() {
        return roomTypeString;
    }

    public void setRoomTypeString(String roomTypeString) {
        this.roomTypeString = roomTypeString;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }
}
