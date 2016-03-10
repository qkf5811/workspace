package com.dkt.school.sch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.dto.BuildingDto;
import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.model.ClassRoom;

public interface BuildingCustomMapper extends BuildingMapper {
	
	public List<Building> selectBuildByCampusId(@Param("id") Integer id);
	
	/**
	 * 获取符合条件的教学楼数量
	 * @param dto
	 * @return
	 */
	public int selectCountOfBuilding(@Param("dto")BuildingDto dto);

	/**
	 * 获取符合条件的教学楼列表
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<BuildingDto> selectTotalInfoOfBuilding(@Param("dto")BuildingDto dto,
			@Param("limit") Limitation limit);

}
