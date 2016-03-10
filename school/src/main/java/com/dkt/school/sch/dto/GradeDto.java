package com.dkt.school.sch.dto;

import com.dkt.school.sch.model.Grade;

/**
 * Created with com.dkt.school.sch.dto by Harry on 2015/8/13 16:31.
 */
public class GradeDto extends Grade {
    private String eduStageTypeString;
    private String isGraduationString;

    public String getEduStageTypeString() {
        return eduStageTypeString;
    }

    public void setEduStageTypeString(String eduStageTypeString) {
        this.eduStageTypeString = eduStageTypeString;
    }

    public String getIsGraduationString() {
        return isGraduationString;
    }

    public void setIsGraduationString(String isGraduationString) {
        this.isGraduationString = isGraduationString;
    }
}
