package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.tea.dto.TeaChangeDto;

public interface TeaChangeService {
	//取得教师异动的数量
	public Integer getTeaChangeCount(String name,String code);
	
	//分页模糊查询教师异动信息
	public List<TeaChangeDto> getTeaChangesByPage(String name,String code,PaginationCustom page);
	
	//新增教师异动
	public Integer addStudentChange(TeaChangeDto tcDto);

	//删除教师异动
	public Integer deleteTeaChangeById(Integer id,String code);
}
