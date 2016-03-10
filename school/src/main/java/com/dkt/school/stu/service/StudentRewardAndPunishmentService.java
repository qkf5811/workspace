package com.dkt.school.stu.service;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.stu.dto.StudentPunishmentDto;
import com.dkt.school.stu.dto.StudentRewardDto;
import com.dkt.school.stu.model.StudentPunishment;
import com.dkt.school.stu.model.StudentReward;

/**
 * Created by JanGin on 2015/6/12.
 */
public interface StudentRewardAndPunishmentService {

    /**
     * 增加学生奖励情况记录
     * @param record
     * @return
     */
    int addStudentRewardRecord(StudentReward record);

    /**
     * 增加学生惩罚情况记录
     * @param record
     * @return
     */
    int addStudentPunishmentRecord(StudentPunishment record);

    /**
     * 获取学生奖励信息列表
     * @param rewardType 
     * @param code 
     * @param name 
     * @param limit
     * @return
     */
	List<StudentRewardDto> getStudentRewardDtoList(String code, Integer rewardType, String name, Limitation limit);

	/**
	 * 获取学生奖励信息条数
	 * @param rewardType 
	 * @param code 
	 * @param name 
	 * @return
	 */
	int getStudentRewardCount(String code, Integer rewardType, String name);

	/**
	 * 获取学生惩罚信息条数
	 * @param punishmentType 
	 * @param code 
	 * @param name 
	 * @return
	 */
	int getStudentPunishmentCount(String code, Integer punishmentType, String name);

	/**
	 * 获取学生惩罚信息列表
	 * @param name 
	 * @param limitation
	 * @return
	 */
	List<StudentPunishmentDto> getStudentPunishmentDtoList(String code,Integer punishmentType,String name, Limitation limit);

	/**
	 * 根据id获取要修改的信息
	 * @param id
	 * @param studentId 
	 * @return
	 */
	StudentRewardDto getStudentRewardDtoById(Integer id, Integer studentId);
	
	/**
	 * 根据id获取惩罚信息的DTO
	 * @param id
	 * @param studentId 
	 * @return
	 */
	StudentPunishmentDto getStudentPunishmentDtoById(Integer id, Integer studentId);

	/**
	 * 修改获奖信息
	 * @param srDto
	 * @return
	 */
	int updateRewardInfo(StudentRewardDto srDto);

	/**
	 * 根据id删除获奖信息
	 * @param id
	 * @return
	 */
	int deleteRewardInfo(Integer id);

	/**
	 * 根据id删除惩罚信息
	 * @param id
	 * @return
	 */
	int deletePunishmentInfo(Integer id);

	/**
	 * 修改惩罚信息
	 * @param spDto
	 * @return
	 */
	int updatePunishmentInfo(StudentPunishmentDto spDto);

	/**
	 * 获取在籍所有学生列表
	 * @param limitation 
	 * @return
	 */
	List<StudentPunishmentDto> getAllPunishmentStuList(String name,String code,Limitation limitation);
	
	/**
	 *  获取在籍所有学生列表
	 * @param code 
	 * @param name 
	 * @return
	 */
	List<StudentRewardDto> getAllRewardStuList(String name, String code, Limitation limit);

	/**
	 *  获取在籍所有学生列表人数
	 * @param code 
	 * @param name 
	 * @return
	 */
	int getAllRewardStuCount(String name, String code);

	/**
	 *  获取在籍所有学生列表人数
	 * @return
	 */
	int getAllPunishmentStuCount(String name,String code);

}
