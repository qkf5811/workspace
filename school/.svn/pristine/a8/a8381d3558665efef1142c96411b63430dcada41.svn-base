package com.dkt.school.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.system.model.EnumerationValue;

/*
 *@Title: EnumerationValueCustomMapper.java
 *@Package com.dkt.youshi.system.dao
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年5月6日下午3:38:22
 */
public interface EnumerationValueCustomMapper extends EnumerationValueMapper {

	/**
	 * 根据常量id查找常量值
	 * @param enumId
	 * @return
	 */
	public List<EnumerationValue> selectByEnumerationId(
			@Param("enumId") Integer enumId);
	
	/**
	 * 根据id查找常量值
	 * @param id
	 * @return
	 */
	public EnumerationValue selectByEnumerationValueId(
			@Param("id") Integer id);

	/**
	 * 根据学号、常量id查找常量值
	 * @author HIU
	 * @param enumId
	 * @param stuCode
	 * @return
	 */
	public List<EnumerationValue> getEnumValueListByEnumIdByStuCode(
			@Param("enumId")Integer enumId, @Param("stuCode")String stuCode);
}

