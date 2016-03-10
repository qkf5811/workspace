package com.dkt.school.sch.controller;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.user.dto.UserDto;
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
 * Created with com.dkt.school.sch.controller by Harry on 2015/7/21 11:28.
 */

@Controller
@RequestMapping("/sch")
public class StudyYearController {
    private final static Logger logger = LoggerFactory.getLogger(StudyYearController.class);

    private StudyYearService studyYearService;

    private EnumerationService enumerationService;

    public StudyYearService getStudyYearService() {
        return studyYearService;
    }

    @Autowired
    public void setStudyYearService(StudyYearService studyYearService) {
        this.studyYearService = studyYearService;
    }

    public EnumerationService getEnumerationService() {
        return enumerationService;
    }

    @Autowired
    public void setEnumerationService(EnumerationService enumerationService) {
        this.enumerationService = enumerationService;
    }

    @RequestMapping("/toStudyYearList")
    public String toStudyYearList(){
        return "sch/studyYearList";
    }

    @ResponseBody
    @RequestMapping("/getStudyYearList")
    public String getStudyYearList(PaginationCustom page){
        int total = studyYearService.getStudyYearCount();
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<StudyYear> studyYearList = studyYearService
                .getStudyYearByPage(page);

        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        JsonArray studyYearListJa = gson.toJsonTree(studyYearList, List.class)
                .getAsJsonArray();

        JsonObject resultJson = new JsonObject();
        resultJson.add("rows", studyYearListJa);
        resultJson.addProperty("total", total);

        return resultJson.toString();
    }

    /**
     * 添加学年信息
     * @param studyYear
     * @return
     */
    @ResponseBody
    @RequestMapping("/addStudyYear")
    public String addStudyYear(StudyYear studyYear){
        JsonObject resultJo = new JsonObject();
        logger.info(new Gson().toJson(studyYear));
        resultJo.addProperty("result", studyYearService.addStudyYear(studyYear));
        return resultJo.toString();
    }

    /**
     * 更新学年信息
     * @param studyYear
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateStudyYear")
    public String updateStudyYear(StudyYear studyYear){
        JsonObject resultJson = new JsonObject();
        resultJson.addProperty("success", studyYearService.updateStudyYear(studyYear));
        return resultJson.toString();
    }

    /**
     * 删除学年信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteStudyYear")
    public String deleteStudyYear(Integer id){
        JsonObject resultJson = new JsonObject();
        resultJson.addProperty("success", studyYearService.deleteStudyYearById(id));
        return resultJson.toString();
    }

    /**
     * 获取所有的学期信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllTermType")
    public String getAllTermType(){
        Gson gson=new Gson();

        return gson.toJson(enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE));
    }

    /**
     * 设置当前学年
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeDefaultStudyYear")
    public String changeDefaultStudyYear(Integer id,Integer termType){
        JsonObject resultJson = new JsonObject();
        resultJson.addProperty("success", studyYearService.changeDefaultStudyYearById(id,termType));
        return resultJson.toString();
    }

    /**
     * 获取当前学年和学期
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCurrentStudyYearAndTermType")
    public String getCurrentStudyYearAndTermType(){
        JsonObject resultJson = new JsonObject();

        resultJson.addProperty("studyYear",studyYearService.getCurrentStudyYear());
        resultJson.addProperty("termType",enumerationService.getEnumValueById(Integer.parseInt(studyYearService.getCurrentTermType())).getName());
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
