package com.dkt.school.equ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.dto.CategoryDto;

public interface CategoryCustomMapper extends CategoryMapper {
	
	//获取所有
	public List<Category> getCategorysInfo();
	
	public List<Category> selectAllCategory();
	/**
	 * 根据分类id查找分类信息
	 * 
	 * @param categoryId
	 * @return
	 */ 
	public CategoryDto selectCategoryDtoByCategoryId(
			@Param("categoryId") Integer categoryId);
	/**
	 * 获取分类信息
	 * @param limit
	 * @param category
	 * @return
	 */
	public List<Category> selectByLimit(
			@Param("category") CategoryDto categoryDto,
			@Param("limit") Limitation limit);
	/**
	 * 获取分类数量
	 * @param category
	 * @return
	 */
	public Integer getCategoryCount(
			@Param("category") CategoryDto categoryDto);
}
