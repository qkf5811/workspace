package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.model.StudentChange;



public interface StuChangeClassCustomMapper extends StuChangeClassMapper {
	
	public int getStuChangeClassCount(@Param("dto")StudentChangeDto dto);

	public List<StudentChangeDto> getStuChangeClassListData(@Param("dto")StudentChangeDto dto,@Param("limit")Limitation limit);

	public StudentChange getStuChangeClassById(@Param("id") Integer id);
	
	public List<StudentChangeDto> findStudentChangeByCode(String code);
	
}
