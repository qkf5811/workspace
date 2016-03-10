package com.dkt.school.pe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.pe.dto.PePersonInfoDto;
import com.dkt.school.pe.model.PePersonInfo;

public interface PePersonInfoCustomMapper extends PePersonInfoMapper {
	
	/**
	 * 查询所有体育工作组的职位
	 * @return
	 */
	public List<Map<Integer, String>> selectAllPePosition();
	
	/**
	 * 查询体育工作组个人信息List
	 * @param position
	 * @param name
	 * @return
	 */
	public List<PePersonInfoDto> selectPersonInfoList(@Param("position")Integer position, @Param("name")String name, @Param("limit")Limitation limit);
	
	/**
	 * 查询体育工作组个人信息数量
	 * @param position
	 * @param name
	 * @return
	 */
	public int selectPersonInfoCount(@Param("position")Integer workGroupPosition, @Param("name")String teaNameInWorkGroup);

	/**
	 * 根据教职工工号检查是否已经存在该人员信息
	 * @param code
	 * @return 
	 */
	public List<PePersonInfo> selectPePersonInfoByTeaCode(@Param("code")String code);

	/**
	 * 根据工号查询tea_info_id
	 * @param code
	 * @return
	 */
	public Integer selectTeaInfoIdByCode(@Param("code")String code);
}
