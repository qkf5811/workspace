package com.dkt.school.pe.dao;

import com.dkt.school.pe.model.PeWorkTask;

public interface PeWorkTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeWorkTask record);

    int insertSelective(PeWorkTask record);

    PeWorkTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeWorkTask record);

    int updateByPrimaryKey(PeWorkTask record);
}