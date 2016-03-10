package com.dkt.school.tea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dao.TeacherThesisCustomMapper;
import com.dkt.school.tea.dto.TeacherThesisDto;
import com.dkt.school.tea.service.AllThesisService;

@Service
public class AllThesisServiceImpl implements AllThesisService{
	@Autowired
	private TeacherThesisCustomMapper teacherThesisCustomMapper;
	//取得论文著作的数量
	@Override
	public Integer getAllThesisCount(String name,String code,Integer thesisType) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.getAllThesisCount(name,code,thesisType);
	}
	/**
	 * 查询所有论文著作
	 * 
	 * @param name
	 * @param code
	 * @param thesisType
	 * @param page
	 * @return
	 */
	@Override
	public List<TeacherThesisDto> getAllThesisByPage(String name, String code,
			Integer thesisType, PaginationCustom page) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.selectByLimit(name,code,thesisType, page.getLimitation());
	}
	
	//根据id删除论文著作
	@Override
	public Integer deleteThesis(Integer id) {
		// TODO Auto-generated method stub
		return teacherThesisCustomMapper.deleteByPrimaryKey(id);
	}

}
