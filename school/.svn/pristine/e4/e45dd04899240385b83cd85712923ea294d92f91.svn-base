package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.StorageCustomMapper;
import com.dkt.school.equ.dto.StorageDto;
import com.dkt.school.equ.model.Storage;
import com.dkt.school.equ.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	
	@Autowired
	private StorageCustomMapper storageMapper;
	
	@Override
	public List<Storage> getAllStoragesInfo() {

		return storageMapper.getAllStoragesInfo();
	}

	@Override
	public String getStorageNameById(int id) {
		
		return storageMapper.getStorageNameById(id);
	}

	@Override
	public int getStorageCount(StorageDto storageDto) {
		// TODO Auto-generated method stub
		return storageMapper.getStorageCount(storageDto);
	}

	@Override
	public List<StorageDto> getStorageByPage(StorageDto storageDto,
			PaginationCustom page) {
		// TODO Auto-generated method stub
		return storageMapper.getStorageByPage(storageDto,page.getLimitation());
	}

	@Override
	public int addStorageInfo(Storage storage) {
		// TODO Auto-generated method stub
		return storageMapper.insert(storage);
	}

	@Override
	public int deleteStorageById(Storage storage) {
		// TODO Auto-generated method stub
		return storageMapper.deleteByPrimaryKey(storage.getId());
	}

	@Override
	public int updateStorage(Storage storage) {
		// TODO Auto-generated method stub
		return storageMapper.updateByPrimaryKeySelective(storage);
	}

}
