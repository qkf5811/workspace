package com.dkt.school.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.edu.dao.CourseMapper;
import com.dkt.school.edu.dao.CoursePlanCustomMapper;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.model.CourseExample;
import com.dkt.school.edu.model.CoursePlan;
import com.dkt.school.edu.service.CoursePlanSettingService;
import com.dkt.school.sch.dao.GradeMapper;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.GradeExample;

/**
 * 
 * @author 赖继鹏
 *
 */
@Service
public class CoursePlanSettingServiceImpl implements CoursePlanSettingService {
 
	private CoursePlanCustomMapper coursePlanCustomMapper;
	private GradeMapper gradeMapper;
	private CourseMapper courseMapper;
	
	public CourseMapper getCourseMapper() {
		return courseMapper;
	}
	@Autowired
	public void setCourseMapper(CourseMapper courseMapper) {
		this.courseMapper = courseMapper;
	}
	public GradeMapper getGradeMapper() {
		return gradeMapper;
	}
	@Autowired
	public void setGradeMapper(GradeMapper gradeMapper) {
		this.gradeMapper = gradeMapper;
	}
	public CoursePlanCustomMapper getCoursePlanCustomMapper() {
		return coursePlanCustomMapper;
	}
	@Autowired
	public void setCoursePlanCustomMapper(
			CoursePlanCustomMapper coursePlanCustomMapper) {
		this.coursePlanCustomMapper = coursePlanCustomMapper;
	}
	
	@Override
	public List<Grade> getAllGradeInfo() {
		
		return gradeMapper.selectByExample(new GradeExample());
	}
	
	@Override
	public List<Course> getAllCourseInfo() {

		return courseMapper.selectByExample(new CourseExample());
	}
	
	@Override
	public int addCoursePlan(CoursePlan coursePlan) {
		
		return coursePlanCustomMapper.insert(coursePlan);
	}
	
	@Override
	public int updateCoursePlan(CoursePlan coursePlan) {
		
		return coursePlanCustomMapper.updateByPrimaryKeySelective(coursePlan);
	}
	
	@Override
	public int deleteCoursePlan(CoursePlan coursePlan) {
		
		return coursePlanCustomMapper.deleteByPrimaryKey(coursePlan.getId());
	}
	

}
