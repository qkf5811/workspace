package com.dkt.school.sch.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dto.GradeDto;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.stu.model.Clazz;

public interface GradeService {

	public List<Grade> getAllGrade();
	
	public List<Clazz> getClassByGradeId(Integer gradeId);

	/**
	 * @author 冯其康
	 * 根据年级和专业方向查询班级
	 * @param gradeId
	 * @param fieldId
	 * @return
	 */
	public List<Clazz> getClassByGradeIdAndFieldId(Integer gradeId,
												   Integer fieldId);

	/**
	 * 根据年级信息条件查询，并返回查询数目
	 * @param name
	 * @param eduStageType
	 * @param isGraduation
	 * @return
	 */
	public int getGradeCount(String name,Integer eduStageType,Integer isGraduation);

	/**
	 * 根据年级信息条件分页查询
	 * @param name
	 * @param eduStageType
	 * @param isGraduation
	 * @param page
	 * @return
	 */
	public List<GradeDto> getGradeByPage(String name,Integer eduStageType,Integer isGraduation,Pagination page);

	/**
	 * 添加年级
	 * @param grade
	 * @return
	 */
	public int addGrade(Grade grade);

	/**
	 * 更新年级信息
	 * @param grade
	 * @return
	 */
	public int updateGrade(Grade grade);

	/**
	 * 根据年级id删除年级信息
	 * @param id
	 * @return
	 */
	public int deleteGrade(Integer id);

	/**
	 * 根据年级id获取年级信息
	 * @param id
	 * @return
	 */
	public Grade findGradeByGradeId(Integer id);
}
