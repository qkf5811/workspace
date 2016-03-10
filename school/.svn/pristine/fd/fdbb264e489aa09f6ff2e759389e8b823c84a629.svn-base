package com.dkt.school.tea.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.TeaChangeDto;
import com.dkt.school.tea.dto.TeacherThesisDto;

public interface AllThesisService {
	//取得论文著作的数量
	public Integer getAllThesisCount(String name,String code,Integer thesisType);
		
	/**
	 * 查询所有论文著作
	 * 
	 * @param name
	 * @param code
	 * @param thesisType
	 * @param page
	 * @return
	 */
	public List<TeacherThesisDto> getAllThesisByPage(String name,String code,Integer thesisType,PaginationCustom page);
	
	//根据id删除论文著作
	public Integer deleteThesis(Integer id);
}
