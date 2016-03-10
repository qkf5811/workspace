package com.dkt.school.edu.model;

public class TeachTask {
    private Integer id;

    private Integer studyYearId;

    private Integer termType;

    private Integer coursePlanId;

    private Integer courseId;

    private Integer classId;

    private Integer courseSeq;

    private Integer teachCourseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyYearId() {
        return studyYearId;
    }

    public void setStudyYearId(Integer studyYearId) {
        this.studyYearId = studyYearId;
    }

    public Integer getTermType() {
        return termType;
    }

    public void setTermType(Integer termType) {
        this.termType = termType;
    }

    public Integer getCoursePlanId() {
        return coursePlanId;
    }

    public void setCoursePlanId(Integer coursePlanId) {
        this.coursePlanId = coursePlanId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseSeq() {
        return courseSeq;
    }

    public void setCourseSeq(Integer courseSeq) {
        this.courseSeq = courseSeq;
    }

    public Integer getTeachCourseId() {
        return teachCourseId;
    }

    public void setTeachCourseId(Integer teachCourseId) {
        this.teachCourseId = teachCourseId;
    }

	@Override
	public String toString() {
		return "TeachTask [id=" + id + ", studyYearId=" + studyYearId
				+ ", termType=" + termType + ", coursePlanId=" + coursePlanId
				+ ", courseId=" + courseId + ", classId=" + classId
				+ ", courseSeq=" + courseSeq + ", teachCourseId="
				+ teachCourseId + "]";
	}
    
    
}