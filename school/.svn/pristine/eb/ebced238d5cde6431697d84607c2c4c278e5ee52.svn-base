package com.dkt.school.apv.controller;

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

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.apv.service.ApvApplicationService;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/apv")
public class ApprovedApplicationController {

	private static final Logger logger = Logger.getLogger(ApprovedApplicationController.class);
	@Autowired
	private EnumerationService enService;
	
	@Autowired
	private ApvApplicationService appService;
	
	@RequestMapping("approvedApplication")
	public String approvedApplication(int userId, Model model) {
		
		logger.info("_---------------显示已审批的申请表------------");
		List<EnumerationValue> applicationTypeList=enService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		List<EnumerationValue> applicationStatusList=enService.getEnumValueListByEnumId(EnumerationType.APPLICATION_STATUS);
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("applicationStatusList", applicationStatusList);
		model.addAttribute("userId", userId);
		
		return "apv/approvedApplication";
	}
	
	@ResponseBody
	@RequestMapping("getApvApplicationListWithApproved")
	public String getApvApplicationListWithApproved(Integer  userId,String name,Integer applicationType,String user,Integer applicationStatus, PaginationCustom page) {
		
		logger.info("_----------------------查询已审批的申请-----------------------");
		
		int total = appService.findCountOfApplicationWithApproved(userId,name,applicationType,user,applicationStatus);
		
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		
		List<ApplicationDto> appList = appService.findApplicationListWithApproved(userId,name,applicationType,user,applicationStatus, page);;
		
		for(ApplicationDto application:appList){
			Date date=application.getAppTime();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			application.setAppTimeStr(dateShow);
			
			if(application.getDepartId()==0 ){
				application.setDepartmentName("---");
				
			}
			if(application.getApplicationType()==0) {
				application.setApplicationTypeStr("---");
			}
			
		
		}
		
		Gson gson = new Gson();
		JsonArray applicationJa = gson.toJsonTree(appList, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", applicationJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}
	
	/**
	 * 数据绑定，用于string类型转成date类型
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
	}
}
