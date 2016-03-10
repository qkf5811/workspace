package com.dkt.school.sch.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.dto.CampusDto;
import com.dkt.school.sch.model.Campus;

public interface CampusCustomMapper extends CampusMapper {
	
	public List<Campus> selectAllCampus();
	/**
	 * 根据校区id查找校区信息
	 * 
	 * @param campusId
	 * @return
	 */ 
	public CampusDto selectCampusDtoByCampusId(
			@Param("campusId") Integer campusId);
	/**
	 * 获取校区信息
	 * @param limit
	 * @param campus
	 * @return
	 */
	public List<Campus> selectByLimit(
			@Param("campus") CampusDto campusDto,
			@Param("limit") Limitation limit);
	/**
	 * 获取校区数量
	 * @param campus
	 * @return
	 */
	public Integer getCampusCount(
			@Param("campus") CampusDto campusDto);
}
