package com.dkt.school.system.controller;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.system.model.SysConfig;
import com.dkt.school.system.service.SysConfigService;
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
 * Created with com.dkt.school.system.controller by Harry on 2015/8/18 17:06.
 */

@Controller
@RequestMapping("/sys")
public class SysConfigController {

    public final static Logger logger = LoggerFactory
            .getLogger(SysConfigController.class);

    private SysConfigService sysConfigService;

    public SysConfigService getSysConfigService() {
        return sysConfigService;
    }

    @Autowired
    public void setSysConfigService(SysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    /**
     * 进入查看所有系统设置列表的页面
     * @param model
     * @return
     */
    @RequestMapping("/toGetSysConfigList")
    public String toGetSysConfigList(Model model){
        return "user/sysConfigList";
    }

    /**
     * 根据条件分页查询所有系统设置
     * @param name
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSysConfigList")
    public String getSysConfigList(String name,PaginationCustom page){
        int total=sysConfigService.getSysConfigCount(name);
        // 设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);
        //根据条件查找操作，返回一个list集合
        List<SysConfig> sysConfigList=sysConfigService.getSysConfigByPage(name,page);
        //自定义json的日期格式
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        JsonArray sysConfigListJsonArray=gson.toJsonTree(sysConfigList, List.class).getAsJsonArray();

        JsonObject resultJson=new JsonObject();
        resultJson.add("rows",  sysConfigListJsonArray);
        resultJson.addProperty("total", total);
        return resultJson.toString();
    }
}
