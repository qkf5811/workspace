package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dao.ContinuingEducationCustomMapper;
import com.dkt.school.tea.dao.ContinuingEducationMapper;
import com.dkt.school.tea.dto.ContinuingEducationDto;
import com.dkt.school.tea.model.ContinuingEducation;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.service.ContinuingEducationService;

@Service
public class ContinuingEducationServiceImpl implements
		ContinuingEducationService {

	@Autowired
	private ContinuingEducationMapper mapper;
	
	@Autowired
	private ContinuingEducationCustomMapper cMapper;
	
	@Override
	public List<ContinuingEducationDto> getTeaContinueEduList(String name,
			String code, Limitation limit) {
		return cMapper.getTeaContinueEduList(name, code, limit);
	}

	@Override
	public int getTeaContiueEduCount(String name, String code) {
		
		return cMapper.getTeaContiueEduCount(name, code);
	}

	@Override
	public int deleteTeaContinueEduItem(Integer id) {
		return cMapper.deleteTeaContinueEduItem(id);
	}

	@Override
	public ContinuingEducationDto getTeaContinuingEduDtoById(Integer id) {
		if (id != null){
			return cMapper.getTeaContinuingEduDtoById(id);
		}
		return null;
	}

	@Override
	public int editTeaConEduItem(ContinuingEducation record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int getTeaContinuingEduCount(String name, String code) {
		
		return cMapper.getTeaContinuingEduCount(name, code);
	}

	@Override
	public List<Teacher> getTeaContinuingEduList(String name,
			String code, Limitation limit) {
		return cMapper.getTeaContinuingEduList(name,
				code,limit);
	}

	@Override
	public int addTeaConEduItem(ContinuingEducation ce) {
		return mapper.insertSelective(ce);
	}

	@Override
	public Integer getTeacherIdByUserId(Integer id) {
		
		return cMapper.getTeacherIdByUserId(id);
	}

	@Override
	public int getMyConEduCount(Integer teacherId, String teachOrganization,
			String courseName, Integer courseType) {
		return cMapper.getMyConEduCount(teacherId,teachOrganization,courseName,courseType);
	}

	@Override
	public List<ContinuingEducation> getMyConEduList(Integer teacherId,
			String teachOrganization, String courseName, Integer courseType,
			Limitation limit) {
		return cMapper.getMyConEduList(teacherId,teachOrganization,courseName,courseType,limit);
	}
}
