package com.dkt.school.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.CoursePlanCustomMapper;
import com.dkt.school.edu.dto.CoursePlanDto;
import com.dkt.school.edu.service.CoursePlanTotalInfoService;

@Service
public class CoursePlanTotalInfoServiceImpl implements
		CoursePlanTotalInfoService {

	private CoursePlanCustomMapper coursePlanCustomMapper;
	
	public CoursePlanCustomMapper getCoursePlanCustomMapper() {
		return coursePlanCustomMapper;
	}

	@Autowired
	public void setCoursePlanCustomMapper(
			CoursePlanCustomMapper coursePlanCustomMapper) {
		this.coursePlanCustomMapper = coursePlanCustomMapper;
	}

	@Override
	public List<CoursePlanDto> selectTotalInfoOfCoursePlan(CoursePlanDto coursePlanInfo,
			PaginationCustom page) {
		
		return coursePlanCustomMapper.selectTotalInfoOfCoursePlan(coursePlanInfo, page.getLimitation());
	}

	@Override
	public int selectCountOfCoursePlan(CoursePlanDto coursePlanInfo) {
		
		return coursePlanCustomMapper.selectCountOfCoursePlan(coursePlanInfo);
	}

	//振佳
	//根据学期类型找到所有的课程班级信
	@Override
	public List<CoursePlanDto> findAllByTermType(Integer termType) {
		// TODO Auto-generated method stub
		return coursePlanCustomMapper.findAllByTermType(termType);
	}

}
