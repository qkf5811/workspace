package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.dto.StorageDto;
import com.dkt.school.equ.model.Storage;

public interface StorageCustomMapper extends StorageMapper {
	
	//查找所有
	public List<Storage> getAllStoragesInfo();

	//获取仓库名
	public String getStorageNameById(int id);
	
	/**
	 * 获取符合条件的仓库数量
	 * 
	 * @param storageDto
	 * @return
	 */
	public int getStorageCount(@Param("storageDto") StorageDto storageDto);

	/**
	 * 获取符合条件的仓库列表
	 * 
	 * @param storageDto
	 * @param page
	 * @return
	 */
	public List<StorageDto> getStorageByPage(
			@Param("storageDto") StorageDto storageDto, @Param("limit") Limitation limit);
}
