package com.dkt.school.pe.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.pe.dto.PePersonInfoDto;
import com.dkt.school.pe.model.PePersonInfo;
import com.dkt.school.pe.service.PePersonInfoService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/pe")
public class WorkGroupController {
	
	private final static Logger logger = Logger.getLogger(WorkGroupController.class);
	
	private PePersonInfoService ppis;
	
	public PePersonInfoService getPpis() {
		return ppis;
	}
	@Autowired
	public void setPpis(PePersonInfoService ppis) {
		this.ppis = ppis;
	}

	@RequestMapping("/personInfoList")
	public String personInfoList(Model model) {
		model.addAttribute("positions", ppis.queryPosition());
		return "pe/personInfoList";
	}
	
	@RequestMapping("/workTask")
	public String workTask(Model model) {
		model.addAttribute("positions", ppis.queryPosition());
		return "pe/workTask";
	}
	
	@ResponseBody
	@RequestMapping("/queryPersonList")
	public String queryPersonList(Integer workGroupPosition, String teaNameInWorkGroup, PaginationCustom page) {
		logger.info("-------------------查询工作组个人信息列表------------------------");
		JsonObject resultJson = new JsonObject();
		if (workGroupPosition == null || workGroupPosition == 0)
			workGroupPosition = null;
		if (teaNameInWorkGroup.trim().equals(""))
			teaNameInWorkGroup = null;
		else 
			teaNameInWorkGroup = teaNameInWorkGroup.trim();
		// total
		int total = ppis.queryPersonInfoCount(workGroupPosition, teaNameInWorkGroup);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		// rows
		List<PePersonInfoDto> personInfoList = ppis.queryPersonInfoList(workGroupPosition, teaNameInWorkGroup, page);
		JsonArray ja = new Gson().toJsonTree(personInfoList, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/addPePersonInfo")
	public String addPePersonInfo(PePersonInfoDto dto) {
		logger.info("-------------------添加工作组人员-----------------------");
		List<PePersonInfo> pList = ppis.queryByTeaCode(dto.getCode().trim());
		if (pList.size() > 0) {
			return "-1";  // 已经存在
		}
		dto.setTeaInfoId(ppis.queryTeaIinfoIdByCode(dto.getCode()));
		int effect = ppis.savePePersonInfo(dto);
		if (effect == 1)  // 添加成功
			return "1";
		else 
			return "0";  // 插入失败，请稍后尝试
	}
	
	@ResponseBody
	@RequestMapping("/editPePersonInfo")
	public String editPePersonInfo(PePersonInfo info) {
		logger.info("-------------------更新工作组人员信息--------------------");
		int result = ppis.updatePersonInfo(info);
		if (result == 0)
			return "0";   // 更新失败，请稍后再尝试
		else if (result == 1)
			return "1";   // 更新失败
		return "-1";    // 未知错误    
	}
	
	@ResponseBody
	@RequestMapping("/deletePePersonInfoById")
	public String deletePePersonInfoById(Integer id) {
		if (id != null) {
			int result = ppis.deletePersonInfo(id);
			if (result == 1)
				return "1";   // 删除成功
		}
		return "0";  // 删除失败
	}
	
}
