package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentPunishmentDto;

public interface StudentPunishmentCustomMapper {

	/**
	 * 获取学生惩罚信息条数
	 * @param punishmentType 
	 * @param code 
	 * @param name 
	 * @return
	 */
	public int getStudentPunishmentCount(@Param("code")String code, @Param("punishmentType")Integer punishmentType, 
										@Param("name")String name);
	
	/**
	 * 根据条件查询学生惩罚信息
	 * @param code
	 * @param punishmentType
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<StudentPunishmentDto> getStudentPunishmentDtoList(@Param("code")String code,
								@Param("punishmentType")Integer punishmentType,
								@Param("name")String name, @Param("limit")Limitation limit);
	
	/**
	 * 根据id根据惩罚信息DTO
	 * @param id
	 * @param studentId 
	 * @return
	 */
	public StudentPunishmentDto getStudentPunishmentDtoById(@Param("id")Integer id, @Param("studentId")Integer studentId);

	/**
	 * 根据id删除信息
	 * @param id
	 * @return
	 */
	public int deleteByStudentId(@Param("id")Integer id);

	/**
	 * 修改惩罚信息
	 * @param spDto
	 * @return
	 */
	public int updatePunishmentInfo(@Param("sp")StudentPunishmentDto spDto);

	/**
	 * 获取惩罚信息的学生列表
	 * @param code 
	 * @param name 
	 * @return
	 */
	public List<StudentPunishmentDto> getAllPunishmentStuList(@Param("name")String name, @Param("code")String code, @Param("limit")Limitation limit);

	/**
	 * 获取惩罚信息的学生人数
	 */
	public int getAllPunishmentStuCount(@Param("name")String name,@Param("code")String code);
}
