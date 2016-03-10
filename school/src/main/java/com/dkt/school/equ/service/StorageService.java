package com.dkt.school.equ.service;

import java.util.List;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.StorageDto;
import com.dkt.school.equ.model.Storage;

public interface StorageService {
	
	//获取所有
	public List<Storage> getAllStoragesInfo();
	
	//获取仓库名称
	public String getStorageNameById(int id);
	
	/**
	 * 获取符合条件的仓库数量
	 * @param storageDto
	 * @return
	 */
	public int getStorageCount(StorageDto storageDto);

	/**
	 * 获取符合条件的仓库列表
	 * @param storageDto
	 * @param page
	 * @return
	 */
	public List<StorageDto> getStorageByPage(StorageDto storageDto,
			PaginationCustom page);

    /**
     * 添加仓库信息
     * @param storage
     * @return
     */
	public int addStorageInfo(Storage storage);

	/**
	 * 删除仓库信息
	 * @param storage
	 * @return
	 */
	public int deleteStorageById(Storage storage);

	/**
	 * 修改仓库信息
	 * @param storage
	 * @return
	 */
	public int updateStorage(Storage storage);
}
