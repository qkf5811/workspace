package com.dkt.school.sch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.sch.dao.SchoolMapper;
import com.dkt.school.sch.model.School;
import com.dkt.school.sch.model.SchoolExample;
import com.dkt.school.sch.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	SchoolMapper schoolMapper;

	@Override
	public School getSchoolInfo() {
		School school = new School();
		List<School> schoolList = schoolMapper.selectByExample(new SchoolExample());
		if (schoolList != null && schoolList.size() > 0) {
			school = schoolList.get(0);
		}
		return school;
	}

	@Override
	public int updateSchool(School school) {
		int result = 0;
		if (school.getId() == null || school.getId() == 0) {
			result = schoolMapper.insert(school);
		} else {
			result = schoolMapper.updateByPrimaryKey(school);
		}
		return result;
	}

}
