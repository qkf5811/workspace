package com.dkt.school.stu.controller;

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
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.stu.dto.StudentChangeDto;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.StudentChange;
import com.dkt.school.stu.service.StuChangeClassService;
import com.dkt.school.stu.service.StudentChangeService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;



@Controller
@RequestMapping("/stu")
public class StuChangeClassController {

	public final static Logger logger = LoggerFactory
			.getLogger(StuChangeClassController.class);
	
	@Autowired
	private StuChangeClassService stuChangeClassService;
	
	@Autowired
	private EnumerationService enumerationService;
	
	@Autowired
	private StudentChangeService scService;
	/**
	 * 进入学生转班列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/stuChangeClassList")
	public String stuChangeClassList(Model model) {
		return "stu/stuChangeClassList";
	}
	
	
	/**
	 * 获取学生转班列表数据
	 * @param dto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStuChangeClassListData")
	public String getStuChangeClassListData(StudentChangeDto dto, PaginationCustom page) {
		int total= stuChangeClassService.getStuChangeClassCount(dto );
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);

		List<StudentChangeDto> stuChangeClass=stuChangeClassService.getStuChangeClassListData(dto,page);
		Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray stuChangeClasssJsonArray=gson.toJsonTree(stuChangeClass, List.class).getAsJsonArray();

		JsonObject resultJson=new JsonObject();
		resultJson.add("rows", stuChangeClasssJsonArray);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 进入添加学生转班页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/stuChangeClassAdd")
	public String stuChangeClassAdd(Model model){
		List<EnumerationValue> changeTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.CHANGE_CLASS);
		model.addAttribute("changeTypeList", changeTypeList);
		return "/stu/stuChangeClassAdd";
	}
	
	/**
	 * 保存学生转班信息
	 * @param obj
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/stuChangeClassSave")
	public String stuChangeClassSave(StudentChangeDto obj){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(obj));
		obj.setOutClassDate(DateUtil.convertStringToDate(obj.getOutClassDateStr()));
		obj.setIntoClassDate(DateUtil.convertStringToDate(obj.getIntoClassDateStr()));
		obj.setOutClassId(scService.getClassByMajorFieldClassName(obj.getOutClassName()).getId());
		obj.setIntoClassId(scService.getClassByMajorFieldClassName(obj.getIntoClassName()).getId());
		StudentDto student = scService.findStudent(obj.getCode());
		obj.setStudentId(student.getId());
		jsonObject.addProperty("result", stuChangeClassService.stuChangeClassSave(obj));
		return jsonObject.toString();
	}
	
	
	/**
	 * 进入编辑学生转班信息的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/stuChangeClassEdit")
	public String stuChangeClassEdit(Integer id,Model model){
		model.addAttribute("id", id);
		return "/stu/StuChangeClassEdit";
	}
	
	/**
	 * 根据ID查找学生转班信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStuChangeClassById")
	public String getStuChangeClassById(Integer id){
		StudentChange obj = stuChangeClassService.getStuChangeClassById(id);
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		resultJson.add("StuChangeClass", gson.toJsonTree(obj));
		return resultJson.toString();
	}
	
	
	/**
	 * 修改保存学生转班信息
	 * @param obj
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/stuChangeClassUpdate")
	public String stuChangeClassUpdate(StudentChangeDto obj){
		JsonObject jsonObject=new JsonObject();
		logger.info(new Gson().toJson(obj));
		jsonObject.addProperty("result", stuChangeClassService.stuChangeClassUpdate(obj));
		return jsonObject.toString();
	}
	
	
	/**
	 * 删除学生转班信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/stuChangeClassDelete")
	public String stuChangeClassDelete(Integer id,String code){
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", stuChangeClassService.stuChangeClassDelete(id,code));
		return jsonObject.toString();
	}
	
}
