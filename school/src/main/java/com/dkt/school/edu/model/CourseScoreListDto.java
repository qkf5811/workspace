package com.dkt.school.edu.model;

import java.util.List;

import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.model.CourseScore;

public class CourseScoreListDto  extends Course{
	private Integer id;
	private Integer teaId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeaId() {
		return teaId;
	}
	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}
	
	public CourseScoreListDto() {
		
	}
}
