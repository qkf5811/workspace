package com.dkt.school.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.TeachCourseCustomMapper;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.model.TeachCourse;
import com.dkt.school.edu.service.TeachCourseService;
import com.dkt.school.sch.dao.StudyYearCustomMapper;
import com.dkt.school.sch.dao.StudyYearMapper;
import com.dkt.school.sch.dto.StudyYearDto;
import com.dkt.school.sch.model.StudyYear;

@Service
public class TeachCourseServiceImpl implements TeachCourseService{
	@Autowired
	private TeachCourseCustomMapper teachCourseCustomMapper;
	
	@Autowired
	private StudyYearCustomMapper studyYearCustomMapper;
	
	//根据编号取得教师任教科目信息的数量
	@Override
	public Integer getTeachCourseCount(Integer studyYearId,Integer termType,String courseName,String major,String grade,String field,String name,String code) {
		return teachCourseCustomMapper.getTeachCourseCount(studyYearId,termType,courseName,major,grade,field,name,code);
	}
	//分页查询教师任教科目
	@Override
	public List<TeachCourseDto> getTeachCourseByPage(Integer studyYearId,Integer termType,String courseName,String major,String grade,String field,String name,
			String code, PaginationCustom page) {
		return teachCourseCustomMapper.selectByLimit(studyYearId,termType,courseName,major,grade,field,name,code, page.getLimitation());
	}
	
	//根据id查找教师授课记录信息
	@Override
	public TeachCourseDto findTeachCourseById(Integer id) {
		return teachCourseCustomMapper.findTeachCourseById(id);
	}
	
	
	//取得所有的学年
	@Override
	public List<StudyYear> getAllStudyYear() {
		return studyYearCustomMapper.getAllStudyYear();
	}

}
