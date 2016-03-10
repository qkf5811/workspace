package com.dkt.school.stu.controller;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.StudentInfoListDto;
import com.dkt.school.stu.model.StudentInfo;
import com.dkt.school.stu.service.StudentInfoService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with com.dkt.school.stu.controller by Harry on 2015/7/6 10:47.
 */

@Controller
@RequestMapping("/stu")
public class StudentListController {

    public final static Logger logger = LoggerFactory
            .getLogger(StudentListController.class);

    private EnumerationService enumerationService;
    private StudentInfoService studentInfoService;

    public EnumerationService getEnumerationService() {
        return enumerationService;
    }

    @Autowired
    public void setEnumerationService(EnumerationService enumerationService) {
        this.enumerationService = enumerationService;
    }

    public StudentInfoService getStudentInfoService() {
        return studentInfoService;
    }

    @Autowired
    public void setStudentInfoService(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    /**
     * 进入查询所有在籍生信息的页面
     * @return
     */
    @RequestMapping("/toGetStuList")
    public String toStudentList(Model model){
        List<EnumerationValue> sexList = enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
        List<EnumerationValue> statusList = enumerationService.getEnumValueListByEnumId(EnumerationType.STU_STATUS);
        List<EnumerationValue> studentStatusList = enumerationService.getEnumValueListByEnumId(EnumerationType.CHANGE_TYPE);
        model.addAttribute("sexList", sexList);
        model.addAttribute("statusList", statusList);
        model.addAttribute("studentStatusList", studentStatusList);
        return "stu/stuList";
    }


    /**
     * 根据条件查询所有在籍生信息
     */
    @ResponseBody
    @RequestMapping("/getStuList")
    public String getStuList(String name,String className,Integer sexType,Integer status,Integer studentStatus,PaginationCustom page){
        int total=studentInfoService.getStuCount(name,className,sexType,status,studentStatus);
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<StudentInfoListDto> students=studentInfoService.getStudentsByPage(name,className,sexType,status,studentStatus,page);
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        JsonArray stuListJsonArray=gson.toJsonTree(students, List.class).getAsJsonArray();

        JsonObject resultJson=new JsonObject();
        resultJson.add("rows", stuListJsonArray);
        resultJson.addProperty("total", total);

        return resultJson.toString();

    }

    /**
     * 进入在籍生详细信息页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toGetStuListDetail")
    public String toGetStuListDetail(int id,Model model){
        model.addAttribute("id", id);
        return "stu/stuListDetail";
    }

    /**
     * 根据学生基本信息id来查询在籍生详细信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStuListDetail")
    public String getStuListDetail(int id){
        JsonObject jsonObject=new JsonObject();
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        return gson.toJson(studentInfoService.getStudentByStudentId(id));
    }


    /**
     * 进入在籍生基本信息编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toEditStuListDetail")
    public String toEditStuListDetail(int id,Model model){
        List<EnumerationValue> sexList = enumerationService.getEnumValueListByEnumId(EnumerationType.SEX_TYPE);
        List<EnumerationValue> nationList = enumerationService.getEnumValueListByEnumId(EnumerationType.NATION_TYPE);
        List<EnumerationValue> houseHoldList = enumerationService.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE);
        List<EnumerationValue> politicalFeatureList = enumerationService.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE);
        List<EnumerationValue> isHkMcList = enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);

        model.addAttribute("id",id);
        model.addAttribute("sexList", sexList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("houseHoldList", houseHoldList);
        model.addAttribute("politicalFeatureList", politicalFeatureList);
        model.addAttribute("isHkMcList", isHkMcList);


        return "stu/editStuListDetail";
    }


    /**
     * 更新在籍生的学生基本信息
     * @param studentInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("/editStuListDetail")
    public String editStuListDetail(StudentInfo studentInfo){
        JsonObject resultJson = new JsonObject();
        resultJson.addProperty("success",studentInfoService.updateStudentInfo(studentInfo));

        return resultJson.toString();
    }

    /**
     * 数据绑定，用于string类型转成date类型
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
}
