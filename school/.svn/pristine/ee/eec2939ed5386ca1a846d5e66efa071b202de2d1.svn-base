package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dao.TeacherThesisCustomMapper;
import com.dkt.school.tea.dto.TeacherThesisDto;
import com.dkt.school.tea.service.TeacherThesisService;
import com.dkt.school.user.model.User;

@Service
public class TeacherThesisServiceImpl implements TeacherThesisService{
	
	@Autowired
	private TeacherThesisCustomMapper teacherThesisCustomMapper;
	//取得个人论文著作的数量
	@Override
	public Integer getTeacherThesisCount(Integer teacherId) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.getTeacherThesisCount(teacherId);
	}
	/**
	 * 查询个人论文著作
	 * 
	 * @param teacherId
	 * @param thesisType
	 * @param page
	 * @return
	 */
	@Override
	public List<TeacherThesisDto> getTeacherThesisByPage(Integer teacherId,
			Integer thesisType, PaginationCustom page) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.selectByLimitAndTeacherId(teacherId,thesisType, page.getLimitation());
	}
	
	//根据id删除论文著作
	@Override
	public Integer deleteThesis(Integer id) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.deleteByPrimaryKey(id);
	}
	
	//添加论文著作
	@Override
	public Integer addTeacherThesis(TeacherThesisDto teacherThesisDto) {
		int result =0;
		if (teacherThesisDto.getTeacherId()== null || "".equals(teacherThesisDto.getTeacherId())
				||teacherThesisDto.getThesisType()== null || "".equals(teacherThesisDto.getThesisType()) ){
			return -1;
		}
		
		
		return teacherThesisCustomMapper.insert(teacherThesisDto);
	}
	
	//根据id查找论文著作信息
	@Override
	public TeacherThesisDto getTeacherThesisById(Integer id) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.getTeacherThesisById(id);
	}
	
	
	//更新论文著作信息的数据
	@Override
	public Integer updateTeacherThesis(TeacherThesisDto teacherThesisDto) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.updateByPrimaryKey(teacherThesisDto);
	}
	
	

}
