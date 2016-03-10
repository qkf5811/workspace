package com.dkt.school.tea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherRewardDto;
import com.dkt.school.tea.model.TeacherReward;

public interface TeacherRewardCustomMapper {

	/**
	 * 获取教职工奖励信息列表
	 * @param code 
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<TeacherRewardDto> getTeaRewardList(@Param("name")String name, @Param("code")String code, 
													@Param("limit")Limitation limit);
	
	/**
	 * 获取教职工奖励信息记录数
	 * @param code 
	 * @param name 
	 * @return
	 */
	public int getTeaRewardCount(@Param("name")String name,@Param("code") String code);
	
	/**
	 * 获取教职工列表
	 * @param code
	 * @param name
	 * @param limit
	 * @return
	 */
	public List<TeacherRewardDto> getAllTeacherList(@Param("code")String code,@Param("name")String name,
													@Param("limit")Limitation limit);

	/**
	 * 获取教职工数量
	 * @param code
	 * @param name
	 * @return
	 */
	public int getTeacherCount(@Param("code")String code,@Param("name")String name);

	/**
	 * 根据id删除某条奖励条目
	 * @param id
	 * @return
	 */
	public int deleteTeaRewardById(@Param("id")Integer id);
	
	/**
	 * 获取单个老师的所有获奖情况
	 * @param id
	 * @param schoolYearId
	 * @param schoolTermType
	 * @param title
	 * @param limit
	 * @return
	 */
	public List<TeacherRewardDto> getSpecifiedTeacherRewardList(@Param("id")Integer id,
													@Param("schoolYearId")Integer schoolYearId,
													@Param("schoolTermType")Integer schoolTermType,
													@Param("title")String title,
													@Param("limit")Limitation limit);

	/**
	 * 获取指定的老师的获奖记录
	 * @param teacherId
	 * @param schoolYearId
	 * @param schoolTermType
	 * @param title
	 * @return
	 */
	public int getSpecifiedTeacherRewardCount(@Param("teacherId")Integer teacherId,
												@Param("schoolYearId")Integer schoolYearId,
												@Param("schoolTermType")Integer schoolTermType,
												@Param("title")String title);

	/**
	 * 根据用户id获取教师的id
	 * @param id
	 * @return
	 */
	public Integer getTeacherIdByUserId(@Param("id")Integer id);
}
