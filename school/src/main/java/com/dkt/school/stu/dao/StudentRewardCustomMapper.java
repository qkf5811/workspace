package com.dkt.school.stu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentRewardDto;

public interface StudentRewardCustomMapper {

	/**
	 * 获取学生奖励信息条数
	 * @param rewardType 
	 * @param code 
	 * @param name 
	 * @return
	 */
	public int getStudentRewardCount(@Param("code")String code, @Param("rewardType")Integer rewardType, @Param("name")String name);
	
	/**
	 * 根据条件查询学生奖励信息
	 * @param code
	 * @param rewardType
	 * @param name 
	 * @param limit
	 * @return
	 */
	public List<StudentRewardDto> getStudentRewardDtoList(@Param("code")String code,
								@Param("rewardType")Integer rewardType,
								@Param("name")String name, @Param("limit")Limitation limit);

	/**
	 * 根据id获取奖励信息DTO
	 * @param id
	 * @param studentId 
	 * @return
	 */
	public StudentRewardDto getStudentRewardDtoById(@Param("id")Integer id, @Param("studentId")Integer studentId);
	
	/**
	 * 根据id删除惩罚信息
	 * @param id
	 * @return
	 */
	public int deleteByStudentId(@Param("id")Integer id);

	/**
	 * 修改获奖信息
	 * @param srDto
	 * @return
	 */
	public int updateRewardInfo(@Param("sr") StudentRewardDto sr);

	/**
	 * 获取所有学生列表
	 * @param code 
	 * @param name 
	 * @return
	 */
	public List<StudentRewardDto> getAllRewardStuList(@Param("name")String name, @Param("code")String code, 
			@Param("limit")Limitation limit);

	/**
	 * 获取所有学生列表的记录数
	 * @param name
	 * @param code
	 * @return
	 */
	public int getAllRewardStuCount(@Param("name")String name,@Param("code")String code);
}
