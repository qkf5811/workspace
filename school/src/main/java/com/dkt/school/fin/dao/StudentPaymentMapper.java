package com.dkt.school.fin.dao;

import com.dkt.school.fin.model.StudentPayment;
import com.dkt.school.fin.model.StudentPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentPaymentMapper {
    int countByExample(StudentPaymentExample example);

    int deleteByExample(StudentPaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentPayment record);

    int insertSelective(StudentPayment record);

    List<StudentPayment> selectByExample(StudentPaymentExample example);

    StudentPayment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentPayment record, @Param("example") StudentPaymentExample example);

    int updateByExample(@Param("record") StudentPayment record, @Param("example") StudentPaymentExample example);

    int updateByPrimaryKeySelective(StudentPayment record);

    int updateByPrimaryKey(StudentPayment record);
}