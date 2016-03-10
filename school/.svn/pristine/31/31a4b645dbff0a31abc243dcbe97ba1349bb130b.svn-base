package com.dkt.school.equ.controller;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;











import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.UseRecord;
import com.dkt.school.equ.service.BorrowRecordService;
import com.dkt.school.equ.service.UseRecordService;
import com.dkt.school.user.dto.UserDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//领用记录
@Controller
@RequestMapping("/equ")
public class UseRecordController {

	public final static Logger logger = LoggerFactory
			.getLogger(UseRecordController.class);
	
	private UseRecordService urService;
	private BorrowRecordService brService;
	
	
	
	
	
	
	public UseRecordService getUrService() {
		return urService;
	}

	@Autowired
	public void setUrService(UseRecordService urService) {
		this.urService = urService;
	}

	
	
	public BorrowRecordService getBrService() {
		return brService;
	}

	@Autowired
	public void setBrService(BorrowRecordService brService) {
		this.brService = brService;
	}

	//跳转到领用记录首页
	@RequestMapping("/useRecordMood")
	public String useRecordMood() {
		return "equ/useRecordMood";
	}
	
	//跳转到借用记录首页
	@RequestMapping("/borrowRecordMood")
	public String borrowRecordMood() {
		return "equ/borrowRecordMood";
	}
	
	/**
	 * 查询所有领用记录
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUseRecordList")
	public String getUseRecordList(Integer itemId, String name, PaginationCustom page) {
		int total = urService.getUseReportCount(itemId,name);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<UseRecordDto> urDto = urService.getUseRecordsByPage(itemId,name,page);
		for(UseRecordDto record:urDto){
			Date date1=record.getUseDate();
			Date date2=record.getUseDealine();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateShow1=null;
			String dateShow2=null;
			try {
				dateShow1=dateFormat.format(date1);
				dateShow2=dateFormat.format(date2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			record.setUseDateSTime(dateShow1);
			record.setUseDealineSTime(dateShow2);
		}
		
		Gson gson = new Gson();
		JsonArray useRecordListJa = gson.toJsonTree(urDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", useRecordListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 查询所有借用记录
	 * 
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBorrowRecordList")
	public String getBorrowRecordList(Integer itemId, String name, PaginationCustom page) {
		int total = brService.getBorrowReportCount(itemId,name);
		
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<BorrowRecordDto> brDto = brService.getBorrowRecordsByPage(itemId,name,page);
		for(BorrowRecordDto record:brDto){
			Date date1=record.getBorrowDate();
			Date date2=record.getBorrowDealine();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateShow1=null;
			String dateShow2=null;
			try {
				dateShow1=dateFormat.format(date1);
				dateShow2=dateFormat.format(date2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			record.setBorrowDateSTime(dateShow1);
			record.setBorrowDealineSTime(dateShow2);
		}
		Gson gson = new Gson();
		JsonArray borrowRecordListJa = gson.toJsonTree(brDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", borrowRecordListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 编辑领用记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditUseRecord")
	public String toEditUseRecord(Integer id,Model model){
		model.addAttribute("itemId", id);
		return "equ/editUseRecord";
	}
	
	/**
	 * 编辑借用记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditBorrowRecord")
	public String toEditBorrowRecord(Integer id,Model model){
		model.addAttribute("itemId", id);
		return "equ/editBorrowRecord";
	}
	
	/**
	 * 根据用户id删除领用记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteUseRecord")
	public String deleteUseRecord(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = urService.deleteUseRecordByItemId(id);
		jsonObject.addProperty("success", result);
	
		return jsonObject.toString();
	}
	
	/**
	 * 根据用户id删除借用记录
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBorrowRecord")
	public String deleteBorrowRecord(Integer id){
		JsonObject jsonObject=new JsonObject();
		Integer result = brService.deleteBorrowRecordByItemId(id);
		jsonObject.addProperty("success", result);	
		return jsonObject.toString();
	}
	
	/**
	 * 跳转到添加领用记录的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddUseRecord")
	public String toAddUseRecord() {	
		return "equ/newUseRecord";
	}
	
	/**
	 * 跳转到添加借用记录的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddBorrowRecord")
	public String toAddBorrowRecord() {	
		return "equ/newBorrowRecord";
	}
	
	//添加借用记录
	@ResponseBody
	@RequestMapping("/addBorrowRecord")
	public String addBorrowRecord(BorrowRecordDto brDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date_borrow=null;
		Date date_dealine=null;
		try {
			date_borrow=dateFormat.parse(brDto.getBorrowDateSTime());
			date_dealine=dateFormat.parse(brDto.getBorrowDealineSTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		brDto.setBorrowDate(date_borrow);
		brDto.setBorrowDealine(date_dealine);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(brDto));
		resultJo.addProperty("result", brService.addBorrowRecord(brDto));
		return resultJo.toString();
	}
	
	//添加领用记录
	@ResponseBody
	@RequestMapping("/addUseRecord")
	public String addUseRecord(UseRecordDto urDto) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date_use=null;
		Date date_dealine=null;
		try {
			date_use=dateFormat.parse(urDto.getUseDateSTime());
			date_dealine=dateFormat.parse(urDto.getUseDealineSTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		urDto.setUseDate(date_use);
		urDto.setUseDealine(date_dealine);
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(urDto));

		resultJo.addProperty("result", urService.addUseRecord(urDto));
		return resultJo.toString();
	}
	

	/**
	 * 根据领用记录id查找领用记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUseRecord")
	public String getUseRecord(Integer id) {
		UseRecordDto urDto = urService.findUseRecordDtoByItemId(id);
		Date date1=urDto.getUseDate();
		Date date2=urDto.getUseDealine();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateShow1=null;
		String dateShow2=null;
		try {
			dateShow1=dateFormat.format(date1);
			dateShow2=dateFormat.format(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		urDto.setUseDateSTime(dateShow1);
		urDto.setUseDealineSTime(dateShow2);
		JsonObject resultJson = new JsonObject();
		
		Gson gson = new Gson();
		resultJson.add("urDto", gson.toJsonTree(urDto));
		return resultJson.toString();
	}
	
	/**
	 * 根据借用记录id查找借用记录信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBorrowRecord")
	public String getBorrowRecord(Integer id) {
		BorrowRecordDto brDto = brService.findBorrowRecordDtoByItemId(id);
		Date date1=brDto.getBorrowDate();
		Date date2=brDto.getBorrowDealine();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateShow1=null;
		String dateShow2=null;
		try {
			dateShow1=dateFormat.format(date1);
			dateShow2=dateFormat.format(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		brDto.setBorrowDateSTime(dateShow1);
		brDto.setBorrowDealineSTime(dateShow2);
		
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("brDto", gson.toJsonTree(brDto));
		return resultJson.toString();
	}

	
	/**
	 * 保存编辑领用记录的数据
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editUseRecord")
	public String editUseRecord(UseRecordDto urDto){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date_use=null;
		Date date_dealine=null;
		try {
			date_use=dateFormat.parse(urDto.getUseDateSTime());
			date_dealine=dateFormat.parse(urDto.getUseDealineSTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		urDto.setUseDate(date_use);
		urDto.setUseDealine(date_dealine);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", urService.updateUseRecord(urDto));
		return jsonObject.toString();
	}
	
	/**
	 * 保存编辑借用记录的数据
	 * @param 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editBorrowRecord")
	public String editBorrowRecord(BorrowRecordDto brDto){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date_borrow=null;
		Date date_dealine=null;
		try {
			date_borrow=dateFormat.parse(brDto.getBorrowDateSTime());
			date_dealine=dateFormat.parse(brDto.getBorrowDealineSTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		brDto.setBorrowDate(date_borrow);
		brDto.setBorrowDealine(date_dealine);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", brService.updateBorrowRecord(brDto));
		return jsonObject.toString();
	}

}
