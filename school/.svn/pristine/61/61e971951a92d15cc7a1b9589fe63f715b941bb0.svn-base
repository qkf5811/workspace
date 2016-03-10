package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherCustomMapper teacherCustomMapper;
	
	//取得教师的数量
	@Override
	public Integer getTeacherCount() {
		// TODO Auto-generated method stub
		return teacherCustomMapper.getTeacherCount();
	}
	//模糊查询取得教师的信息
	@Override
	public List<TeacherDto> getTeachersByPage(String name, String code,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.selectByLimit(name,code, page.getLimitation());
	}
	
	//通过userId找到teacher
	@Override
	public TeacherDto getTeacherByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.getTeacherByUserId(userId);
	}
	@Override
	public Teacher selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.selectByPrimaryKey(id);
	}
	
	//模糊查询取得教师的数量
	@Override
	public Integer getTeaCount(String name, String code) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.getTeaCount(name,code);
	}
	@Override
	public Integer getTeacherIdByUserId(Integer userId) {
		return teacherCustomMapper.getTeacherIdByUserId(userId);
	}
	@Override
	public Integer getClassIdByTeacherId(Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.getClassIdByTeacherId(teacherId);
	}
	@Override
	public Integer getGradeIdByClassId(Integer classId) {
		return teacherCustomMapper.getGradeIdByClassId(classId);
	}
	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherCustomMapper.getAllTeacher();
	}

}
