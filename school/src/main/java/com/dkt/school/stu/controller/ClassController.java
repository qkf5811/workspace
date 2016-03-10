package com.dkt.school.stu.controller;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorFieldService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.dto.ClazzDto;
import com.dkt.school.stu.dto.StudentInfoListDto;
import com.dkt.school.stu.model.Clazz;
import com.dkt.school.stu.service.ClazzService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with com.dkt.school.stu.controller by Harry on 2015/8/4 12:08.
 */

@Controller
@RequestMapping("/stu")
public class ClassController {

    public final static Logger logger = LoggerFactory
            .getLogger(ClassController.class);

    private ClazzService clazzService;
    private GradeService gradeService;
    private MajorService majorService;
    private MajorFieldService majorFieldService;

    public ClazzService getClazzService() {
        return clazzService;
    }

    @Autowired
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public MajorService getMajorService() {
        return majorService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    public MajorFieldService getMajorFieldService() {
        return majorFieldService;
    }

    @Autowired
    public void setMajorFieldService(MajorFieldService majorFieldService) {
        this.majorFieldService = majorFieldService;
    }

    /**
     * 进入查询所有班级信息的页面
     * @return
     */
    @RequestMapping("/toGetClassList")
    public String toGetClassList(Model model){

        List<Major> majorList=majorService.getAllMajorInfo();
        List<MajorField> majorFieldList=majorFieldService.getAllMajorField();
        List<Grade> gradeList=gradeService.getAllGrade();
        model.addAttribute("majorList",majorList);
        model.addAttribute("majorFieldList",majorFieldList);
        model.addAttribute("gradeList", gradeList);
        return "stu/classList";
    }

    /**
     * 根据条件查询所有班级信息
     * @param name
     * @param gradeName
     * @param majorFieldId
     * @param teacherName
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTheClassList")
    public String getTheClassList(String name,Integer gradeId,Integer majorFieldId,String teacherName, PaginationCustom page){
        int total=clazzService.getClassCount(name,gradeId,majorFieldId,teacherName);
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<ClazzDto> classes=clazzService.getClassesByPage(name,gradeId,majorFieldId,teacherName,page);
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        JsonArray classesJsonArray=gson.toJsonTree(classes, List.class).getAsJsonArray();

        JsonObject resultJson=new JsonObject();
        resultJson.add("rows", classesJsonArray);
        resultJson.addProperty("total", total);

        return resultJson.toString();


    }

    /**
     * 进入添加班级信息页面
     * @param model
     * @return
     */
    @RequestMapping("toAddClass")
    public String toAddClass(Model model){
        List<Major> majorList=majorService.getAllMajorInfo();
        List<Grade> gradeList=gradeService.getAllGrade();
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("majorList", majorList);

        return "stu/newClass";
    }

    /**
     * 添加班级信息
     * @param clazz
     * @return
     */
    @ResponseBody
    @RequestMapping("/addClass")
    public String addClass(Clazz clazz){
        JsonObject resultJo = new JsonObject();
        logger.info(new Gson().toJson(clazz));
        resultJo.addProperty("result", clazzService.addClazz(clazz));
        return resultJo.toString();
    }

    /**
     * 进入编辑班级信息页面
     * @param id
     * @return
     */
    @RequestMapping("/toEditClass")
    public String toEditClass(Integer id,Model model){
        List<Major> majorList=majorService.getAllMajorInfo();
        List<Grade> gradeList=gradeService.getAllGrade();
        model.addAttribute("gradeList", gradeList);
        model.addAttribute("majorList", majorList);
        model.addAttribute("classId", id);
        return "stu/editClass";
    }

    /**
     * 编辑班级信息
     * @param clazz
     * @return
     */
    @ResponseBody
    @RequestMapping("/editClass")
    public String editClass(Clazz clazz){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", clazzService.updateClazz(clazz));
        return jsonObject.toString();
    }

    /**
     * 删除班级信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteClass")
    public String deleteClass(Integer id){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", clazzService.deleteClazzById(id));
        return jsonObject.toString();
    }

    /**
     * 根据班级id获取班级信息，并返回json格式的字符串
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getClazzByClazzId")
    public String getClazz(Integer id){
        ClazzDto clazzDto = clazzService.findClazzByClazzId(id);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("clazz", gson.toJsonTree(clazzDto));
        return resultJson.toString();
    }
}
