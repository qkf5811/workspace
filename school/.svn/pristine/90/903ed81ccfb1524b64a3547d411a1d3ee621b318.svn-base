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
import com.dkt.school.equ.dto.MaintainRecordDto;
import com.dkt.school.equ.model.EquipmentItem;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.equ.service.MaintainRecordService;
import com.dkt.school.user.model.User;
import com.dkt.school.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/maintainRecord")
public class EquMaintainRecordController {
	
	public final static Logger logger = LoggerFactory
			.getLogger(EquMaintainRecordController.class);
	
	private MaintainRecordService maintainRecordService;
	@Autowired
	public void setMaintainRecordService(MaintainRecordService maintainRecordService) {
		this.maintainRecordService = maintainRecordService;
	}
	public MaintainRecordService getMaintainRecordService() {
		return maintainRecordService;
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
	 * 跳转到维修记录列表
	 * @return
	 */
	@RequestMapping("/maintainRecordList")
	public String maintainRecordList() {
		System.out.println("先maintainRecordList()");
		return "equ/maintainRecordList";
	}
	
	/**
	 * 查询所有记录
	 * 
	 * @param itemCode
	 * @param maintainUserName
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMaintainRecordList")
	public String getMaintainRecordList(String itemCode, String maintainUserName,String equName,String equBrand, PaginationCustom page) {
		System.out.println("getMaintainRecordList()");
		System.out.println(itemCode + " " + maintainUserName+" "+equName+" "+equBrand);
		int total = maintainRecordService.getMaintainRecordCount(itemCode, maintainUserName);
		System.out.println("记录数为："+total);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<MaintainRecordDto> recordList = maintainRecordService
				.getMaintainRecordsByPage(itemCode, maintainUserName, equName, equBrand, page);
		for(MaintainRecordDto record:recordList){
			System.out.println("itemCode:"+record.getItemCode()+" 设备名称："+record.getEquName()+" 维修师名称："+record.getMaintainUserName()+
					"   品牌是："+record.getEquBrand()+"   型号是："+record.getEquModel()+"   "+record.getMaintainDate()+"     "+record.getRemark());
			//日期格式转换：
			Date date=record.getMaintainDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
				//System.out.println(dateShow);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			record.setMaintainRecordSTime(dateShow);
			//System.out.println("想要显示的日期格式："+record.getMaintainRecordSTime());
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
	 * 编辑记录(可编辑选项有：设备编号列表，设备名称列表(否)，维护人员列表，维护日期，备注)
	 * @param id
	 * @param model
	 * @return
	 */
	/*
	@RequestMapping("/toEditMaintainRecord")
	public String toEditMaintainRecord(Integer id,Model model){
		//List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		//List<Department> departments=departmentService.findAllDepartment();
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//维护人员列表，也就是所有用户列表
		List<User> maintainUsers=userService.findAllUser();
//		List<Role> roles=roleService.findAllRole();
		
		model.addAttribute("maintainRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("maintainUsers", maintainUsers);
//		model.addAttribute("roles", roles);
		
		return "equ/editMaintainRecord";
	}
	*/
	
	/**
	 * 根据用户id查找维护记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMaintainRecord")
	public String getMaintainRecord(Integer id) {
		MaintainRecordDto maintainRecord = maintainRecordService.findMaintainRecordDtoByMaintainRecordId(id);
		System.out.println("itemCode:"+maintainRecord.getItemCode()+" 设备名称："+maintainRecord.getEquName()+" 维修师名称："+maintainRecord.getMaintainUserName()+
				"   品牌是："+maintainRecord.getEquBrand()+"   型号是："+maintainRecord.getEquModel()+"   "+maintainRecord.getMaintainDate()+"     "+maintainRecord.getMaintainRecordSTime()+"    "+maintainRecord.getRemark());
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("maintainRecord", gson.toJsonTree(maintainRecord));
		return resultJson.toString();
	}
	
	/**
	 * 保存编辑维护记录的数据
	 * @param maintainRecord
	 * @return
	 */
	/*
	@ResponseBody
	@RequestMapping("/editMaintainRecord")
	public String editMaintainRecord(MaintainRecordDto maintainRecord){
		System.out.println("editMaintainRecord");
		System.out.println(maintainRecord.getEquName()+"  "+maintainRecord.getEquBrand()+"   "+maintainRecord.getEquModel());
		System.out.println(maintainRecord.getMaintainRecordSTime());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date=dateFormat.parse(maintainRecord.getMaintainRecordSTime());
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maintainRecord.setMaintainDate(date);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", maintainRecordService.updateMaintainRecord(maintainRecord));
		return jsonObject.toString();
	}
	*/
	
	
	/**
	 * 根据维护记录id删除维护记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteMaintainRecord")
	public String deleteMaintainRecord(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", maintainRecordService.deleteMaintainRecordByMaintainRecordId(id));
		return jsonObject.toString();
		
	}
	
	/**
	 * 查看记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMaintainRecordDetails")
	public String toMaintainRecordDetails(Integer id,Model model){
		
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//维护人员列表，也就是所有用户列表
		List<User> maintainUsers=userService.findAllUser();
		
		model.addAttribute("maintainRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("maintainUsers", maintainUsers);

		return "equ/maintainRecordDetails";
	
	}
}
