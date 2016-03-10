package com.dkt.school.sch.dao;

import java.util.List;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.dto.ClassRoomDto;
import org.apache.ibatis.annotations.Param;

import com.dkt.school.sch.model.ClassRoom;

public interface ClassRoomCustomMapper extends ClassRoomMapper {
	
	/**
	 * 根据教学楼id获取教室
	 */
	public List<ClassRoom> selectClassRoomByBuildingId(@Param("id") Integer id);

	/**
	 * 根据条件查询教室的数量，返回一个int类型
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @return
	 */
	public int countBySearch(@Param("name") String name,@Param("campusId") Integer campusId,@Param("buildingId") Integer buildingId,@Param("roomType") Integer roomType);

	/**
	 * 根据条件模糊分页查询教室信息
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @param limit
	 * @return
	 */
	public List<ClassRoomDto> selectByLimit(@Param("name") String name,@Param("campusId") Integer campusId,@Param("buildingId") Integer buildingId,@Param("roomType") Integer roomType,@Param("limit")Limitation limit);

	/**
	 * 根据教室id查询教室信息和教室所属校区的id
	 * @param id
	 * @return
	 */
	public ClassRoomDto selectClassRoomDtoByClassRoomId(@Param("id") Integer id);
	/**
	 * @author 吴俊鹏
	 * 根据教学楼id获取仓库属性的教室
	 */
	public List<ClassRoom> getClassByBuildingIdForStorage(@Param("id") Integer id);
}
