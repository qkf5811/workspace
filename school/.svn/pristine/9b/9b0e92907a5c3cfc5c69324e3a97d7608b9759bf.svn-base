package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.model.Teacher;

public interface TeacherService {
	//取得教师的数量
	public Integer getTeacherCount();
		
	//模糊查询取得教师的数量
	public Integer getTeaCount(String name,String code);
	//分页模糊查询教师信息
	public List<TeacherDto> getTeachersByPage(String name,String code,PaginationCustom page);


	//通过userId找到teacher
	public TeacherDto getTeacherByUserId(Integer userId);

	public Teacher selectByPrimaryKey(int id);

	//根据用户id获取教师id
	public Integer getTeacherIdByUserId(Integer userId);

	//根据教师id获取班级id
	public Integer getClassIdByTeacherId(Integer teacherId);

	//根据classId获得年级id
	public Integer getGradeIdByClassId(Integer classId);

	//霍尔德所有
	public List<Teacher> getAllTeacher();
}
