package com.dkt.school.equ.controller;




import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.equ.dao.FunctionRoomCustomMapper;
import com.dkt.school.equ.dao.RoomApplicationCustomMapper;
import com.dkt.school.equ.dto.FunctionRoomDto;
import com.dkt.school.equ.model.FunctionRoom;
import com.dkt.school.equ.model.RoomApplication;
import com.dkt.school.equ.service.FunctionRoomService;
import com.dkt.school.equ.service.RoomApplicationService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mysql.fabric.Response;

//领用记录
@Controller
@RequestMapping("/equ")
public class RoomApplicationController {

	public final static Logger logger = LoggerFactory.getLogger(RoomApplicationController.class);
	
	
	@Autowired
	private RoomApplicationService roomApplicationService;
	
	@Autowired
	private FunctionRoomService functionRoomService;
	
	@Autowired
	private FunctionRoomCustomMapper functionRoomMapper;
	
	@Autowired
	private EnumerationService enumerationService;
	
	@Autowired
	private RoomApplicationCustomMapper roomApplicationMapper;
	/**
	 * 进入功能室使用申请页面
	 * @param model
	 * @return
	 * 2015年9月7日下午4:18:18
	 */
	@RequestMapping("/roomApplicationList")
	public String roomApplicationList(Model model) {
		return "equ/roomApplicationList";
	}
	
	
	/**
	 * 获取功能室使用申请数据
	 * @param dto
	 * @param page
	 * @return
	 * 2015年9月7日下午4:18:21
	 */
	@ResponseBody
	@RequestMapping("/getRoomApplicationList")
	public String getRoomApplicationList(FunctionRoomDto dto, PaginationCustom page) {
		int total= roomApplicationService.getRoomApplicationCount(dto);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<FunctionRoomDto> functionRooms=roomApplicationService.getRoomApplicatioByPage(dto,page);
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		JsonArray functionRoomsJsonArray=gson.toJsonTree(functionRooms, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", functionRoomsJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 新建功能室使用申请
	 * @param id
	 * @param model
	 * @return
	 * 2015年9月7日下午4:59:35
	 */
	@RequestMapping("/toAddRoomApplication")
	public String toAddRoomApplication(Model model){
		List<EnumerationValue> applicationTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.APPLICATION_TYPE);
		model.addAttribute("applicationTypeList", applicationTypeList);
		List<FunctionRoom> functionRoomList = functionRoomMapper.selectByExample(null);
		model.addAttribute("functionRoomList",functionRoomList);
		return "/equ/newRoomApp";
	}
	
	@ResponseBody
	@RequestMapping("/addRoomApplication")
	public String addRoomApplication(HttpSession session,FunctionRoomDto functionRoomDto){
		JsonObject jsonObject=new JsonObject();
		User user = (User)session.getAttribute("user");
		logger.info(new Gson().toJson(functionRoomDto));
		functionRoomDto.setUseUserId(user.getId());
		functionRoomDto.setDepartId(user.getDepartmentId());
		jsonObject.addProperty("result", roomApplicationService.addApplication(functionRoomDto));
		return jsonObject.toString();
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 * 2015年9月7日下午4:18:10
	 */
	@RequestMapping("/toEditRoomApplication")
	public String toEditRoomApplication(Integer id,String appName,Model model){
		List<FunctionRoom> functionRoomList = functionRoomMapper.selectByExample(null);
		model.addAttribute("functionRoomList",functionRoomList);
		RoomApplication room = roomApplicationMapper.selectByPrimaryKey(id);
		FunctionRoomDto dto = new FunctionRoomDto();
		dto.setAppName(appName);
		dto.setReason(room.getRemark());
		dto.setUseFromDateStr(DateUtil.getDateTime("yyyy-MM-dd HH:mm", room.getUseFromDate()));
		dto.setUseToDateStr(DateUtil.getDateTime("yyyy-MM-dd HH:mm", room.getUseToDate()));
		dto.setRemark(room.getRemark());
		dto.setApplicationId(room.getApplicationId());
		dto.setFunctionRoomId(room.getFunctionRoomId());
		model.addAttribute("id", id);
		model.addAttribute("dto", dto);
		return "/equ/editRoomApp";
	}
	
	/**
	 * 修改保存功能室使用申请
	 * @param functionRoom
	 * @return
	 * 2015年9月7日下午4:18:26
	 */
	@ResponseBody
	@RequestMapping("/editRoomApplication")
	public String editRoomApplication(FunctionRoomDto functionRoomDto){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(functionRoomDto));
		jsonObject.addProperty("result", roomApplicationService.updateRoomApplication(functionRoomDto));
		return jsonObject.toString();
	}
	
	
	/**
	 * 删除功能室使用申请
	 * @param id
	 * @return
	 * 2015年9月7日下午4:18:29
	 */
	@ResponseBody
	@RequestMapping("/deleteRoomApplication")
	public String deleteRoomApplication(Integer id){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", roomApplicationMapper.deleteByPrimaryKey(id));
		return jsonObject.toString();
	}

}
