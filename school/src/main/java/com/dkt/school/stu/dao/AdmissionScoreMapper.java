package com.dkt.school.stu.dao;

import com.dkt.school.stu.model.AdmissionScore;
import com.dkt.school.stu.model.AdmissionScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmissionScoreMapper {
    int countByExample(AdmissionScoreExample example);

    int deleteByExample(AdmissionScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdmissionScore record);

    int insertSelective(AdmissionScore record);

    List<AdmissionScore> selectByExample(AdmissionScoreExample example);

    AdmissionScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdmissionScore record, @Param("example") AdmissionScoreExample example);

    int updateByExample(@Param("record") AdmissionScore record, @Param("example") AdmissionScoreExample example);

    int updateByPrimaryKeySelective(AdmissionScore record);

    int updateByPrimaryKey(AdmissionScore record);
}