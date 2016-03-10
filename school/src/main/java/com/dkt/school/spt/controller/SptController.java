package com.dkt.school.spt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.spt.dto.SptMeetingDto;
import com.dkt.school.spt.dto.SptMeetingItemDto;
import com.dkt.school.spt.model.SptMeeting;
import com.dkt.school.spt.model.SptMeetingItem;
import com.dkt.school.spt.service.SptMeetingItemService;
import com.dkt.school.spt.service.SptMeetingService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/spt")
public class SptController {
		
	private final static Logger logger = Logger.getLogger(SptController.class);
	
	private SptMeetingService sms;
	
	private SptMeetingItemService smis;
	
	public SptMeetingItemService getSmis() {
		return smis;
	}
	@Autowired
	public void setSmis(SptMeetingItemService smis) {
		this.smis = smis;
	}
	public SptMeetingService getSms() {
		return sms;
	}
	@Autowired
	public void setSms(SptMeetingService sms) {
		this.sms = sms;
	}

	@RequestMapping("/sptMeeting")
	public String sptMeeting() {
		logger.info("--------------------跳转到运动会列表------------------------");
		return "spt/sptMeeting";
	}
	
	@ResponseBody
	@RequestMapping("/querySptMeetingList")
	public String queryStpMeeting(SptMeetingDto dto, PaginationCustom page) {
		logger.info("---------------------------查询运动会信息-----------------------");
		
		int total = sms.queryStpMeetingCount(dto);
		page.setCurrentPage(page.getPage());	
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<SptMeeting> sList = sms.queryStpMeetingList(dto, page);
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
				.toJsonTree(sList, List.class).getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("total", total);
		resultJson.add("rows", ja);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addStpMeeting")
	public String addStpMeeting(SptMeeting meet) {
		logger.info("------------------添加运动会信息---------------------------");
		int result = sms.addStpMeetingInfo(meet);
		if (result == 1) 
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/updateStpMeeting")
	public String updateStpMeeting(SptMeeting meet) {
		logger.info("---------------------更新运动会信息-----------------------");
		int result = sms.updateSptMeeting(meet);
		if (result == 1) 
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/deleteSptMeeting")
	public String deleteSptMeeting(Integer id) {
		logger.info("-------------------删除运动会信息---------------------");
		int result = sms.deleteSptMeetingById(id);
		if (result == 1) 
			return "1";
		else 
			return "0";
	}
	
	@RequestMapping("/sptMeetingItem")
	public String sptMeetingItem(Model model) {
		logger.info("------------------------跳转到运动会项目页面----------------------");
		model.addAttribute("types", smis.querySptMeetingItemType());
		return "spt/sptItem";
	}
	
	@ResponseBody
	@RequestMapping("/querySptMeetingItemList")
	public String querySptMeetingItemList(SptMeetingItemDto dto, PaginationCustom page) {
		logger.info("---------------------------查询运动会项目信息-----------------------");
		
		int total = smis.queryStpMeetingitemCount(dto);
		page.setCurrentPage(page.getPage());	
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<SptMeetingItemDto> sList = smis.queryStpMeetingItemList(dto, page);
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
				.toJsonTree(sList, List.class).getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("total", total);
		resultJson.add("rows", ja);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addSptMeetingItem")
	public String addSptMeetingItem(SptMeetingItem item) {
		logger.info("------------------------添加运动会项目信息--------------------------");
		int result = smis.addSptMeetingItem(item);
		if (result == 1)
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/deleteSptMeetingItem")
	public String deleteSptMeetingItem(Integer id) {
		logger.info("-----------------------删除运动会项目信息-------------------------------");
		int result = smis.removeSptMeetingItem(id);
		if (result == 1)
			return "1";
		else 
			return "";
	}
	
	@ResponseBody
	@RequestMapping("/updateSptMeetingItemInfo")
	public String updateSptMeetingItemInfo(SptMeetingItem item) {
		logger.info("-----------------------更新运动会项目信息-------------------------------");
		int result = smis.updateSptMeetingItem(item);
		if (result == 1) 
			return "1";
		else 
			return "";
	}
	/**
	 * 数据绑定，用于string类型转成date类型
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true)); // true:允许输入空值，false:不能为空值
	}
}
