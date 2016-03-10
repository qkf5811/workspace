package com.dkt.school.sch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;

public interface MajorCustomMapper extends MajorMapper {
	
	//获得所有专业信息
	List<Major> getAllMajorInfo();
	
	//根据专业id修改专业名称
	/*public int editMajorName(
			@Param("majorId")int majorId,
			@Param("newName")String newName);
*/
	
	//获得专业信息
	List<Major> getAllMajor();

	//邮专业获得专业方向
	List<MajorField> getFieldByMajorId(@Param("majorId")Integer majorId);

	/**
	 * 根据页面得到所有专业的数量
	 * @param limitation
	 * @return
	 */
	public int selectMajorCountByPage(
			@Param("limit")Limitation limitation);
	
	/**
	 * 根据页面得到所有专业
	 * @param limitation
	 * @return
	 */
	public List<Major> selectMajorByPage(
			@Param("limit")Limitation limitation);

	
}
