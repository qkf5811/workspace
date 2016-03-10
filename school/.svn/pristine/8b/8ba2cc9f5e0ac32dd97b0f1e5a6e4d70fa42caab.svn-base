package com.dkt.school.edu.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.sch.model.StudyYear;

public interface TeachCourseService {
	//根据编号取得教师任教科目信息的数量
	public Integer getTeachCourseCount(Integer studyYearId,Integer termType,String courseName,String major,String grade,String field,String name,String code);
	
	//分页查询教师任教科目
	public List<TeachCourseDto> getTeachCourseByPage(Integer studyYearId,Integer termType,String courseName,String major,String grade,String field,String name,String code,PaginationCustom page);	
	
	//根据id查找教师授课记录信息
	public TeachCourseDto findTeachCourseById(Integer id);
	
	//取得所有的学年
	public List<StudyYear> getAllStudyYear();

}
