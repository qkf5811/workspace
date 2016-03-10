package com.dkt.school.edu.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dkt.school.edu.model.CoursePlan;
import com.dkt.school.edu.service.CoursePlanSettingService;
import com.dkt.school.tea.controller.TeacherInfoController;
import com.google.gson.JsonObject;

/**
 * 设置课程计划记录
 * @author 赖继鹏
 *
 */
@Controller
@RequestMapping("/edu")
public class CoursePlanSettingController {
	private final static Logger logger = LoggerFactory
			.getLogger(TeacherInfoController.class);
	
	private CoursePlanSettingService coursePlanSettingService;

	public CoursePlanSettingService getCoursePlanSettingService() {
		return coursePlanSettingService;
	}
	
    @Autowired
	public void setCoursePlanSettingService(
			CoursePlanSettingService coursePlanSettingService) {
		this.coursePlanSettingService = coursePlanSettingService;
	}
    
    /**
     * 添加课程计划
     * @param coursePlan
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCoursePlan")
    public String addCoursePlan(CoursePlan coursePlan){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------插入一条课程计划记录------------------------");
        resultJo.addProperty("result", coursePlanSettingService.addCoursePlan(coursePlan));
        return resultJo.toString();
    }
	
    /**
     * 修改课程计划
     * @param coursePlan
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCoursePlan")
    public String updateCoursePlan(CoursePlan coursePlan){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改一条课程计划记录------------------------");
        resultJo.addProperty("result", coursePlanSettingService.updateCoursePlan(coursePlan));
        return resultJo.toString();
    }
    
    

    /**
     * 删除课程计划
     * @param coursePlan
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCoursePlan")
    public String deleteCoursePlan(CoursePlan coursePlan){
        JsonObject resultJo = new JsonObject();
        logger.info("-------------------修改一条课程计划记录------------------------");
        resultJo.addProperty("result", coursePlanSettingService.deleteCoursePlan(coursePlan));
        return resultJo.toString();
    }
   

}
