package com.dkt.school.sch.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.ClassRoomDto;
import com.dkt.school.sch.model.ClassRoom;

public interface ClassRoomService {
	
	/**
	 * 根据教学楼id获得教室
	 * @param id
	 * @return
	 */
	public List<ClassRoom> getClassRoomByBuilding(int id);

	/**
	 * 根据教室信息条件查询，并返回查询数目
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @return
	 */
	public int getClassRoomCount(String name,Integer campusId,Integer buildingId,Integer roomType);

	/**
	 * 根据教室信息条件分页查询
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @param page
	 * @return
	 */
	public List<ClassRoomDto> getClassRoomByPage(String name,Integer campusId,Integer buildingId,Integer roomType,Pagination page);

	/**
	 * 添加教室
	 * @param classRoom
	 * @return
	 */
	public int addClassRoom(ClassRoom classRoom);

	/**
	 * 更新教室信息
	 * @param classRoom
	 * @return
	 */
	public int updateClassRoom(ClassRoom classRoom);

	/**
	 * 根据教室id删除教室信息
	 * @param id
	 * @return
	 */
	public int deleteClassRoom(Integer id);

	/**
	 * 根据教室id获取教室信息
	 * @param id
	 * @return
	 */
	public ClassRoom findClassRoomByClassRoomId(Integer id);
	
	/**
	 * @author 吴俊鹏
	 * 得到所有的classroom
	 * @return
	 */
	public List<ClassRoom> getAllClassRoom();

	public List<ClassRoom> getClassByBuildingIdForStorage(int id);
}
