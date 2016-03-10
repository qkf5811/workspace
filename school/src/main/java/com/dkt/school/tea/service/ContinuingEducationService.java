package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.ContinuingEducationDto;
import com.dkt.school.tea.model.ContinuingEducation;
import com.dkt.school.tea.model.Teacher;

public interface ContinuingEducationService {

	public List<ContinuingEducationDto> getTeaContinueEduList(String name,
						String code,
						Limitation limit);
	
	public int getTeaContiueEduCount(String name,String code);

	public int deleteTeaContinueEduItem(Integer id);

	public ContinuingEducationDto getTeaContinuingEduDtoById(Integer id);

	public int editTeaConEduItem(ContinuingEducation record);

	public int getTeaContinuingEduCount(String name, String code);

	public List<Teacher> getTeaContinuingEduList(String name,
			String code, Limitation limit);

	public int addTeaConEduItem(ContinuingEducation ce);

	public Integer getTeacherIdByUserId(Integer id);

	public int getMyConEduCount(Integer teacherId,String teachOrganization, String courseName,
			Integer courseType);

	public List<ContinuingEducation> getMyConEduList(Integer teacherId,String teachOrganization,
			String courseName, Integer courseType, Limitation limit);
}
