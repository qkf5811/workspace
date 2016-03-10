package com.dkt.school.edu.dao;

import com.dkt.school.edu.dto.CourseScoreByStudentDto;
import com.dkt.school.edu.dto.StudentInfoDto;
import com.dkt.school.edu.model.CourseScore;
import com.dkt.school.edu.model.CourseScoreExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseScoreMapper {
    int countByExample(CourseScoreExample example);

    int deleteByExample(CourseScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseScore record);

    int insertSelective(CourseScore record);

    List<CourseScore> selectByExample(CourseScoreExample example);

    CourseScore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseScore record, @Param("example") CourseScoreExample example);

    int updateByExample(@Param("record") CourseScore record, @Param("example") CourseScoreExample example);

    int updateByPrimaryKeySelective(CourseScore record);

    int updateByPrimaryKey(CourseScore record);
   
    public List<CourseScoreByStudentDto> getStuCourseScoreList(@Param("studentCode")String studentCode);

	public StudentInfoDto getStudentInfo(@Param("studentCode")String studentCode);

	public List<Map<String, Object>> getStudyYearAndTermName(@Param("studentCode")String studentCode);

	public Integer isExistStudentCode(@Param("studentCode")String studentCode);

	public List<CourseScoreByStudentDto> getScoreByCourse(@Param("studentCode")String studentCode,
			@Param("studyYear")String studyYear,@Param("termName") String termName,
			@Param("courseCode") String courseCode, @Param("className")String className);

	public HashMap<String, Object> getscoreRegion(@Param("studentCode")String studentCode,
			@Param("studyYear")String studyYear,@Param("termName") String termName,
			@Param("courseCode") String courseCode, @Param("className")String className);
}