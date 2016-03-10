package com.dkt.school.edu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.apv.dto.ApplicationDto;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CoursePlanDto;
import com.dkt.school.edu.dto.CourseTeacherDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.dto.TeachTaskDto;
import com.dkt.school.edu.service.CoursePlanTotalInfoService;
import com.dkt.school.edu.service.TeachCourseService;
import com.dkt.school.edu.service.TeachTaskService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/edu")
public class TeachTaskController {
	public final static Logger logger = LoggerFactory
			.getLogger(TeachTaskController.class);

	private TeachTaskService teachTaskService;
	
	private TeachCourseService teachCourseService;

	private CoursePlanTotalInfoService coursePlanTotalInfoService;

	private EnumerationService enumerationService;
	
	private GradeService gradeService;
	private MajorService majorService;
	
	

	public EnumerationService getEnumerationService() {
		return enumerationService;
	}

	@Autowired
	public void setEnumerationService(EnumerationService enumerationService) {
		this.enumerationService = enumerationService;
	}
	public TeachTaskService getTeachTaskService() {
		return teachTaskService;
	}

	@Autowired
	public void setTeachTaskService(TeachTaskService teachTaskService) {
		this.teachTaskService = teachTaskService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public CoursePlanTotalInfoService getCoursePlanTotalInfoService() {
		return coursePlanTotalInfoService;
	}

	@Autowired
	public void setCoursePlanTotalInfoService(
			CoursePlanTotalInfoService coursePlanTotalInfoService) {
		this.coursePlanTotalInfoService = coursePlanTotalInfoService;
	}

	public TeachCourseService getTeachCourseService() {
		return teachCourseService;
	}

	@Autowired
	public void setTeachCourseService(TeachCourseService teachCourseService) {
		this.teachCourseService = teachCourseService;
	}

	// 跳转到教学任务首页
	@RequestMapping("/teachTaskList")
	public String teachTaskList(Model model) {
		//取得所有的学期类型
		List<EnumerationValue> termTypeList=enumerationService.getEnumValueListByEnumId(EnumerationType.SCHOOL_TERM_TYPE);
		//取得所有的学年类型
		List<StudyYear> studyYearList = teachCourseService.getAllStudyYear();
		List<Major> majorList = majorService.getAllMajor();
		List<Grade> gradeList = gradeService.getAllGrade();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("majorList", majorList);
		model.addAttribute("termTypeList", termTypeList);
		model.addAttribute("studyYearList", studyYearList);
		return "edu/teachTaskList";
	}

	/**
	 * 查询所有教学任务信息
	 * 
	 * @param name
	 * @param code
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeachTaskList")
	public String getTeachTaskList(String courseName,Integer major,Integer grade,Integer field,Integer termType,Integer studyYearId, PaginationCustom page) {
		/*先根据学期类型、学年字段判断教学任务中是否已经存在需要查询的信息
		如果没有，根据学期类型，在课程计划表取得所有的课程班级信息
		再根据课程班级信息，将study_year_id，term_type，course_plan_id，course_id，class_id 设进 教学任务表中
		最后返回所有与查询联系的教学任务信息
		如果有，先取出所有教学任务直接返回所有与查询联系的教学任务信息*/
		
		//根据学期类型、学年字段查找教学任务中是否存在相同的教学任务记录
		List<TeachTaskDto> teachTasks = teachTaskService.findTeachTaskByTermTypeAndStudyYearId(termType,studyYearId);
		/*Integer studyYearId = teachTaskService.findStudyYearIdByStudyYearName(studyYear);*/
		Gson gson = new Gson();
		JsonObject resultJson = new JsonObject();
		//教学任务记录为空
		if(teachTasks.size()<1) {
			//根据学期类型在课程计划中查找所有的记录
			List<CoursePlanDto> coursePlanDto=coursePlanTotalInfoService.findAllByTermType(termType);
			//将取出来的课程计划信息一一赋给教学任务
			int i = 1;
			for(CoursePlanDto coursePlan:coursePlanDto){
				TeachTaskDto tt = new TeachTaskDto();
				tt.setClassId(coursePlan.getClassId());
				tt.setCourseId(coursePlan.getCourseId());
				tt.setCoursePlanId(coursePlan.getId());
				tt.setStudyYearId(studyYearId);
				tt.setTermType(coursePlan.getTermType());
				//课程序号从1开始递增
				tt.setCourseSeq(i++);
				tt.setTeachCourseId(0);
				tt.setTeacherId1(0);
				tt.setTeacherId2(0);
				teachTaskService.addTeachTaskDto(tt);
			}
			//根据条件取得教学任务记录的总数
			int total = teachTaskService.getTeachTaskCount(courseName,major,grade,field,termType,studyYearId);
			// 设置当前页面所选择的每页记录数
			page.setPageRecorders(page.getRows());
			page.setCurrentPage(page.getPage());
			page.setTotalRows(total);
			//根据条件模糊查询取得教学任务记录
			List<TeachTaskDto> teachTaskDto = teachTaskService.getTeachTaskByPage(courseName,major,grade,field,termType,studyYearId,page);
			//对教学任务中的每条记录未有值字段初始化
			String str=null;
			for(TeachTaskDto ttDto:teachTaskDto) {
				ttDto.setTeacherNames("");
				ttDto.setTeacherId1(0);
				ttDto.setTeacherId2(0);
				
				Date date1=ttDto.getStartDate();
				Date date2=ttDto.getEndDate();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String dateShow1=null;
				String dateShow2=null;
				try {
					dateShow1=dateFormat.format(date1);
					dateShow2=dateFormat.format(date2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				ttDto.setStartDateStr(dateShow1);	
				ttDto.setEndDateStr(dateShow2);	
				
				
				str=ttDto.getStudyYearName()+'('+ttDto.getStartDateStr()+'~'+ttDto.getEndDateStr()+')';
				ttDto.setStudyYearDateStr(str);
			}
			JsonArray teachTaskListJa = gson.toJsonTree(teachTaskDto, List.class)
					.getAsJsonArray();
			resultJson.add("rows", teachTaskListJa);
			resultJson.addProperty("total", total);
		}else {
			//教学记录不为空
			
			//根据条件取得教学任务记录的总数
			int total = teachTaskService.getTeachTaskCount(courseName,major,grade,field,termType,studyYearId);
			// 设置当前页面所选择的每页记录数
			page.setPageRecorders(page.getRows());
			page.setCurrentPage(page.getPage());
			page.setTotalRows(total);
			
			//根据条件模糊查询取得教学任务记录
			List<TeachTaskDto> teachTaskDto = teachTaskService.getTeachTaskByPage(courseName,major,grade,field,termType,studyYearId,page);
			//对教学任务中的每条记录未有值字段初始化
			String str=null;
			for(TeachTaskDto ttDto:teachTaskDto) {
				Integer teacherId1 = 0;
				Integer teacherId2 = 0;
				//当记录中的教师授课id字段大于0时，表明这条记录已经设置了教师
				if(ttDto.getTeachCourseId()> 0) {
					//根据教师授课id找到教师授课中间表所有的teacher
					List<CourseTeacherDto> courseTeacherDto = teachTaskService.findTeacherNameByTeachCourseId(ttDto.getTeachCourseId());
					//取出第一名老师
					String teacherName1= courseTeacherDto.get(0).getTeacherName();
					teacherId1 = courseTeacherDto.get(0).getTeacherId();
					ttDto.setTeacherId1(teacherId1);
					ttDto.setTeacherId2(teacherId2);
					//当课程有第二名老师授课时
					if(courseTeacherDto.size()==2) {
						String teacherName2= courseTeacherDto.get(1).getTeacherName();
						teacherId2 = courseTeacherDto.get(1).getTeacherId();
						ttDto.setTeacherId2(teacherId2);
						if(teacherName2!=null) {
							teacherName1=teacherName1+","+teacherName2;
						}
					}
				
					ttDto.setTeacherNames(teacherName1);
					
					
				}else{
					//教学任务还未设置了老师时，对未赋值的字段赋初始化值
					ttDto.setTeacherNames("");
					ttDto.setTeacherId1(teacherId1);
					ttDto.setTeacherId2(teacherId2);
				}
				
				Date date1=ttDto.getStartDate();
				Date date2=ttDto.getEndDate();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String dateShow1=null;
				String dateShow2=null;
				try {
					dateShow1=dateFormat.format(date1);
					dateShow2=dateFormat.format(date2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				ttDto.setStartDateStr(dateShow1);	
				ttDto.setEndDateStr(dateShow2);	
				
				
				str=ttDto.getStudyYearName()+'('+ttDto.getStartDateStr()+'~'+ttDto.getEndDateStr()+')';
				ttDto.setStudyYearDateStr(str);
				
			}
			JsonArray teachTaskListJa = gson.toJsonTree(teachTaskDto, List.class)
					.getAsJsonArray();
			resultJson.add("rows", teachTaskListJa);
			resultJson.addProperty("total", total);
		}
		

		return resultJson.toString();
	}
	
	//返回空
	@ResponseBody
	@RequestMapping("/getNUll")
	public String getNUll(PaginationCustom page) {
		
		int total = 0;
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<ApplicationDto> applicationDto = new ArrayList<ApplicationDto>();
		
		
		Gson gson = new Gson();
		JsonArray applicationJa = gson.toJsonTree(applicationDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", applicationJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();	
	}

	/**
	 * 编辑教学任务信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditTeachTask")
	public String toEditTeachTask(Integer id, Integer classId,
			Integer studyYearId, Integer termType, Integer courseId,
			Integer coursePlanId, String courseName, String major,
			String field, String grade, String className, Integer courseSeq,
			String teacherNames, Integer teacherId1, Integer teacherId2,
			Model model) {
		
		//对从页面中返回的teachernames拆分为一位老师或者二位老师
		StringTokenizer st = new StringTokenizer(teacherNames, ",");
		String[] str = new String[2];
		int i = 0;
		while (st.hasMoreTokens()) {
			str[i] = st.nextToken();
			i++;
		}
		String teacherName1 = str[0];
		String teacherName2 = str[1];
		//当老师未存在时，赋值为空
		if (teacherName1 == null) {
			teacherName1 = "";
		}
		if (teacherName2 == null) {
			teacherName2 = "";
		}
		model.addAttribute("teachTaskId", id);
		model.addAttribute("studyYearIdPar", studyYearId);
		model.addAttribute("termTypePar", termType);
		model.addAttribute("courseNamePar", courseName);
		model.addAttribute("majorPar", major);
		model.addAttribute("fieldPar", field);
		model.addAttribute("gradePar", grade);
		model.addAttribute("classNamePar", className);
		model.addAttribute("courseSeqPar", courseSeq);
		model.addAttribute("teacherName1Par", teacherName1);
		model.addAttribute("teacherName2Par", teacherName2);
		model.addAttribute("courseIdPar", courseId);
		model.addAttribute("coursePlanIdPar", coursePlanId);
		model.addAttribute("classIdPar", classId);
		model.addAttribute("teacherId1Par", teacherId1);
		model.addAttribute("teacherId2Par", teacherId2);
		return "edu/editTeachTask";
	}

	/**
	 * 保存编辑教学任务信息的数据
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editTeachTask")
	public String editTeachTask(TeachTaskDto teachTaskDto, String teacherName1, String teacherName2,Integer oldCourseSeq) {
		// 对教师授课表每一条记录进行study_year_id，term_type，course_plan_id，course_id,
		// course_seq查询(course_seq设定默认值)
		// 如果记录存在，取出教师授课表id，并以此id删除所有的教师授课中间表，查找出所有相应的class_id（教师授课表中已有的class_id和新增的class_id），以此更新教师授课表中classes，插入所有的教师授课中间表记录
		// 如果记录不存在，则向教师授课表、教师授课中间表中插入记录

		// 1. courseSeq 不变
		// 2. courseSeq 已经编辑好所有信息并提交后再改变
		
		
		
		
		// 对教师授课表每一条记录进行study_year_id，term_type，course_plan_id，course_id判断
		TeachCourseDto teachCourseDto = teachTaskService
				.findTeachCourseByCondition(teachTaskDto.getStudyYearId(),
						teachTaskDto.getTermType(), teachTaskDto.getCourseId(),
						teachTaskDto.getCoursePlanId(),
						teachTaskDto.getCourseSeq());
		// 教师授课记录存在
		if (teachCourseDto != null) {
			//取出教师授课id
			Integer teachCourseId = teachCourseDto.getId();
			
			/*List<CourseTeacherDto> courseTeacher = teachTaskService.findTeacherNameByTeachCourseId(teachCourseId);*/
			
			//判断页面中从过来的教学任务课程序号字段是否改变
			//改变
			if(teachTaskDto.getCourseSeq()!=oldCourseSeq) {
				//根据旧的课程序号等字段寻找旧的教师授课记录,并删除这条记录
				TeachCourseDto teachCourse = teachTaskService
						.findTeachCourseByCondition(teachTaskDto.getStudyYearId(),
								teachTaskDto.getTermType(), teachTaskDto.getCourseId(),
								teachTaskDto.getCoursePlanId(),
								oldCourseSeq);
				int tcId=teachCourse.getId();
				teachTaskService.deleteTeachCourseById(tcId);
				//根据授课id删除教师授课中间表下所有的记录
				teachTaskService.delectCourseTeacher(tcId);
			}
			// 根据教师授课id删除所有相关的教师授课中间表
			teachTaskService.delectCourseTeacher(teachCourseId);
			
			//取得编辑页面中的教学任务班级字段
			String newClass = teachTaskDto.getClassName();
			//对已有的教师授课classes字段进行单个班级拆分
			StringTokenizer st = new StringTokenizer(
					teachCourseDto.getClasses(), ",");
			String[] str = new String[3];
			int i = 0;
			while (st.hasMoreTokens()) {
				str[i] = st.nextToken();
				i++;
			}
			// 1 .增加班级 2.班级不变，老师增加减少更改，只需要判断原先的班级是否与增加的班级重复
			String class1 = str[0];
			String class2 = str[1];
			String class3 = str[2];
			
			//新旧班级不相等
			if (!newClass.equals(class1) && !newClass.equals(class2)
					&& !newClass.equals(class3)) {
				teachCourseDto.setClasses(teachCourseDto.getClasses() + ","
						+ newClass);
				teachTaskService.updateTeachCourse(teachCourseDto);
			}
			//对教学任务中教师授课id进行赋值
			teachTaskDto.setTeachCourseId(teachCourseId);
			//更新教学任务信息
			teachTaskService.updateTeachTask(teachTaskDto);
			
			//新增教师授课中间表记录
			CourseTeacherDto courseTeacherDto = new CourseTeacherDto();
			courseTeacherDto.setTeachCourseId(teachCourseId);
			courseTeacherDto.setTeacherId(teachTaskDto.getTeacherId1());
			teachTaskService.addCourseTeacher(courseTeacherDto);
			//两名老师
			if (teachTaskDto.getTeacherId2() > 0) {
				courseTeacherDto.setTeachCourseId(teachCourseId);
				courseTeacherDto.setTeacherId(teachTaskDto.getTeacherId2());
				teachTaskService.addCourseTeacher(courseTeacherDto);
			}

		} else {
			// 记录不存在，则向教师授课表、教师授课中间表中插入记录
			TeachCourseDto tcDto = new TeachCourseDto();
			tcDto.setCourseId(teachTaskDto.getCourseId());
			tcDto.setCoursePlanId(teachTaskDto.getCoursePlanId());
			tcDto.setTermType(teachTaskDto.getTermType());
			tcDto.setStudyYearId(teachTaskDto.getStudyYearId());
			tcDto.setCourseSeq(teachTaskDto.getCourseSeq());
			tcDto.setClasses(teachTaskDto.getClassName());
			teachTaskService.addTeachCourse(tcDto);

			//根据条件查找出教师授课记录
			TeachCourseDto teachCourse = teachTaskService
					.findTeachCourseByCondition(tcDto.getStudyYearId(),
							tcDto.getTermType(), tcDto.getCourseId(),
							tcDto.getCoursePlanId(), tcDto.getCourseSeq());
			
			//更新教学任务信息
			teachTaskDto.setTeachCourseId(teachCourse.getId());
			teachTaskService.updateTeachTask(teachTaskDto);
			
			//新增教师授课中间表记录
			CourseTeacherDto courseTeacherDto = new CourseTeacherDto();
			courseTeacherDto.setTeachCourseId(teachCourse.getId());
			courseTeacherDto.setTeacherId(teachTaskDto.getTeacherId1());
			teachTaskService.addCourseTeacher(courseTeacherDto);
			//两名老师
			if (teachTaskDto.getTeacherId2() > 0) {
				courseTeacherDto.setTeachCourseId(teachCourse.getId());
				courseTeacherDto.setTeacherId(teachTaskDto.getTeacherId2());
				teachTaskService.addCourseTeacher(courseTeacherDto);
			}
		}

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("success", 1);
		return jsonObject.toString();
	}
}
