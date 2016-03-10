package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.model.TeacherEduExperience;

public interface TeacherEduExperienceService {

	//根据teacherId查询教师教育经历
	public TeacherEduExperience getTeaEduExpByTeacherId(int teacherId);
	
	//根据teacherId查询所有教师教育经历
	public List<TeacherEduExperienceDto> getAllTeaEduExpByTeacherId(int teacherId);

	//根据teacherId查询所有教师教育经历记录数量
	public int getAllTeaEduExpCountByTeacherId(int id);

	public void dtoListToDtoStrList(List<TeacherEduExperienceDto> list);

	public int deleteById(int id);
	
	public TeacherEduExperience selectByPrimaryId(int id);
}
