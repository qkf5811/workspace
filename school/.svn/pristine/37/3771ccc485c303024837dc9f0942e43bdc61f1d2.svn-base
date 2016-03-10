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
import com.dkt.school.equ.dto.StorageDto;
import com.dkt.school.equ.model.Storage;
import com.dkt.school.equ.service.StorageService;
import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.model.ClassRoom;
import com.dkt.school.sch.service.BuildingService;
import com.dkt.school.sch.service.ClassRoomService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@Controller
@RequestMapping("equ")
public class StorageListController {
	private static final Logger logger=LoggerFactory.getLogger(StorageListController.class);
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private ClassRoomService classRoomService;
	@Autowired
	private StorageService storageService;
	
	/**
	 * 打开仓库列表首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/toStorageList")
	public String toStorageList(Model model){
		logger.info("---------进入仓库列表的首页-------");
		List<Building> buildingList=buildingService.getAllBuilding();
		List<ClassRoom> classRoomList=classRoomService.getAllClassRoom();
		model.addAttribute("buildingList",buildingList);
		model.addAttribute("classRoomList",classRoomList);
		return "/equ/storageList";
	}
	/**
	 * 查询到符合条件的仓库信息
	 * @param storageDto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStorageList")
	public String searchStorageTotalInfo(StorageDto storageDto, PaginationCustom page) {
		System.out.println("StorageDto : "+storageDto);
		logger.info("-----------查询仓库信息---------------");
		 int total=storageService.getStorageCount(storageDto);
	      //设置当前页面所选择的每页记录数
	        page.setPageRecorders(page.getRows());
	        page.setCurrentPage(page.getPage());
	        page.setTotalRows(total);
	        List<StorageDto> storageList=storageService.getStorageByPage(storageDto, page);
	        Gson gson=new Gson();
	        JsonArray storageListJa=gson.toJsonTree(storageList, List.class).getAsJsonArray();
	        JsonObject resultJo=new JsonObject();
	        resultJo.add("rows",storageListJa);
	        resultJo.addProperty("total", total);
	        return resultJo.toString();
	}
	
	/**
	 * 教学楼和教室的二级联动
	 * @param builiding
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassRoomByBuilding")
	public String getClassRoomByBuilding(Integer buildingId){
		List<ClassRoom> classRoomList = classRoomService.getClassByBuildingIdForStorage(buildingId);
		JsonArray jsArr = new Gson().toJsonTree(classRoomList,List.class).getAsJsonArray();
		return jsArr.toString();
	}
	
	/**
     * 添加仓库信息
     * @param storage
     * @return
     */
    @ResponseBody
    @RequestMapping("/addStorageInfo")
    public String addStorageInfo(Storage storage){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------插入一条仓库信息记录------------------------");
        resultJo.addProperty("result", storageService.addStorageInfo(storage));
        return resultJo.toString();
    }
    
    
   /**
    * 修改仓库信息
    * @param storage
    * @return
    */
    @ResponseBody
    @RequestMapping("/updateStorage")
    public String updateStorage(Storage storage){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改仓库信息记录------------------------");
        resultJo.addProperty("result", storageService.updateStorage(storage));
        return resultJo.toString();
    }
    
    /**
     * 删除仓库信息
     * @param storage
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteStorage")
    public String deleteStorageById(Storage storage){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------删除设备种类信息记录------------------------");
        resultJo.addProperty("result", storageService.deleteStorageById(storage));
        return resultJo.toString();
    }
}
