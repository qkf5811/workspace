package com.dkt.school.stu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.StudentPunishmentDto;
import com.dkt.school.stu.model.StudentPunishment;
import com.dkt.school.stu.service.StudentRewardAndPunishmentService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by JanGin on 2015/6/11.
 */
@Controller
@RequestMapping("/stu")
public class StudentPunishmentController {

	private final static Logger logger = LoggerFactory.getLogger(StudentPunishmentController.class);
	@Autowired
    private StudentRewardAndPunishmentService stuService;
	
	@Autowired
	private EnumerationService enumService;
    
    @ResponseBody
    @RequestMapping("/addPunishmentInfo")
    public String addPunishmentInfo(StudentPunishment studentPunishment){
    	JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result",stuService.addStudentPunishmentRecord(studentPunishment));
        return jsonObject.toString();
    }
    
    
    @RequestMapping("/toAddPunishmentInfo")
    public String addPunishmentInfo(Model model){
   
    	List<EnumerationValue> punishmentTypeList = enumService.getEnumValueListByEnumId(EnumerationType.PUNISHMENT_TYPE);
    	model.addAttribute("punishmentType", punishmentTypeList);
        return "stu/addPunishmentInfo";
    }

    @RequestMapping("/toUpdatePunishmentInfo")
    public String toUpdatePunishmentInfo(@RequestParam("id")Integer id,
    			@RequestParam("studentId")Integer studentId,Model model){
    	StudentPunishmentDto spDto = stuService.getStudentPunishmentDtoById(id,studentId);
    	List<EnumerationValue> punishmentTypeList = enumService.getEnumValueListByEnumId(EnumerationType.PUNISHMENT_TYPE);
    	model.addAttribute("punishmentType",punishmentTypeList);
    	model.addAttribute("sp", spDto);
    	return "stu/updatePunishmentInfo";
    }
    
    @ResponseBody
    @RequestMapping("/updatePunishmentInfo")
    public String updatePunishmentInfo(StudentPunishmentDto spDto){
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("success", stuService.updatePunishmentInfo(spDto));
    	return jsonObject.toString();
    }
    
    @RequestMapping("/toPunishmentList")
    public String toPunishmentList(){
    	return "stu/punishmentList";
    }
    
    @ResponseBody
    @RequestMapping("/deletePunishmentInfo")
    public String deletePunishmentInfo(Integer id){
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("success", stuService.deletePunishmentInfo(id));
    	return jsonObject.toString();
    }
    
    /**
     * 学生惩罚列表
     * @param code
     * @param punishmentType
     * @param name
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPunishmentList")
    public String getPunishmentList(String code,Integer punishmentType,
    								String name,PaginationCustom page){
    	List<StudentPunishmentDto> sList = stuService.getStudentPunishmentDtoList(code,punishmentType,name,page.getLimitation());
    	int totalRows = stuService.getStudentPunishmentCount(code,punishmentType,name);
    	//设置分页
    	page.setCurrentPage(page.getPage());
    	page.setPageRecorders(page.getRows());
    	page.setTotalRows(totalRows);
    	Gson gson = new Gson();
    	//转换成json数组
    	JsonArray jsArr = gson.toJsonTree(sList, List.class).getAsJsonArray();
    	JsonObject resultJson = new JsonObject();
    	resultJson.add("rows", jsArr);
    	resultJson.addProperty("total", totalRows);
    	return resultJson.toString();
    }

    @RequestMapping("/toAllPunishmentList")
    public String toAllPunishmentStuList(){
    	
    	return "stu/allPunishmentList";
    }
    
    /**
     * 添加页面的在籍生列表
     * @param name
     * @param code
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllPunishmentList")
    public String getAllPunishmentList(String name,String code,PaginationCustom page){
    	int totals = stuService.getAllPunishmentStuCount(name,code);
    	page.setCurrentPage(page.getCurrentPage());
    	page.setPageRecorders(page.getPageRecorders());
    	page.setTotalRows(totals);
    	Gson gson = new Gson();
    	JsonObject jsonObject = new JsonObject();
    	List<StudentPunishmentDto> list = stuService.getAllPunishmentStuList(name,code,page.getLimitation());
    	JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
    	jsonObject.add("rows", jsArr);
    	jsonObject.addProperty("total", totals);
    	return jsonObject.toString();
    }
}

