package com.dkt.school.pe.dao;

import com.dkt.school.pe.model.PePersonInfo;

public interface PePersonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PePersonInfo record);

    int insertSelective(PePersonInfo record);

    PePersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PePersonInfo record);

    int updateByPrimaryKey(PePersonInfo record);
}