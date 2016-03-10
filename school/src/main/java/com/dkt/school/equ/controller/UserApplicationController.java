package com.dkt.school.equ.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.UseApplicationDto;
import com.dkt.school.equ.service.UseApplicationService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//设备领用申请
@Controller
@RequestMapping("/equ")
public class UserApplicationController {
	public final static Logger logger = LoggerFactory
			.getLogger(UseRecordController.class);
	
	private EnumerationService enumerationService;
	
	@Autowired
	private UseApplicationService useApplicationService;
	
	

	public UseApplicationService getUseApplicationService() {
		return useApplicationService;
	}

	public void setUseApplicationService(UseApplicationService useApplicationService) {
		this.useApplicationService = useApplicationService;
	}

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}
	
	//跳转到领用申请首页
	@RequestMapping("/useApplicationMood")
	public String useApplicationMood(Model model,Integer userId) {
		List<EnumerationValue> applicationStatusList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_STATUS);
		model.addAttribute("applicationStatusList", applicationStatusList);
		model.addAttribute("userId", userId);
		return "equ/useApplicationList";
	}	
	
	//显示个人申请页面
	@ResponseBody
	@RequestMapping("/getUseApplicationList") 
	public String getUseApplicationList(Integer  userId,String name,String equipName,Integer applicationStatus, PaginationCustom page){
		System.out.println("1");
		int total = useApplicationService.getUseApplicationCount(userId,name,equipName,applicationStatus);
		// 设置当前页面所选择的每页记录数
		
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<UseApplicationDto> useApplicationDto = useApplicationService.getUseApplicationByPage(userId,name,equipName,applicationStatus,page);
		for(UseApplicationDto useApplication:useApplicationDto){
			Date date=useApplication.getAppTime();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			useApplication.setAppTimeStr(dateShow);
			
			if(useApplication.getDepartId()==0 ){
				useApplication.setDepartName("---");
				
			}
			
			
		
		}
		
		Gson gson = new Gson();
		JsonArray useApplicationDtoJa = gson.toJsonTree(useApplicationDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", useApplicationDtoJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}	
	
	
	/**
	 * 跳转到添加申请的页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/toAddUseApplication")
	public String toAddUseApplication(Integer userId,Model model) {	
		model.addAttribute("userId", userId);
		return "equ/newUseApplication";
	}
	
	//添加草稿记录
	@ResponseBody
	@RequestMapping("/addWithDraft")
	public String addWithDraft(UseApplicationDto useApplicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(useApplicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		useApplicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(useApplicationDto));
		resultJo.addProperty("result", useApplicationService.addWithDraft(useApplicationDto));
		return resultJo.toString();
	}	
	
	//添加申请记录
	@ResponseBody
	@RequestMapping("/addNewUseApplication")
	public String addNewUseApplication(UseApplicationDto useApplicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(useApplicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		useApplicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(useApplicationDto));
		resultJo.addProperty("result", useApplicationService.addNewUseApplication(useApplicationDto));
		return resultJo.toString();
	}	
	
	/**
	 * 编辑申请草稿信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditUseApplication")
	public String toEditUseApplication(UseApplicationDto useApplicationDto,
			Model model) {
		if(useApplicationDto.getDepartName().equals("---")) {
			useApplicationDto.setDepartName("");
		}
		if(useApplicationDto.getApvApplicationName().equals("---")) {
			useApplicationDto.setApvApplicationName("");
		}
		if(useApplicationDto.getReason().equals("---")) {
			useApplicationDto.setReason("");
		}
		if(useApplicationDto.getRemark().equals("---")) {
			useApplicationDto.setRemark("");
		}
		
		if(useApplicationDto.getEquipName().equals("---")) {
			useApplicationDto.setEquipName("");
		}
		
		if(useApplicationDto.getModel().equals("---")) {
			useApplicationDto.setModel("");
		}
		
		if(useApplicationDto.getAmount()==0) {
			useApplicationDto.setAmount(null);
		}
		
		
		
		model.addAttribute("useApplicationId", useApplicationDto.getId());
		model.addAttribute("applicationId", useApplicationDto.getApplicationId());
		model.addAttribute("apvApplicationName", useApplicationDto.getApvApplicationName());
		model.addAttribute("applicationType", useApplicationDto.getApplicationType());
		model.addAttribute("departId", useApplicationDto.getDepartId());
		model.addAttribute("departName", useApplicationDto.getDepartName());
		model.addAttribute("equipName", useApplicationDto.getEquipName());
		model.addAttribute("model", useApplicationDto.getModel());
		model.addAttribute("reason", useApplicationDto.getReason());
		model.addAttribute("remark", useApplicationDto.getRemark());
		model.addAttribute("amount", useApplicationDto.getAmount());
		model.addAttribute("userId", useApplicationDto.getUserId());
		return "equ/editUseApplication";
	}
	
	//更新申请草稿
	@ResponseBody
	@RequestMapping("/editWithDraft")
	public String editWithDraft(UseApplicationDto useApplicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(useApplicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		useApplicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(useApplicationDto));
		resultJo.addProperty("result", useApplicationService.editWithDraft(useApplicationDto));
		return resultJo.toString();
	}	
	
	//编辑草稿到提交申请
	@ResponseBody
	@RequestMapping("/editUseApplicationToAdd")
	public String editUseApplicationToAdd(UseApplicationDto useApplicationDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(useApplicationDto.getAppTimeStr());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		useApplicationDto.setAppTime(date);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(useApplicationDto));
		resultJo.addProperty("result", useApplicationService.editUseApplicationToAdd(useApplicationDto));
		return resultJo.toString();
	}		
	
	/**
	 * 根据id删除申请草稿
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteUseApplication")
	public String deleteUseApplication(Integer id,Integer applicationId){
		JsonObject jsonObject=new JsonObject();
		Integer result = useApplicationService.deleteUseApplication(id,applicationId);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}

}
