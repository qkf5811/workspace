package com.dkt.school.fin.service.impl;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.fin.dao.ChargeStandardCustomMapper;
import com.dkt.school.fin.dao.ChargeStandardMapper;
import com.dkt.school.fin.dto.ChargeStandardDto;
import com.dkt.school.fin.model.ChargeStandard;
import com.dkt.school.fin.model.ChargeStandardExample;
import com.dkt.school.fin.service.ChargeStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with com.dkt.school.fin.service.impl by Harry on 2015/8/27 11:54.
 */

@Service
public class ChargeStandardServiceImpl implements ChargeStandardService{

    private ChargeStandardCustomMapper chargeStandardCustomMapper;

    public ChargeStandardCustomMapper getChargeStandardCustomMapper() {
        return chargeStandardCustomMapper;
    }

    @Autowired
    public void setChargeStandardCustomMapper(ChargeStandardCustomMapper chargeStandardCustomMapper) {
        this.chargeStandardCustomMapper = chargeStandardCustomMapper;
    }

    @Override
    public int getChargeStandardCount(Integer gradeId, Integer termType, Integer majorId, Integer majorFieldId) {
        return chargeStandardCustomMapper.countBySearch(gradeId,termType,majorId,majorFieldId);
    }

    @Override
    public List<ChargeStandardDto> getChargeStandardByPage(Integer gradeId, Integer termType, Integer majorId, Integer majorFieldId, Pagination page) {
        return chargeStandardCustomMapper.selectByLimit(gradeId, termType, majorId, majorFieldId, page.getLimitation());
    }

    @Override
    public int addChargeStandard(ChargeStandard chargeStandard) {

        ChargeStandardExample chargeStandardExample=new ChargeStandardExample();
        ChargeStandardExample.Criteria criteria=chargeStandardExample.createCriteria();
        criteria.andGradeIdEqualTo(chargeStandard.getGradeId()).andTermTypeEqualTo(chargeStandard.getTermType()).andMajorIdEqualTo(chargeStandard.getMajorId()).andFieldIdEqualTo(chargeStandard.getFieldId());
        if(chargeStandardCustomMapper.countByExample(chargeStandardExample)>0){
            return -2;
        }else{
            return chargeStandardCustomMapper.insert(chargeStandard);
        }


    }

    @Override
    public ChargeStandardDto findChargeStandardByChargeStandardId(Integer id) {
        return chargeStandardCustomMapper.selectChargeStandardById(id);
    }

    @Override
    public int updateChargeStandard(ChargeStandard chargeStandard) {
        return chargeStandardCustomMapper.updateByPrimaryKey(chargeStandard);
    }

    @Override
    public int deleteChargeStandardById(Integer id) {
        return chargeStandardCustomMapper.deleteByPrimaryKey(id);
    }
}
