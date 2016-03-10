package com.dkt.school.equ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.CategoryDto;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.service.CategoryService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/equ")
public class CategoryListController {
	@Autowired
	private CategoryService categoryService;

	  @RequestMapping("/categoryList")
	    public String categoryList(){
	        return "equ/categoryList";
	    }
	
	/**
     * 得到所有的分类信息
     * @param page
     * @return String
     */

    @ResponseBody
    @RequestMapping("/getCategoryList")
    public String getCategoryList(CategoryDto categoryDto,PaginationCustom page){
        int total=categoryService.getCategoryCount(categoryDto);
      //设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);
        List<Category> categoryList=categoryService.getCategoryByPage(categoryDto, page);
        Gson gson=new Gson();
        JsonArray categoryListJa=gson.toJsonTree(categoryList, List.class).getAsJsonArray();
        JsonObject resultJo=new JsonObject();
        resultJo.add("rows",categoryListJa);
        resultJo.addProperty("total", total);
        return resultJo.toString();
    }
	
	 /**
     * 更新分类
     * @param category
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCategory")
    public String updateCategory(Category category){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", categoryService.updateCategory(category));
        return resultJson.toString();
    }

	/**
     * 添加分类
     * @param category
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCategoryInfo")
    public String addCategory(Category category){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", categoryService.addCategoryInfo(category));
        return resultJson.toString();
    }
	
	 /**
     * 根据分类id删除分类
     * @param categoryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Integer categoryId){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", categoryService.deleteCategoryById(categoryId));
        return resultJson.toString();
    }
    /**
     * 根据分类id查找分类信息
     * @param categoryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCategory")
    public String getCategory(Integer categoryId){
        CategoryDto categoryDto=categoryService.findCategoryDtoByCategoryId(categoryId);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("category", gson.toJsonTree(categoryDto));
        return resultJson.toString();
    }
}
