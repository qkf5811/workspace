package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.ContinuingEducationDto;
import com.dkt.school.tea.model.ContinuingEducation;
import com.dkt.school.tea.model.Teacher;

public interface ContinuingEducationCustomMapper {

	public List<ContinuingEducationDto> getTeaContinueEduList(
												@Param("name")String name,
												@Param("code")String code,
												@Param("limit")Limitation limit);
	
	public int getTeaContiueEduCount(@Param("name")String name,@Param("code")String code);

	public int deleteTeaContinueEduItem(@Param("id")Integer id);

	public ContinuingEducationDto getTeaContinuingEduDtoById(@Param("id")Integer id);

	public int getTeaContinuingEduCount(@Param("name")String name, @Param("code")String code);

	public List<Teacher> getTeaContinuingEduList(@Param("name")String name,
			@Param("code")String code, @Param("limit")Limitation limit);

	public int getTeacherIdByUserId(@Param("id")Integer id);

	public int getMyConEduCount(@Param("teacherId")Integer teacherId, 
								@Param("teachOrganization")String teachOrganization,
								@Param("courseName")String courseName, 
								@Param("courseType")Integer courseType);

	public List<ContinuingEducation> getMyConEduList(@Param("teacherId")Integer teacherId,
													@Param("teachOrganization")String teachOrganization, 
													@Param("courseName")String courseName,
													@Param("courseType") Integer courseType,
													@Param("limit")Limitation limit);
}
