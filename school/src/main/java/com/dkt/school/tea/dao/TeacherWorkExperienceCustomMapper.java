package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherWorkExperienceDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.model.TeacherWorkExperience;

public interface TeacherWorkExperienceCustomMapper {

	/**
	 * 获取教师工作经历列表
	 * @param name 
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<TeacherWorkExperienceDto> getTeacherWorkList(@Param("code")String code,@Param("name") String name, @Param("limit")Limitation limit);

	/**
	 * 获取教师工作经历记录数
	 * @param code
	 * @param name
	 * @return
	 */
	public Integer getTeacherWorkCount(@Param("code")String code,@Param("name")String name);

	/**
	 * 根据id删除具体的教职工履历条目
	 * @param id
	 * @return
	 */
	public int deleteWorkItemById(@Param("id")Integer id);

	/**
	 * 根据id获取具体的某个教职工履历条目
	 * @param id
	 * @return
	 */
	public TeacherWorkExperienceDto getTeacherWorkExperienceById(@Param("id")Integer id);

	/**
	 * 获取教职工数量
	 * @param name
	 * @param code
	 * @return
	 */
	public int getTeacherCount(@Param("name")String name,@Param("code")String code);

	/**
	 * 获取教职工履历信息列表
	 * @param name
	 * @param code
	 * @param limit
	 * @return
	 */
	public List<Teacher> getAllTeacher(@Param("name")String name,@Param("code")String code,
														@Param("limit")Limitation limit);

	/**
	 * 根据code获取
	 * @param code
	 * @return
	 */
	public int getTeacherIdByCode(@Param("code")String code);
	
	/**
	 * 批量插入教职工履历信息(数据来源：excel表)
	 * @param list
	 * @return
	 */
	public int insertTeaWorkExperienceByXLS(@Param("tList")List<TeacherWorkExperience> tlist);

	/**
	 * 获取单个教师的简历记录数
	 * @param id
	 * @return
	 */
	public Integer getSingleWorkExperienceCount(@Param("id")Integer id);

	/**
	 * 获取单个教师的简历集合
	 * @param id
	 * @return
	 */
	public List<TeacherWorkExperienceDto> getSingleWorkExperienceById(@Param("id")Integer id);
}
