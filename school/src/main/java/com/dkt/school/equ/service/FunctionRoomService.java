package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;

public interface FunctionRoomService {
	
	/**
	 * 根据教学楼id获得功能室
	 * @param id
	 * @return
	 */
	public List<FunctionRoom> getFunctionRoomByBuilding(int id);

	/**
	 * 根据功能室信息条件查询，并返回查询数目
	 * @param buildingId
	 * @param name
	 * @return
	 * 2015年9月5日下午4:14:31
	 */
	public int getFunctionRoomCount(Integer buildingId,String name);

	/**
	 * 根据功能室信息条件分页查询
	 * @param name
	 * @param buildingId
	 * @param roomType
	 * @param page
	 * @return
	 */
	public List<FunctionRoomDto> getFunctionRoomByPage(String name,Integer buildingId,Pagination page);

	/**
	 * 添加功能室
	 * @param FunctionRoom
	 * @return
	 */
	public int addFunctionRoom(FunctionRoom FunctionRoom);

	/**
	 * 更新功能室信息
	 * @param FunctionRoom
	 * @return
	 */
	public int updateFunctionRoom(FunctionRoom FunctionRoom);

	/**
	 * 根据功能室id删除功能室信息
	 * @param id
	 * @return
	 */
	public int deleteFunctionRoom(Integer id);

	/**
	 * 根据功能室id获取功能室信息
	 * @param id
	 * @return
	 */
	public FunctionRoom findFunctionRoomById(Integer id);
	
	/**
	 * 功能室使用记录条数
	 * @param funRoomName
	 * @param uName
	 * @return
	 * 2015年9月6日下午3:13:56
	 */
	public int getFunctionRoomRecordCount(String funRoomName, String uName);
	
	/**
	 * 功能室使用记录数据
	 * @param funRoomName
	 * @param uName
	 * @param page
	 * @return
	 * 2015年9月6日下午3:58:12
	 */
	public List<FunctionRoomDto> getFunctionRoomRecordByPage(String funRoomName, String uName,Pagination page);
	
}
