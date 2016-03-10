package com.dkt.school.system.dao;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.system.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with com.dkt.school.system.dao by Harry on 2015/8/18 16:24.
 */
public interface SysConfigCustomMapper extends SysConfigMapper{

    /**
     *根据条件查询系统设置的数量，返回一个int类型
     * @param name
     * @return
     */
    public int countBySearch(@Param("name") String name);

    /**
     * 根据条件模糊分页查询系统设置信息
     * @param name
     * @param limit
     * @return
     */
    public List<SysConfig> selectByLimit(@Param("name") String name,@Param("limit")Limitation limit);
}
