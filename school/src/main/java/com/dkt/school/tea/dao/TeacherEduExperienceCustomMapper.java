package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.model.TeacherEduExperience;

public interface TeacherEduExperienceCustomMapper extends
		TeacherEduExperienceMapper {
	
	//根据teacherId查询记录
	public TeacherEduExperience getTeaEduExpByTeacherId(@Param("teacherId")int teacherId);

	//根据teacherId查询所有教育经历
	public List<TeacherEduExperienceDto> getAllTeacherEduExpByTeacherId(
			@Param("teacherId")int teacherId);

	//根据teacherId查询所有教育经历记录数量
	public int getAllTeaEduExpCountByTeacherId(@Param("teacherId")int id);

}
