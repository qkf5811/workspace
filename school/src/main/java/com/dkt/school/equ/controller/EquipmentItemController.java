package com.dkt.school.equ.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.EquipmentItemDto;
import com.dkt.school.equ.dto.EquipmentUseDto;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * @author JanGin Chan
 * 2015年5月09日
 */
@Controller
@RequestMapping("/equ")
public class EquipmentItemController {

	public static final Logger logger = LoggerFactory
			.getLogger(EquipmentItemController.class);
	
	@Autowired
	private EquipmentItemService eiService;
	
	@Autowired
	private EnumerationService enumerationService;
	
	@RequestMapping("/toEquList")
	public String toEquList(Model model){
		List<EnumerationValue> sourceList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.SOURCE);
		List<EnumerationValue> useStatusList = enumerationService
					.getEnumValueListByEnumId(EnumerationType.USE_STATUS);
		model.addAttribute("sList", sourceList);
		model.addAttribute("uList", useStatusList);
		return "/equ/equList";
	}
	
	@RequestMapping("/toEquUseDetail")
	public String toEquUseDetail(@RequestParam Integer id,Model model){
		//System.out.println("id="+id);
		EquipmentUseDto euDto = eiService.getEquipmentUseDtoById(id);
		//List<EnumerationValue> sexList = enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		if (euDto != null){
			System.out.println(euDto);
			model.addAttribute("euDto", euDto);
			//model.addAttribute("sexList",sexList);
		}
		
		
		return "/equ/equUseDetail";
	}
	
	
	@ResponseBody
	@RequestMapping("/getEquList")
	public String getEquList(@RequestParam(required=false)String category,@RequestParam(required=false)Integer useStatus,
							 @RequestParam(required=false)Integer source,
							@RequestParam(required=false)String buyTime,PaginationCustom page){
		System.out.println("类别 = "+category+" 使用情况 = "+useStatus +" 来源="+source);
		int total = eiService.selectEquipmentItemCount(category,useStatus,source,buyTime);
		//设置page的参数
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		List<EquipmentItemDto> eList = eiService.findEquipmentItemDtoByCondition(category,useStatus,source,buyTime, page);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		JsonArray jsArr = gson.toJsonTree(eList,List.class).getAsJsonArray();
		/*for (int i = 0; i <jsArr.size(); i++){
			System.out.println(jsArr.getAsJsonObject());
		}*/
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", jsArr);
		resultJson.addProperty("total", total);
		return resultJson.toString();
		
	}
	
}
