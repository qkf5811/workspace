package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.BuyDetail;
import com.dkt.school.equ.model.BuyDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyDetailMapper {
    int countByExample(BuyDetailExample example);

    int deleteByExample(BuyDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuyDetail record);

    int insertSelective(BuyDetail record);

    List<BuyDetail> selectByExample(BuyDetailExample example);

    BuyDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuyDetail record, @Param("example") BuyDetailExample example);

    int updateByExample(@Param("record") BuyDetail record, @Param("example") BuyDetailExample example);

    int updateByPrimaryKeySelective(BuyDetail record);

    int updateByPrimaryKey(BuyDetail record);
}