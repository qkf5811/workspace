package com.dkt.school.system.service.impl;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.system.dao.SysLogCustomMapper;
import com.dkt.school.system.dto.SysLogDto;
import com.dkt.school.system.model.SysLog;
import com.dkt.school.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with com.dkt.school.system.service.impl by Harry on 2015/5/18 16:55.
 */

@Service
public class SysLogServiceImpl implements SysLogService {

    private SysLogCustomMapper sysLogMapper;

    public SysLogCustomMapper getSysLogMapper() {
        return sysLogMapper;
    }

    @Autowired
    public void setSysLogMapper(SysLogCustomMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

    @Override
    public int addSysLog(SysLog sysLog) {
        return sysLogMapper.insert(sysLog);
    }

    @Override
    public List<SysLogDto> getSysLogsByPage(Integer operType,String userName,String startTime,String stopTime, Pagination page) {
        return sysLogMapper.selectByLimit(operType,userName,startTime,stopTime,page.getLimitation());
    }

    @Override
    public Integer getSysLogCount(Integer operType,String userName,String startTime,String stopTime) {
        return sysLogMapper.countBySearch(operType,userName,startTime,stopTime);
    }
}
