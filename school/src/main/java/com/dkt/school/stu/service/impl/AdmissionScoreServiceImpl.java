package com.dkt.school.stu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dkt.school.stu.dao.AdmissionScoreCustomMapper;
import com.dkt.school.stu.service.AdmissionScoreService;

public class AdmissionScoreServiceImpl implements AdmissionScoreService {

	private AdmissionScoreCustomMapper admissionScoreCustomerMapper;
	@Autowired
	public void setAdmissionScoreCustomerMapper(
			AdmissionScoreCustomMapper admissionScoreCustomerMapper) {
		this.admissionScoreCustomerMapper = admissionScoreCustomerMapper;
	}
	public AdmissionScoreCustomMapper getAdmissionScoreCustomerMapper() {
		return admissionScoreCustomerMapper;
	}


	@Override
	public Integer findStudentInfoIdByExamNum(String examNum) {
		// TODO Auto-generated method stub
		return admissionScoreCustomerMapper.getStudentInfoIdByExamNum(examNum);
	}

}
