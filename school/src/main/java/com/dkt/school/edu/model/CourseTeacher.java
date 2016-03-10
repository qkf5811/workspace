package com.dkt.school.edu.model;

public class CourseTeacher {
    private Integer id;

    private Integer teachCourseId;

    private Integer teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeachCourseId() {
        return teachCourseId;
    }

    public void setTeachCourseId(Integer teachCourseId) {
        this.teachCourseId = teachCourseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

	@Override
	public String toString() {
		return "CourseTeacher [id=" + id + ", teachCourseId=" + teachCourseId
				+ ", teacherId=" + teacherId + "]";
	}
    
    
}