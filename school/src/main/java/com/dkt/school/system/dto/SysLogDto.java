package com.dkt.school.system.dto;

import com.dkt.school.system.model.SysLog;

/**
 * Created with com.dkt.school.system.dto by Harry on 2015/5/20 11:36.
 */
public class SysLogDto extends SysLog {

    private String operTypeName;

    private String operUserName;

    public String getOperTypeName() {
        return operTypeName;
    }

    public void setOperTypeName(String operTypeName) {
        this.operTypeName = operTypeName;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }
}
