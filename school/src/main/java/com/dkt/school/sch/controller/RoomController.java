package com.dkt.school.sch.controller;

import java.util.List;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.ClassRoomDto;
import com.dkt.school.sch.model.Campus;
import com.dkt.school.sch.service.CampusService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.sch.model.Building;
import com.dkt.school.sch.model.ClassRoom;
import com.dkt.school.sch.service.BuildingService;
import com.dkt.school.sch.service.ClassRoomService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
@RequestMapping("sch")
public class RoomController {

	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private ClassRoomService classService;

	private CampusService campusService;

	private ClassRoomService classRoomService;

	private EnumerationService enumerationService;

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}

	public CampusService getCampusService() {
		return campusService;
	}

	@Autowired
	public void setCampusService(CampusService campusService) {
		this.campusService = campusService;
	}

	public ClassRoomService getClassRoomService() {
		return classRoomService;
	}

	@Autowired
	public void setClassRoomService(ClassRoomService classRoomService) {
		this.classRoomService = classRoomService;
	}

	/**
	 * 根据校区id获得教学楼
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getBuildingByCampusId")
	public String getBuildingByCampusId(int id) {
		
		logger.info("----------根据校区id获得教学楼---------");
		
		List<Building> list = buildingService.getBuildingByCampusId(id);
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		return ja.toString();
	}
	
	/**
	 * 根据教学楼id获得教室
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getClassByBuildingId")
	public String getClassByBuildingId(int id) {
		
		logger.info("----------根据教学楼id获得教室---------");
		List<ClassRoom> list = classService.getClassRoomByBuilding(id);
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		
		return ja.toString();
	}

	/**
	 * 进入查找所有教室信息的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toClassRoomList")
	public String toClassRoomList(Model model){
		List<EnumerationValue> roomTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.ROOM_TYPE);
		List<Campus> campusList=campusService.getAllCampus();
		model.addAttribute("roomTypeList",roomTypeList);
		model.addAttribute("campusList",campusList);

		return "/sch/classRoomList";
	}

	/**
	 * 根据条件查询所有教室
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassRoomList")
	public String getClassRoomList(String name,Integer campusId,Integer buildingId,Integer roomType,PaginationCustom page){
		int total=classService.getClassRoomCount(name, campusId,buildingId,roomType);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<ClassRoomDto> classRooms=classService.getClassRoomByPage(name, campusId,buildingId,roomType, page);
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray classRoomsJsonArray=gson.toJsonTree(classRooms, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", classRoomsJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}

	/**
	 * 进入添加教室信息页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddClassRoom")
	public String toAddClassRoom(Model model){
		List<EnumerationValue> roomTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.ROOM_TYPE);
		List<Campus> campusList=campusService.getAllCampus();
		model.addAttribute("roomTypeList", roomTypeList);
		model.addAttribute("campusList", campusList);
		return "/sch/newClassRoom";
	}

	/**
	 * 添加教室信息
	 * @param classRoom
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addClassRoom")
	public String addClassRoom(ClassRoom classRoom){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(classRoom));
		jsonObject.addProperty("result", classRoomService.addClassRoom(classRoom));
		return jsonObject.toString();
	}

	/**
	 * 进入编辑教室信息的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditClassRoom")
	public String toEditClassRoom(Integer id,Model model){
		List<EnumerationValue> roomTypeList = enumerationService.getEnumValueListByEnumId(EnumerationType.ROOM_TYPE);
		List<Campus> campusList=campusService.getAllCampus();
		model.addAttribute("roomTypeList", roomTypeList);
		model.addAttribute("campusList", campusList);
		model.addAttribute("classRoomId", id);
		return "/sch/editClassRoom";
	}

	/**
	 * 编辑教室信息
	 * @param classRoom
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editClassRoom")
	public String editClassRoom(ClassRoom classRoom){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(classRoom));
		jsonObject.addProperty("result", classRoomService.updateClassRoom(classRoom));
		return jsonObject.toString();
	}

	/**
	 * 删除教室信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteClassRoom")
	public String deleteClassRoom(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", classRoomService.deleteClassRoom(id));
		return jsonObject.toString();
	}

	/**
	 * 根据教室id获取教室信息，并返回json格式的字符串
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassRoomByClassRoomId")
	public String getClassRoomByClassRoomId(Integer id){
		ClassRoom classRoom = classRoomService.findClassRoomByClassRoomId(id);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("classRoom", gson.toJsonTree(classRoom));
		return resultJson.toString();
	}
	/**
	 * @author 吴俊鹏
	 * 根据教学楼id获得仓库属性的教室
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getClassByBuildingIdForStorage")
	public String getClassByBuildingIdForStorage(int id) {
		
		logger.info("----------根据教学楼id获得仓库属性的教室---------");
		List<ClassRoom> list = classService.getClassByBuildingIdForStorage(id);
		
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		
		return ja.toString();
	}
}
