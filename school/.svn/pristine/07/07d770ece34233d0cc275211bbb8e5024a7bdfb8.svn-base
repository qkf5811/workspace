package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dto.TeachCourseDto;


public interface TeachCourseCustomMapper extends TeachCourseMapper{
	//根据编号取得教师任教科目的数量
	public Integer getTeachCourseCount(@Param("studyYearId") Integer studyYearId,
			@Param("termType") Integer termType, 
			@Param("courseName") String courseName,
			@Param("major") String major, 
			@Param("grade") String grade,
			@Param("field") String field, 
			@Param("name") String name,
			@Param("code") String code);
	
	/**
	* 根据学号和姓名分页查询
	* 
	* @param code
	* @param name
	* @param page
	* @return
	*/
	public List<TeachCourseDto> selectByLimit(
			@Param("studyYearId") Integer studyYearId,
			@Param("termType") Integer termType, 
			@Param("courseName") String courseName,
			@Param("major") String major, 
			@Param("grade") String grade,
			@Param("field") String field, 
			@Param("name") String name,
			@Param("code") String code, 
			@Param("limit") Limitation limit);	
	
	public TeachCourseDto findTeachCourseById(@Param("id") Integer id);
	
	//根据条件查找教师授课记录
	public TeachCourseDto findTeachCourseByCondition(@Param("studyYearId") Integer studyYearId,@Param("termType") Integer termType,@Param("courseId") Integer courseId,@Param("coursePlanId") Integer coursePlanId,@Param("courseSeq") Integer courseSeq);

	/**
	 * @param termType 
	 * @param studyYearId 
	 * 
	 * @Title: getScoreTypeByCIdAndCPId
	 * @author 赖继鹏
	 * @Description: 根据courseId和coursePlanId获取课程录入成绩时的成绩制（百分制or等级制）
	 * @param courseId
	 * @param coursePlanId
	 * @return     
	 * @throws
	 */
	public String getScoreTypeByCIdAndCPId(@Param("courseId")String courseId, @Param("coursePlanId")String coursePlanId, 
			@Param("studyYearId")String studyYearId, @Param("termType")String termType);
}
