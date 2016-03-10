package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;
import com.dkt.school.equ.model.RoomApplication;

public interface RoomApplicationService {
	
	/**
	 * 添加申请
	 * @param obj
	 * @return
	 * 2015年9月7日下午5:05:08
	 */
	public int addRoomApplication(RoomApplication obj);
	
	/**
	 * 功能室使用申请条数
	 * @param appName
	 * @param funRoomName
	 * @param uName
	 * @return
	 * 2015年9月7日下午3:28:43
	 */
	public int getRoomApplicationCount(FunctionRoomDto dto);
	
	/**
	 * 功能室使用申请数据
	 * @param appName
	 * @param funRoomName
	 * @param uName
	 * @param page
	 * @return
	 * 2015年9月7日下午3:31:34
	 */
	public List<FunctionRoomDto> getRoomApplicatioByPage(FunctionRoomDto dto,Pagination page);
	
	/**
	 * 删除功能室申请
	 * @param id
	 * @return
	 * 2015年9月7日下午4:32:24
	 */
	public int deleteRoomApplication(Integer id);
	
	/**
	 * 更新功能室申请
	 * @param FunctionRoom
	 * @return
	 * 2015年9月7日下午4:33:03
	 */
	public int updateRoomApplication(FunctionRoomDto dto);
	
	/**
	 * 添加流程和功能室申请ID
	 * @param functionRoomDto
	 * @return
	 * 2015年9月8日上午11:04:26
	 */
	public int addApplication(FunctionRoomDto functionRoomDto);
}
