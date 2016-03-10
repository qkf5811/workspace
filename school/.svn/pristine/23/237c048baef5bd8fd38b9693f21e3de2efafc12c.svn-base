package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.CoursePlanDto;
import com.dkt.school.system.model.EnumerationValue;



/**
 * 
 * @author 赖继鹏
 *
 */
public interface CoursePlanCustomMapper extends CoursePlanMapper {
	
	//通过CoursePlanDto查找教师符合条件所有信息
	public List<CoursePlanDto> selectTotalInfoOfCoursePlan(@Param("dto")CoursePlanDto dto,
			@Param("limit") Limitation limit);
	//得到符合条件所有课程计划的记录数
	public int selectCountOfCoursePlan(@Param("dto")CoursePlanDto dto);
	
	

	//得到学期类型的数据
	public List<EnumerationValue> getAllTermTypeInfo();
	
	//得到课程类型的数据
	public List<EnumerationValue> getAllCourseTypeInfo();
	
	//得到课考核方式的数据
	public List<EnumerationValue> getAllExamineTypeInfo();
	
	//振佳
	//根据学期类型找到所有的课程班级信息
	public List<CoursePlanDto> findAllByTermType(@Param("termType")Integer termType);
	

}
