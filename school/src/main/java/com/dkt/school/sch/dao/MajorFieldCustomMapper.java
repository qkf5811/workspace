package com.dkt.school.sch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.dto.MajorFieldDto;
import com.dkt.school.sch.model.MajorField;

public interface MajorFieldCustomMapper extends MajorFieldMapper {
	
	//根据专业id得到专业方向的数量
	public int getMajorFieldCountByMajorId(int majorId);
	
	//得到专业方向的数量
	public int getMajorFieldCount();
	
	//根据专业id得到专业方向的信息
	public List<MajorField> getMajorFieldByMajorId(int majorId);
	
	//获取所有专业方向信息
	public List<MajorField> getAllMajorFieldInfo();
	
	//获取所有专业方向信息
	public List<MajorFieldDto> getAllMajorFieldInfoByPage(
			@Param("limit") Limitation limit);
	
	//根据专业id得到专业方向的信息
	public List<MajorFieldDto> getMajorFieldInfoByPage(
			@Param("majorId") int majorId,
			@Param("limit") Limitation limit);
	
	//----------------炳坚-----------------
	//根据专业名字得到专业id
	public Integer getMajorFieldIdByName(@Param("majorFieldName")String majorFieldName);
	//----------------炳坚-----------------

	//根据专业id删除专业方向
	public int deleteByMajorId(int id);
	
	//根据专业方向id修改专业名称
	public int editMajorFieldName(
			@Param("majorFieldId")int majorFieldId,
			@Param("newName")String newName);
}
