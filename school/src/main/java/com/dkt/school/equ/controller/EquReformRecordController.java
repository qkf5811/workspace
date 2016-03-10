package com.dkt.school.equ.controller;

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

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.ReformRecordDto;
import com.dkt.school.equ.model.EquipmentItem;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.equ.service.ReformRecordService;
import com.dkt.school.user.model.User;
import com.dkt.school.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/reformRecord")
public class EquReformRecordController {
	
	public final static Logger logger = LoggerFactory
			.getLogger(EquReformRecordController.class);
	
	private ReformRecordService reformRecordService;
	@Autowired
	public void setReformRecordService(ReformRecordService reformRecordService) {
		this.reformRecordService = reformRecordService;
	}
	public ReformRecordService getReformRecordService() {
		return reformRecordService;
	}
	
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
	public UserService getUserService() {
		return userService;
	}

	
	private EquipmentItemService equipmentItemService ;
	@Autowired
	public void setEquipmentItemService(EquipmentItemService equipmentItemService) {
		this.equipmentItemService = equipmentItemService;
	}
	public EquipmentItemService getEquipmentItemService() {
		return equipmentItemService;
	}
	

	/**
	 * 跳转到改造记录列表
	 * @return
	 */
	@RequestMapping("/reformRecordList")
	public String reformRecordList() {
		System.out.println("先reformRecordList()");
		return "equ/reformRecordList";
	}
	
	/**
	 * 查询所有记录
	 * 
	 * @param itemCode
	 * @param reformUserName
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getReformRecordList")
	public String getReformRecordList(String itemCode, String reformUserName,String equName,String equBrand, PaginationCustom page) {
		System.out.println("getReformRecordList()");
		System.out.println(itemCode + " " + reformUserName+" "+equName+" "+equBrand);
		int total = reformRecordService.getReformRecordCount(itemCode, reformUserName);
		System.out.println("记录数为："+total);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<ReformRecordDto> recordList = reformRecordService
				.getReformRecordsByPage(itemCode, reformUserName,equName,equBrand, page);
		for(ReformRecordDto record:recordList){
			System.out.println("itemCode:"+record.getItemCode()+" 设备名称："+record.getEquName()+" 维修师名称："+record.getReformUserName()+
			"   品牌是："+record.getEquBrand()+"   型号是："+record.getEquModel()+"   "+record.getReformDate()+"     "+record.getRemark());
			//日期格式转换：
			Date date=record.getReformDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
				//System.out.println(dateShow);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			record.setReformRecordSTime(dateShow);
		}
		
		
		Gson gson = new Gson();
		JsonArray recordListJa = gson.toJsonTree(recordList, List.class)
				.getAsJsonArray();

		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", recordListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	
	/**
	 * 编辑记录(可编辑选项有：设备编号列表，设备名称列表(否)，改造人员列表，改造日期，备注)
	 * @param id
	 * @param model
	 * @return
	 */
	/*
	@RequestMapping("/toEditReformRecord")
	public String toEditReformRecord(Integer id,Model model){
		//List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		//List<Department> departments=departmentService.findAllDepartment();
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//维护人员列表，也就是所有用户列表
		List<User> reformUsers=userService.findAllUser();
//		List<Role> roles=roleService.findAllRole();
		
		model.addAttribute("reformRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("reformUsers", reformUsers);
//		model.addAttribute("roles", roles);
		
		return "equ/editReformRecord";
	}
	*/
	/**
	 * 根据用户id查找改造记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getReformRecord")
	public String getReformRecord(Integer id) {
		ReformRecordDto reformRecord = reformRecordService.findReformRecordDtoByReformRecordId(id);
		//System.out.println(reformRecord.getEquName()+" "+reformRecord.getEquBrand()+" "+reformRecord.getEquModel());
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("reformRecord", gson.toJsonTree(reformRecord));
		return resultJson.toString();
	}
	
	/**
	 * 保存编辑改造记录的数据
	 * @param reformRecord
	 * @return
	 */
	/*
	@ResponseBody
	@RequestMapping("/editReformRecord")
	public String editReformRecord(ReformRecordDto reformRecord){
		System.out.println("editReformRecord");
		System.out.println(reformRecord.getReformRecordSTime());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date=dateFormat.parse(reformRecord.getReformRecordSTime());
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reformRecord.setReformDate(date);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", reformRecordService.updateReformRecord(reformRecord));
		return jsonObject.toString();
	}
	*/
	
	
	/**
	 * 根据维护记录id删除改造记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteReformRecord")
	public String deleteReformRecord(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", reformRecordService.deleteReformRecordByReformRecordId(id));
		return jsonObject.toString();
		
	}
	
	/**
	 * 查看记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toReformRecordDetails")
	public String toReformRecordDetails(Integer id,Model model){
		
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//维护人员列表，也就是所有用户列表
		List<User> reformUsers=userService.findAllUser();
		
		model.addAttribute("reformRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("reformUsers", reformUsers);

		return "equ/reformRecordDetails";
	
	}
}
