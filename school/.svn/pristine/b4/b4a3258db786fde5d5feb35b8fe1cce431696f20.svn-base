package com.dkt.school.edu.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.CourseCustomMapper;
import com.dkt.school.edu.dao.CourseScheduleCustomMapper;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CoursePlanOfCourseScheduleDto;
import com.dkt.school.edu.dto.CourseScheduleDto;
import com.dkt.school.edu.model.Course;
import com.dkt.school.edu.model.CoursePlan;
import com.dkt.school.edu.model.CourseSchedule;
import com.dkt.school.edu.model.CourseTeacher;
import com.dkt.school.edu.model.TeachCourse;
import com.dkt.school.edu.model.TeachTask;
import com.dkt.school.edu.service.CourseScheduleService;
import com.dkt.school.system.dao.EnumerationMapper;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	final String FILE_NAME = "/江门幼师课表.xls";
	final static String LINE_SEPARATOR = System.getProperty("line.separator");
	@Autowired
	private CourseScheduleCustomMapper scheduleMapper;
	@Autowired 
	private EnumerationMapper enumMapper;
	@Autowired
	private CourseCustomMapper courseMapper;

	@Override
	public List<CourseScheduleDto> getPersonalCourseScheduleByUserId(
			Integer userId) {
		List<CourseScheduleDto> list = scheduleMapper
				.getPersonalCourseScheduleByUserId(userId);

		return list;
	}

	public int updateBySchedule(CourseSchedule schedule) {
		return scheduleMapper.updateByCourseSchedule(schedule);

	}

	@Override
	public List<CourseScheduleDto> findCourseSchedule(Integer gradeId,
			String classes, String teacherName) {
		return scheduleMapper.findCourseSchedule(gradeId, classes, teacherName);
	}

	@Override
	public List<CourseScheduleDto> showClassSchedule(Integer gradeId,
			Integer classId) {
		return scheduleMapper.showClassSchedule(gradeId,classId);
	}

	@Override
	public List<CourseInTeaCourseTableDto> findCourseByClassId(int classId) {
		
		List<CourseInTeaCourseTableDto> list = scheduleMapper.selectCourseByClassId(classId);
		List<CourseInTeaCourseTableDto> resultList = new ArrayList<CourseInTeaCourseTableDto>();
		//对在教学任务里设置了相同课程序号的课程进行比较（相同的课&&不同的班级：表示一起上课）
	/*	for (int i = 0; i < list.size()-1; ++i) {
			
			for (int j = 1; j < list.size(); ++j) {
				
				if (list.get(i) == list.get(j)) {
					
					if (list.get(i).getCourseScheduleId() == list.get(j).getCourseScheduleId()) {
						
					}
				}
			}
		}*/
		return list;
	}

	@Override
	public int removeCourseScheduleById(int scheduleId) {
		return scheduleMapper.deleteByPrimaryKey(scheduleId);
	}

	@Override
	public int findCountOfCoursePlanInCourseSchedule(int majorId, int fieldId,
			String courseName, String className) {
		return scheduleMapper.selectCountOfCoursePlanInCourseSchedule(majorId,
				fieldId, courseName, className);
	}

	@Override
	public List<CoursePlanOfCourseScheduleDto> findCoursePlanInCourseSchedule(
			int majorId, int fieldId, String courseName, String className, PaginationCustom page) {
		return scheduleMapper.selectCoursePlanInCourseSchedule(majorId,
				fieldId, courseName, className,page.getLimitation());
	}

	@Override
	public int addCourseSchedule(CourseSchedule cs) {
		return scheduleMapper.insert(cs);
	}

	@Override
	public int isConflit(CourseSchedule dto, int classId) {

		// 本班所有的课程
		List<CourseInTeaCourseTableDto> list = this
				.findCourseByClassId(classId);

		int result = 0;
		int effect = 0;
		/**************** 先判断上课时间和上课地点是否有冲突 *******/
		// 时间
		// 1.星期和节次 相同，则比较上课周次(1.1比较连续周次的范围，1.2比较间断周次是否有重复)[在该老师的所有课程里进行比较]
		// 控制台输出
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).toString());
		}

		// 判断 (星期、节次是否相同,再判断周次是否相同)
		for (int i = 0; i < list.size(); ++i) {

			int weekDay = list.get(i).getWeekDay();
			int weekDayOfDto = dto.getWeekDay();
			if (weekDay == weekDayOfDto) {

				int section = list.get(i).getSectionType();
				int sectionOfDto = dto.getSectionType();
				if (section == sectionOfDto) { // 星期、节次相同，则判断上课周次是否有交集

					//先判断是否是同一门课
					int teachCourseId = dto.getTeachCourseId();
					int tmpTCId = list.get(i).getTeachCourseId();
					System.out.println(teachCourseId + ", " + tmpTCId);
					System.out.println("是否是同一门课: " + (teachCourseId == tmpTCId));
					if (teachCourseId == tmpTCId) {
						
						return -2;
					}
					System.out.println("找到相同星期和节次的课程!" + list.get(i).getName());
					// 截取出 (其他课程连续)周次
					List<Integer> weeks = null;
					if (!list.get(i).getWeeks().trim().equals("-|,|，")) {
						String weeksStr[] = list.get(i).getWeeks()
								.split("-|,|，");
						weeks = new ArrayList<Integer>();
						weeks.add(Integer.parseInt(weeksStr[0].trim()));
						weeks.add(Integer.parseInt(weeksStr[1].trim()));
					}
					// 截取出 (其他课程间断)周次
					List<Integer> weeksIds = null;
					if (!list.get(i).getWeekIds().trim().equals("")) {
						
						weeksIds = new ArrayList<Integer>();

						if (list.get(i).getWeekIds().trim().contains(",")
								|| list.get(i).getWeekIds().trim().contains("，")) {
							String weeksIdsStr[] = list.get(i).getWeekIds()
									.split(",|，");
							
							for (int j = 0; j < weeksIdsStr.length; ++j) {
								weeksIds.add(Integer.parseInt(weeksIdsStr[j]
										.trim()));
							}
						} else {
							
							weeksIds.add(Integer.parseInt(list.get(i).getWeekIds().trim()));
							
						}
					}

					// 截取页面dto的周次
					List<Integer> dtoWeeks = null;
					List<Integer> dtoWeekIds = null;
					if (!dto.getWeeks().trim().equals("")) {
						String dtoWeeksStr[] = dto.getWeeks().split("-");
						dtoWeeks = new ArrayList<Integer>();
						dtoWeeks.add(Integer.parseInt(dtoWeeksStr[0].trim()));
						dtoWeeks.add(Integer.parseInt(dtoWeeksStr[1].trim()));

					}
					if (!dto.getWeekIds().trim().equals("")) {
						dtoWeekIds = new ArrayList<Integer>();
						
						boolean b1 = dto.getWeekIds().trim().contains(",");
						boolean b2 =dto.getWeekIds().trim().contains("，");
						System.out.println("dto.getWeekIds().trim().contains(','):" + b1);
						System.out.println("dto.getWeekIds().trim().contains('，'):" + b2);
						if (b1 || b2 ) {
							String dtoWeekIdsStr[] = dto.getWeekIds().split(
									",|，");
							for (int j = 0; j < dtoWeekIdsStr.length; ++j) {
								dtoWeekIds.add(Integer
										.parseInt(dtoWeekIdsStr[j].trim()));
							}
						} else {
							dtoWeekIds.add(Integer.parseInt(dto.getWeekIds().trim()));
							
						}
					}

					int weeksStart = 0;
					int weeksEnd = 0;
					int dtoWeeksStart = 0;
					int dtoWeeksEnd = 0;
					if (weeks != null) {
						weeksStart = weeks.get(0);
						weeksEnd = weeks.get(1);
					}
					if (dtoWeeks != null) {
						dtoWeeksStart = dtoWeeks.get(0);
						dtoWeeksEnd = dtoWeeks.get(1);
					}
					// 比较连续周次(区间是否有交集)
					System.out.println("第 " + (i + 1) + " 个:");
					System.out.println("页面连续周次（开始）:" + dtoWeeksStart);
					System.out.println("页面连续周次（结束）:" + dtoWeeksEnd);
					System.out.println("已存在课程连续周次(开始):" + weeksStart);
					System.out.println("已存在课程连续周次(结束):" + weeksEnd);
					if (weeks != null && dtoWeeks != null) {
						if (dtoWeeksStart <= weeksStart) {

							if (dtoWeeksEnd >= weeksStart) {

								System.out.println("连续周次有交集!");
								// List<CourseInTeaCourseTableDto> ret = new
								// ArrayList<CourseInTeaCourseTableDto>();
								// ret.add(list.get(i));
								return -1;
							}
						} else if (dtoWeeksStart >= weeksStart
								&& dtoWeeksStart <= weeksEnd) {

							// if (dtoWeeksEnd >= weeksEnd) {

							System.out.println("连续周次有交集!");
							// List<CourseInTeaCourseTableDto> ret = new
							// ArrayList<CourseInTeaCourseTableDto>();
							// ret.add(list.get(i));
							return -1;
							// }
						}
					}
					// 比较间断周次(是否有相同)
					if (weeksIds != null && dtoWeekIds != null) {
						System.out.println(weeksIds.toString());
						System.out.println(dtoWeekIds.toString());
						for (int j = 0; j < weeksIds.size(); ++j) {
							if (dtoWeekIds.contains(weeksIds.get(j))) {

								System.out.println("间断周次有重复!" + ", "
										+ weeksIds.get(j));
								// List<CourseInTeaCourseTableDto> ret = new
								// ArrayList<CourseInTeaCourseTableDto>();
								// ret.add(list.get(i));
								return -1;
							}
						}
					}
					// 比较连续和间断周次（是否包含）
					if (weeksStart != 0 && weeksEnd != 0
							&& dtoWeekIds != null) {
						System.out.println("判断连续和间断周次（是否包含）：");
						System.out.println("weeksStart : " + weeksStart + ",weeksEnd : " + weeksEnd + ",dtoWeekIds : " + dtoWeekIds);
						for (int j = 0; j < dtoWeekIds.size(); ++j) {
							if (dtoWeekIds.get(j) >= weeksStart
									&& dtoWeekIds.get(j) <= weeksEnd) {

								System.out.println("间断周次和连续周次有包含关系!" + ", "
										+ dtoWeekIds.get(j));
							//	List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
							//	ret.add(list.get(i));
								return -1;
							}
						}
					}
					if (dtoWeeksStart != 0 && dtoWeeksEnd != 0
							&& weeksIds != null) {
						System.out.println("判断连续和间断周次（是否包含）：");
						System.out.println("dtoWeeksStart : " + dtoWeeksStart + ",dtoWeeksEnd : " + dtoWeeksEnd + ",weeksIds : " + weeksIds);
						for (int j = 0; j < weeksIds.size(); ++j) {
							if (weeksIds.get(j) >= dtoWeeksStart
									&& weeksIds.get(j) <= dtoWeeksEnd) {

								System.out.println("间断周次和连续周次有包含关系!" + ", "
										+ weeksIds.get(j));
							//	List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
							//	ret.add(list.get(i));
								return -1;
							}
						}
					}
				}
			}
		}
		System.out.println("没有冲突，继续!\n判断同一时间的课程是否有地点冲突(所有该时间上的课程)!");// 我先写写sql...
		/*
		 * List<CourseInTeaCourseTableDto> courses = comaMapper
		 * .selectCourseWithTimeConflictAndAddressConflict( dto.getTeacherId(),
		 * // 教师id dto.getClassRoomId(),// 上课地点 dto.getWeekDay(), // 星期几上课
		 * dto.getSectionType(), // 第几节上课 dtoWeeksStart, // 连续周次开头 dtoWeeksEnd,
		 * // 连续周次结尾 dtoWeekIds); // 所有间断周次的list集合
		 * System.out.println("跟其他课程冲突的课程数量(其他老师的课程): " + courses.size());
		 * System.out.println("跟其他课程冲突的课程: " + courses.toString());
		 * 
		 * if (courses.size() > 0) { // 有地点冲突
		 * 
		 * if (courses.size() == 1) { return courses; } }
		 */
		int dtoWeeksStart = 0;
		int dtoWeeksEnd = 0;
		// 截取页面dto的周次
		List<Integer> dtoWeeks = null;
		List<Integer> dtoWeekIds = null;
		if (!dto.getWeeks().trim().equals("")) {
			String dtoWeeksStr[] = dto.getWeeks().split("-");
			dtoWeeks = new ArrayList<Integer>();
			dtoWeeks.add(Integer.parseInt(dtoWeeksStr[0].trim()));
			dtoWeeks.add(Integer.parseInt(dtoWeeksStr[1].trim()));

		}
		if (!dto.getWeekIds().trim().equals("")) {
			
			dtoWeekIds = new ArrayList<Integer>();
			boolean b1 = dto.getWeekIds().trim().contains(",");
			boolean b2 =dto.getWeekIds().trim().contains("，");
			if(b1 || b2) {
				String[] arr = dto.getWeekIds().trim().split(",|，|-");
				for (int i = 0; i < arr.length; ++i) {
					
					dtoWeekIds.add(Integer.parseInt(arr[i]));
				}
			} else {
				
				dtoWeekIds.add(Integer.parseInt(dto.getWeekIds().trim()));
				
			} 
		}
		if (dtoWeeks != null) {
			dtoWeeksStart = dtoWeeks.get(0);
			dtoWeeksEnd = dtoWeeks.get(1);
		}
		List<CourseInTeaCourseTableDto> conflict = courseMapper
				.selectCourseWithTimeConflictAndAddressConflict(
						null,
						dto.getClassRoomId(),
						dto.getWeekDay(),
						dto.getSectionType(), 
						dtoWeeksStart, 
						dtoWeeksEnd,
						dtoWeekIds);
		if (conflict.size() > 0) {
			//除去相同scheduleId可以多个老师同时上一门课）
			for (int j = 0; j < conflict.size(); ++j) {
//				if (conflict.get(j).getCourseScheduleId() == dto.getCourseScheduleId()) {
				if (conflict.get(j).getCourseScheduleId() == dto.getId()) {
					conflict.remove(j);
				}
			}
			if (conflict.size() > 0) {
				System.out.println("冲突的课程数量(相同的时间段和地点):" + conflict.size());
				System.out.println("冲突的课程(相同的时间段和地点):" + conflict.toString());
				return conflict.size();
			}
		}
		// 没有冲突
		return -10;
	}
	
	/**
	 * 导入excel课表(业务逻辑不对)
	 * @param in
	 * @param ext
	 * @return
	 * @throws Exception 
	public Integer importCourseScheduleByExcelOldVersion(InputStream in,String ext) throws Exception {
		try{
			Workbook wb = null;
			if (ext.equalsIgnoreCase("xls")){
				wb = new HSSFWorkbook(in);
			} else if (ext.equalsIgnoreCase("xlsx")){
				wb = new XSSFWorkbook(in);
			}
			Sheet sheet = wb.getSheetAt(0);
			//Iterator<Row> rowIter = sheet.rowIterator();
			for(int i = 0; i < sheet.getLastRowNum();i++){
				Row row = sheet.getRow(i);
				logger.info("当前行是第:"+row.getRowNum()+"行--------");
				//从第三行开始读数据
				if (row.getRowNum() < 2)
					continue;
				Cell cell = null;
				//Iterator<Cell> cellIter = row.cellIterator();
				//一行对应多个对象 
				CourseSchedule cs = new CourseSchedule();
				CoursePlan cp = new CoursePlan();
				TeachCourse tc = new TeachCourse();
				CourseTeacher ct = new CourseTeacher();
				//可能有多个TeacherTask(ttList的大小默认一个)
				List<TeachTask> ttList = new ArrayList<TeachTask>();
				ttList.add(new TeachTask());
								
				//set学年id
				cell = row.getCell(0);
				if (cell.getStringCellValue() != null){
					Integer studyYearId = scheduleMapper		//
							.getStudyYearIdByStudyYear(cell.getStringCellValue().trim());
					if (studyYearId != null){
						System.out.println(studyYearId);
						tc.setStudyYearId(studyYearId);
						ttList.get(0).setStudyYearId(studyYearId);
					} else{
						return -2;			//学年数据出错
					}
				}
				//set学期id
				cell = row.getCell(1);
				if (cell.getStringCellValue() != null){
					Integer termType = scheduleMapper			//
							.getTermTypeByTerm(cell.getStringCellValue().trim());
					if (termType != null){
						System.out.println(termType);
						tc.setTermType(termType);
						ttList.get(0).setTermType(termType);
						cp.setTermType(termType);
					} else {
						return -3;       //学期数据出错
					}
				}
				//set课程id
				cell = row.getCell(2);
				if (cell.getStringCellValue() != null){
					Integer courseId = scheduleMapper			//
							.getCourseIdByCourse(cell.getStringCellValue());
					if (courseId != null){
						System.out.println(courseId);
						tc.setCourseId(courseId);
						ttList.get(0).setCourseId(courseId);
						cp.setCourseId(courseId);
					} else{
						return -4;			//课程信息出错
					}
					
				}
				//set课程类型
				cell = row.getCell(3);
				if (cell.getStringCellValue() != null){
					Integer courseType = scheduleMapper
							.getCourseTypeByCourse(cell.getStringCellValue().trim());
					if (courseType != null){
						System.out.println(courseType);
						cp.setCourseType(courseType);
						
					} else {
						return -6;			//课程类型出错
					}
				}
				//set专业id
				cell = row.getCell(4);
				if (cell.getStringCellValue() != null){
					Integer majorId = scheduleMapper
							.getMajorIdByMajor(cell.getStringCellValue().trim());
					if (majorId != null){
						System.out.println(majorId);
						cp.setMajorId(majorId);
						
					} else{
						return -7;        //专业信息出错
					}
				}
				//set专业方向id
				cell = row.getCell(5);
				if (cell.getStringCellValue() != null){
					Integer fieldId = scheduleMapper
							.getFieldIdByField(cell.getStringCellValue().trim());
					if(fieldId != null){
						System.out.println(fieldId);
						cp.setFieldId(fieldId);
					} else {
						return -7;			//专业信息出错
					}
				}
				//set年级
				cell = row.getCell(6);
				if (cell.getStringCellValue() != null){
					Integer gradeId = scheduleMapper
							.getGradeIdByGrade(cell.getStringCellValue().trim());
					if (gradeId != null){
						System.out.println(gradeId);
						cp.setGradeId(gradeId);
					} else{
						return -9;			//年级信息出错
					}
				}
				//set教室id
				cell = row.getCell(7);
				if (cell.getStringCellValue() != null){
					Integer classRoomId = scheduleMapper
							.getClassRoomIdByClassRoom(cell.getStringCellValue().trim());
					if (classRoomId != null){
						System.out.println(classRoomId);
						cs.setClassRoomId(classRoomId);
					} else {
						return -10;
					}
				}
				//set教师id
				cell = row.getCell(8);
				if (cell.getStringCellValue() != null){
					Integer teacherId = scheduleMapper
							.getTeacherIdByTeacher(cell.getStringCellValue().trim());
					if (teacherId != null){
						System.out.println(teacherId);
						ct.setTeacherId(teacherId);
					} else {
						return -11;			//教师信息出错
					}
				}
				//set上课班级和班级id
				cell = row.getCell(9);
				if (cell.getStringCellValue() != null){
					//切割字符串
					String[] classes = cell.getStringCellValue().trim().split(",|，");
					if (classes.length == 1){
						Integer classId = scheduleMapper
								.getClassIdByClass(cell.getStringCellValue().trim());
						ttList.get(0).setClassId(classId);
						tc.setClasses(cell.getStringCellValue().trim());		
					}
					else{
						for(int index = 0; index<classes.length; index++){
							//如果上课班级数量多于原先设定的容器的容量的话扩充ttList的容量
							if (ttList.size() < classes.length){
								for(int j = 0;j<classes.length - ttList.size();j++){
									TeachTask tt = new TeachTask();
									ttList.add(tt);
								}
							}
							Integer classId = scheduleMapper.getClassIdByClass(classes[index]);
							if (classId != null){
								ttList.get(index).setClassId(classId);
							} else{
								//不存在这样的班级
								return -8;
							}
						}
						//这个字段一定要set
						tc.setClasses(cell.getStringCellValue().trim());
					}
				}
				//set连续周次
				cell = row.getCell(10);
				if (cell.getStringCellValue() != null){
					cs.setWeeks(cell.getStringCellValue().trim());
				}
				//set分散周次
				cell = row.getCell(11);
				if (cell.getStringCellValue() != null){
					cs.setWeekIds(cell.getStringCellValue().trim());
				}
				//set星期
				cell = row.getCell(12);
				if (cell.getStringCellValue() != null){
					Integer weekDay = scheduleMapper		//
							.getWeekDayIdByWeekDay(cell.getStringCellValue().trim());
					if (weekDay != null){
						System.out.println(weekDay);
						cs.setWeekDay(weekDay);
					} else {
						return -12;
					}
				}
				//set节次
				cell = row.getCell(13);
				if (cell.getStringCellValue() != null){
					Integer sectionType = scheduleMapper		//
							.getSectionTypeBySection(cell.getStringCellValue().trim());
					if (sectionType != null){
						System.out.println(sectionType);
						cs.setSectionType(sectionType);
					} else {
						return -12;
					}
				}
				//set学分
				cell = row.getCell(14);
				if (cell.getStringCellValue() != null){
					cp.setCredit(Float.parseFloat(cell.getStringCellValue().trim()));
				}
				//set学时
				cell = row.getCell(15);
				if (cell.getStringCellValue() != null){
					cp.setHours(Integer.parseInt(cell.getStringCellValue().trim()));
				}
				//set考试类型
				cell = row.getCell(16);
				if (cell.getStringCellValue() != null){
					Integer examineType = scheduleMapper	//
							.getExamTypeByExam(cell.getStringCellValue().trim());
					if (examineType != null){
						System.out.println(examineType);
						cp.setExamineType(examineType);
					} else {
						return -10;
					}
				}
				//set备注
				cell = row.getCell(17);
				if (cell.getStringCellValue() != null){
					cp.setRemark(cell.getStringCellValue().trim());
				}
				//这里检查冲突课程！！
				List<Course> conflictList1 = scheduleMapper
						.findConflictCourseWeekIds(cs.getSectionType(),cs.getWeekDay(),
								cs.getWeekIds(),ct.getTeacherId());
				if (conflictList1 != null){
					for(Course c : conflictList1){
						if (c.getName() != null){
							return -20;			//存在冲突上课时间
						}
					}
				}
				List<Course> conflictList2 = scheduleMapper
								.findConflictCourseWeeks(cs.getSectionType(), 
								cs.getWeekDay(), cs.getWeeks(), ct.getTeacherId());
				if (conflictList2 != null){
					for(Course c : conflictList2){
						if (c.getName() != null){
							return -20;			//存在冲突上课时间
						}
					}
				}
				
				//set关联字段(course_plan_id)
				Integer coursePlanId = scheduleMapper		//通过多个字段来查询course_paln_id
						.getCoursePlanIdByFields(cp.getMajorId(),cp.getFieldId(),
								cp.getGradeId(),cp.getTermType(),cp.getCourseId());
				if (coursePlanId != null){
					System.out.println(coursePlanId);
					tc.setCoursePlanId(coursePlanId);
					ttList.get(0).setCoursePlanId(coursePlanId);
					//当course_plan_id 不为空的情况下关联其他字段
					Integer teachCourseId = scheduleMapper
							.getTeacherCourseIdByFields(tc.getCourseId(),
									tc.getCoursePlanId(),tc.getClasses());
					if (teachCourseId != null){
						System.out.println(teachCourseId);
						//不为空插入关联值
						cs.setTeachCourseId(teachCourseId);
						ct.setTeachCourseId(teachCourseId);
						ttList.get(0).setTeachCourseId(teachCourseId);
			
					} else {
						
						//不存在teach_course插入一条记录以获得teach_course_id
						scheduleMapper.insertTeachCourse(tc);
						//获取最新id
						Integer teach_course_id = scheduleMapper.selectLastId();
						System.out.println(teach_course_id);
						cs.setTeachCourseId(teach_course_id);
						ct.setTeachCourseId(teach_course_id);
						ttList.get(0).setTeachCourseId(teach_course_id);
						//这里除了设置teachCourseId之外,
						//将对应classes增加的新的TeachTask其他字段也set好
						for(int y=1;y<ttList.size();y++){
							ttList.get(y).setCourseId(ttList.get(0).getCourseId());
							ttList.get(y).setClassId(ttList.get(0).getClassId());
							ttList.get(y).setCoursePlanId(ttList.get(0).getCoursePlanId());
							ttList.get(y).setStudyYearId(ttList.get(0).getStudyYearId());
							ttList.get(y).setTeachCourseId(ttList.get(0).getTeachCourseId());
							ttList.get(y).setTermType(ttList.get(0).getTermType());
						}
					}
				} else {
					//无该教学计划course_plan_id
					return -5;		//暂时没有该教学计划
				}
				logger.info("cp:"+cp);
				logger.info("cs:"+cs);
				logger.info("ct:"+ct);
				for(int x = 0;x<ttList.size();x++){
					logger.info("tt:"+ttList.get(x));
				}
				//插入多个表(TeachCourse表在上方已插入)
				scheduleMapper.insertCoursePlan(cp);
				scheduleMapper.insertTeachTaskList(ttList);
				scheduleMapper.insertCourseSchedule(cs);
				scheduleMapper.insertCourseTeacher(ct);
			}
		} catch(TooManyResultsException e){
			e.printStackTrace();
			return -13;
		}
		
		//如果正常返回0
		return 0;
	} */
	
	/**
	 * 导入excel课表
	 * @param in
	 * @param ext
	 * @return
	 * @throws Exception 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false,
	rollbackFor = {java.lang.Exception.class,java.lang.RuntimeException.class})
	public Integer importCourseScheduleByExcel(InputStream in,String ext) throws Exception {
		try{
			Workbook wb = null;	
			if (ext.equalsIgnoreCase("xls")){
				wb = new HSSFWorkbook(in);
			} else if (ext.equalsIgnoreCase("xlsx")){
				wb = new XSSFWorkbook(in);
			} else {
				return -1;
			}
			Sheet sheet = wb.getSheetAt(1);
			if (!sheet.getSheetName().equals("江门幼师课表")){
				return -20;		//导入的excel并非是课表
			}
			for(int i = 0; i < sheet.getLastRowNum();i++){
				logger.info("这个表一共有"+sheet.getLastRowNum()+"行");
				Row row = sheet.getRow(i);
				//从第三行开始读数据
				if (row.getRowNum() < 2){
					logger.info("当前行是第:"+row.getRowNum()+"行--------");
					continue;
				}
				CourseSchedule cs = new CourseSchedule();
				CoursePlan cp = new CoursePlan();
				CourseTeacher ct = new CourseTeacher();
				TeachCourse tc = new TeachCourse();
				Cell cell = null;
				cell = row.getCell(0);
				if (cell.getStringCellValue() != null){
					Integer studyYearId = scheduleMapper		//
							.getStudyYearIdByStudyYear(cell.getStringCellValue().trim());
					tc.setStudyYearId(studyYearId);
					if (null == studyYearId){
						return -2;	//学年数据出错
					}
				}
				cell = row.getCell(1);
				if (cell.getStringCellValue() != null){
					Integer termType = scheduleMapper			//
							.getTermTypeByTerm(cell.getStringCellValue().trim());
					if (null == termType){
						return -3;	//学期数据出错
					} else{
						tc.setTermType(termType);
					}
				}
				cell = row.getCell(2);
				if (cell.getStringCellValue() != null){
					Integer courseId = scheduleMapper			//
							.getCourseIdByCourse(cell.getStringCellValue().trim());
					if (null == courseId){
						return -4;			//课程信息出错
					} else{
						cp.setCourseId(courseId);
					}
				}
				cell = row.getCell(3);
				if (cell.getStringCellValue() != null){
					Integer courseType = scheduleMapper
							.getCourseTypeByCourse(cell.getStringCellValue().trim());
					if (null == courseType){
						return -6;
					} else{
						cp.setCourseType(courseType);
					}
				}
				cell = row.getCell(4);
				if (cell.getStringCellValue() != null){
					Integer majorId = scheduleMapper
							.getMajorIdByMajor(cell.getStringCellValue().trim());
					if (null == majorId){
						return -7;		//专业信息出错
					} else{
						cp.setMajorId(majorId);
					}
				}
				cell = row.getCell(5);
				if (cell.getStringCellValue() != null){
					Integer fieldId = scheduleMapper
							.getFieldIdByField(cell.getStringCellValue().trim());
					if(null == fieldId){
						return -7;	//专业信息方向出错	
					} else {
						cp.setFieldId(fieldId);
					}
				}
				
				cell = row.getCell(6);
				if (cell.getStringCellValue() != null){
					Integer gradeId = scheduleMapper
							.getGradeIdByGrade(cell.getStringCellValue().trim());
					if (null == gradeId){
						return -9;		//年级信息出错 
					} else{
						cp.setGradeId(gradeId);
					}
				}
				cell = row.getCell(7);
				if (cell.getStringCellValue() != null){
					Integer classRoomId = scheduleMapper
							.getClassRoomIdByClassRoom(cell.getStringCellValue().trim());
					if (null == classRoomId){
						return -10;		//教室信息出错
					} else{
						cs.setClassRoomId(classRoomId);
					}
				}
				cell = row.getCell(8);
				if (cell.getStringCellValue() != null){
					Integer teacherId = scheduleMapper
							.getTeacherIdByTeacher(cell.getStringCellValue().trim());
					if (null == teacherId){
						return -11;		//教师信息出错
					} else{
						ct.setTeacherId(teacherId);
					}
				}
				//设置班级
				cell = row.getCell(9);
				if (cell.getStringCellValue() != null){
					tc.setClasses(cell.getStringCellValue().trim());		
				}	
				//set连续周次
				cell = row.getCell(10);
				if (cell.getStringCellValue() != null){
					cs.setWeeks(cell.getStringCellValue().trim());
				}
				//set分散周次
				cell = row.getCell(11);
				if (cell.getStringCellValue() != null){
					cs.setWeekIds(cell.getStringCellValue().trim());
				}
				//set星期
				cell = row.getCell(12);
				if (cell.getStringCellValue() != null){
					Integer weekDay = scheduleMapper		//
							.getWeekDayIdByWeekDay(cell.getStringCellValue().trim());
					if (weekDay != null){
						System.out.println(weekDay);
						cs.setWeekDay(weekDay);
					} else {
						return -12;
					}
				}
				//set节次
				cell = row.getCell(13);
				if (cell.getStringCellValue() != null){
					Integer sectionType = scheduleMapper		//
							.getSectionTypeBySection(cell.getStringCellValue().trim());
					if (sectionType != null){
						System.out.println(sectionType);
						cs.setSectionType(sectionType);
					} else {
						return -12;
					}
				}
				
				//查询是否存在对应的教学计划
				Integer coursePlanId = scheduleMapper		//通过多个字段来查询course_paln_id
						.getCoursePlanIdByFields(cp.getMajorId(),cp.getFieldId(),
								cp.getGradeId(),cp.getTermType(),cp.getCourseId());
				if (null == coursePlanId){
					return -5;		//不存在这样的教学计划
				}
				
				//查询是否有对应的教师授课记录
				Integer teachCourseId = scheduleMapper.getTeacherCourseIdByFields(
						tc.getStudyYearId(),
						tc.getTermType(),
						cp.getCourseId(),
						coursePlanId,
						tc.getClasses());
				//更新班级信息
				if (teachCourseId != null){
					scheduleMapper.updateTeachCourse(tc.getClasses(),teachCourseId);
					ct.setTeachCourseId(teachCourseId);
					cs.setTeachCourseId(teachCourseId);
				} else{
					return -15;		//不存在相应的教师授课记录
				}
				
				//这里检查冲突课程！！
				List<Course> conflictList1 = scheduleMapper
						.findConflictCourseWeekIds(cs.getSectionType(),cs.getWeekDay(),
								cs.getWeekIds(),ct.getTeacherId());
				if (conflictList1 != null){
					for(Course c : conflictList1){
						if (c.getName() != null){
							return -13;			//存在冲突上课时间
						}
					}
				}
				List<Course> conflictList2 = scheduleMapper
								.findConflictCourseWeeks(cs.getSectionType(), 
								cs.getWeekDay(), cs.getWeeks(), ct.getTeacherId());
				if (conflictList2 != null){
					for(Course c : conflictList2){
						if (c.getName() != null){
							return -13;			//存在冲突上课时间
						}
					}
				}
				
				scheduleMapper.insertCourseSchedule(cs);
				scheduleMapper.insertCourseTeacher(ct);
			}
			return 0;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 导出课表到excel
	 */
	@Override
	public void exportSchedule2Xls(File file, List<CourseScheduleDto> list) {
		OutputStream out = null;
		try{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		//设置字体垂直居中
		CellStyle style = wb.createCellStyle();	
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//第一行表头
		Row row_0 = sheet.createRow(0);
		//System.out.println("rownum="+row_0.getRowNum());
		//设置行高
		row_0.setHeightInPoints(50);
		Cell cell0_1 = row_0.createCell(1);
		cell0_1.setCellStyle(style);
		cell0_1.setCellValue("星期一");
		Cell cell0_2 = row_0.createCell(2);
		cell0_2.setCellStyle(style);
		cell0_2.setCellValue("星期二");
		Cell cell0_3 = row_0.createCell(3);
		cell0_3.setCellStyle(style);
		cell0_3.setCellValue("星期三");
		Cell cell0_4 = row_0.createCell(4);
		cell0_4.setCellStyle(style);
		cell0_4.setCellValue("星期四");
		Cell cell0_5 = row_0.createCell(5);
		cell0_5.setCellStyle(style);
		cell0_5.setCellValue("星期五");
		Cell cell0_6 = row_0.createCell(6);
		cell0_6.setCellStyle(style);
		cell0_6.setCellValue("星期六");
		Cell cell0_7 = row_0.createCell(7);
		cell0_7.setCellStyle(style);
		cell0_7.setCellValue("星期日");
		//第二行
		Row row_1 = sheet.createRow(1);
		row_1.setHeightInPoints(80);
		Cell cell1_0 = row_1.createCell(0);
		cell1_0.setCellStyle(style);
		cell1_0.setCellValue("第一节");
		Cell cell1_6 = row_1.createCell(6);
		cell1_6.setCellStyle(style);
		cell1_6.setCellValue("休息");
		//第三行
		Row row_2 = sheet.createRow(2);
		row_2.setHeightInPoints(80);
		Cell cell2_0 = row_2.createCell(0);
		cell2_0.setCellStyle(style);
		cell2_0.setCellValue("第二节");
		//第四行
		Row row_3 = sheet.createRow(3);
		row_3.setHeightInPoints(80);
		Cell cell3_0 = row_3.createCell(0);
		cell3_0.setCellStyle(style);
		cell3_0.setCellValue("第三节");
		//第五行
		Row row_4 = sheet.createRow(4);
		row_4.setHeightInPoints(80);
		Cell cell4_0 = row_4.createCell(0);
		cell4_0.setCellStyle(style);
		cell4_0.setCellValue("第四节");
		//第六行
		Row row_5 = sheet.createRow(5);
		row_5.setHeightInPoints(80);
		Cell cell5_0 = row_5.createCell(0);
		cell5_0.setCellStyle(style);
		cell5_0.setCellValue("第五节");
		//第七行
		Row row_6 = sheet.createRow(6);
		row_6.setHeightInPoints(80);
		Cell cell6_0 = row_6.createCell(0);
		cell6_0.setCellStyle(style);
		cell6_0.setCellValue("第六节");
		//第八行
		Row row_7 = sheet.createRow(7);
		row_7.setHeightInPoints(80);
		Cell cell7_0 = row_7.createCell(0);
		cell7_0.setCellStyle(style);
		cell7_0.setCellValue("第七节");
		for(int i = 0;i < 8; i++){
			//设置1到8行的列宽
			sheet.setColumnWidth(i, 256*50);

		}
		//合并单元格(参数arg0:为起始行,arg1:结束行,arg3:起始列,arg4:结束列)
		CellRangeAddress region = new CellRangeAddress(1,7,6,7);
		sheet.addMergedRegion(region);
		
		/********************开始从集合中取出数据往excel表里填充********************************/
		logger.info("/********************开始从集合中取出数据往excel表里填充********************************/");
		for(CourseScheduleDto dto : list){
			/*星期一的课*/
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 1){
				row_1.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 2){
				row_2.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 3){
				row_3.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 4){
				row_4.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 5){
				row_5.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 6){
				row_6.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 1 && dto.getSectionType() % 10 == 7){
				row_7.createCell(1).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			/*星期二的课*/
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 1){
				Cell cell = row_1.createCell(2);
				//System.out.println(cell);
				cell.setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
				//System.out.println(cell);
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 2){
				row_2.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 3){
				row_3.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 4){
				row_4.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 5){
				row_5.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 6){
				row_6.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 2 && dto.getSectionType() % 10 == 7){
				row_7.createCell(2).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			/*星期三的课*/
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 1){
				row_1.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 2){
				row_2.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 3){
				row_3.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 4){
				row_4.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 5){
				row_5.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 6){
				row_6.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 3 && dto.getSectionType() % 10 == 7){
				row_7.createCell(3).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			/*星期四的课*/
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 1){
				row_1.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 2){
				row_2.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 3){
				row_3.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 4){
				row_4.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 5){
				row_5.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 6){
				row_6.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 4 && dto.getSectionType() % 10 == 7){
				row_7.createCell(4).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			/*星期五的课*/
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 1){
				row_1.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 2){
				row_2.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 3){
				row_3.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 4){
				row_4.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 5){
				row_5.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 6){
				row_6.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
			if (dto.getWeekDay() % 10 == 5 && dto.getSectionType() % 10 == 7){
				row_7.createCell(5).setCellValue(dto.getCourseName()+" 授课:"+dto.getTeacherName()
						+ LINE_SEPARATOR + "专业:"+dto.getMajorStr()+dto.getFieldStr()
						+ LINE_SEPARATOR + "班级:"+dto.getClassroom()
						+ LINE_SEPARATOR + "学时:"+dto.getHours()+"学分:"+dto.getCredit()
						+ LINE_SEPARATOR + dto.getClasses() 
						+ LINE_SEPARATOR + "周次:" + dto.getWeekIds()+" "+dto.getWeeks() );
			}
		}
		out = new FileOutputStream(file);
		wb.write(out);
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			if (out != null){
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
