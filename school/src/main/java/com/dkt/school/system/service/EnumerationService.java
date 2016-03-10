package com.dkt.school.system.service;

import java.util.List;

import com.dkt.school.system.model.EnumerationValue;

/*
 *@Title: EnumerationService.java
 *@Package com.dkt.school.system.Service
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:40:59
 */
public interface EnumerationService {

	/**
	 * 根据常量id获取常量值，并返回一个集合
	 * @param enumId
	 * @return List
	 */
	public List<EnumerationValue> getEnumValueListByEnumId(Integer enumId);
	
	
	/**
	 * 根据id获取常量值，并返回一个EnumerationValue对象
	 * @param id
	 * @return
	 */
	public EnumerationValue getEnumValueById(Integer id);


	public List<EnumerationValue> getEnumValueListByEnumIdByStuCode(Integer enumId, String stuCode);
}

