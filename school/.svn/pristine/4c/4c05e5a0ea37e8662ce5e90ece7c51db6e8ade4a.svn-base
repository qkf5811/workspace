package com.dkt.school.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Limitation;
import com.dkt.school.edu.dao.CourseSearchCustomMapper;
import com.dkt.school.edu.dto.CourseSearchConditionDto;
import com.dkt.school.edu.dto.CourseSearchDto;
import com.dkt.school.edu.service.CourseSearchService;
import com.dkt.school.sch.dao.StudyYearMapper;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.stu.model.Clazz;

/**
 * 这个实现用于开课查询
 * @author JanGin Chan
 * 2015年8月20日
 */
@Service
public class CourseSearchServiceImpl implements CourseSearchService {

	@Autowired
	private CourseSearchCustomMapper cscMapper;

	@Override
	public List<CourseSearchDto> findCourseByCondition(
			CourseSearchConditionDto condition, Limitation limit) {
		List<CourseSearchDto> list =  cscMapper.findCourseByCondition(condition, limit);
		if (list != null){
			for (CourseSearchDto dto : list){
				if ( 32001 == dto.getTermType()){
					dto.setTermStr("第一学期");
				} if (32002 == dto.getTermType()){
					dto.setTermStr("第二学期");
				} if (33001 == dto.getCourseType()){
					dto.setCourseTypeStr("必修");
				} if (33002 == dto.getCourseType()){
					dto.setCourseTypeStr("选修");
				} if (34001 == dto.getExamType()){
					dto.setExamTypeStr("考试");
				} if (34002 == dto.getExamType()){
					dto.setExamTypeStr("考查");
				} if (35001 == dto.getScoreType()){
					dto.setScoreTypeStr("百分制");
				} if (35002 == dto.getScoreType()){
					dto.setScoreTypeStr("等级制");
				}
				switch(dto.getSectionType()){
				case 37001:
					dto.setSectionTypeStr("第一节");
					break;
				case 37002:
					dto.setSectionTypeStr("第二节");
					break;
				case 37003:
					dto.setSectionTypeStr("第三节");
					break;
				case 37004:
					dto.setSectionTypeStr("第四节");
					break;
				case 37005:
					dto.setSectionTypeStr("第五节");
					break;
				case 37006:
					dto.setSectionTypeStr("第六节");
					break;
				case 37007:
					dto.setSectionTypeStr("第七节");
					break;
				}
				
				switch(dto.getWeekday()){
				case 36001:
					dto.setWeekdayStr("星期一");
				case 36002:
					dto.setWeekdayStr("星期二");
				case 36003:
					dto.setWeekdayStr("星期三");
				case 36004:
					dto.setWeekdayStr("星期四");
				case 36005:
					dto.setWeekdayStr("星期五");
				}
			}
		}
		return list;
	}

	@Override
	public Integer findCourseCountByCondition(CourseSearchConditionDto condition) {
		return cscMapper.findCourseCountByCondition(condition);
	}

	@Override
	public List<Clazz> getClassByGrade(Integer gradeId) {
		return cscMapper.getClassByGrade(gradeId);
	}

	@Override
	public List<MajorField> getFieldByMajor(Integer majorId) {
		return cscMapper.getFieldByMajor(majorId);
	}

}
