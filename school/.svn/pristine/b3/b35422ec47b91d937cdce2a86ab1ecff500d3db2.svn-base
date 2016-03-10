package com.dkt.school.sch.service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.model.StudyYear;

import java.util.List;

/**
 * Created with com.dkt.school.sch.service by Harry on 2015/7/21 11:41.
 */
public interface StudyYearService {


    /**
     * 根据学年信息条件查询，并返回查询数目
     * @return
     */
    public Integer getStudyYearCount();

    /**
     * 根据学年信息条件分页查询
     * @param page
     * @return
     */
    public List<StudyYear> getStudyYearByPage(
                                        Pagination page);

    /**
     * 添加学年信息
     * @param studyYear
     * @return
     */
    public int addStudyYear(StudyYear studyYear);

    /**
     * 更新学年信息
     * @param studyYear
     * @return
     */
    public int updateStudyYear(StudyYear studyYear);

    /**
     * 删除学年信息
     * @param id
     * @return
     */
    public int deleteStudyYearById(Integer id);

    /**
     * 根据学年id设置当前学年
     * @param id
     * @param termType
     * @return
     */
    public int changeDefaultStudyYearById(Integer id,Integer termType);
    
    /**
     * 获得所有的学年填充到下拉框
     * @return
     */
    public List<StudyYear> getAllStudyYear();

    /**
     * 获取当前学年名称
     * @return
     */
    public String getCurrentStudyYear();

    /**
     * 获取当前学期的id
     * @return
     */
    public String getCurrentTermType();
}
