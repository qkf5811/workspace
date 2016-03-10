package com.dkt.school.sch.dao;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.sch.dto.StudyYearDto;
import com.dkt.school.sch.model.StudyYear;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with com.dkt.school.sch.dao by Harry on 2015/7/21 11:29.
 */
public interface StudyYearCustomMapper extends StudyYearMapper{

    /**
     * 查询学年信息的数量，返回一个Integer类型
     * @return
     */
    public Integer countBySearch();

    /**
     * 分页查询学年信息
     * @param limit
     * @return
     */
    public List<StudyYear> selectByLimit(
            @Param("limit") Limitation limit);


    public Integer findStudyYearIdByStudyYearName(@Param("studyYear") String studyYear);
    
    /**
     * 获取所有的学年填充到下拉框中
     * @return
     */
    public List<StudyYear> getAllStudyYear();
}
