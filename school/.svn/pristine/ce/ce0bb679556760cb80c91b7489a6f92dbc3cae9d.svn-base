package com.dkt.school.tea.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dao.TeacherCustomMapper;
import com.dkt.school.tea.dao.TeacherEduExperienceCustomMapper;
import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.model.TeacherEduExperience;
import com.dkt.school.tea.service.TeacherEduExperienceService;
@Service
public class TeacherEduExperienceServiceImpl implements
		TeacherEduExperienceService {
	
	@Autowired
	TeacherEduExperienceCustomMapper teaEduExpMapper;

	@Autowired
	EnumerationService enumerationService;
	
	@Autowired
	TeacherCustomMapper teaMapper;
	
	@Override
	public TeacherEduExperience getTeaEduExpByTeacherId(int teacherId) {

		return teaEduExpMapper.getTeaEduExpByTeacherId(teacherId);
	}

	@Override
	public List<TeacherEduExperienceDto> getAllTeaEduExpByTeacherId(int teacherId) {
		
		return teaEduExpMapper.getAllTeacherEduExpByTeacherId(teacherId);
	}

	@Override
	public int getAllTeaEduExpCountByTeacherId(int id) {
		// TODO Auto-generated method stub
		return teaEduExpMapper.getAllTeaEduExpCountByTeacherId(id);
	}

	@Override
	public void dtoListToDtoStrList(List<TeacherEduExperienceDto> list) {

		//各种枚举
		List<EnumerationValue> eduTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE);
		List<EnumerationValue> degreeTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE);
		
		int tmp = 0;
		for (int i = 0; i < list.size(); ++i) {
			//教育类型
			Integer eduType = list.get(i).getEducationType();
			for (int j = 0; j < eduTypeList.size(); ++j) {
				tmp = eduTypeList.get(j).getId();
				System.out.println(eduType + "," + tmp);
				if ( tmp == eduType) {
					list.get(i).setEducationTypeStr(eduTypeList.get(j).getName());
					break;
				}
			}
			//学历类型
			Integer degreeType = list.get(i).getDegreeType();
			for (int j = 0; j < degreeTypeList.size(); ++j) {
				tmp = degreeTypeList.get(j).getId();
				if ( tmp == degreeType) {
					list.get(i).setDegreeTypeStr(degreeTypeList.get(j).getName());
					break;
				}
			}
			//开始日期
			list.get(i).setStartDateStr(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getStartDate()));
			//结束日期
			list.get(i).setEndDateStr(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getEndDate()));
		}
	}

	@Override
	public int deleteById(int id) {
		
		TeacherEduExperience eduExp = teaEduExpMapper.selectByPrimaryKey(id);

		//删除教育经历记录后也要更新teacher_info表里对应的degreeType，取最大
		int result = teaEduExpMapper.deleteByPrimaryKey(id);
		teaMapper.updateTeacherInfoDegreeType(eduExp.getTeacherId());
		return result;
	}

	@Override
	public TeacherEduExperience selectByPrimaryId(int id) {
		// TODO Auto-generated method stub
		return teaEduExpMapper.selectByPrimaryKey(id);
	}

}
