package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CourseDto;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CourseOfManualAdjustDto;
import com.dkt.school.edu.model.Course;

public interface CourseCustomMapper extends CourseMapper {
	/**
	 * 根据条件查询课程数量信息
	 * 
	 * @param code
	 * @param name
	 * @param teaName
	 * @param limit
	 * @return
	 */
	public int selectCountOfCourseByConditions(@Param("code") String code,
			@Param("name") String name, @Param("teaName") String teaName,
			@Param("limit") Limitation limit);

	/**
	 * 根据条件查询课程信息
	 * @param code
	 * @param name
	 * @param teaName
	 * @param limit
	 * @return
	 */
	public List<CourseOfManualAdjustDto> selectCourseOfManualAdjustByConditions(
			@Param("code") String code, @Param("name") String name,
			@Param("teaName") String teaName, @Param("limit") Limitation limit);

	/**
	 * 根据教师id得到该教师所有的课程信息
	 * 
	 * @param id
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> selectCourseOfTeacherByTeacherId(
			@Param("id") Integer id);

	/**
	 * 根据dto更新课程计划表的专业和专业方向
	 * 
	 * @param dto
	 * @return
	 */
	public int updateMajorAndFieldByDto(
			@Param("dto") CourseInTeaCourseTableDto dto);

	/**
	 * 根据dto更新排课表的上课时间和上课地点
	 * 
	 * @param dto
	 * @return
	 */
	public int updateCourseTimeAndAddressByDto(
			@Param("dto") CourseInTeaCourseTableDto dto);

	/**
	 * 根据dto更新teach_course表里的上课班级
	 * 
	 * @param dto
	 * @return
	 */
	public int updateCourseClassesByDto(
			@Param("dto") CourseInTeaCourseTableDto dto);

	/**
	 * 根据所有上课时间和地点来查询有地点冲突的课程
	 * 
	 * @param classRoomId
	 * @param weekDay
	 * @param sectionType
	 * @param dtoWeeksStart
	 * @param dtoWeeksEnd
	 * @param dtoWeekIds
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> selectCourseWithTimeConflictAndAddressConflict(
			@Param("scheduleId") Integer scheduleId,
			@Param("classRoomId") Integer classRoomId,
			@Param("weekDay") Integer weekDay,
			@Param("sectionType") Integer sectionType,
			@Param("dtoWeeksStart") int dtoWeeksStart,
			@Param("dtoWeeksEnd") int dtoWeeksEnd,
			@Param("dtoWeekIds") List<Integer> dtoWeekIds);

	/**********************************************************************
	 * ./
	 * 
	 */
	public Integer findCourseByCourseNameAndMajorId(
			@Param("courseName") String courseName,
			@Param("majorId") Integer majorId);
	public Integer countByNameAndMajorId(
			@Param("courseDto") CourseDto courseDto);
	public List<Course> selectByLimit(
			@Param("courseDto") CourseDto courseDto,
			@Param("limit") Limitation limit);
	/**
	 * 根据课程id查找课程信息
	 * 
	 * @param courseId
	 * @return
	 */
	public CourseDto selectCourseDtoByCourseId(
			@Param("courseId") Integer courseId);

	// 根据专业id得到课程信息的数量
	public int getCourseCountByMajorId(int major);

	// 得到课程信息的数量
	public int getCourseCount();

	// 根据专业id得到课程的信息
	public List<Course> getCourseByMajorId(int majorId);

	// 获取所有课程信息
	public List<Course> getAllCourseInfo();

	// 获取所有课程信息
	public List<CourseDto> getAllCourseInfoByPage(
			@Param("limit") Limitation limit);

	// 根据专业id得到课程的信息
	public List<CourseDto> getCourseInfoByPage(
			@Param("majorId") int majorFieldId, @Param("limit") Limitation limit);

	// 添加课程信息
	public int addCourse(@Param("course") String course);

	// 根据课程id删除课程信息
	public int deleteByCourseId(int id);

	// 根据课程id修改课程信息
	public int editCourseName(@Param("courseId") int courseId,
			@Param("newName") String newName);
}
