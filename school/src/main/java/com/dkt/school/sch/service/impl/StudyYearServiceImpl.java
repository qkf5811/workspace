package com.dkt.school.sch.service.impl;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.sch.dao.StudyYearCustomMapper;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.StudyYearService;
import com.dkt.school.system.dao.SysConfigCustomMapper;
import com.dkt.school.system.model.SysConfig;
import com.dkt.school.system.model.SysConfigExample;
import com.dkt.school.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with com.dkt.school.sch.service.impl by Harry on 2015/7/21 11:41.
 */

@Service
public class StudyYearServiceImpl  implements StudyYearService{

    private StudyYearCustomMapper studyYearCustomMapper;

    private SysConfigCustomMapper sysConfigCustomMapper;

    public StudyYearCustomMapper getStudyYearCustomMapper() {
        return studyYearCustomMapper;
    }

    @Autowired
    public void setStudyYearCustomMapper(StudyYearCustomMapper studyYearCustomMapper) {
        this.studyYearCustomMapper = studyYearCustomMapper;
    }

    public SysConfigCustomMapper getSysConfigCustomMapper() {
        return sysConfigCustomMapper;
    }

    @Autowired
    public void setSysConfigCustomMapper(SysConfigCustomMapper sysConfigCustomMapper) {
        this.sysConfigCustomMapper = sysConfigCustomMapper;
    }

    @Override
    public Integer getStudyYearCount() {
        return studyYearCustomMapper.countBySearch();
    }

    @Override
    public List<StudyYear> getStudyYearByPage(Pagination page) {
        return studyYearCustomMapper.selectByLimit(page.getLimitation());
    }

    @Override
    public int addStudyYear(StudyYear studyYear) {
        return studyYearCustomMapper.insert(studyYear);
    }

    @Override
    public int updateStudyYear(StudyYear studyYear) {
        return studyYearCustomMapper.updateByPrimaryKey(studyYear);
    }

    @Override
    public int deleteStudyYearById(Integer id) {
        return studyYearCustomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int changeDefaultStudyYearById(Integer id,Integer termType) {

        SysConfigExample sysConfigExample=new SysConfigExample();
        SysConfigExample.Criteria criteria=sysConfigExample.createCriteria();
        criteria.andCodeEqualTo("study_year");
        SysConfig sysConfig=sysConfigCustomMapper.selectByExample(sysConfigExample).get(0);
        sysConfig.setDefaultValue(sysConfig.getValue());
        sysConfig.setValue(id.toString());

        SysConfigExample sysConfigTermExample=new SysConfigExample();
        SysConfigExample.Criteria termCriteria=sysConfigTermExample.createCriteria();
        termCriteria.andCodeEqualTo("term_type");
        SysConfig sysTermConfig=sysConfigCustomMapper.selectByExample(sysConfigTermExample).get(0);
        sysTermConfig.setDefaultValue(sysTermConfig.getValue());
        sysTermConfig.setValue(termType.toString());


        sysConfigCustomMapper.updateByPrimaryKey(sysConfig);

        return sysConfigCustomMapper.updateByPrimaryKey(sysTermConfig);
    }

	@Override
	public List<StudyYear> getAllStudyYear() {
		
		return studyYearCustomMapper.getAllStudyYear();
	}

    @Override
    public String getCurrentStudyYear() {
        SysConfigExample sysConfigExample=new SysConfigExample();
        SysConfigExample.Criteria criteria=sysConfigExample.createCriteria();
        criteria.andCodeEqualTo("study_year");
        SysConfig sysConfig=sysConfigCustomMapper.selectByExample(sysConfigExample).get(0);
        StudyYear studyYear=studyYearCustomMapper.selectByPrimaryKey(Integer.parseInt(sysConfig.getValue()));
        return studyYear.getName();
    }

    @Override
    public String getCurrentTermType() {
        SysConfigExample sysConfigTermExample=new SysConfigExample();
        SysConfigExample.Criteria termCriteria=sysConfigTermExample.createCriteria();
        termCriteria.andCodeEqualTo("term_type");
        SysConfig sysTermConfig=sysConfigCustomMapper.selectByExample(sysConfigTermExample).get(0);

        return sysTermConfig.getValue();
    }
}
