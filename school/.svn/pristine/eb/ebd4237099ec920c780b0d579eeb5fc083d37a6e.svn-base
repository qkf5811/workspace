package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.tea.dto.TeaChangeDto;

public interface TeaChangeCustomMapper extends TeacherChangeMapper{

	//取得教师异动的数量
	public Integer getTeaChangeCount(@Param("name") String name,
			@Param("code") String code);
		
	/**
	* 根据学号和姓名模糊分页查询
	* 
	* @param code
	* @param name
	* @param page
	* @return
	*/
	public List<TeaChangeDto> selectByLimit(
			@Param("name") String name,
			@Param("code") String code, 
			@Param("limit") Limitation limit);
	
	//根据编号取得所有的教师
	public List<TeaChangeDto> findTeaChangeByCode(String code);
}
