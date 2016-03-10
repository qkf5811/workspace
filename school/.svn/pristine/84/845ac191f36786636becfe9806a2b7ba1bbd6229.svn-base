package com.dkt.school.system.service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.system.dto.SysLogDto;
import com.dkt.school.system.model.SysLog;

import java.util.List;

/**
 * Created with com.dkt.school.system.service by Harry on 2015/5/18 15:48.
 */
public interface SysLogService {

    /**
     * 添加系统操作日志
     * @param sysLog
     * @return
     */
    public int addSysLog(SysLog sysLog);

    /**
     * 根据条件查询系统操作记录，并返回查询数目
     * @param userName
     * @param startTime
     * @param stopTime
     * @return
     */
    public Integer getSysLogCount(Integer operType,String userName,String startTime,String stopTime);

    /**
     * 根据条件模糊分页查询系统操作日志
     * @param userName
     * @param startTime
     * @param stopTime
     * @param page
     * @return
     */
    public List<SysLogDto> getSysLogsByPage(Integer operType,String userName,String startTime,String stopTime,Pagination page);
}
