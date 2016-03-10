package com.dkt.school.stu.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.DivideClassDto;
import com.dkt.school.stu.dto.StudentToBeDividedDto;
import com.dkt.school.stu.model.Student;


public interface DivideClassSettingService {

	/**
	 * 查询出各个专业的分班情况
	 * @param page
	 * @return
	 */
	List<DivideClassDto> selectTotalInfoOfDivideClass(PaginationCustom page);

	/**
	 * 查询进行手动分班设置的学生列表
	 * @param dto
	 * @param page
	 * @return
	 */
	List<StudentToBeDividedDto> selectStudentsToDivide(
			StudentToBeDividedDto dto, PaginationCustom page);

	/**
	 * 查询进行手动分班设置的学生人数
	 * @param dto
	 * @return
	 */
	int selectCountOfStudentsToDivide(StudentToBeDividedDto dto);

	/**
	 * 查询出各个专业的分班情况的记录数
	 * @return
	 */
	int selectCountOfTotalInfoOfDivideClass();

	/**
	 *  添加学生分班信息记录
	 * @param student
	 * @return
	 */
	int addNewStudentInAClass(Student student);

	/**
	 * 根据MarjorFieldId和ClassID获取学号
	 * @param majorFieldId
	 * @param classId
	 * @return
	 */
	String getCodeByMarjorFieldIdAndClassID(int majorFieldId, int classId);


	/**
	 * 执行自动分班设置
	 * @return
	 */
	int autoDivideClassSetting();


}
