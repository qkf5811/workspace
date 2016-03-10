package com.dkt.school.edu.service;

import java.util.List;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CoursePlanDto;

public interface CoursePlanTotalInfoService {
	
    /**
     * 加载/查询的到符合条件的所有课程计划记录
     * @param coursePlanInfo
     * @param page
     * @return
     */
	public List<CoursePlanDto> selectTotalInfoOfCoursePlan(CoursePlanDto coursePlanInfo,PaginationCustom page);
	
	
	/**
	 * 得到所有课程计划的记录数
	 * @param coursePlanInfo
	 * @return
	 */
	public int selectCountOfCoursePlan(CoursePlanDto coursePlanInfo);
	
	//振佳
	//根据学期类型找到所有的课程班级信息
	public List<CoursePlanDto> findAllByTermType(Integer termType);

}
