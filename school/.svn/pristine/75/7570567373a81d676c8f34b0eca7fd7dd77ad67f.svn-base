package com.dkt.school.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.CourseScoreCustomMapper;
import com.dkt.school.edu.dao.TeachCourseCustomMapper;
import com.dkt.school.edu.dao.TeachTaskCustomMapper;
import com.dkt.school.edu.dto.CourseToQueryScoByHTDto;
import com.dkt.school.edu.model.CourseScore;
import com.dkt.school.edu.model.CourseScoreExample;
import com.dkt.school.edu.service.QueryScoreByHeadTeaService;
import com.dkt.school.stu.model.Student;
import com.dkt.school.system.dao.EnumerationValueCustomMapper;
import com.dkt.school.system.dao.SysConfigCustomMapper;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.model.SysConfig;
import com.dkt.school.system.model.SysConfigExample;
/**
 * 
 * <p>Title: QueryScoreByHeadTeaServiceImpl</p>
 * <p>Description: 用于处理班主任成绩查询的业务逻辑接口的实现类</p>
 * <p>Company: 江门市多科特科技发展有限公司</p> 
 * @author 赖继鹏
 * @date 2015年9月14日上午10:19:21
 *
 */

@Service
public class QueryScoreByHeadTeaServiceImpl implements
		QueryScoreByHeadTeaService {
	
	private TeachTaskCustomMapper teachTaskCustomMapper;
	
	private CourseScoreCustomMapper courseScoreCustomMapper;
	
	private EnumerationValueCustomMapper enumerationValueMapper;
	
	private TeachCourseCustomMapper teachCourseCustomMapper;
	
	private SysConfigCustomMapper sysConfigCustomMapper;
	
	

	public SysConfigCustomMapper getSysConfigCustomMapper() {
		return sysConfigCustomMapper;
	}
	@Autowired
	public void setSysConfigCustomMapper(SysConfigCustomMapper sysConfigCustomMapper) {
		this.sysConfigCustomMapper = sysConfigCustomMapper;
	}
	public TeachCourseCustomMapper getTeachCourseCustomMapper() {
		return teachCourseCustomMapper;
	}
	@Autowired
	public void setTeachCourseCustomMapper(
			TeachCourseCustomMapper teachCourseCustomMapper) {
		this.teachCourseCustomMapper = teachCourseCustomMapper;
	}
	public EnumerationValueCustomMapper getEnumerationValueMapper() {
		return enumerationValueMapper;
	}
	@Autowired
	public void setEnumerationValueMapper(
			EnumerationValueCustomMapper enumerationValueMapper) {
		this.enumerationValueMapper = enumerationValueMapper;
	}
	public CourseScoreCustomMapper getCourseScoreCustomMapper() {
		return courseScoreCustomMapper;
	}
	@Autowired
	public void setCourseScoreCustomMapper(
			CourseScoreCustomMapper courseScoreCustomMapper) {
		this.courseScoreCustomMapper = courseScoreCustomMapper;
	}
	public TeachTaskCustomMapper getTeachTaskCustomMapper() {
		return teachTaskCustomMapper;
	}
    @Autowired
	public void setTeachTaskCustomMapper(TeachTaskCustomMapper teachTaskCustomMapper) {
		this.teachTaskCustomMapper = teachTaskCustomMapper;
	}

	@Override
	public int selectCountOfCourseToQueryScoByHT(CourseToQueryScoByHTDto dto) {	
		return teachTaskCustomMapper.selectCountOfCourseToQueryScoByHT(dto);
	}

	@Override
	public List<CourseToQueryScoByHTDto> selectCourseToQueryScoByHT(
			CourseToQueryScoByHTDto dto, PaginationCustom page) {
		if (page==null) {
			return teachTaskCustomMapper.selectCourseToQueryScoByHT(dto,null);
		}
		return teachTaskCustomMapper.selectCourseToQueryScoByHT(dto,page.getLimitation());
	}
	
	/**
	 * 
	 * @Title: getCurrentStudyYear
	 * @author 赖继鹏
	 * @Description: 获取当前学年Id
	 * @return     
	 * @throws
	 */
	@Override
	public String getCurrentStudyYear(){
		SysConfigExample example=new SysConfigExample();
		example.createCriteria().andCodeEqualTo("study_year");
		List<SysConfig> sysConfigList= sysConfigCustomMapper.selectByExample(example);
		return sysConfigList.get(0).getValue();
	}
	
	/**
	 * 
	 * @Title: getCurrentTermType
	 * @author 赖继鹏
	 * @Description: 获取当前学期Id
	 * @return     
	 * @throws
	 */
	@Override
	public String getCurrentTermType(){
		SysConfigExample example=new SysConfigExample();
		example.createCriteria().andCodeEqualTo("term_type");
		List<SysConfig> sysConfigList= sysConfigCustomMapper.selectByExample(example);
		return sysConfigList.get(0).getValue();
	}
	
	@Override
	//根据学生和teachCourseId查询每个学生对应的成绩
	public List<String> getScoreByStuAndTCId(List<Student> studentList,
			String teachCourseId,String courseId, String coursePlanId, String studyYearId, String termType) {
		//System.out.println("termType:"+termType);
		List<String> scoreList=new ArrayList<String>();
		//获取课程对应的所有学生成绩
		CourseScoreExample example = new CourseScoreExample();
		example.createCriteria().andTeachCourseIdEqualTo(Integer.parseInt(teachCourseId));
		List<CourseScore> courseScoreList=courseScoreCustomMapper.selectByExample(example);
		//根据courseId和coursePlanId获取课程录入成绩时的成绩制（百分制or等级制）
		String scoreType=teachCourseCustomMapper.getScoreTypeByCIdAndCPId(courseId,coursePlanId,studyYearId,termType);
		//获取等级制成绩分数值
		List<EnumerationValue> evList=enumerationValueMapper.selectByEnumerationId(EnumerationType.GRADE_SCORE_TYPE);
		Map<Integer, String> gradeScoreTypeMap=new HashMap<Integer, String>();
		for (EnumerationValue enumerationValue : evList) {
			gradeScoreTypeMap.put(enumerationValue.getId(), enumerationValue.getName());
		}
		//设置每学生的成绩
		for(Student student:studentList){
			boolean exit=true;
			for (CourseScore courseScore : courseScoreList) {
					if(student.getId()==courseScore.getStudentId()){
						if(scoreType.equals("百分制")||scoreType==null){
							scoreList.add(courseScore.getHundredTotalScore()+"");
							exit=true;
							break;
						}else{
							scoreList.add(gradeScoreTypeMap.get(courseScore.getGradeTotalScore()));
							exit=true;
							break;
						}
					}else{
						exit=false;
					}		
			}
			if(exit==false){
				scoreList.add(" ");
			}
			
		}
		return scoreList;
	}
	
	
	
	@Override
	public Map<String, String> getScoreByStuAndCoursePlan(
			List<Student> studentList, String classId,List<CourseToQueryScoByHTDto> courseToQueryScoByHTList) {
		
		//存储每个学生对应的每门成绩的容器(key:studentCode+courseId 、 value:成绩)
    	Map<String, String> scoreMap = new HashMap<String, String>();
    	//获取等级制成绩分数值
    	List<EnumerationValue> evList=enumerationValueMapper.selectByEnumerationId(EnumerationType.GRADE_SCORE_TYPE);
    	Map<Integer, String> gradeScoreTypeMap=new HashMap<Integer, String>();
    	for (EnumerationValue enumerationValue : evList) {
    		gradeScoreTypeMap.put(enumerationValue.getId(), enumerationValue.getName());
    	}
		
		//循环遍历处理每一门课程
		for (CourseToQueryScoByHTDto courseDto : courseToQueryScoByHTList) {
			//获得课程id
			int courseId=courseDto.getCourseId();
			//获取coursePlanId
			int coursePlanId=courseDto.getCoursePlanId();
			//获取teachCourseId
			int teachCourseId=courseDto.getTeachCourseId();
			//获取学年Id
			int studyYearId=courseDto.getStudyYearId();
			//获取学期Id
			int termType=courseDto.getTermType();
			
			//获取课程对应的所有学生成绩
			CourseScoreExample example = new CourseScoreExample();
			example.createCriteria().andTeachCourseIdEqualTo(teachCourseId);
			List<CourseScore> courseScoreList=courseScoreCustomMapper.selectByExample(example);
			//根据courseId和coursePlanId获取课程录入成绩时的成绩制（百分制or等级制）
			String scoreType=teachCourseCustomMapper.getScoreTypeByCIdAndCPId(courseId+"",coursePlanId+"",studyYearId+"",termType+"");
			
			//设置每个学生对应该门课程的成绩
			for(Student student:studentList){
				boolean exit=true;
				for (CourseScore courseScore : courseScoreList) {
						if(student.getId()==courseScore.getStudentId()){
							if(scoreType.equals("百分制")||scoreType==null){
								scoreMap.put(student.getCode()+courseId, courseScore.getHundredTotalScore()+"");
								exit=true;
								break;
							}else{
								scoreMap.put(student.getCode()+courseId, gradeScoreTypeMap.get(courseScore.getGradeTotalScore()));
								exit=true;
								break;
							}
						}else{
							exit=false;
						}
				}
				if(exit==false){
					scoreMap.put(student.getCode()+courseId, " ");
				}
				
			}
			
		}
		
		
//		System.out.println("通过Map.keySet遍历key和value：");
//		for (String key : scoreMap.keySet()) {
//			System.out.println("key= "+ key + " and value= " + scoreMap.get(key));
//		}
		return scoreMap;
	}

}
