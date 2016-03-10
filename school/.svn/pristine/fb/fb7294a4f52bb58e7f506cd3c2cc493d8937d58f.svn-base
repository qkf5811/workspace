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
import com.dkt.school.equ.dto.ScrapRecordDto;
import com.dkt.school.equ.model.EquipmentItem;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.equ.service.ScrapRecordService;
import com.dkt.school.user.model.User;
import com.dkt.school.user.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/scrapRecord")
public class EquScrapRecordController {
	
	public final static Logger logger = LoggerFactory
			.getLogger(EquScrapRecordController.class);
	
	private ScrapRecordService scrapRecordService;
	@Autowired
	public void setScrapRecordService(ScrapRecordService scrapRecordService) {
		this.scrapRecordService = scrapRecordService;
	}
	public ScrapRecordService getScrapRecordService() {
		return scrapRecordService;
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
	 * 跳转到报废记录列表
	 * @return
	 */
	@RequestMapping("/scrapRecordList")
	public String scrapRecordList() {
		System.out.println("先scrapRecordList()");
		return "equ/scrapRecordList";
	}
	
	/**
	 * 查询所有记录
	 * 
	 * @param itemCode
	 * @param scrapUserName
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getScrapRecordList")
	public String getScrapRecordList(String itemCode, String scrapUserName,String equName,String equBrand, PaginationCustom page) {
		System.out.println("getScrapRecordList()");
		System.out.println(itemCode + " " + scrapUserName+" "+equName+" "+equBrand);
		int total = scrapRecordService.getScrapRecordCount(itemCode, scrapUserName);
		System.out.println("记录数为："+total);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<ScrapRecordDto> recordList = scrapRecordService
				.getScrapRecordsByPage(itemCode, scrapUserName,  equName, equBrand, page);
		for(ScrapRecordDto record:recordList){
			System.out.println("itemCode:"+record.getItemCode()+" 设备名称："+record.getEquName()+" 维修师名称："+record.getScrapUserName()+
					"   品牌是："+record.getEquBrand()+"   型号是："+record.getEquModel()+"   "+record.getScrapDate()+"     "+record.getRemark());
			//日期格式转换：
			Date date=record.getScrapDate();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateShow=null;
			try {
				dateShow=dateFormat.format(date);
				//System.out.println(dateShow);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			record.setScrapRecordSTime(dateShow);
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
	 * 编辑记录(可编辑选项有：设备编号列表，设备名称列表(否)，报废人员列表，报废日期，备注)
	 * @param id
	 * @param model
	 * @return
	 */
	/*
	@RequestMapping("/toEditScrapRecord")
	public String toEditScrapRecord(Integer id,Model model){
		//List<EnumerationValue> sexList=enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
		//List<Department> departments=departmentService.findAllDepartment();
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//报废人员列表，也就是所有用户列表
		List<User> scrapUsers=userService.findAllUser();
//		List<Role> roles=roleService.findAllRole();
		
		model.addAttribute("scrapRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("scrapUsers", scrapUsers);
//		model.addAttribute("roles", roles);
		
		return "equ/editScrapRecord";
	}
	*/
	/**
	 * 根据用户id查找报废记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getScrapRecord")
	public String getScrapRecord(Integer id) {
		ScrapRecordDto scrapRecord = scrapRecordService.findScrapRecordDtoByScrapRecordId(id);
		System.out.println(scrapRecord);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("scrapRecord", gson.toJsonTree(scrapRecord));
		return resultJson.toString();
	}
	
	/**
	 * 保存编辑报废记录的数据
	 * @param scrapRecord
	 * @return
	 */
	/*
	@ResponseBody
	@RequestMapping("/editScrapRecord")
	public String editScrapRecord(ScrapRecordDto scrapRecord){
		System.out.println("editScrapRecord");
		System.out.println(scrapRecord.getScrapRecordSTime());
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=null;
		try {
			date=dateFormat.parse(scrapRecord.getScrapRecordSTime());
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrapRecord.setScrapDate(date);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", scrapRecordService.updateScrapRecord(scrapRecord));
		return jsonObject.toString();
	}
	*/
	
	/**
	 * 根据报废记录id删除报废记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteScrapRecord")
	public String deleteScrapRecord(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", scrapRecordService.deleteScrapRecordByScrapRecordId(id));
		return jsonObject.toString();
		
	}
	
	/**
	 * 查看记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toScrapRecordDetails")
	public String toScrapRecordDetails(Integer id,Model model){
		
		//设备编号列表
		List<EquipmentItem> equipmentItems=equipmentItemService.findAllEquipmentItem();
		//报废人员列表，也就是所有用户列表
		List<User> scrapUsers=userService.findAllUser();
		
		model.addAttribute("scrapRecordId", id);
		model.addAttribute("equipmentItems", equipmentItems);
		model.addAttribute("scrapUsers", scrapUsers);

		return "equ/scrapRecordDetails";
	
	}
}
