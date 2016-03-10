package com.dkt.school.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.util.DateUtil;
import com.dkt.school.edu.dao.CourseScoreCustomMapper;
import com.dkt.school.edu.dao.CourseScoreMapper;
import com.dkt.school.edu.dto.CourseCountDto;
import com.dkt.school.edu.dto.CourseScoreByStudentDto;
import com.dkt.school.edu.dto.CourseScoreDto;
import com.dkt.school.edu.dto.StudentInfoDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.service.CourseScoreService;
import com.dkt.school.sch.dao.StudyYearCustomMapper;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.stu.model.Student;

@Service
public class CourseScoreServiceImpl implements CourseScoreService{
	@Autowired
	private CourseScoreCustomMapper courseScoreCustomMapper;
	
	@Autowired
	private StudyYearCustomMapper studyYearCustomMapper;
		
	@Autowired
	private CourseScoreMapper courseScoreMapper;
	//取得所有的学年
	@Override
	public List<StudyYear> getAllStudyYear() {
		// TODO Auto-generated method stub
		return studyYearCustomMapper.getAllStudyYear();
	}
	@Override
	public List<Course> getCourseByTeacherId(Integer classId,Integer teacherId) {
		return courseScoreCustomMapper.getCourseByTeacherId(classId, teacherId);
	}
	
	@Override
	public List<Student> getStuToScoreInput(Integer courseId){
		return courseScoreCustomMapper.getStuToScoreInput(courseId);
	}
	@Override
	public int addCourseScores(String[] numberboxs,String[] examScore,String[] totalScore,Integer[] examNature,Integer[] studentId,Integer teachCourseId,String scoreType) {
		List<CourseScoreDto> list = new ArrayList<CourseScoreDto>();
		String inputTime = DateUtil.getDateTime();
		CourseScoreDto cs = null;
		if("35001".equals(scoreType)) {
			for(int i = 0 ;i < numberboxs.length;i++) {
//				if(38003 != examNature[i]) {
					cs = new CourseScoreDto();
					cs.setStudentId(studentId[i]);
					cs.setTeachCourseId(teachCourseId);
					cs.setHundredExamScore(Float.parseFloat(examScore[i]));
					cs.setHundredUsualScore(Float.parseFloat(numberboxs[i]));
					cs.setHundredTotalScore(Float.parseFloat(totalScore[i]));
					cs.setExamNatureType(examNature[i]);
					cs.setGradeExamScore(0);
					cs.setGradeTotalScore(0);
					cs.setGradeUsualScore(0);
					cs.setInputTimeStr(inputTime);
					list.add(cs);
//				}
				
			}
		}else {
			for(int i = 0 ;i < numberboxs.length;i++) {
//				if(38003 != examNature[i]) {
					cs = new CourseScoreDto();
					cs.setStudentId(studentId[i]);
					cs.setTeachCourseId(teachCourseId);
					cs.setHundredExamScore(0f);
					cs.setHundredUsualScore(0f);
					cs.setHundredTotalScore(0f);
					cs.setExamNatureType(examNature[i]);
					cs.setGradeExamScore(Integer.parseInt(examScore[i]));
					cs.setGradeTotalScore(Integer.parseInt(totalScore[i]));
					cs.setGradeUsualScore(Integer.parseInt(numberboxs[i]));
					cs.setInputTimeStr(inputTime);
					list.add(cs);
//				}
				
			}
		}
		if(list.size() > 0)
			return courseScoreCustomMapper.addCourseScores(list);
		else 
			return 0;
		
	}
	@Override
	public List<Integer> getTeaCourseId(Integer studyYearId, Integer termType,
			String courseId, String examDate, String scoreType,
			Integer teacherId, Integer classId) {
		return courseScoreCustomMapper.getTeaCourseId(studyYearId,termType,courseId,examDate,scoreType,teacherId,classId);
	}
	@Override
	public List<TeachCourseDto> getTeacherCourseList(Integer teacherId,TeachCourseDto dto,Pagination page) {
		return courseScoreCustomMapper.getTeacherCourseList(teacherId,dto,page.getLimitation());
	}
	@Override
	public int updateTeachCourse(Integer courseId, String examDate,
			String scoreType, Float usualScoreRatio,String dateTime) {
		return courseScoreCustomMapper.updateTeachCourse(courseId,examDate,scoreType,usualScoreRatio,dateTime);
	}
	@Override
	public Map<String,CourseCountDto> getCourseCountList(TeachCourseDto dto) {
		List<CourseScoreDto> csList  = courseScoreCustomMapper.getCourseCountList(dto);
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,CourseCountDto> linkMap = new LinkedHashMap<String,CourseCountDto>();
		String courseName = "课程";
		int sum = 0;
		double avgScore = 0d;
		double sumScore = 0d;
		CourseCountDto cc = null;
		linkMap.put(courseName, new CourseCountDto());
		if(csList == null || csList.size() == 0) {
			dto.setTermType(0);
			dto.setCoursePlanId(sum);
			return null;
		}
		for(CourseScoreDto cs : csList) {
			if(map.containsKey(cs.getName())) {
				map.put(cs.getName(), map.get(cs.getName()) + 1) ;
			}else {
				map.put(cs.getName(), 1);
				cc = new CourseCountDto();
				linkMap.put(cs.getName(), cc);
			}
			
		}
		CourseCountDto ccdto = linkMap.get(courseName);
		for(CourseScoreDto cs : csList) {
			if(cs.getHundredTotalScore() == null || cs.getGradeTotalScore() == null) {
				continue;
			}
			if("35001".equals(dto.getScoreTypeStr())) {
				double totalScore = cs.getHundredTotalScore() * 10;
				
				if(linkMap.containsKey(cs.getName())) {
					CourseCountDto newcc = linkMap.get(cs.getName());
					if(totalScore < 600) {
						newcc.setInt0(newcc.getInt0() + 1);
						ccdto.setInt0(ccdto.getInt0() + 1);
					}else if(totalScore >= 600 && totalScore < 700){
						newcc.setInt1(newcc.getInt1() + 1);
						ccdto.setInt1(ccdto.getInt1() + 1);
					}else if(totalScore >= 700 && totalScore < 800) {
						newcc.setInt2(newcc.getInt2() + 1);
						ccdto.setInt2(ccdto.getInt2() + 1);
					}else if(totalScore >= 800 && totalScore < 900) {
						newcc.setInt3(newcc.getInt3() + 1);
						ccdto.setInt3(ccdto.getInt3() + 1);
					}else if(totalScore >= 900 && totalScore <= 1000) {
						newcc.setInt4(newcc.getInt4() + 1);
						ccdto.setInt4(ccdto.getInt4() + 1);
					}
					
					newcc.setSumScore(newcc.getSumScore() + totalScore);
					newcc.setSum(newcc.getSum() + 1);
				}
				
				sumScore += totalScore;
			}else {
				int gradeTotal = cs.getGradeTotalScore();
				if(linkMap.containsKey(cs.getName())) {
					CourseCountDto newcc = linkMap.get(cs.getName());
					switch (gradeTotal) {
					case 40001:
						newcc.setInt0(newcc.getInt0() + 1);
						ccdto.setInt0(ccdto.getInt0() + 1);
						break;
					case 40002:
						newcc.setInt1(newcc.getInt1() + 1);
						ccdto.setInt1(ccdto.getInt1() + 1);
						break;
					case 40003:
						newcc.setInt2(newcc.getInt2() + 1);
						ccdto.setInt2(ccdto.getInt2() + 1);
						break;
					case 40004:
						newcc.setInt3(newcc.getInt3() + 1);
						ccdto.setInt3(ccdto.getInt3() + 1);
						break;
					case 40005:
						newcc.setInt4(newcc.getInt4() + 1);
						ccdto.setInt4(ccdto.getInt4() + 1);
						break;
					default:
						break;
					}
					newcc.setSum(newcc.getSum() + 1);
				}
				
			}
			
			sum++;
		}
			
		map.put(courseName, sum);
		ccdto.setSum(sum);
		for(Map.Entry<String, CourseCountDto> entry:linkMap.entrySet()){
			if(map.containsKey(entry.getKey()) && entry.getValue().getSum() > 0) {
				CourseCountDto newcc = entry.getValue();
				newcc.setDouble0((double)newcc.getInt0() / newcc.getSum());
				newcc.setDouble1((double)newcc.getInt1() / newcc.getSum());
				newcc.setDouble2((double)newcc.getInt2() / newcc.getSum());
				newcc.setDouble3((double)newcc.getInt3() / newcc.getSum());
				newcc.setDouble4((double)newcc.getInt4() / newcc.getSum());
				newcc.setAvg(newcc.getSumScore() / ( newcc.getSum() * 10));
//				newcc.setSum(map.get(entry.getKey()));
			}
		}   
		avgScore = sumScore / ((sum  > 0 ? sum : 1) * 10);
		ccdto.setAvg(Math.round(avgScore*100) * 0.01d);
		dto.setTermType(csList.size());
		dto.setCoursePlanId(sum);
		return linkMap;
	}
	
	
	@Override
	public List<CourseScoreByStudentDto> getStuCourseScoreList(
			String studentCode) {		
		return courseScoreMapper.getStuCourseScoreList(studentCode);
	}
	
	@Override
	public StudentInfoDto getStudentInfo(String studentCode) {
		
		return courseScoreMapper.getStudentInfo(studentCode);
	}
	@Override
	public List<Map<String, Object>> getStudyYearAndTermName(String studentCode) {
		
		return courseScoreMapper.getStudyYearAndTermName(studentCode);
	}
	@Override
	public Integer isExistStudentCode(String studentCode) {
		return courseScoreMapper.isExistStudentCode(studentCode);			
	}
	@Override
	public List<CourseScoreByStudentDto> getScoreByCourse(String studentCode,String studyYear, String termName,
			String courseCode, String className) {
			
		return courseScoreMapper.getScoreByCourse(studentCode,studyYear, termName, courseCode, className);
	}
	@Override
	public HashMap<String,Object> getscoreRegion(String studentCode, String studyYear, String termName,
			String courseCode, String className) {
		return courseScoreMapper.getscoreRegion(studentCode,studyYear, termName, courseCode, className);
		
	}
	
}
