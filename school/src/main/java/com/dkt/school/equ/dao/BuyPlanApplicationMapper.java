package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.BuyPlanApplication;
import com.dkt.school.equ.model.BuyPlanApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyPlanApplicationMapper {
    int countByExample(BuyPlanApplicationExample example);

    int deleteByExample(BuyPlanApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuyPlanApplication record);

    int insertSelective(BuyPlanApplication record);

    List<BuyPlanApplication> selectByExample(BuyPlanApplicationExample example);

    BuyPlanApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuyPlanApplication record, @Param("example") BuyPlanApplicationExample example);

    int updateByExample(@Param("record") BuyPlanApplication record, @Param("example") BuyPlanApplicationExample example);

    int updateByPrimaryKeySelective(BuyPlanApplication record);

    int updateByPrimaryKey(BuyPlanApplication record);
}