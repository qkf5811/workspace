package com.dkt.school.stu.dao;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.stu.dto.AdmissionScoreDto;

public interface AdmissionScoreCustomMapper extends AdmissionScoreMapper{
	/**
	 * 根据准考证号查询该学生的基本信息id
	 */
	public Integer getStudentInfoIdByExamNum(@Param("examNum")String examNum);
	
	/**
	 * 插入学生的成绩并返回id
	 */
	public Integer insertAdmissionScoreAndGetId(AdmissionScoreDto admissionScoreDto);
}
