package com.dkt.school.equ.controller;

import java.util.List;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.model.Equipment;
import com.dkt.school.equ.service.CategoryService;
import com.dkt.school.equ.service.EquipmentService;
import com.dkt.school.sch.controller.RoomController;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("equ")
public class EquipmentListController {

private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	private EquipmentService equipmentService;
	
	public EquipmentService getEquipmentService() {
		return equipmentService;
	}
    @Autowired
	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}

    private CategoryService categoryService;
   
	public CategoryService getCategoryService() {
		return categoryService;
	}
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	/**
	 * 进入设备种类页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEquipmentList")
	public String toEquipmentList(Model model){
		logger.info("----------进入设备种类列表页面---------");
		List<Category> categoryList=categoryService.getAllCategory();
		model.addAttribute("categoryList",categoryList);
		return "/equ/equipmentList";
	}
	
	
	/**
	 * 查询到符合条件的设备种类信息
	 * @param dto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEquipmentList")
	public String searchEquipmentTotalInfo(EquipmentDto dto, PaginationCustom page) {
		System.out.println("EquipmentDto : "+dto);
		logger.info("-----------查询设备管理信息---------------");
		JsonObject resultJson = new JsonObject();
		// total:所有记录数并设置page的属性
		int total = equipmentService.selectCountOfEquipment(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		// 查询记录
		List<EquipmentDto> equipmentList =
				equipmentService.selectTotalInfoOfEquipment(dto,page);

		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
				.toJsonTree(equipmentList, List.class).getAsJsonArray();

		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	/**
     * 添加设备种类
     * @param equipment
     * @return
     */
    @ResponseBody
    @RequestMapping("/addEquipmentInfo")
    public String addEquipmentInfo(Equipment equipment){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------插入一条设备种类信息记录------------------------");
        resultJo.addProperty("result", equipmentService.addEquipmentInfo(equipment));
        return resultJo.toString();
    }
    
    
   /**
    * 修改设备种类
    * @param equipment
    * @return
    */
    @ResponseBody
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改设备种类信息记录------------------------");
        resultJo.addProperty("result", equipmentService.updateEquipment(equipment));
        return resultJo.toString();
    }
    
    /**
     * 删除设备种类
     * @param equipment
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteEquipment")
    public String deleteEquipmentById(Equipment equipment){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------删除设备种类信息记录------------------------");
        resultJo.addProperty("result", equipmentService.deleteEquipmentById(equipment));
        return resultJo.toString();
    }
}
