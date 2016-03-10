package com.dkt.school.equ.controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;
import com.dkt.school.equ.service.BorrowRecordService;
import com.dkt.school.equ.service.FunctionRoomService;
import com.dkt.school.equ.service.UseRecordService;
import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.model.ClassRoom;
import com.dkt.school.sch.service.BuildingService;
import com.dkt.school.system.model.EnumerationValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//领用记录
@Controller
@RequestMapping("/equ")
public class FunctionRoomController {

	public final static Logger logger = LoggerFactory
			.getLogger(FunctionRoomController.class);
	
	@Autowired
	private UseRecordService urService;
	@Autowired
	private BorrowRecordService brService;
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private FunctionRoomService functionRoomService;
	
	/**
	 * 功能室列表
	 * @param model
	 * @return
	 * 2015年9月6日下午2:50:25
	 */
	@RequestMapping("/functionRoomList")
	public String functionRoomList(Model model) {
		List<Building> building = buildingService.getAllBuilding();
		model.addAttribute("building",building);
		return "equ/functionRoomList";
	}
	
	
	/**
	 * 获取功能室列表数据
	 * @param itemId
	 * @param name
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getFunctionRoomList")
	public String getfunctionRoomList(Integer buildingId, String name, PaginationCustom page) {
		int total= functionRoomService.getFunctionRoomCount(buildingId,name );
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<FunctionRoomDto> functionRooms=functionRoomService.getFunctionRoomByPage(name,buildingId,page);
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray functionRoomsJsonArray=gson.toJsonTree(functionRooms, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", functionRoomsJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 进入添加功能室页面
	 * @param model
	 * @return
	 * 2015年9月6日上午10:40:04
	 */
	@RequestMapping("/toAddFunctionRoom")
	public String toAddFunctionRoom(Model model){
		List<Building> building = buildingService.getAllBuilding();
		model.addAttribute("building",building);
		return "/equ/newFunctionRoom";
	}
	
	/**
	 * 添加功能室信息
	 * @param classRoom
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addFunctionRoom")
	public String addFunctionRoom(FunctionRoom functionRoom){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(functionRoom));
		jsonObject.addProperty("result", functionRoomService.addFunctionRoom(functionRoom));
		return jsonObject.toString();
	}
	
	
	/**
	 * 进入编辑功能室信息的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditFunctionRoom")
	public String toEditFunctionRoom(Integer id,Model model){
		List<Building> building = buildingService.getAllBuilding();
		model.addAttribute("building",building);
		model.addAttribute("id", id);
		return "/equ/editFunctionRoom";
	}
	
	/**
	 * 根据ID查找功能室信息
	 * @param id
	 * @return
	 * 2015年9月6日上午11:04:39
	 */
	@ResponseBody
	@RequestMapping("/getFunctionRoomById")
	public String getFunctionRoomById(Integer id){
		FunctionRoom functionRoom = functionRoomService.findFunctionRoomById(id);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("FunctionRoom", gson.toJsonTree(functionRoom));
		return resultJson.toString();
	}
	
	
	/**
	 * 修改保存功能室信息
	 * @param classRoom
	 * @return
	 * 2015年9月6日上午11:39:20
	 */
	@ResponseBody
	@RequestMapping("/editFunctionRoom")
	public String editFunctionRoom(FunctionRoom functionRoom){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(functionRoom));
		jsonObject.addProperty("result", functionRoomService.updateFunctionRoom(functionRoom));
		return jsonObject.toString();
	}
	
	
	/**
	 * 删除功能室信息
	 * @param id
	 * @return
	 * 2015年9月6日上午11:42:17
	 */
	@ResponseBody
	@RequestMapping("/deleteFunctionRoom")
	public String deleteFunctionRoom(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", functionRoomService.deleteFunctionRoom(id));
		return jsonObject.toString();
	}
	
	
	/**
	 * 功能室使用记录列表
	 * @param model
	 * @return
	 * 2015年9月6日下午2:54:09
	 */
	@RequestMapping("/functionRoomRecordList")
	public String functionRoomRecordList(Model model) {
		return "equ/functionRoomRecordList";
	}
	
	/**
	 * 获取功能室记录数据
	 * @param funRoomName
	 * @param uName
	 * @param page
	 * @return
	 * 2015年9月6日下午4:13:50
	 */
	@ResponseBody
	@RequestMapping("/getFunctionRoomRecordList")
	public String getFunctionRoomRecordList(String funRoomName, String uName, PaginationCustom page) {
		int total= functionRoomService.getFunctionRoomRecordCount(funRoomName,uName);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<FunctionRoomDto> functionRooms=functionRoomService.getFunctionRoomRecordByPage(funRoomName,uName,page);
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray functionRoomsJsonArray=gson.toJsonTree(functionRooms, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", functionRoomsJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}

}
