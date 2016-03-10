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
import com.dkt.school.stu.dto.StudentRewardDto;
import com.dkt.school.stu.model.StudentReward;
import com.dkt.school.stu.service.StudentRewardAndPunishmentService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/stu")
public class StudentRewardController {
	private final static Logger logger = LoggerFactory
			.getLogger(StudentRewardController.class);

	@Autowired
    private StudentRewardAndPunishmentService stuService;
	
	@Autowired
	private EnumerationService enumService;

    @RequestMapping("/toAddRewardInfo")
    public String addRewardInfo(Model model){
    	List<EnumerationValue> rewardTypeList = enumService.getEnumValueListByEnumId(EnumerationType.REWARD_TYPE);
    	model.addAttribute("rewardType",rewardTypeList);
        return "stu/addRewardInfo";
    }
    
    /**
     * 添加学生奖励信息
     * @param studentReward
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRewardInfo")
    public String addRewardInfo(StudentReward studentReward){
    	System.out.println(studentReward.toString());
    	JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result",stuService.addStudentRewardRecord(studentReward));
        return jsonObject.toString();
    }

    @RequestMapping("/toRewardList")
    public String toRewardList(){
    	return "stu/rewardList";
    }
    
    @RequestMapping("/toUpdateRewardInfo")
    public String toUpdateRewardInfo(@RequestParam("id")Integer id,
    				@RequestParam("studentId")Integer studentId,Model model){
    	StudentRewardDto srDto = stuService.getStudentRewardDtoById(id,studentId);
    	List<EnumerationValue> rewardTypeList = enumService.getEnumValueListByEnumId(EnumerationType.REWARD_TYPE);
    	model.addAttribute("rewardType",rewardTypeList);
    	model.addAttribute("sr", srDto);
    	return "stu/updateRewardInfo";
    }
    
    /**
     * 跳转到修改页面
     * @param srDto
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRewardInfo")
    public String updateRewardInfo(StudentRewardDto srDto){
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("success", stuService.updateRewardInfo(srDto)); 
    	return jsonObject.toString();
    }
    
    @RequestMapping("/toAllRewardList")
    public String toRewardStuList(){
    	return "stu/allRewardList";
    }
    
    /**
     * 更新页面的在籍生列表
     * @param name
     * @param code
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllRewardList")
    public String getAllRewardList(String name,String code,PaginationCustom page){
    	int totals = stuService.getAllRewardStuCount(name,code);
    	page.setCurrentPage(page.getCurrentPage());
    	page.setPageRecorders(page.getPageRecorders());
    	page.setTotalRows(totals);
    	Gson gson = new Gson();
    	JsonObject jsonObject = new JsonObject();
    	List<StudentRewardDto> list = stuService.getAllRewardStuList(name,code,page.getLimitation());
    	logger.info("--------------------------"+page.getLimitation().getOffset().toString());
    	logger.info("--------------------------"+page.getLimitation().getRows().toString());
    	/*for (StudentRewardDto dto : list){
    		System.out.println(dto);
    	}*/
    	JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
    	jsonObject.add("rows", jsArr);
    	jsonObject.addProperty("total", totals);
    	return jsonObject.toString();
    }
    
    @ResponseBody
    @RequestMapping("/deleteRewardInfo")
    public String deleteRewardInfo(Integer id){
    	JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty("success", stuService.deleteRewardInfo(id));
    	return jsonObject.toString();
    }
    
    @ResponseBody
    @RequestMapping("/getRewardList")
    public String getRewardList(String code,Integer rewardType,
    							String name,PaginationCustom page){
    	List<StudentRewardDto> sList = stuService.getStudentRewardDtoList(code,rewardType,name,page.getLimitation());
    	int totalRows = stuService.getStudentRewardCount(code,rewardType,name);
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
}
