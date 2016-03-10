package com.dkt.school.fin.service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.fin.dto.ChargeStandardDto;
import com.dkt.school.fin.model.ChargeStandard;

import java.util.List;

/**
 * Created with com.dkt.school.fin.service by Harry on 2015/8/27 11:53.
 */
public interface ChargeStandardService {

    /**
     * 根据收费标准条件查询，并返回查询数目
     * @param gradeId
     * @param termType
     * @param majorId
     * @param majorFieldId
     * @return
     */
    public int getChargeStandardCount(Integer gradeId,Integer termType,Integer majorId,Integer majorFieldId);

    /**
     * 根据收费标准条件分页查询
     * @param gradeId
     * @param termType
     * @param majorId
     * @param majorFieldId
     * @param page
     * @return
     */
    public List<ChargeStandardDto> getChargeStandardByPage(Integer gradeId,Integer termType,Integer majorId,Integer majorFieldId,Pagination page);

    /**
     * 添加收费标准
     * @param chargeStandard
     * @return
     */
    public int addChargeStandard(ChargeStandard chargeStandard);


    /**
     * 根据收费标准id获取收费标准
     * @param id
     * @return
     */
    public ChargeStandardDto findChargeStandardByChargeStandardId(Integer id);

    /**
     * 更新收费标准信息
     * @param chargeStandard
     * @return
     */
    public int updateChargeStandard(ChargeStandard chargeStandard);

    /**
     * 根据收费标准id删除收费标准
     * @param id
     * @return
     */
    public int deleteChargeStandardById(Integer id);
}
