package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CourseSearchConditionDto;
import com.dkt.school.edu.dto.CourseSearchDto;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.stu.model.Clazz;

public interface CourseSearchCustomMapper {

	/**
	 * 开课查询
	 * @param condition
	 * @param limit
	 * @return
	 */
	List<CourseSearchDto> findCourseByCondition(
			@Param("condition")CourseSearchConditionDto condition,@Param("limit") Limitation limit);
	
	/**
	 * 开课查询的记录数
	 * @param condition
	 * @return
	 */
	Integer findCourseCountByCondition(@Param("condition")CourseSearchConditionDto condition);
	
	/**
	 * 年级班级的二级联动
	 * @param gradeId
	 * @return
	 */
	List<Clazz> getClassByGrade(@Param("gradeId")Integer gradeId);
	
	/**
	 * 专业和相关方向的二级联动
	 * @param majorId
	 * @return
	 */
	List<MajorField> getFieldByMajor(@Param("majorId")Integer majorId);

	
}
