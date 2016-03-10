package com.dkt.school.edu.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.edu.service.CourseService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/edu")
public class CourseSettingController {
	
	private final static Logger logger = LoggerFactory.getLogger(CourseSettingController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MajorService majorService;

	/**
	 * 打开课程设置首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/courseSetting")
	public String openCourseSettingPage(Model model) {
		
		logger.info("----------------得到专业信息-----------------");
		
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		return "edu/courseSetting";
	}
	
	/**
     * 根据课程名和专业名模糊分页查询
     * @param name
     * @param majorId
     * @param page
     * @return String
     */

    @ResponseBody
    @RequestMapping("/getCourseList")
    public String getCourseList(CourseDto courseDto,PaginationCustom page){
        int total=courseService.getCourseCount(courseDto);
      //设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);
        List<Course> courseList=courseService.getCourseByPage(courseDto, page);
        Gson gson=new Gson();
        JsonArray courseListJa=gson.toJsonTree(courseList, List.class).getAsJsonArray();
        JsonObject resultJo=new JsonObject();
        resultJo.add("rows",courseListJa);
        resultJo.addProperty("total", total);
        return resultJo.toString();
    }
	
	 /**
     * 更新课程
     * @param course
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", courseService.updateCourse(course));
        return resultJson.toString();
    }

	/**
     * 添加课程
     * @param course
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCourse")
    public String addCourse(Course course){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", courseService.addCourse(course));
        return resultJson.toString();
    }
	
	 /**
     * 根据课程id删除课程
     * @param courseId
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCourse")
    public String deleteCourse(Integer courseId){
        JsonObject resultJson=new JsonObject();
        resultJson.addProperty("success", courseService.deleteCourseById(courseId));
        return resultJson.toString();
    }
    /**
     * 根据课程id查找课程信息
     * @param courseId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCourse")
    public String getCourse(Integer courseId){
        CourseDto courseDto=courseService.findCourseDtoByCourseId(courseId);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("course", gson.toJsonTree(courseDto));
        return resultJson.toString();
    }
}
