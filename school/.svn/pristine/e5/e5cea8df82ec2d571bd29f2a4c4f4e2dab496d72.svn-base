package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.TeacherFamilyDto;
import com.dkt.school.tea.dto.TeacherThesisDto;

public interface TeacherThesisService {
	//取得个人论文著作的数量
	public Integer getTeacherThesisCount(Integer teacherId);
	
	/**
	 * 查询个人所有论文著作
	 * 
	 * @param teacherId
	 * @param thesisType
	 * @param page
	 * @return
	 */
	public List<TeacherThesisDto> getTeacherThesisByPage(Integer teacherId,Integer thesisType,PaginationCustom page);

	
	//根据id删除论文著作
	public Integer deleteThesis(Integer id);
	
	//添加论文著作
	public Integer addTeacherThesis(TeacherThesisDto teacherThesisDto);
	
	
	//根据id查找论文著作信息
	public TeacherThesisDto getTeacherThesisById(Integer id);
	
	//更新论文著作信息的数据
	public Integer updateTeacherThesis(TeacherThesisDto teacherThesisDto);
}
