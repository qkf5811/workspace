package com.dkt.school.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseToQueryScoByHTDto;
import com.dkt.school.edu.dto.TeachTaskDto;

public interface TeachTaskCustomMapper extends TeachTaskMapper{
	//根据学期取得所有教学任务
	public Integer getTeachTaskCount(@Param("courseName") String courseName,
			@Param("major") Integer major, 
			@Param("grade") Integer grade,
			@Param("field") Integer field,@Param("termType")Integer termType,@Param("studyYearId")Integer studyYearId);
	
	/**
	* 分页查询所有教学任务
	* 
	* @param termType
	* @param page
	* @return
	*/
	public List<TeachTaskDto> selectByLimit(
			@Param("courseName") String courseName,
			@Param("major") Integer major, 
			@Param("grade") Integer grade,
			@Param("field") Integer field,
			@Param("termType") Integer termType, 
			@Param("studyYearId") Integer studyYearId, 
			@Param("limit") Limitation limit);	
	
	//根据条件查询教学任务信息
	public List<TeachTaskDto> findTeachTaskByTermTypeAndStudyYearId(@Param("termType")Integer termType, @Param("studyYearId")Integer studyYearId);

	/**
	 * 
	 * @Title: selectCourseToQueryScoByHT
	 * @author 赖继鹏
	 * @Description: 根据班级、学年、学期、课程名称查询对应的所有课程
	 * @param dto
	 * @param page
	 * @return     
	 * @throws
	 */
	public List<CourseToQueryScoByHTDto> selectCourseToQueryScoByHT(
			@Param("dto")CourseToQueryScoByHTDto dto, @Param("limit")Limitation limit);

	/**
	 * 
	 * @Title: selectCountOfCourseToQueryScoByHT
	 * @author 赖继鹏
	 * @Description: 根据班级、学年、学期、课程名称查询对应的所有课程数量
	 * @param dto
	 * @return     
	 * @throws
	 */
	public int selectCountOfCourseToQueryScoByHT(@Param("dto")CourseToQueryScoByHTDto dto);
}
