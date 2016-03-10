package com.dkt.school.apv.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.apv.model.ApprovalNode;
import com.dkt.school.apv.service.ApprovalSettingService;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.user.service.RoleService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/apv")
public class ApprovalSettingController {

	private static final Logger logger = Logger.getLogger(ApprovalSettingController.class);
	
	@Autowired
	private EnumerationService emService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ApprovalSettingService asService;
	
	@RequestMapping("approvalSetting")
	public String ApprovalSetting(Model model) {
		
		logger.info("------打开审批流程设置窗口----------");
		model.addAttribute("applicationType", emService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE));
		
		return "/apv/approveSetting";
	}
	
	@ResponseBody
	@RequestMapping("findApproveSettingByApplicationType")
	public String findApproveSettingByApplicationType(int applicationType, PaginationCustom page) {
		
		logger.info("-------------根据申请类型来查找审批流程----------");
		JsonObject resultJson = new JsonObject();
		//数量
		int total = asService.findApproveSettingCountByApplicationType(applicationType, page);
		System.out.println("数量: " + total);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		//记录
		List<ApprovalNodeDto> list = asService.findApproveSettingByApplicationType(applicationType, page);
		
		//设置步骤
		for (int i = 0; i < list.size(); ++i) {
			
			list.get(i).setSeqStr("步骤" + list.get(i).getSeq());
		}
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
				
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	@RequestMapping("addApprovalNode")
	public String addApprovalNode(Model model) {
		
		logger.info("------------to添加审批节点--------------");
		model.addAttribute("applicationType", emService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE));
		model.addAttribute("roleList", roleService.findAllRole());
		return "apv/addApprovalNode";
	}
	
	@RequestMapping("toEditApprovalNode")
	public String editApprovalNode(int id, Model model) {
		
		logger.info("------------to编辑审批节点--------------");
	//	System.out.println("id:" + id);
	//	model.addAttribute("dto", asService.findApproveNodeById(id));
		model.addAttribute("id", id);
		model.addAttribute("applicationType", emService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE));
		model.addAttribute("roleList", roleService.findAllRole());
		return "apv/editApprovalNode";
	}
	
	@ResponseBody
	@RequestMapping("getApvNodeInfoById")
	public String getApvNodeInfoById(int id) {
		
		logger.info("------------根据id获取审批节点信息--------------");
		
		
		ApprovalNode node = (ApprovalNode) asService.findApproveNodeById(id);
		String result = new Gson().toJson(node, ApprovalNode.class);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("editApprovalNode")
	public String editApprovalNode(ApprovalNodeDto dto) {
		
		logger.info("------------编辑审批节点--------------");
		JsonObject resultJson = new JsonObject();
		
		int result = asService.updateApprovalNodeByDto(dto);
		
		resultJson.addProperty("result", result);
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("deleteApprovalNodeById")
	public String deleteApprovalNodeById(int id) {
		
		logger.info("------------删除审批节点--------------");
		JsonObject resultJson = new JsonObject();
		
		int result = asService.deleteApprovalNodeById(id);
		
		resultJson.addProperty("result", result);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("addNewApprovalNode")
	public String addNewApprovalNode(ApprovalNodeDto dto) {
		
		logger.info("----------添加审批节点-----------");
		List<EnumerationValue> list = emService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
		for (int i = 0; i < list.size(); ++i) {
			
			if (dto.getIsLastStr().equals(list.get(i).getName())) {
				dto.setIsLast(list.get(i).getId());
				break;
			}
				
		}
		String result = asService.addNewApprivalNode(dto);
		
		return result;
		
	}
}
