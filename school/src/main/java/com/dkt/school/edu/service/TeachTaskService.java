package com.dkt.school.edu.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseTeacherDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.dto.TeachTaskDto;
import com.dkt.school.tea.dto.TeacherDto;

public interface TeachTaskService {
	//根据学期取得所有教学任务
	public Integer getTeachTaskCount(String courseName,Integer major,Integer grade,Integer field,Integer termType,Integer studyYearId);
	
	//分页查询所有教学任务
	public List<TeachTaskDto> getTeachTaskByPage(String courseName,Integer major,Integer grade,Integer field,Integer termType,Integer studyYearId,PaginationCustom page);
	
	//根据条件查询教学任务信息
	public List<TeachTaskDto> findTeachTaskByTermTypeAndStudyYearId(Integer termType,Integer studyYearId);
	
	//取得学年id
	public Integer findStudyYearIdByStudyYearName(String studyYear);
	
	//插入一条数据
	public Integer addTeachTaskDto(TeachTaskDto teachTaskDto);
	
	//根据条件查找教师授课记录
	public TeachCourseDto findTeachCourseByCondition(Integer studyYearId,Integer termType,Integer courseId,Integer coursePlanId,Integer courseSeq);

	//根据教师授课id删除所有教师授课中间表
	public Integer delectCourseTeacher( Integer teachCourseId);
	
	//更新教师授课表
	public Integer updateTeachCourse(TeachCourseDto teachCourseDto);
	
	//添加教师授课中间记录
	public Integer addCourseTeacher(CourseTeacherDto courseTeacherDto);
	
	//添加教师授课记录
	public Integer addTeachCourse(TeachCourseDto teachCourseDto);
	
	//更新教学任务表
	public Integer updateTeachTask(TeachTaskDto teachTaskDto);
	
	//根据教师授课id找到教师授课中间表所有的teacherName
	public List<CourseTeacherDto> findTeacherNameByTeachCourseId(Integer teachCourseId);
	
	//根据id删除教师授课记录
	public Integer deleteTeachCourseById(Integer id);
	
	
}
