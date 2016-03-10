package com.dkt.school.fin.controller;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.ChargeStandardDto;
import com.dkt.school.fin.model.ChargeStandard;
import com.dkt.school.fin.service.ChargeStandardService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
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
 * Created with com.dkt.school.fin.controller by Harry on 2015/8/27 11:58.
 */

@Controller
@RequestMapping("/fin")
public class ChargeStandardController {

    public final static Logger logger = LoggerFactory
            .getLogger(ChargeStandardController.class);


    private ChargeStandardService chargeStandardService;

    private GradeService gradeService;

    private EnumerationService enumerationService;
    private MajorService majorService;


    public ChargeStandardService getChargeStandardService() {
        return chargeStandardService;
    }

    @Autowired
    public void setChargeStandardService(ChargeStandardService chargeStandardService) {
        this.chargeStandardService = chargeStandardService;
    }

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

    public MajorService getMajorService() {
        return majorService;
    }

    @Autowired
    public void setMajorService(MajorService majorService) {
        this.majorService = majorService;
    }

    /**
     * 进入查看所有收费标准页面
     * @return
     */
    @RequestMapping("/toChargeStandardList")
    public String toChargeStandardList(Model model){
        List<Grade> gradeList=gradeService.getAllGrade();
        List<EnumerationValue> termTypeList= enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
        List<Major> majorList=majorService.getAllMajorInfo();

        model.addAttribute("gradeList",gradeList);
        model.addAttribute("termTypeList",termTypeList);
        model.addAttribute("majorList",majorList);
        return "fin/chargeStandardList";
    }

    /**
     *根据条件查询所有收费标准
     * @param gradeId
     * @param termType
     * @param majorId
     * @param majorFieldId
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getChargeStandardList")
    public String getChargeStandardList(Integer gradeId,Integer termType,Integer majorId,Integer majorFieldId,PaginationCustom page){
        int total=chargeStandardService.getChargeStandardCount(gradeId,termType,majorId,majorFieldId);
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);

        List<ChargeStandardDto> chargeStandardList=chargeStandardService.getChargeStandardByPage(gradeId,termType,majorId,majorFieldId,page);
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        JsonArray chargeStandardListJsonArray=gson.toJsonTree(chargeStandardList, List.class).getAsJsonArray();

        JsonObject resultJson=new JsonObject();
        resultJson.add("rows", chargeStandardListJsonArray);
        resultJson.addProperty("total", total);

        return resultJson.toString();

    }

    /**
     * 进入添加收费标准页面
     * @param model
     * @return
     */
    @RequestMapping("/toAddChargeStandard")
    public String toAddChargeStandard(Model model){
        List<Grade> gradeList=gradeService.getAllGrade();
        List<EnumerationValue> termTypeList= enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
        List<Major> majorList=majorService.getAllMajorInfo();

        model.addAttribute("gradeList",gradeList);
        model.addAttribute("termTypeList", termTypeList);
        model.addAttribute("majorList", majorList);
        return "fin/newChargeStandard";
    }

    /**
     * 添加收费标准
     * @param chargeStandard
     * @return
     */
    @ResponseBody
    @RequestMapping("/addChargeStandard")
    public String addChargeStandard(ChargeStandard chargeStandard){
        JsonObject resultJo = new JsonObject();
        logger.info(new Gson().toJson(chargeStandard));
        resultJo.addProperty("result", chargeStandardService.addChargeStandard(chargeStandard));
        return resultJo.toString();

    }

    /**
     * 进入编辑收费标准页面
     * @param model
     * @return
     */
    @RequestMapping("/toEditChargeStandard")
    public String toEditChargeStandard(Integer id,Model model){
        model.addAttribute("id", id);
        return "fin/editChargeStandard";
    }

    /**
     * 编辑收费标准信息
     * @param chargeStandard
     * @return
     */
    @ResponseBody
    @RequestMapping("/editChargeStandard")
    public String editChargeStandard(ChargeStandard chargeStandard){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("result", chargeStandardService.updateChargeStandard(chargeStandard));
        return jsonObject.toString();
    }

    /**
     * 删除收费标准
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteChargeStandard")
    public String deleteChargeStandard(Integer id){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("success", chargeStandardService.deleteChargeStandardById(id));
        return jsonObject.toString();
    }

    /**
     * 根据收费标准id获取班级信息，并返回json格式的字符串
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getChargeStandardByChargeStandardId")
    public String getChargeStandard(Integer id){
        ChargeStandardDto chargeStandardDto=chargeStandardService.findChargeStandardByChargeStandardId(id);
        JsonObject resultJson = new JsonObject();
        Gson gson = new Gson();
        resultJson.add("chargeStandard", gson.toJsonTree(chargeStandardDto));
        return resultJson.toString();
    }
}
