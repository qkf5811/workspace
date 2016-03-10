package com.dkt.school.edu.service;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CourseSearchConditionDto;
import com.dkt.school.edu.dto.CourseSearchDto;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.stu.model.Clazz;

public interface CourseSearchService {

	List<CourseSearchDto> findCourseByCondition(
			com.dkt.school.edu.dto.CourseSearchConditionDto condition, Limitation limit);

	Integer findCourseCountByCondition(CourseSearchConditionDto condition);

	List<Clazz> getClassByGrade(Integer gradeId);

	List<MajorField> getFieldByMajor(Integer majorId);

	
}
