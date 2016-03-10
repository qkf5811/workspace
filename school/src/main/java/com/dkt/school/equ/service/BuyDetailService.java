package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BuyDetailDto;
import com.dkt.school.equ.model.BuyDetail;

public interface BuyDetailService {

	//根据设备种类获取总价值
	public BuyDetailDto getPriceListWidthEquipmentId(int equipmentId);
	
	//查询所有设备总价值
	public List<BuyDetailDto> getAllPrice(PaginationCustom page);

	/**
	 * 得到所有购买明细
	 * @return
	 */
	public List<BuyDetail> findAllBuyDetail();
}
