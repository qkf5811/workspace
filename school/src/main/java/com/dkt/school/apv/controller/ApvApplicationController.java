package com.dkt.school.apv.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.apv.service.ApvApplicationService;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.TeacherDto;
import com.dkt.school.tea.dto.TeacherThesisDto;
import com.dkt.school.user.dto.DepartmentDto;
import com.dkt.school.user.model.Department;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/apv")
public class ApvApplicationController {
	private final static Logger logger = LoggerFactory.getLogger(ApvApplicationController.class);
	
	private ApvApplicationService apvApplicationService;
	
	private EnumerationService enumerationService;
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}
	
	public ApvApplicationService getApvApplicationService() {
		return apvApplicationService;
	}

	@Autowired
	public void setApvApplicationService(ApvApplicationService apvApplicationService) {
		this.apvApplicationService = apvApplicationService;
	}

	//跳转到个人申请页面
	@RequestMapping("/apvApplicationList")
	public String apvApplicationList(Integer userId,Model model) {
		List<EnumerationValue> applicationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		List<EnumerationValue> applicationStatusList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_STATUS);
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("applicationStatusList", applicationStatusList);
		model.addAttribute("userId", userId);
		return "apv/apvApplicationList";
	}
	
	
	
	//跳转到所有申请页面
	@RequestMapping("/allApplicationList")
	public String allApplicationList(Model model) {
		List<EnumerationValue> applicationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		List<EnumerationValue> applicationStatusList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_STATUS);
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("applicationStatusList", applicationStatusList);
		return "apv/allApplicationList";
	}	
	//显示个人申请页面
	@ResponseBody
	@RequestMapping("/getApvApplicationList") 
	public String getApvApplicationList(Integer  userId,String name,Integer applicationType,String user,Integer applicationStatus, PaginationCustom page){
		int total = apvApplicationService.getApvApplicationCount(userId,name,applicationType,user,applicationStatus);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<ApplicationDto> applicationDto = apvApplicationService.getApvApplicationByPage(userId,name,applicationType,user,applicationStatus,page);
		for(ApplicationDto application:applicationDto){
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
		JsonArray applicationJa = gson.toJsonTree(applicationDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", applicationJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}
	
	//显示所有申请页面
	@ResponseBody
	@RequestMapping("/getAllApplicationList") 
	public String getAllApplicationList(String name,Integer applicationType,String user,Integer applicationStatus, PaginationCustom page){
		int total = apvApplicationService.getAllApvApplicationCount(name,applicationType,user,applicationStatus);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<ApplicationDto> applicationDto = apvApplicationService.getAllApvApplicationByPage(name,applicationType,user,applicationStatus,page);
		for(ApplicationDto application:applicationDto){
			Date date=application.getAppTime();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			application.setAppTimeStr(dateShow);
			
			
		
		}
		
		Gson gson = new Gson();
		JsonArray applicationJa = gson.toJsonTree(applicationDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", applicationJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}
	/**
	 * 跳转到添加申请的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddApvApplication")
	public String toAddApvApplication(Integer userId,Model model) {	
		List<EnumerationValue> applicationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("userId", userId);
		return "apv/newApplication";
	}
	
	//显示部门页面
	@ResponseBody
	@RequestMapping("/getDepartmentList") 
	public String getDepartmentList(String name, PaginationCustom page){
		int total = apvApplicationService.getDepartmentCount(name);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<DepartmentDto> departmentDto = apvApplicationService.getDepartmentByPage(name,page);
		
		
		Gson gson = new Gson();
		JsonArray applicationJa = gson.toJsonTree(departmentDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", applicationJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}	
	
	//显示设备页面
	@ResponseBody
	@RequestMapping("/getEquipmentList") 
	public String getEquipNameList(String name,String model, PaginationCustom page){
		int total = apvApplicationService.getEquipmentAmount(name,model);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<EquipmentDto> equipmentDto = apvApplicationService.getEquipmentByPage(name,model,page);
		
		
		Gson gson = new Gson();
		JsonArray equipmentJa = gson.toJsonTree(equipmentDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", equipmentJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}		
	
	//添加草稿记录
	@ResponseBody
	@RequestMapping("/addWithDraft")
	public String addWithDraft(ApplicationDto applicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(applicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(applicationDto));
		resultJo.addProperty("result", apvApplicationService.addWithDraft(applicationDto));
		return resultJo.toString();
	}	
	
	
	
	//更新申请草稿
	@ResponseBody
	@RequestMapping("/editWithDraft")
	public String editWithDraft(ApplicationDto applicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(applicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(applicationDto));
		resultJo.addProperty("result", apvApplicationService.editWithDraft(applicationDto));
		return resultJo.toString();
	}		
	//添加申请记录
	@ResponseBody
	@RequestMapping("/addNewApplication")
	public String addNewApplication(ApplicationDto applicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(applicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(applicationDto));
		resultJo.addProperty("result", apvApplicationService.addNewApplication(applicationDto));
		return resultJo.toString();
	}		
	
	//编辑草稿到提交申请
	@ResponseBody
	@RequestMapping("/editApplicationToAdd")
	public String editApplicationToAdd(ApplicationDto applicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(applicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(applicationDto));
		resultJo.addProperty("result", apvApplicationService.editApplicationToAdd(applicationDto));
		return resultJo.toString();
	}	
	
	/**
	 * 编辑申请草稿信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditApplication")
	public String toEditApplication(ApplicationDto applicationDto,
			Model model) {
		if(applicationDto.getDepartmentName().equals("---")) {
			applicationDto.setDepartmentName("");
		}
		if(applicationDto.getName().equals("---")) {
			applicationDto.setName("");
		}
		if(applicationDto.getReason().equals("---")) {
			applicationDto.setReason("");
		}
		if(applicationDto.getRemark().equals("---")) {
			applicationDto.setRemark("");
		}
		List<EnumerationValue> applicationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		model.addAttribute("applicationTypeList", applicationTypeList);
		model.addAttribute("applicationId", applicationDto.getId());
		model.addAttribute("applicationType", applicationDto.getApplicationType());
		model.addAttribute("departId", applicationDto.getDepartId());
		model.addAttribute("departmentName", applicationDto.getDepartmentName());
		model.addAttribute("name", applicationDto.getName());
		model.addAttribute("reason", applicationDto.getReason());
		model.addAttribute("remark", applicationDto.getRemark());
		model.addAttribute("userId", applicationDto.getUserId());
		return "apv/editApplication";
	}
	
	/**
	 * 根据id删除申请草稿
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteApplication")
	public String deleteApplication(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = apvApplicationService.deleteApplication(id);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
		
	
	
	
	
}