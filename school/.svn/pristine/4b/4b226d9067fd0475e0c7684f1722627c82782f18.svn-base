package com.dkt.school.sch.service.impl;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dto.GradeDto;
import com.dkt.school.sch.model.GradeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.sch.dao.GradeCustomMapper;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.stu.model.Clazz;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeCustomMapper gcMapper;
	@Override
	public List<Grade> getAllGrade() {
		
		return gcMapper.getAllGrade();
	}
	@Override
	public List<Clazz> getClassByGradeId(Integer gradeId) {
		
		return gcMapper.getClassByGradeId(gradeId);
	}
	@Override
	public List<Clazz> getClassByGradeIdAndFieldId(Integer gradeId,
			Integer fieldId) {
		// TODO Auto-generated method stub
		return gcMapper.selectClassByGradeIdAndFieldId(gradeId, fieldId);
	}

	@Override
	public int getGradeCount(String name, Integer eduStageType, Integer isGraduation) {
		return gcMapper.countBySearch(name,eduStageType,isGraduation);
	}

	@Override
	public List<GradeDto> getGradeByPage(String name, Integer eduStageType, Integer isGraduation, Pagination page) {
		return gcMapper.selectByLimit(name,eduStageType,isGraduation,page.getLimitation());
	}

	@Override
	public int addGrade(Grade grade) {
		return gcMapper.insert(grade);
	}

	@Override
	public int updateGrade(Grade grade) {
		return gcMapper.updateByPrimaryKey(grade);
	}

	@Override
	public int deleteGrade(Integer id) {
		return gcMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Grade findGradeByGradeId(Integer id) {
		GradeExample gradeExample=new GradeExample();
		GradeExample.Criteria criteria=gradeExample.createCriteria();
		criteria.andIdEqualTo(id);

		return gcMapper.selectByExample(gradeExample).get(0);
	}

}
