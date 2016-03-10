package com.dkt.school.equ.service;

import java.util.List;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.dto.CategoryDto;


public interface CategoryService {
	//添加设备分类信息
	public int addCategory(Category record);
	
	//获取所有设备分类信息
	public List<Category> getCategorysInfo();
	
	//获取所有分类
			public List<Category> getAllCategory();
			
			/**
			 * 添加分类
			 * @param category
			 * @return
			 */
			public int addCategoryInfo(Category category);
			
			//获得分类数目
			public int getCategoryCount(CategoryDto categoryDto);
			
			//获取分类信息
			public List<Category> getCategoryByPage(CategoryDto categoryDto,Pagination page);
			
			/**
			 * 更新分类内容
			 */
			public int updateCategory(Category category);
			
			/**
			 * 删除分类
			 * @param categoryId
			 * @return
			 */
			public int deleteCategoryById(Integer categoryId);
			
			/**
			 * 根据分类id查找分类信息,返回一个CategoryDto
			 * @param categoryId
			 * @return
			 */
			public CategoryDto findCategoryDtoByCategoryId(Integer categoryId);
}
