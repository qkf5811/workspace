package com.dkt.school.sch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.BuildingDto;
import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.service.BuildingService;
import com.dkt.school.sch.service.CampusService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * @author 赖继鹏
 *
 */

@Controller
@RequestMapping("sch")
public class BuildingController {

	private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);
	
	private BuildingService buildingService;
	
	public BuildingService getBuildingService() {
		return buildingService;
	}
    @Autowired
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

    private CampusService campusService;
   
	public CampusService getCampusService() {
		return campusService;
	}
	@Autowired
	public void setCampusService(CampusService campusService) {
		this.campusService = campusService;
	}
	
	
	/**
	 * 进入教学楼列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toBuildingList")
	public String toBuildingList(Model model){
		logger.info("----------进入教学楼列表页面---------");
		List<Campus> campusList=campusService.getAllCampus();
		model.addAttribute("campusList",campusList);
		return "/sch/buildingList";
	}
	
	
	/**
	 * 查询到符合条件的教学楼信息
	 * @param dto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBuildingList")
	public String searchBuildingTotalInfo(BuildingDto dto, PaginationCustom page) {
		System.out.println("BuildingDto : "+dto);
		logger.info("-----------查询教学楼信息---------------");
		JsonObject resultJson = new JsonObject();
		// total:所有记录数并设置page的属性
		int total = buildingService.selectCountOfBuilding(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		// 查询记录
		List<BuildingDto> buildingList =
				buildingService.selectTotalInfoOfBuilding(dto,page);

		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
				.toJsonTree(buildingList, List.class).getAsJsonArray();

		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	/**
     * 添加教学楼
     * @param building
     * @return
     */
    @ResponseBody
    @RequestMapping("/addBuilding")
    public String addCoursePlan(Building building){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------插入一条教学楼信息记录------------------------");
        resultJo.addProperty("result", buildingService.addBuilding(building));
        return resultJo.toString();
    }
    
    
   /**
    * 修改教学楼
    * @param building
    * @return
    */
    @ResponseBody
    @RequestMapping("/updateBuilding")
    public String updateBuilding(Building building){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改教学楼信息记录------------------------");
        resultJo.addProperty("result", buildingService.updateBuilding(building));
        return resultJo.toString();
    }
    
    /**
     * 删除教学楼
     * @param building
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteBuilding")
    public String deleteBuildingById(Building building){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改一条教学楼信息记录------------------------");
        resultJo.addProperty("result", buildingService.deleteBuildingById(building));
        return resultJo.toString();
    }
}
