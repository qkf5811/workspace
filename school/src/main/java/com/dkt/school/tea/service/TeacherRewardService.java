package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherRewardDto;
import com.dkt.school.tea.model.TeacherReward;

public interface TeacherRewardService {

	public List<TeacherRewardDto> getTeaRewardList(String name, String code, Limitation limit);
	
	public int getTeaRewardCount(String name, String code);
	
	public List<TeacherRewardDto> getTeacherList(String code,String name,Limitation limit);

	public int getTeacherCount(String code,String name);
	//增加教职工获奖记录条目
	public int addTeaRewardItem(TeacherRewardDto record);

	/**
	 * 根据id删除某条奖励条目
	 * @param id
	 * @return
	 */
	public int deleteTeaRewardItemById(Integer id);
	
	/**
	 * 获取指定老师的所有获奖情况
	 * @param id
	 * @return
	 */
	public List<TeacherRewardDto> getSpecifiedTeacherRewardList(Integer id,Integer schoolYearId,Integer schoolTermType,
			String title,Limitation limit);

	/**
	 * 获取指定单个老师的获奖记录
	 * @param teacherId
	 * @return
	 */
	public int getSpecifiedTeacherRewardCount(Integer teacherId,Integer schoolYearId,
									Integer schoolTermType,String title);

	/**
	 * 根据用户id获得教师id
	 * @param id
	 * @return
	 */
	public Integer getTeacherIdByUserId(Integer id);
}
