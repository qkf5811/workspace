package com.dkt.school.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.CourseTeacherCustomMapper;
import com.dkt.school.edu.dao.TeachCourseCustomMapper;
import com.dkt.school.edu.dao.TeachTaskCustomMapper;
import com.dkt.school.edu.dto.CourseTeacherDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.dto.TeachTaskDto;
import com.dkt.school.edu.service.TeachTaskService;
import com.dkt.school.sch.dao.StudyYearCustomMapper;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dto.TeacherDto;

@Service
public class TeachTaskServiceImpl implements TeachTaskService{
	@Autowired
	private TeachTaskCustomMapper teachTaskCustomMapper;
	
	@Autowired
	private StudyYearCustomMapper studyYearCustomMapper;
	
	@Autowired
	private TeachCourseCustomMapper teachCourseCustomMapper;
	
	@Autowired
	private CourseTeacherCustomMapper courseTeacherCustomMapper;
	

	
	//根据学期取得所有教学任务
	@Override
	public Integer getTeachTaskCount(String courseName,Integer major,Integer grade,Integer field,Integer termType,Integer studyYearId) {
		// TODO Auto-generated method stub
		return teachTaskCustomMapper.getTeachTaskCount(courseName,major,grade,field,termType,studyYearId);
	}

	//分页查询所有教学任务
	@Override
	public List<TeachTaskDto> getTeachTaskByPage(String courseName,Integer major,Integer grade,Integer field,Integer termType,Integer studyYearId,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return teachTaskCustomMapper.selectByLimit(courseName,major,grade,field,termType,studyYearId, page.getLimitation());
	}
	//根据条件查询教学任务信息
	@Override
	public List<TeachTaskDto> findTeachTaskByTermTypeAndStudyYearId(
			Integer termType, Integer studyYearId) {
		// TODO Auto-generated method stub
		return teachTaskCustomMapper.findTeachTaskByTermTypeAndStudyYearId(termType,studyYearId);
	}

	//取得学年id
	@Override
	public Integer findStudyYearIdByStudyYearName(String studyYear) {
		// TODO Auto-generated method stub
		return studyYearCustomMapper.findStudyYearIdByStudyYearName(studyYear);
	}
	//插入一条数据
	@Override
	public Integer addTeachTaskDto(TeachTaskDto teachTaskDto) {
		// TODO Auto-generated method stub
		return teachTaskCustomMapper.insert(teachTaskDto);
	}
	//根据条件查找教师授课记录
	@Override
	public TeachCourseDto findTeachCourseByCondition(
			Integer studyYearId,Integer termType, Integer courseId, Integer coursePlanId,
			Integer courseSeq) {
		// TODO Auto-generated method stub
		return teachCourseCustomMapper.findTeachCourseByCondition(studyYearId,termType,courseId,coursePlanId,courseSeq);
	}

	//根据教师授课id删除所有教师授课中间表
	@Override
	public Integer delectCourseTeacher(Integer teachCourseId) {
		// TODO Auto-generated method stub
		return courseTeacherCustomMapper.delectCourseTeacher(teachCourseId);
	}

	//更新教师授课表
	@Override
	public Integer updateTeachCourse(TeachCourseDto teachCourseDto) {
		// TODO Auto-generated method stub
		return teachCourseCustomMapper.updateByPrimaryKey(teachCourseDto);
	}

	//添加教师授课中间表
	@Override
	public Integer addCourseTeacher(CourseTeacherDto courseTeacherDto) {
		// TODO Auto-generated method stub
		return courseTeacherCustomMapper.insert(courseTeacherDto);
	}

	//添加教师授课记录
	@Override
	public Integer addTeachCourse(TeachCourseDto teachCourseDto) {
		// TODO Auto-generated method stub
		return teachCourseCustomMapper.insert(teachCourseDto);
	}

	//更新教学任务表
	@Override
	public Integer updateTeachTask(TeachTaskDto teachTaskDto) {
		// TODO Auto-generated method stub
		return teachTaskCustomMapper.updateByPrimaryKey(teachTaskDto);
	}

	//根据教师授课id找到教师授课中间表所有的teacherName
	@Override
	public List<CourseTeacherDto> findTeacherNameByTeachCourseId(
			Integer teachCourseId) {
		// TODO Auto-generated method stub
		return courseTeacherCustomMapper.findTeacherNameByTeachCourseId(teachCourseId);
	}

	//根据id删除教师授课记录
	@Override
	public Integer deleteTeachCourseById(Integer id) {
		// TODO Auto-generated method stub
		return teachCourseCustomMapper.deleteByPrimaryKey(id);
	}
	

}
