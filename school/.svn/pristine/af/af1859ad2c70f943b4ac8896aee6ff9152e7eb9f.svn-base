package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeaChangeDto;
import com.dkt.school.tea.dto.TeacherFamilyDto;



public interface TeaFamilyCustomMapper extends TeacherFamilyMapper{
	//根据编号取得教师家庭信息的数量
	public Integer getTeaFamilyCount(String code);
	
	//根据教师id取得教师家庭信息的数量
	public Integer getTeaFamilyCountById(@Param("id") Integer id);
	
	/**
	* 根据编号和姓名分页查询
	* 
	* @param code
	* @param name
	* @param page
	* @return
	*/
	public List<TeacherFamilyDto> selectByLimit(
			@Param("name") String name,
			@Param("code") String code, 
			@Param("limit") Limitation limit);
	
	//根据teacherId分页查询家庭信息
	public List<TeacherFamilyDto> getTeaFamilyById(
			@Param("id") Integer id, 
			@Param("limit") Limitation limit);
	//根据id查找教职工家庭信息
	public TeacherFamilyDto findTeaFamilyById(Integer id);
}
