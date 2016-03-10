package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dao.TeaFamilyCustomMapper;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherFamilyDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.TeaFamilyService;

@Service
public class TeaFamilyServiceImpl implements TeaFamilyService {

	@Autowired
	private TeaFamilyCustomMapper teaFamilyCustomMapper;
	
	@Autowired
	private TeacherCustomMapper teacherCustomMapper;
	
	@Override
	public Integer getTeaFamilyCount(String code) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.getTeaFamilyCount(code);
	}
	//分页查询教师家庭信息
	@Override
	public List<TeacherFamilyDto> getTeaFamilyByPage(String name, String code,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.selectByLimit(name,code, page.getLimitation());
	}
	
	//根据编号取得教师信息
	@Override
	public TeacherDto getTeacherByCode(String code) {
		// TODO Auto-generated method stub
		return teacherCustomMapper.findTeacher(code);
	}
	
	//增加教职工家庭信息
	@Override
	public Integer addTeaFamily(TeacherFamilyDto teacherFamilyDto) {
		if (teacherFamilyDto.getName()== null || "".equals(teacherFamilyDto.getName())
				||teacherFamilyDto.getRelationType()==null || "".equals(teacherFamilyDto.getRelationType()) ){
			return -1;
		}		
		return teaFamilyCustomMapper.insert(teacherFamilyDto);
	}
	
	//根据id查找教职工家庭信息
	@Override
	public TeacherFamilyDto findTeaFamilyById(Integer id) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.findTeaFamilyById(id);
	}
	
	//更新教职工家庭信息的数据
	@Override
	public Integer updateTeacherFamily(TeacherFamilyDto teacherFamilyDto) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.updateByPrimaryKey(teacherFamilyDto);
	}
	
	//根据id删除教职工家庭信息
	@Override
	public Integer deleteTeaFamilyById(Integer id) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.deleteByPrimaryKey(id);
	}
	
	//根据id取得教师家庭信息的数量
	@Override
	public Integer getTeaFamilyCountById(Integer id) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.getTeaFamilyCountById(id);
	}
	
	//分页查询教师家庭信息
	@Override
	public List<TeacherFamilyDto> getTeaFamilyById(Integer id,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return teaFamilyCustomMapper.getTeaFamilyById(id, page.getLimitation());
	}
	
		
}
