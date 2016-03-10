package com.dkt.school.sch.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.MajorFieldDto;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;

public interface MajorFieldService {
	
	//获取所有专业方向信息并分页查询
	public List<MajorFieldDto> getAllMajorFieldInfoByPage(PaginationCustom page);
	
	//根据专业id得到专业方向的记录
	public List<MajorField> getMajorFieldInfoByMajorId(int majorId);
	
	//根据专业id得到专业方向的记录
	public List<MajorFieldDto> getMajorFieldInfoByMajorIdByPage(int majorId, PaginationCustom page);
	
	//根据专业id得到专业方向的信息
	public int getMajorFieldCountByMajorId(int majorId);
	
	//得到专业方向的数量
	public int getMajorFieldCount();
	
	//添加专业方向
	public int addMajorField(MajorField majorField);
	
	//根据专业方向id删除专业方向
	public int deleteMajorFieldById(int id);
	
	//得到majorFieldDto
	public void toMajorFieldDto(List<MajorFieldDto> dtoList);
	
	//根据专业方向id修改专业名称
	public int editMajorFieldName(int majorFieldId, String newName);

	/**
	 * 获取所有专业方向
	 * @return
	 */
	public List<MajorField> getAllMajorField();
	
	/**
	 * 更新专业方向内容
	 */
	public int updateMajorField(MajorField majorField);
}
