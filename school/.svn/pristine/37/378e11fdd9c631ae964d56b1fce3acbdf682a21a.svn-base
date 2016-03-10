package com.dkt.school.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.edu.service.CourseService;
import com.dkt.school.edu.dao.CourseCustomMapper;
import com.dkt.school.edu.dto.CourseDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.model.CourseExample;
import com.dkt.school.sch.dao.MajorCustomMapper;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseCustomMapper courseCustomMapper;


	@Autowired	
	private MajorCustomMapper majorMapper;

	public CourseCustomMapper getCourseCustomMapper() {
		return courseCustomMapper;
	}

	@Autowired
	public void setCourseCustomMapper(CourseCustomMapper courseCustomMapper) {
		this.courseCustomMapper = courseCustomMapper;
	}

	public int addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseCustomMapper.insert(course);
	}
	public List<Course> getCourseByPage(CourseDto courseDto,
			Pagination page) {
		// TODO Auto-generated method stub
		return courseCustomMapper.selectByLimit(courseDto, page.getLimitation());
	}

	public int getCourseCount(CourseDto courseDto) {

		return courseCustomMapper.countByNameAndMajorId(courseDto);
	}

	public int updateCourse(Course course) {

		return courseCustomMapper.updateByPrimaryKeySelective(course);
	}

	public int deleteCourseById(Integer courseId) {

		return courseCustomMapper.deleteByPrimaryKey(courseId);
	}

	public List<Course> findAllCourse() {
		// TODO Auto-generated method stub
		return courseCustomMapper.selectByExample(new CourseExample());
	}

	public CourseDto findCourseDtoByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		return courseCustomMapper.selectCourseDtoByCourseId(courseId);
	}


}
