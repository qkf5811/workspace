package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.RoomApplication;

public interface RoomApplicationCustomMapper extends RoomApplicationMapper {
	
	
	
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
	
	/**
	 * 根据流程ID查找对象
	 * @param appId
	 * @return
	 * 2015年9月9日上午11:03:32
	 */
	public RoomApplication getRoomApplicationByAppId(@Param("appId")Integer appId) ;
}
