package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.tea.dao.TeacherRewardCustomMapper;
import com.dkt.school.tea.dao.TeacherRewardMapper;
import com.dkt.school.tea.dto.TeacherRewardDto;
import com.dkt.school.tea.service.TeacherRewardService;

@Service
public class TeacherRewardServiceImpl implements TeacherRewardService {

	@Autowired
	private TeacherRewardMapper mapper;
	
	@Autowired
	private TeacherRewardCustomMapper cMapper;
	@Override
	public List<TeacherRewardDto> getTeaRewardList(String name,String code,Limitation limit) {
		List<TeacherRewardDto> list = cMapper.getTeaRewardList(name,code,limit);
		if (list != null && list.size() > 0){
			for (TeacherRewardDto dto : list){
				if (dto.getSchoolTermType().equals(32001)){
					dto.setSchoolTermTypeStr("第一学期");
				}
				if (dto.getSchoolTermType().equals(32002)){
					dto.setSchoolTermTypeStr("第二学期");
				}
				if (dto.getRewardType() == 24001){
					dto.setRewardTypeStr("杰出青年");
				}
				if (dto.getRewardType() == 24002){
					dto.setRewardTypeStr("优秀教师");
				} 
				if (dto.getRewardType() == 24003){
					dto.setRewardTypeStr("优秀班主任");
				}
			}
		}		
		return list;
	}

	@Override
	public int getTeaRewardCount(String name,String code) {
		return cMapper.getTeaRewardCount(name,code);
	}

	@Override
	public List<TeacherRewardDto> getTeacherList(String code, String name,
			Limitation limit) {
		return cMapper.getAllTeacherList(code, name, limit);
	}

	@Override
	public int getTeacherCount(String code,String name) {
		return cMapper.getTeacherCount(code,name);
	}

	@Override
	public int addTeaRewardItem(TeacherRewardDto record) {
		
		return mapper.insert(record);
	}

	@Override
	public int deleteTeaRewardItemById(Integer id) {
		if (id != null){
			return cMapper.deleteTeaRewardById(id);
		}
		return -1;
	}

	@Override
	public List<TeacherRewardDto> getSpecifiedTeacherRewardList(Integer id,Integer schoolYearId,Integer schoolTermType,
																String title,Limitation limit) {
	
		List<TeacherRewardDto> list = cMapper.getSpecifiedTeacherRewardList(id, schoolYearId, schoolTermType, title, limit);
		
		for (TeacherRewardDto dto : list){
			if (dto.getSchoolTermType() == 32001){
				dto.setSchoolTermTypeStr("第一学期");
			}
			if (dto.getSchoolTermType() == 32002){
				dto.setSchoolTermTypeStr("第二学期");
			} 
			if (dto.getRewardType() == 24001){
				dto.setRewardTypeStr("杰出青年");
			}
			if (dto.getRewardType() == 24002){
				dto.setRewardTypeStr("优秀教师");
			} 
			if (dto.getRewardType() == 24003){
				dto.setRewardTypeStr("优秀班主任");
			}
		}
		
		return list;	
	}

	@Override
	public int getSpecifiedTeacherRewardCount(Integer teacherId,Integer schoolYearId,
										Integer schoolTermType,String title) {
		int result = cMapper.getSpecifiedTeacherRewardCount(teacherId,schoolYearId,schoolTermType,title);
		return result;
	}

	@Override
	public Integer getTeacherIdByUserId(Integer id) {
		
		return cMapper.getTeacherIdByUserId(id);
	}

}
