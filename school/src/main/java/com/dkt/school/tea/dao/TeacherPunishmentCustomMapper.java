package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherPunishmentDto;

public interface TeacherPunishmentCustomMapper {

	/**
	 * 获取教职工惩罚信息列表
	 * @param code 
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<TeacherPunishmentDto> getTeaPunishmentList(@Param("name")String name, @Param("code")String code, 
													@Param("limit")Limitation limit);
	
	/**
	 * 获取教职工惩罚信息记录数
	 * @return
	 */
	public int getTeaPunishmentCount();
	
	/**
	 * 获取教职工列表
	 * @param code
	 * @param name
	 * @param limit
	 * @return
	 */
	public List<TeacherPunishmentDto> getAllTeacherList(@Param("code")String code,@Param("name")String name,
													@Param("limit")Limitation limit);

	/**
	 * 获取教职工数量
	 * @param code
	 * @param name
	 * @return
	 */
	public int getTeacherCount(@Param("code")String code,@Param("name")String name);

	/**
	 * 根据id删除某条惩罚条目
	 * @param id
	 * @return
	 */
	public int deleteTeaPunishmentById(@Param("id")Integer id);
	
	/**
	 * 获取指定的单个教师的处罚记录数
	 * @param teacherId
	 * @param schoolYearId
	 * @param schoolTermType
	 * @param title
	 * @return
	 */
	public int getSpecifiedTeacherPunishCount(@Param("teacherId")Integer teacherId,
												@Param("schoolYearId")Integer schoolYearId,
												@Param("schoolTermType")Integer schoolTermType,
												@Param("title")String title);

	/**
	 * 获取指定的单个教师的处罚记录
	 * @param teacherId
	 * @param limit
	 * @param schoolYearId
	 * @param schoolTermType
	 * @param title
	 * @return
	 */
	public List<TeacherPunishmentDto> getSpecifiedTeacherPunishList(@Param("teacherId")Integer teacherId,
																@Param("schoolYearId")Integer schoolYearId,
																@Param("schoolTermType")Integer schoolTermType,
																@Param("title")String title,
																@Param("limit")Limitation limit);
	
	/**
	 *  根据用户id获取教师的id
	 * @param id
	 * @return
	 */
	public int getTeacherIdByUserId(@Param("id")Integer id);
}
