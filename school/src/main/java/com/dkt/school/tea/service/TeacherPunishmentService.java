package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dto.TeacherPunishmentDto;
import com.dkt.school.tea.model.TeacherPunishment;

public interface TeacherPunishmentService {

public List<TeacherPunishmentDto> getTeaPunishmentList(String name, String code, Limitation limit);
	
	public int getTeaPunishmentCount();
	
	public List<TeacherPunishmentDto> getTeacherList(String code,String name,Limitation limit);

	public int getTeacherCount(String code,String name);
	//增加教职工受罚记录条目
	public int addTeaPunishmentItem(TeacherPunishment tr);

	/**
	 * 根据id删除某条奖励条目
	 * @param id
	 * @return
	 */
	public int deleteTeaPunishmentItemById(Integer id);
	
	public List<TeacherPunishmentDto> getSpecifiedTeacherPunishList(Integer teacherId,Integer schoolYearId,
						Integer schoolTermType,String title,Limitation limit);
	
	public int getSpecifiedTeacherPunishCount(Integer teacherId,Integer schoolYearId,
			Integer schoolTermType,String title);
	
	public int getTeacherIdByUserId(Integer id);
}
