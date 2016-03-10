package com.dkt.school.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.system.dao.EnumerationValueCustomMapper;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;

/*
 *@Title: EnumerationServiceImpl.java
 *@Package com.dkt.school.system.Service.impl
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:42:36
 */

@Service
public class EnumerationServiceImpl implements EnumerationService {

	private EnumerationValueCustomMapper enumerationValueMapper;
	

	public EnumerationValueCustomMapper getEnumerationValueMapper() {
		return enumerationValueMapper;
	}

	@Autowired
	public void setEnumerationValueMapper(
			EnumerationValueCustomMapper enumerationValueMapper) {
		this.enumerationValueMapper = enumerationValueMapper;
	}


	public List<EnumerationValue> getEnumValueListByEnumId(Integer enumId) {
		// TODO Auto-generated method stub
		return enumerationValueMapper.selectByEnumerationId(enumId);
	}

	public EnumerationValue getEnumValueById(Integer id) {
		// TODO Auto-generated method stub
		return enumerationValueMapper.selectByEnumerationValueId(id);
	}

	@Override
	public List<EnumerationValue> getEnumValueListByEnumIdByStuCode(
			Integer enumId, String stuCode) {
		// TODO Auto-generated method stub
		return enumerationValueMapper.getEnumValueListByEnumIdByStuCode(enumId,stuCode);
	}

}

