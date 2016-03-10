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
import com.dkt.school.apv.model.Approval;
import com.dkt.school.apv.service.ApprovalService;
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
public class WaitForApproveController {

	private static final Logger logger = Logger.getLogger(WaitForApproveController.class);
	
	@Autowired
	private EnumerationService enService;
	
	@Autowired
	private ApprovalService apvService;
	
	@Autowired
	private ApvApplicationService appService;
	
	@RequestMapping("waitForApprove")
	public String waitForApprove(int userId, Model model) {
		
		List<EnumerationValue> applicationTypeList=enService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		List<EnumerationValue> applicationStatusList=enService.getEnumValueListByEnumId(EnumerationType.APPLICATION_STATUS);
		List<EnumerationValue> apvResult = enService.getEnumValueListByEnumId(EnumerationType.APPROVAL_STATUS);
		
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("applicationStatusList", applicationStatusList);
		model.addAttribute("apvResult", apvResult);
		model.addAttribute("userId", userId);
		return "apv/waitForApprove";
	}
	
	@ResponseBody
	@RequestMapping("getApvApplicationListWithoutPass")
	public String getApvApplicationListWithoutPass(Integer  userId,String name,Integer applicationType,String user,Integer applicationStatus, PaginationCustom page) {
		
		int total = appService.findCountOfApplicationWithoutPass(userId,name,applicationType,user,applicationStatus);
		
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		
		List<ApplicationDto> appList = appService.findApplicationListWithoutPass(userId,name,applicationType,user,applicationStatus, page);;
		
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
	 * 提交审批
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("postApprove")
	public String postApprove(Approval dto) {
		
		logger.info("-----------提交审批--------------");
		JsonObject resultJson = new JsonObject();
		
		resultJson.addProperty("result", apvService.addApprovalByDto(dto));
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
