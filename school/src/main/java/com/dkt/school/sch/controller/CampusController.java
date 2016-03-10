package com.dkt.school.sch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.controller.CampusController;
import com.dkt.school.sch.dto.CampusDto;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.service.CampusService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/sch")
public class CampusController {
	
	@Autowired
	private CampusService campusService;

	  @RequestMapping("/campusList")
	    public String campusList(){
	        return "sch/campusList";
	    }
	
	/**
     * 得到所有的校区信息
     * @param page
     * @return String
     */

    @ResponseBody
    @RequestMapping("/getCampusList")
    public String getCampusList(CampusDto campusDto,PaginationCustom page){
        int total=campusService.getCampusCount(campusDto);
      //设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);
        List<Campus> campusList=campusService.getCampusByPage(campusDto, page);
        Gson gson=new Gson();
        JsonArray campusListJa=gson.toJsonTree(campusList, List.class).getAsJsonArray();
        JsonObject resultJo=new JsonObject();
        resultJo.add("rows",campusListJa);
        resultJo.addProperty("total", total);
        return resultJo.toString();
    }
	
	 /**
     * 更新校区
     * @param campus
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCampus")
    public String updateCampus(Campus campus){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", campusService.updateCampus(campus));
        return resultJson.toString();
    }

	/**
     * 添加校区
     * @param campus
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCampus")
    public String addCampus(Campus campus){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", campusService.addCampus(campus));
        return resultJson.toString();
    }
	
	 /**
     * 根据校区id删除校区
     * @param campusId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCampus")
    public String deleteCampus(Integer campusId){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", campusService.deleteCampusById(campusId));
        return resultJson.toString();
    }
    /**
     * 根据校区id查找校区信息
     * @param campusId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCampus")
    public String getCampus(Integer campusId){
        CampusDto campusDto=campusService.findCampusDtoByCampusId(campusId);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("campus", gson.toJsonTree(campusDto));
        return resultJson.toString();
    }
}
