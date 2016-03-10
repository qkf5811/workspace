package com.dkt.school.equ.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.equ.dao.CategoryCustomMapper;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.dao.CategoryMapper;
import com.dkt.school.equ.dto.CategoryDto;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryCustomMapper categoryMapper;
	
	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}
	
	@Autowired
	public void setCategoryMapper(CategoryCustomMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}
	
	@Autowired
	private CategoryCustomMapper categoryCustomMapper;
	
	public CategoryCustomMapper getCategoryCustomMapper() {
		return categoryCustomMapper;
	}

	@Autowired
	public void setCategoryCustomMapper(CategoryCustomMapper categoryCustomMapper) {
		this.categoryCustomMapper = categoryCustomMapper;
	}
	
	
	@Override
	public int addCategory(Category record) {

		//判断设备分类信息是否完整
		if (record.getName() == null || "".equals(record.getName()) ||
			record.getRemark() == null || "".equals(record.getRemark()))
			return -1;
		else 
			return categoryMapper.insert(record);
	}

	//获取所有设备分类
	@Override
	public List<Category> getCategorysInfo() {
		List<Category> categoryList = categoryMapper.getCategorysInfo();
		return categoryList;
	}
	
	@Override
	public List<Category> getAllCategory() {
		
		return categoryCustomMapper.selectAllCategory();
	}

	public int addCategoryInfo(Category category) {
		return categoryCustomMapper.insert(category);
	}
	public List<Category> getCategoryByPage(CategoryDto categoryDto,
			Pagination page) {
		return categoryCustomMapper.selectByLimit(categoryDto, page.getLimitation());
	}

	public int getCategoryCount(CategoryDto categoryDto) {
		return categoryCustomMapper.getCategoryCount(categoryDto);
	}

	public int updateCategory(Category category) {

		return categoryCustomMapper.updateByPrimaryKeySelective(category);
	}

	public int deleteCategoryById(Integer categoryId) {

		return categoryCustomMapper.deleteByPrimaryKey(categoryId);
	}
	public CategoryDto findCategoryDtoByCategoryId(Integer categoryId) {
		return categoryCustomMapper.selectCategoryDtoByCategoryId(categoryId);
	}
	
}
