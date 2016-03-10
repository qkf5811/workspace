package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.BuyDetailDto;
import com.dkt.school.equ.model.BuyDetail;

public interface BuyDetailCustomMapper extends BuyDetailMapper {
	
	//获取某种类的设备的总价
	public BuyDetailDto getDetailByEquipmentId(int equipmentId);
	
	//获取所有
	public List<BuyDetailDto> getAllPrice(
			@Param("limit")Limitation limit);

	/**
	 * 得到所有购买明细
	 * @return
	 */
	public List<BuyDetail> selectAllBuyDetail();
}
