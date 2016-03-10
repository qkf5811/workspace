package com.dkt.school.fin.dao;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.fin.dto.ChargeStandardDto;
import com.dkt.school.fin.model.ChargeStandard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with com.dkt.school.fin.dao by Harry on 2015/8/27 12:00.
 */
public interface ChargeStandardCustomMapper extends ChargeStandardMapper {

    /**
     * 根据条件查询收费标准的数量，返回一个int类型
     * @param gradeId
     * @param termType
     * @param majorId
     * @param majorFieldId
     * @return
     */
    public int countBySearch(@Param("gradeId") Integer gradeId,@Param("termType") Integer termType,@Param("majorId") Integer majorId,@Param("majorFieldId") Integer majorFieldId);

    /**
     * 根据条件模糊分页查询收费标准
     * @param gradeId
     * @param termType
     * @param majorId
     * @param majorFieldId
     * @param limit
     * @return
     */
    public List<ChargeStandardDto> selectByLimit(@Param("gradeId") Integer gradeId,@Param("termType") Integer termType,@Param("majorId") Integer majorId,@Param("majorFieldId") Integer majorFieldId,@Param("limit")Limitation limit);


    /**
     * 根据收费标准id查询收费标准
     * @param id
     * @return
     */
    public ChargeStandardDto selectChargeStandardById(@Param("id") Integer id);

    /**
     * 
     * @Title: selectChargeStandardByMultiC
     * @author 赖继鹏
     * @Description: 根据学期类型、专业方向ID、年级ID获取收费标准
     * @param gradeId
     * @param termType
     * @param majorFieldId
     * @return     
     * @throws
     */
	public List<ChargeStandard> selectChargeStandardByMultiC(@Param("gradeId") Integer gradeId,
			@Param("termType") Integer termType, @Param("majorFieldId") Integer majorFieldId);
}
