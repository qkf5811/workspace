package com.dkt.school.edu.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CourseOfManualAdjustDto;

public interface CourseOfManualAdjustService {
	
	/**
	 * 根据条件查询课程数量信息
	 * @param code
	 * @param name
	 * @param teaName
	 * @param page
	 * @return
	 */
	public int findCountOfCourseByConditions(String code,
											 String name,
											 String teaName,
											 PaginationCustom page);
	
	/**
	 * 根据条件查询课程信息
	 * @param code
	 * @param name
	 * @param teaName
	 * @param page
	 * @return
	 */
	public List<CourseOfManualAdjustDto> findCourseListByConditions(String code, 
															     String name,
															     String teaName, 
															     PaginationCustom page);

	/**
	 * 根据教师id获取该教师所有课程信息
	 * @param id
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> findCourseOfTeacherByTeacherId(
			Integer id);

	/**
	 * 根据dto更新教师课表里的某门课
	 * @param dto
	 * @return
	 */
	public List<CourseInTeaCourseTableDto> updateCourseOfTeacherInTeacherCourseTable(
			CourseInTeaCourseTableDto dto);
}
