package com.dkt.school.system.service.impl;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.system.dao.SysConfigCustomMapper;
import com.dkt.school.system.model.SysConfig;
import com.dkt.school.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with com.dkt.school.system.service.impl by Harry on 2015/8/18 16:53.
 */

@Service
public class SysConfigServiceImpl implements SysConfigService{

    private SysConfigCustomMapper sysConfigCustomMapper;

    public SysConfigCustomMapper getSysConfigCustomMapper() {
        return sysConfigCustomMapper;
    }

    @Autowired
    public void setSysConfigCustomMapper(SysConfigCustomMapper sysConfigCustomMapper) {
        this.sysConfigCustomMapper = sysConfigCustomMapper;
    }

    @Override
    public int getSysConfigCount(String name) {
        return sysConfigCustomMapper.countBySearch(name);
    }

    @Override
    public List<SysConfig> getSysConfigByPage(String name, Pagination page) {
        return sysConfigCustomMapper.selectByLimit(name,page.getLimitation());
    }
}
