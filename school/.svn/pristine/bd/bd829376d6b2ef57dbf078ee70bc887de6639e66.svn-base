package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.edu.dto.CourseTeacherDto;

public interface CourseTeacherCustomMapper extends CourseTeacherMapper{
	//根据教师授课id删除所有教师授课中间表
	public Integer delectCourseTeacher(@Param("teachCourseId") Integer teachCourseId);
	
	//根据教师授课id找到教师授课中间表所有的teacherName
	public List<CourseTeacherDto> findTeacherNameByTeachCourseId(@Param("teachCourseId") Integer teachCourseId);
}
