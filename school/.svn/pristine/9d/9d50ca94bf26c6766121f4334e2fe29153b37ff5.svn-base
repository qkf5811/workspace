package com.dkt.school.sch.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.BuildingDto;
import com.dkt.school.sch.model.Building;

public interface BuildingService {
	
	//根据校区获取教学楼
	public List<Building> getBuildingByCampusId(Integer id);

	/**
	 * 获取所有的教学楼
	 * @return
	 */
	public List<Building> getAllBuilding();

	/**
	 * 获取符合条件的教学楼数量
	 * @param dto
	 * @return
	 */
	public int selectCountOfBuilding(BuildingDto dto);

	/**
	 * 获取符合条件的教学楼列表
	 * @param dto
	 * @param page
	 * @return
	 */
	public List<BuildingDto> selectTotalInfoOfBuilding(BuildingDto dto,
			PaginationCustom page);

    /**
     * 添加教学楼
     * @param building
     * @return
     */
	public int addBuilding(Building building);

	/**
	 * 删除教学楼
	 * @param building
	 * @return
	 */
	public int deleteBuildingById(Building building);

	/**
	 * 修改教学楼
	 * @param building
	 * @return
	 */
	public int updateBuilding(Building building);

}
