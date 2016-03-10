package com.dkt.school.fin.dao;

import com.dkt.school.fin.model.NewStudentPayment;
import com.dkt.school.fin.model.NewStudentPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewStudentPaymentMapper {
    int countByExample(NewStudentPaymentExample example);

    int deleteByExample(NewStudentPaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewStudentPayment record);

    int insertSelective(NewStudentPayment record);

    List<NewStudentPayment> selectByExample(NewStudentPaymentExample example);

    NewStudentPayment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewStudentPayment record, @Param("example") NewStudentPaymentExample example);

    int updateByExample(@Param("record") NewStudentPayment record, @Param("example") NewStudentPaymentExample example);

    int updateByPrimaryKeySelective(NewStudentPayment record);

    int updateByPrimaryKey(NewStudentPayment record);
}