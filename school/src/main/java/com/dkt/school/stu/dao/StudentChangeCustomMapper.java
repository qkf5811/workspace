package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.stu.dto.StudentChangeDto;

public interface StudentChangeCustomMapper extends StudentChangeMapper{
	
	//取得学籍异动的数量
	public Integer getStudentChangeCount(@Param("name") String name,
			@Param("code") String code);
	
	/**
	 * 根据学号和姓名模糊分页查询
	 * 
	 * @param code
	 * @param name
	 * @param page
	 * @return
	 */
	public List<StudentChangeDto> selectByLimit(
			@Param("name") String name,
			@Param("code") String code, 
			@Param("limit") Limitation limit);
	//根据id查找学籍异动
	public StudentChangeDto findStudentChangeById(Integer id);
	
	//更新学籍异动
	public Integer updateStudentChange(StudentChangeDto scDto);
	
	//根據学号取得学籍异动
	public List<StudentChangeDto> findStudentChangeByCode(String code);
}
