package com.dkt.school.equ.dao;

import com.dkt.school.equ.model.BorrowApplication;
import com.dkt.school.equ.model.BorrowApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowApplicationMapper {
    int countByExample(BorrowApplicationExample example);

    int deleteByExample(BorrowApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowApplication record);

    int insertSelective(BorrowApplication record);

    List<BorrowApplication> selectByExample(BorrowApplicationExample example);

    BorrowApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowApplication record, @Param("example") BorrowApplicationExample example);

    int updateByExample(@Param("record") BorrowApplication record, @Param("example") BorrowApplicationExample example);

    int updateByPrimaryKeySelective(BorrowApplication record);

    int updateByPrimaryKey(BorrowApplication record);
}