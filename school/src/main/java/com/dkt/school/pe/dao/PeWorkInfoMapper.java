package com.dkt.school.pe.dao;

import com.dkt.school.pe.model.PeWorkInfo;

public interface PeWorkInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeWorkInfo record);

    int insertSelective(PeWorkInfo record);

    PeWorkInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeWorkInfo record);

    int updateByPrimaryKey(PeWorkInfo record);
}