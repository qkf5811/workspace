package com.dkt.school.pe.service;

import java.util.List;
import java.util.Map;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dto.PePersonInfoDto;
import com.dkt.school.pe.model.PePersonInfo;

public interface PePersonInfoService {
	
	/**
	 * 根据职位和姓名查找工作组里的人员信息
	 * @param position 职位
	 * @param name 姓名
	 * @return
	 */
	public List<PePersonInfoDto> queryPersonInfoList(Integer position, String name, PaginationCustom page);
	
	/**
	 * 查询体育工作组人员数量
	 * @param workGroupPosition
	 * @param teaNameInWorkGroup
	 * @return
	 */
	public int queryPersonInfoCount(Integer workGroupPosition, String teaNameInWorkGroup);
	
	/**
	 * 根据主键查找工作组人员个人信息
	 * @param id
	 * @return
	 */
	public PePersonInfoDto queryPersonInfo(Integer id);
	
	/**
	 * 根据id删除工作组里的人员信息
	 * @param id
	 * @return
	 */
	public int deletePersonInfo(Integer id);
	
	/**
	 * 更新人员信息
	 * @param pi
	 * @return
	 */
	public int updatePersonInfo(PePersonInfo pi);

	/**
	 * 查询所有体育工作组的职位
	 * @return
	 */
	public List<Map<Integer, String>> queryPosition();

	/**
	 * 根据教职工工号，检查是否已经存在人员信息
	 * @param code
	 * @return
	 */
	public List<PePersonInfo> queryByTeaCode(String code);

	/**
	 * 根据工号查询tea_info_if
	 * @param code
	 * @return
	 */
	public Integer queryTeaIinfoIdByCode(String code);

	/**
	 * 添加工作组人员信息
	 * @param dto
	 * @return
	 */
	public int savePePersonInfo(PePersonInfoDto dto);
	
}
