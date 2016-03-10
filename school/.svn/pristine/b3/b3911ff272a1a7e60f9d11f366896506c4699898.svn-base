package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dao.TeacherPunishmentCustomMapper;
import com.dkt.school.tea.dao.TeacherPunishmentMapper;
import com.dkt.school.tea.dto.TeacherPunishmentDto;
import com.dkt.school.tea.model.TeacherPunishment;
import com.dkt.school.tea.service.TeacherPunishmentService;

@Service
public class TeacherPunishmentServiceImpl implements TeacherPunishmentService {

	@Autowired
	private TeacherPunishmentMapper mapper;
	
	@Autowired
	private TeacherPunishmentCustomMapper cMapper;
	@Override
	public List<TeacherPunishmentDto> getTeaPunishmentList(String name,String code,Limitation limit) {
		List<TeacherPunishmentDto> list = cMapper.getTeaPunishmentList(name,code,limit);
		if (list != null && list.size() > 0){
			for(TeacherPunishmentDto dto : list){
				if (dto.getSchoolTermType().equals(32001)){
					dto.setSchoolTermTypeStr("第一学期");
				}
				if (dto.getSchoolTermType().equals(32002)){
					dto.setSchoolTermTypeStr("第二学期");
				}
				if (dto.getPunishmentType() == 25001){
					dto.setPunishmentTypeStr("克扣奖金");
				}
				if (dto.getPunishmentType() == 25002){
					dto.setPunishmentTypeStr("停职");
				} 
			}
			return list;
		}
		return null;
	}

	@Override
	public int getTeaPunishmentCount() {
		return cMapper.getTeaPunishmentCount();
	}

	@Override
	public List<TeacherPunishmentDto> getTeacherList(String code, String name,
			Limitation limit) {
		return cMapper.getAllTeacherList(code, name, limit);
	}

	@Override
	public int getTeacherCount(String code,String name) {
		return cMapper.getTeacherCount(code,name);
	}

	@Override
	public int addTeaPunishmentItem(TeacherPunishment record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public int deleteTeaPunishmentItemById(Integer id) {
		if (id != null){
			return cMapper.deleteTeaPunishmentById(id);
		}
		return -1;
	}

	@Override
	public List<TeacherPunishmentDto> getSpecifiedTeacherPunishList(
			Integer teacherId,Integer schoolYearId,Integer schoolTermType,String title, Limitation limit) {
		
		List<TeacherPunishmentDto> list = cMapper.getSpecifiedTeacherPunishList(teacherId,schoolYearId,schoolTermType,title,limit);
		if (list!= null && list.size() > 0){
			for(TeacherPunishmentDto dto : list){
				if (dto.getSchoolTermType().equals(32001)){
					dto.setSchoolTermTypeStr("第一学期");
				}
				if (dto.getSchoolTermType().equals(32002)){
					dto.setSchoolTermTypeStr("第二学期");
				}
				if (dto.getPunishmentType() == 25001){
					dto.setPunishmentTypeStr("克扣奖金");
				}
				if (dto.getPunishmentType() == 25002){
					dto.setPunishmentTypeStr("停职");
				} 
			}
		}
	
		return list;
	}

	@Override
	public int getSpecifiedTeacherPunishCount(Integer teacherId,Integer schoolYearId,Integer schoolTermType,String title) {
		return cMapper.getSpecifiedTeacherPunishCount(teacherId,schoolYearId,schoolTermType,title);
	}

	@Override
	public int getTeacherIdByUserId(Integer id) {
		return cMapper.getTeacherIdByUserId(id);
	}


}
