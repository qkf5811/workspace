package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.BuyBatch;
import com.dkt.school.equ.model.BuyBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyBatchMapper {
    int countByExample(BuyBatchExample example);

    int deleteByExample(BuyBatchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuyBatch record);

    int insertSelective(BuyBatch record);

    List<BuyBatch> selectByExample(BuyBatchExample example);

    BuyBatch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuyBatch record, @Param("example") BuyBatchExample example);

    int updateByExample(@Param("record") BuyBatch record, @Param("example") BuyBatchExample example);

    int updateByPrimaryKeySelective(BuyBatch record);

    int updateByPrimaryKey(BuyBatch record);
}