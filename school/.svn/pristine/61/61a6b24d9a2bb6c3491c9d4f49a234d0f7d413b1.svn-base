package com.dkt.school.fin.dao;

import com.dkt.school.fin.model.StudentAccount;
import com.dkt.school.fin.model.StudentAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentAccountMapper {
    int countByExample(StudentAccountExample example);

    int deleteByExample(StudentAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    List<StudentAccount> selectByExample(StudentAccountExample example);

    StudentAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByExample(@Param("record") StudentAccount record, @Param("example") StudentAccountExample example);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);
}