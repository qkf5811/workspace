package com.dkt.school.sch.service;

import java.util.List;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dto.CampusDto;
import com.dkt.school.sch.model.Campus;

public interface CampusService {
	
	//获取所有校区
	public List<Campus> getAllCampus();
	
	/**
	 * 添加校区
	 * @param campus
	 * @return
	 */
	public int addCampus(Campus campus);
	
	//获得校区数目
	public int getCampusCount(CampusDto campusDto);
	
	//获取校区信息
	public List<Campus> getCampusByPage(CampusDto campusDto,Pagination page);
	
	/**
	 * 更新校区内容
	 */
	public int updateCampus(Campus campus);
	
	/**
	 * 删除校区
	 * @param campusId
	 * @return
	 */
	public int deleteCampusById(Integer campusId);
	
	/**
	 * 根据校区id查找校区信息,返回一个CampusDto
	 * @param campusId
	 * @return
	 */
	public CampusDto findCampusDtoByCampusId(Integer campusId);
}
