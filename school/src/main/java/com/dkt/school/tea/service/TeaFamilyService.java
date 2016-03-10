package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.TeaChangeDto;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherFamilyDto;

public interface TeaFamilyService {
	//根据编号取得教师家庭信息的数量
	public Integer getTeaFamilyCount(String code);
	
	//根据id取得教师家庭信息的数量
	public Integer getTeaFamilyCountById(Integer id);
		
	//分页查询教师家庭信息
	public List<TeacherFamilyDto> getTeaFamilyByPage(String name,String code,PaginationCustom page);	
	
	//分页查询教师家庭信息
	public List<TeacherFamilyDto> getTeaFamilyById(Integer id,PaginationCustom page);	

	//根据编号取得教师信息
	public TeacherDto getTeacherByCode(String code);
	
	//增加教职工家庭信息
	public Integer addTeaFamily(TeacherFamilyDto teacherFamilyDto);
	
	//根据id查找教职工家庭信息
	public TeacherFamilyDto findTeaFamilyById(Integer id);
	
	//更新教职工家庭信息的数据
	public Integer updateTeacherFamily(TeacherFamilyDto teacherFamilyDto);
	
	//根据id删除教职工家庭信息
	public Integer deleteTeaFamilyById(Integer id);
}
