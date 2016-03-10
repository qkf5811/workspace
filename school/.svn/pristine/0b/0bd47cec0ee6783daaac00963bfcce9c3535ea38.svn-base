package com.dkt.school.apv.dao;

import com.dkt.school.apv.model.ApprovalNode;
import com.dkt.school.apv.model.ApprovalNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApprovalNodeMapper {
    int countByExample(ApprovalNodeExample example);

    int deleteByExample(ApprovalNodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApprovalNode record);

    int insertSelective(ApprovalNode record);

    List<ApprovalNode> selectByExample(ApprovalNodeExample example);

    ApprovalNode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApprovalNode record, @Param("example") ApprovalNodeExample example);

    int updateByExample(@Param("record") ApprovalNode record, @Param("example") ApprovalNodeExample example);

    int updateByPrimaryKeySelective(ApprovalNode record);

    int updateByPrimaryKey(ApprovalNode record);
}