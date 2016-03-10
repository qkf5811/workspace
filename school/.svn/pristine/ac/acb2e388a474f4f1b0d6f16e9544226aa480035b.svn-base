package com.dkt.school.system.dao;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.system.dto.SysLogDto;
import com.dkt.school.system.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with com.dkt.school.system.dao by Harry on 2015/5/18 16:57.
 */
public interface SysLogCustomMapper extends SysLogMapper {

    /**
     *根据条件查询系统操作记录的数量，返回一个Integer类型
     * @param startTime
     * @param stopTime
     * @return
     */
    public Integer countBySearch(@Param("operType") Integer operType,@Param("userName") String userName,@Param("startTime") String startTime,@Param("stopTime") String stopTime);

    /**
     * 根据条件模糊分页查询系统操作记录信息
     * @param userName
     * @param startTime
     * @param stopTime
     * @param limit
     * @return
     */
    public List<SysLogDto> selectByLimit(@Param("operType") Integer operType,@Param("userName") String userName,@Param("startTime") String startTime,@Param("stopTime") String stopTime,@Param("limit") Limitation limit);
}
