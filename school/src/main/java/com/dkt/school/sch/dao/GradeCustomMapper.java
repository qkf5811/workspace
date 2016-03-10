package com.dkt.school.sch.dao;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.GradeDto;
import org.apache.ibatis.annotations.Param;

import com.dkt.school.sch.model.Grade;
import com.dkt.school.stu.model.Clazz;

public interface GradeCustomMapper extends GradeMapper{

	List<Grade> getAllGrade();

	List<Clazz> getClassByGradeId(@Param("gradeId")Integer gradeId);

	/**
	 * @author 冯其康
	 * 根据年级id和专业方向id查询班级
	 * @param gradeId
	 * @param fieldId
	 * @return
	 */
	List<Clazz> selectClassByGradeIdAndFieldId(
			@Param("gradeId")Integer gradeId,
			@Param("fieldId")Integer fieldId);

	/**
	 * 根据条件查询年级的数量，返回一个int类型
	 * @param name
	 * @param eduStageType
	 * @param isGraduation
	 * @return
	 */
	public int countBySearch(@Param("name") String name,@Param("eduStageType") Integer eduStageType,@Param("isGraduation") Integer isGraduation);

	/**
	 * 根据条件模糊分页查询年级信息
	 * @param name
	 * @param eduStageType
	 * @param isGraduation
	 * @param limit
	 * @return
	 */
	public List<GradeDto> selectByLimit(@Param("name") String name,@Param("eduStageType") Integer eduStageType,@Param("isGraduation") Integer isGraduation,@Param("limit")Limitation limit);

}
