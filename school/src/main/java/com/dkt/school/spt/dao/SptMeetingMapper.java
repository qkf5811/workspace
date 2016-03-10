package com.dkt.school.spt.dao;

import com.dkt.school.spt.model.SptMeeting;

public interface SptMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SptMeeting record);

    int insertSelective(SptMeeting record);

    SptMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SptMeeting record);

    int updateByPrimaryKey(SptMeeting record);
}