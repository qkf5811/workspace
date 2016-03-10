package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.BuyDetailCustomMapper;
import com.dkt.school.equ.dao.EquipmentCustomMapper;
import com.dkt.school.equ.dto.BuyDetailDto;
import com.dkt.school.equ.model.BuyDetail;
import com.dkt.school.equ.model.Equipment;
import com.dkt.school.equ.service.BuyDetailService;
@Service
public class BuyDetailServiceImpl implements BuyDetailService {
	
	private BuyDetailCustomMapper buyDetailMapper;
	
	private EquipmentCustomMapper equipMapper;


	public EquipmentCustomMapper getEquiupMapper() {
		return equipMapper;
	}

	@Autowired
	public void setEquipMapper(EquipmentCustomMapper equipMapper) {
		this.equipMapper = equipMapper;
	}

	public BuyDetailCustomMapper getBuyDetailMapper() {
		return buyDetailMapper;
	}
	
	@Autowired
	public void setBuyDetailMapper(BuyDetailCustomMapper buyDetailMapper) {
		this.buyDetailMapper = buyDetailMapper;
	}
	
	@Override
	public BuyDetailDto getPriceListWidthEquipmentId(int equipmentId) {
		BuyDetailDto dto = buyDetailMapper.getDetailByEquipmentId(equipmentId);
		Equipment equ = equipMapper.selectByPrimaryKey(equipmentId);
		
		double totalPrice = 0;
		totalPrice += dto.getPrice() * dto.getAmount();
		
		dto.setEquipmentName(equ.getName());
		dto.setTotalPrice(totalPrice);
		return dto;
	}

	@Override
	public List<BuyDetailDto> getAllPrice(PaginationCustom page) {
		List<BuyDetailDto> list = buyDetailMapper.getAllPrice(page.getLimitation());
		
		for ( BuyDetailDto temp : list) {
			Equipment equip = equipMapper.selectByPrimaryKey(temp.getEquipmentId());
			temp.setEquipmentName(equip.getName());
			temp.setTotalPrice(temp.getPrice() * temp.getAmount());
		}
		
		return list; 
	}

	@Override
	public List<BuyDetail> findAllBuyDetail() {
		// TODO Auto-generated method stub
		return buyDetailMapper.selectAllBuyDetail();
	}

}
