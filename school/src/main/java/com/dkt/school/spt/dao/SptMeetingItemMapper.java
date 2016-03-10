package com.dkt.school.spt.dao;

import com.dkt.school.spt.model.SptMeetingItem;

public interface SptMeetingItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SptMeetingItem record);

    int insertSelective(SptMeetingItem record);

    SptMeetingItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SptMeetingItem record);

    int updateByPrimaryKey(SptMeetingItem record);
}