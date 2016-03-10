package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;

public interface FunctionRoomCustomMapper extends FunctionRoomMapper {
	
	/**
	 * 根据教学楼id获取教室
	 */
	public List<FunctionRoom> selectFunctionRoomByBuildingId(@Param("id") Integer id);

	/**
	 * 根据条件查询教室的数量，返回一个int类型
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @return
	 */
	public int countBySearch(@Param("buildingId") Integer buildingId,@Param("name") String name);

	/**
	 * 根据条件模糊分页查询教室信息
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @param limit
	 * @return
	 */
	public List<FunctionRoomDto> selectByLimit(@Param("name") String name,@Param("buildingId") Integer buildingId
			,@Param("limit")Limitation limit);

	/**
	 * 根据教室id查询教室信息和教室所属校区的id
	 * @param id
	 * @return
	 */
	public FunctionRoom selectFunctionRoomById(@Param("id") Integer id);
	
	/**
	 * 功能室使用记录条数
	 * @param funRoomName
	 * @param uName
	 * @return
	 * 2015年9月6日下午3:13:56
	 */
	public int getFunctionRoomRecordCount(@Param("rname")String funRoomName, 
			@Param("uname")String uName);
	
	/**
	 * 功能室使用记录数据
	 * @param funRoomName
	 * @param uName
	 * @param page
	 * @return
	 * 2015年9月6日下午3:58:12
	 */
	public List<FunctionRoomDto> selectRecordByLimit(@Param("rname")String funRoomName, 
			@Param("uname")String uName,@Param("limit")Limitation limit);
	
	
	/**
	 * 功能室使用申请条数
	 * @param appName
	 * @param funRoomName
	 * @param uName
	 * @return
	 * 2015年9月7日下午3:28:43
	 */
	public int getRoomApplicationCount(@Param("dto")FunctionRoomDto dto);
	
	/**
	 * 功能室使用申请数据
	 * @param appName
	 * @param funRoomName
	 * @param uName
	 * @param page
	 * @return
	 * 2015年9月7日下午3:31:34
	 */
	public List<FunctionRoomDto> getRoomApplicatioByPage(@Param("dto")FunctionRoomDto dto,@Param("limit")Limitation limit);
}
