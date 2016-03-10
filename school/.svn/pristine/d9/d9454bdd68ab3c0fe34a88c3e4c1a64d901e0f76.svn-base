package com.dkt.school.edu.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.edu.dto.CourseDto;
import com.dkt.school.edu.model.Course;

public interface CourseService {
	/**
	 * 添加课程
	 * @param course
	 * @return
	 */
	public int addCourse(Course course);

	/**
	 * 根据课程名和专业ID模糊查询，并返回查询数目
	 * @param name
	 * @param majorId
	 * @return int
	 */
	public int getCourseCount(CourseDto courseDto);
	
	/**
	 * 根据课程名和专业ID模糊分页查询
	 * @param name
	 * @param majorId
	 * @param page
	 * @return
	 */
	public List<Course> getCourseByPage(CourseDto courseDto,Pagination page);
	
	
	/**
	 * 更新课程内容
	 */
	public int updateCourse(Course course);
	
	/**
	 * 删除课程
	 * @param courseId
	 * @return
	 */
	public int deleteCourseById(Integer courseId);
	
	/**
	 * 查找所有的课程
	 * @return
	 */
	public List<Course> findAllCourse();
	
	/**
	 * 根据课程id查找课程信息,返回一个CourseDto
	 * @param courseId
	 * @return
	 */
	public CourseDto findCourseDtoByCourseId(Integer courseId);

}
