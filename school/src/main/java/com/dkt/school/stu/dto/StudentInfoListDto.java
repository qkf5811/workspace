package com.dkt.school.stu.dto;

import com.dkt.school.stu.model.StudentInfo;

/**
 * Created with com.dkt.school.stu.dto by Harry on 2015/7/6 11:36.
 */
public class StudentInfoListDto extends StudentInfo {
    private String sex;
    private String stuStatus;
    private String nation;
    private String code;
    private String householdTypeString;
    private String politicalFeatureTypeString;
    private String isHkMcString;
    private String examineeTypeString;
    private String studyTypeString;
    private String enterSchoolTypeString;
    private String eduStageTypeString;
    private String className;
    private String majorFieldName;
    private String studentStatusString;

    /*private String isDivideClassString;*/

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHouseholdTypeString() {
        return householdTypeString;
    }

    public void setHouseholdTypeString(String householdTypeString) {
        this.householdTypeString = householdTypeString;
    }

    public String getPoliticalFeatureTypeString() {
        return politicalFeatureTypeString;
    }

    public void setPoliticalFeatureTypeString(String politicalFeatureTypeString) {
        this.politicalFeatureTypeString = politicalFeatureTypeString;
    }

    public String getIsHkMcString() {
        return isHkMcString;
    }

    public void setIsHkMcString(String isHkMcString) {
        this.isHkMcString = isHkMcString;
    }

    public String getExamineeTypeString() {
        return examineeTypeString;
    }

    public void setExamineeTypeString(String examineeTypeString) {
        this.examineeTypeString = examineeTypeString;
    }

    public String getStudyTypeString() {
        return studyTypeString;
    }

    public void setStudyTypeString(String studyTypeString) {
        this.studyTypeString = studyTypeString;
    }

    public String getEnterSchoolTypeString() {
        return enterSchoolTypeString;
    }

    public void setEnterSchoolTypeString(String enterSchoolTypeString) {
        this.enterSchoolTypeString = enterSchoolTypeString;
    }

    public String getEduStageTypeString() {
        return eduStageTypeString;
    }

    public void setEduStageTypeString(String eduStageTypeString) {
        this.eduStageTypeString = eduStageTypeString;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

	public String getMajorFieldName() {
		return majorFieldName;
	}

	public void setMajorFieldName(String majorFieldName) {
		this.majorFieldName = majorFieldName;
	}

    public String getStudentStatusString() {
        return studentStatusString;
    }

    public void setStudentStatusString(String studentStatusString) {
        this.studentStatusString = studentStatusString;
    }
}
