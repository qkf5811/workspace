package com.dkt.school.sch.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;

public interface MajorService {
	
	//得到所有专业记录
	public List<Major> getAllMajorInfo();
	
	//添加专业
	public int addNewMajor(Major major);
	
	//删除专业
	public int deleteMajor(int id);

	/**
	 * 更新专业内容
	 */
	public int updateMajor(Major major);
	
	//获得所有专业
	public List<Major> getAllMajor();

	/*根据专业获得所有方向*/
	public List<MajorField> getFieldByMajorId(Integer majorId);

	/**
	 * 根据页面得到所有专业的数量
	 * @param page
	 * @return
	 */
	public int getAllMajorCountByPage(PaginationCustom page);

	/**
	 * 根据页面得到所有专业
	 * @param page
	 * @return
	 */
	public List<Major> getAllMajorByPage(PaginationCustom page);

}
