package com.dkt.school.sch.controller;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.GradeDto;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
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

import java.util.List;

/**
 * Created with com.dkt.school.sch.controller by Harry on 2015/8/13 15:37.
 */
@Controller
@RequestMapping("/sch")
public class GradeController {

    public final static Logger logger = LoggerFactory
            .getLogger(GradeController.class);

    private GradeService gradeService;
    private EnumerationService enumerationService;

    public GradeService getGradeService() {
        return gradeService;
    }

    @Autowired
    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public EnumerationService getEnumerationService() {
        return enumerationService;
    }

    @Autowired
    public void setEnumerationService(EnumerationService enumerationService) {
        this.enumerationService = enumerationService;
    }


    /**
     * 进入查询所有年级信息的页面
     * @return
     */
    @RequestMapping("/toGradeList")
    public String toGradeList(Model model){

        List<EnumerationValue> eduStageList = enumerationService.getEnumValueListByEnumId(EnumerationType.EDU_STAGE_TYPE);
        List<EnumerationValue> isGraduationList = enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
        model.addAttribute("eduStageList",eduStageList);
        model.addAttribute("isGraduationList",isGraduationList);
        return "sch/gradeList";
    }

    /**
     * 根据条件查询所有年级
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGradeList")
    public String getGradeList(String name, Integer eduStageType, Integer isGraduation, PaginationCustom page){

        int total=gradeService.getGradeCount(name,eduStageType,isGraduation);
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<GradeDto> grades=gradeService.getGradeByPage(name,eduStageType,isGraduation,page);
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        JsonArray gradesJsonArray=gson.toJsonTree(grades, List.class).getAsJsonArray();

        JsonObject resultJson=new JsonObject();
        resultJson.add("rows", gradesJsonArray);
        resultJson.addProperty("total", total);

        return resultJson.toString();
    }

    /**
     * 进入添加年级页面
     * @param model
     * @return
     */
    @RequestMapping("/toAddGrade")
    public String toAddGrade(Model model){
        List<EnumerationValue> eduStageList = enumerationService.getEnumValueListByEnumId(EnumerationType.EDU_STAGE_TYPE);
        List<EnumerationValue> isGraduationList = enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
        model.addAttribute("eduStageList", eduStageList);
        model.addAttribute("isGraduationList", isGraduationList);
        return "sch/newGrade";
    }

    /**
     * 添加年级信息
     * @param grade
     * @return
     */
    @ResponseBody
    @RequestMapping("/addGrade")
    public String addGrade(Grade grade){
        JsonObject resultJo = new JsonObject();
        logger.info(new Gson().toJson(grade));
        resultJo.addProperty("result", gradeService.addGrade(grade));
        return resultJo.toString();

    }

    /**
     * 进入年级编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toEditGrade")
    public String toEditGrade(Integer id ,Model model){
        List<EnumerationValue> eduStageList = enumerationService.getEnumValueListByEnumId(EnumerationType.EDU_STAGE_TYPE);
        List<EnumerationValue> isGraduationList = enumerationService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
        model.addAttribute("eduStageList", eduStageList);
        model.addAttribute("isGraduationList", isGraduationList);
        model.addAttribute("gradeId", id);
        return "sch/editGrade";
    }

    /**
     * 更新年级信息
     * @param grade
     * @return
     */
    @ResponseBody
    @RequestMapping("/editGrade")
    public String editGrade(Grade grade){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", gradeService.updateGrade(grade));
        return jsonObject.toString();
    }

    /**
     * 删除年级信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteGrade")
    public String deleteGrade(Integer id){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", gradeService.deleteGrade(id));
        return jsonObject.toString();
    }

    /**
     * 根据年级id获取年级信息，并返回json格式的字符串
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getGradeByGradeId")
    public String getGrade(Integer id){
        Grade grade = gradeService.findGradeByGradeId(id);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("grade", gson.toJsonTree(grade));
        return resultJson.toString();
    }
}
