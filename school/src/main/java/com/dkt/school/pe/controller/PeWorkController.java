package com.dkt.school.pe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dto.PeWorkInfoDto;
import com.dkt.school.pe.dto.PeWorkTaskDto;
import com.dkt.school.pe.model.PeWorkInfo;
import com.dkt.school.pe.model.PeWorkTask;
import com.dkt.school.pe.service.PePersonInfoService;
import com.dkt.school.pe.service.PeWorkInfoService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/pe")
public class PeWorkController {
	
	private final static Logger logger = Logger.getLogger(PeWorkController.class);
	
	private PeWorkInfoService pws;
	
	private PePersonInfoService ppis;
	
	public PePersonInfoService getPpis() {
		return ppis;
	}
	
	@Autowired
	public void setPpis(PePersonInfoService ppis) {
		this.ppis = ppis;
	}
	public PeWorkInfoService getPws() {
		return pws;
	}
	@Autowired
	public void setPws(PeWorkInfoService pws) {
		this.pws = pws;
	}

	@RequestMapping("/peWork")
	public String peWork() {
		return "pe/peWorkList";
	}
	
	@ResponseBody
	@RequestMapping("/queryPeWorkList")
	public String queryPeWorkList(PeWorkInfoDto info, PaginationCustom page) {
		logger.info("------------------查询所有体育工作-------------------");
		
		int total = pws.queryPeWorkInfoCount(info);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<PeWorkInfo> wList = pws.queryPeWorkList(info, page);
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
				.toJsonTree(wList, List.class).getAsJsonArray();
		
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("total", total);
		resultJson.add("rows", ja);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addPeWorkInfo")
	public String addPeWorkInfo(PeWorkInfo info) {
		logger.info("------------------添加体育工作信息--------------------");
		
		int result = pws.addPeWorkInfo(info);
		if (result == 1)
			return "1";
		else
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/editPeWorkInfo")
	public String editPeWorkInfo(PeWorkInfo info) {
		logger.info("---------------------更新体育工作信息--------------------");
		int result = pws.updatePeWorkInfo(info);
		if (result == 1)
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/deletePeWorkInfoById")
	public String deletePeWorkInfoById(Integer id) {
		logger.info("-------------------删除体育工作信息------------------------");
		int result = pws.deletePeWorkInfo(id);
		if (result == 1)
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/queryPeWorkTaskList") 
	public String queryPeWorkTaskList(PeWorkInfoDto dto, PaginationCustom page) {
		logger.info("--------------------查询工作任务分配情况---------------");
		
		int total = pws.queryPeWorkTaskCount(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<PeWorkTaskDto> wList = pws.queryPeWorkTaskList(dto, page);
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
				.toJsonTree(wList, List.class).getAsJsonArray();
		
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("total", total);
		resultJson.add("rows", ja);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deletePeWorkTaskById")
	public String deletePeWorkTaskById(Integer id) {
		logger.info("--------------------删除工作任务信息-----------------------");
		int result = pws.deletePeWorkTaskById(id);
		if (result == 1) 
			return "1";
		else 
			return "0";
	}
	
	@ResponseBody
	@RequestMapping("/addPeWorkTask")
	public String addPeWorkTask(PeWorkTask task) {
		logger.info("-----------------------分配体育工作任务-----------------");
		int result = pws.addPeWorkTask(task);
		if (result == 1)
			return "1";
		else 
			return "0";
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
