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
import com.dkt.school.sch.dto.MajorFieldDto;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.MajorFieldService;
import com.dkt.school.sch.service.MajorService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/sch")
public class MajorSettingController {
	
	private final static Logger logger = LoggerFactory.getLogger(MajorSettingController.class);
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private MajorFieldService majorFieldService;
	
	/**
	 * 打开专业方向设置首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/majorFieldSetting")
	public String openMajorSettingPage(Model model) {
		
		logger.info("----------------得到专业信息-----------------");
		
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		return "sch/majorFieldSetting";
	}
	
	/**
	 * 打开专业设置首页
	 * @return
	 */
	@RequestMapping("/majorSetting")
	public String openMajorSettingDatagridPage() {
		
		logger.info("----------------打开专业设置-----------------");
		
		return "sch/majorSetting";
	}
	
	@ResponseBody
	@RequestMapping("getAllMajorPage")
	public String getAllMajorPage(PaginationCustom page) {
		
		logger.info("----------------得到所有专业信息-------------");
		JsonObject resultJson = new JsonObject();
		
		int total = majorService.getAllMajorCountByPage(page);
		
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<Major> list = majorService.getAllMajorByPage(page);
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	/**
	 * 得到专业的json数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMajorOfJson")
	public String getMajorOfJson() {
		
		JsonObject resultJson = new JsonObject();
		logger.info("------------------得到专业的json数据---------------");
		List<Major> list = majorService.getAllMajorInfo();
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();

		
		resultJson.add("majorJson", ja);
		String str = resultJson.toString().substring(13, resultJson.toString().length()-1);
		return str;
	}
	
	/**
	 * 通过专业ID得到专业方向的datagrid
	 * @param majorId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMajorFieldByMajorId")
	public String getMajorFieldByMajorId(int majorId, PaginationCustom page) {
		
		int total = 0;
		List<MajorFieldDto> list = null;
		if (majorId == 0) {
			total = majorFieldService.getMajorFieldCount();
			
			page.setCurrentPage(page.getPage());
			page.setPageRecorders(page.getRows());
			page.setTotalRows(total);
			list = majorFieldService.getAllMajorFieldInfoByPage(page);
		} else {
			total = majorFieldService.getMajorFieldCountByMajorId(majorId);
			
			page.setCurrentPage(page.getPage());
			page.setPageRecorders(page.getRows());
			page.setTotalPages(total);
			
			list = majorFieldService.getMajorFieldInfoByMajorIdByPage(majorId, page);
		}
		majorFieldService.toMajorFieldDto(list);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}

	
	/**
	 * 添加专业
	 * @param major
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAddNewMajor")
	public String addNewMajor(Major major) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------添加专业-----------------------");
		resultJson.addProperty("result", majorService.addNewMajor(major));
		
		return resultJson.toString();
	}
	
	 /**
     * 更新专业
     * @param major
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateMajor")
    public String updateMajor(Major major){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", majorService.updateMajor(major));
        return resultJson.toString();
    }
	
	/**
	 * 修改专业方向名称
	 * @param majorFieldId
	 * @param newName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editMajorFieldName")
	public String editMajorFieldName(int majorFieldId, String newName) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("----------------修改专业方向名称---------------");
		
		resultJson.addProperty("result", majorFieldService.editMajorFieldName(majorFieldId, newName));
		return resultJson.toString();
	}
	/**
	 * 删除专业
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toDeleteMajor")
	public String deleteMajor(int id) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("--------------------删除专业--------------------");
		resultJson.addProperty("result", majorService.deleteMajor(id));
		
		return resultJson.toString();
	}
	
	/**
	 * 添加专业方向
	 * @param majorField
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toAddNewMajorField")
	public String toAddNewMajorField(MajorField majorField) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("----------------添加专业方向---------------");
		
		resultJson.addProperty("result", majorFieldService.addMajorField(majorField));
		return resultJson.toString();
	}
	
	/**
	 * 根据专业id得到专业方向的json串
	 * @param majorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMajorFieldJsonByMajorId")
	public String getMajorFieldJsonByMajorId(int majorId) {
		
	//	JsonObject resultJson = new JsonObject();
		logger.info("---------------根据专业id得到专业方向的json串-------------------");
		
		List<MajorField> list = majorFieldService.getMajorFieldInfoByMajorId(majorId);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		
		return ja.toString();
	}
	
	 /**
     * 更新专业方向
     * @param majorField
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateMajorField")
    public String updateMajorField(MajorField majorField){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", majorFieldService.updateMajorField(majorField));
        return resultJson.toString();
    }
	
	/**
	 * 根据专业方向id删除专业方向
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toDeleteMajorField")
	public String deleteMajorField(int id) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("----------------根据专业方向id删除专业方向-----------------");
		
		resultJson.addProperty("result", majorFieldService.deleteMajorFieldById(id));
		
		return resultJson.toString();
	}
}
