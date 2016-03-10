package com.dkt.school.sch.service;

import com.dkt.school.sch.model.School;

public interface SchoolService {

	School getSchoolInfo();

	int updateSchool(School school);

}
