package com.dkt.school.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dao.CourseCustomMapper;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CourseOfManualAdjustDto;
import com.dkt.school.edu.service.CourseOfManualAdjustService;

@Service
public class CourseOfManualAdjustServiceImpl implements
		CourseOfManualAdjustService {

	@Autowired
	private CourseCustomMapper comaMapper;

	@Override
	public int findCountOfCourseByConditions(String code, String name,
			String teaName, PaginationCustom page) {
		// TODO Auto-generated method stub
		return comaMapper.selectCountOfCourseByConditions(code, name, teaName,
				page.getLimitation());
	}

	@Override
	public List<CourseOfManualAdjustDto> findCourseListByConditions(
			String code, String name, String teaName, PaginationCustom page) {
		// TODO Auto-generated method stub
		return comaMapper.selectCourseOfManualAdjustByConditions(code, name,
				teaName, page.getLimitation());
	}

	@Override
	public List<CourseInTeaCourseTableDto> findCourseOfTeacherByTeacherId(
			Integer id) {

		return comaMapper.selectCourseOfTeacherByTeacherId(id);
	}

	@Override
	@Transactional
	public List<CourseInTeaCourseTableDto> updateCourseOfTeacherInTeacherCourseTable(
			CourseInTeaCourseTableDto dto) {

		int result = 0;
		int effect = 0;
		boolean onlyOne = false; // 该教师只有一门课
		/**************** 先判断上课时间和上课地点是否有冲突 *******/
		// 时间
		// 1.星期和节次 相同，则比较上课周次(1.1比较连续周次的范围，1.2比较间断周次是否有重复)[在该老师的所有课程里进行比较]
		List<CourseInTeaCourseTableDto> list = comaMapper
				.selectCourseOfTeacherByTeacherId(dto.getTeacherId());
		// 控制台输出
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i).toString());
		}
		// 该教师的课程数量>1时才需要移除
		if (list.size() > 1) {
			onlyOne = false;
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i).getCourseScheduleId() == dto
						.getCourseScheduleId()) {
					list.remove(i);
					break;
				}
			}
			System.out.println("除去相同的课程后:");
			// 控制台输出
			for (int i = 0; i < list.size(); ++i) {
				System.out.println(list.get(i).toString());
			}
		} else {
			onlyOne = true;
		}

		// 判断 (星期、节次是否相同,再判断周次是否相同)
		for (int i = 0; i < list.size(); ++i) {

			int weekDay = list.get(i).getWeekDay();
			int weekDayOfDto = dto.getWeekDay();
			if (weekDay == weekDayOfDto) {

				int section = list.get(i).getSectionType();
				int sectionOfDto = dto.getSectionType();
				if (section == sectionOfDto) { // 星期、节次相同，则判断上课周次是否有交集

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

						System.out
								.println("正则:"
										+ list.get(i).getWeekIds().trim()
												.contains(","));
						System.out
								.println("正则:"
										+ list.get(i).getWeekIds().trim()
												.contains("，"));
						if (list.get(i).getWeekIds().trim().contains(",")
								|| list.get(i).getWeekIds().trim().contains("，")) {
							String weeksIdsStr[] = list.get(i).getWeekIds()
									.split(",|，");
							weeksIds = new ArrayList<Integer>();
							for (int j = 0; j < weeksIdsStr.length; ++j) {
								weeksIds.add(Integer.parseInt(weeksIdsStr[j]
										.trim()));
							}
						} else {
							
							weeksIds = new ArrayList<Integer>();
							weeksIds.add(Integer.parseInt(list.get(i)
									.getWeekIds().trim()));
							
						}
					}

					// 截取页面dto的周次
					List<Integer> dtoWeeks = null;
					List<Integer> dtoWeekIds = null;
					if (!dto.getWeeks().trim().equals("-")) {
						String dtoWeeksStr[] = dto.getWeeks().split("-");
						dtoWeeks = new ArrayList<Integer>();
						dtoWeeks.add(Integer.parseInt(dtoWeeksStr[0].trim()));
						dtoWeeks.add(Integer.parseInt(dtoWeeksStr[1].trim()));

					}
					if (!dto.getWeekIds().trim().equals("")) {

						System.out.println("正则:"+ list.get(i).getWeekIds().trim().contains(","));
						System.out.println("正则:"+ list.get(i).getWeekIds().trim()
												.contains("，"));
						if (dto.getWeekIds().trim().contains(",")
								|| dto.getWeekIds().trim().contains("，")) {// ([,，]*)
							dtoWeekIds = new ArrayList<Integer>();
							String dtoWeekIdsStr[] = dto.getWeekIds().split(
									",|，");
							for (int j = 0; j < dtoWeekIdsStr.length; ++j) {
								dtoWeekIds.add(Integer
										.parseInt(dtoWeekIdsStr[j].trim()));
							}
						} else {
							dtoWeekIds = new ArrayList<Integer>();
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
					if (!onlyOne) {
						// 比较连续周次(区间是否有交集)
						System.out.println("第 " + (i + 1) + " 个:");
						if (weeks != null && dtoWeeks != null) {
							if (dtoWeeksStart <= weeksStart) {

								if (dtoWeeksEnd >= weeksStart
										&& dtoWeeksEnd <= weeksEnd) {

									System.out.println("连续周次有交集!");
									List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
									ret.add(list.get(i));
									return ret;
								}
							} else if (dtoWeeksStart >= weeksStart
									&& dtoWeeksStart <= weeksEnd) {

								// if (dtoWeeksEnd >= weeksEnd) {

								System.out.println("连续周次有交集!");
								List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
								ret.add(list.get(i));
								return ret;
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
									List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
									ret.add(list.get(i));
									return ret;
								}
							}
						}
						// 比较连续和间断周次（是否包含）
						if (weeksStart != 0 && weeksEnd != 0
								&& dtoWeekIds != null) {

							for (int j = 0; j < dtoWeekIds.size(); ++j) {
								if (dtoWeekIds.get(j) >= weeksStart
										&& dtoWeekIds.get(j) <= weeksEnd) {

									System.out.println("间断周次和连续周次有包含关系!" + ", "
											+ dtoWeekIds.get(j));
									List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
									ret.add(list.get(i));
									return ret;
								}
							}
						}
						if (dtoWeeksStart != 0 && dtoWeeksEnd != 0
								&& weeksIds != null) {

							for (int j = 0; j < weeksIds.size(); ++j) {
								if (weeksIds.get(j) >= dtoWeeksStart
										&& weeksIds.get(j) <= dtoWeeksEnd) {

									System.out.println("间断周次和连续周次有包含关系!" + ", "
											+ weeksIds.get(j));
									List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
									ret.add(list.get(i));
									return ret;
								}
							}
						}
					}

					System.out
							.println("没有冲突，继续!\n判断同一时间的课程是否有地点冲突(所有该时间上的课程)!");// 我先写写sql...
					List<CourseInTeaCourseTableDto> courses = comaMapper
							.selectCourseWithTimeConflictAndAddressConflict(
									dto.getTeacherId(), // 教师id
									dto.getClassRoomId(),// 上课地点
									dto.getWeekDay(), // 星期几上课
									dto.getSectionType(), // 第几节上课
									dtoWeeksStart, // 连续周次开头
									dtoWeeksEnd, // 连续周次结尾
									dtoWeekIds); // 所有间断周次的list集合
					System.out.println("跟其他课程冲突的课程数量(其他老师的课程): "
							+ courses.size());
					System.out.println("跟其他课程冲突的课程: " + courses.toString());

					if (courses.size() > 0) { // 有地点冲突
						
						//除去相同scheduleId可以多个老师同时上一门课）
						for (int j = 0; j < courses.size(); ++j) {
							if (courses.get(j).getCourseScheduleId() == dto.getCourseScheduleId()) {
								courses.remove(j);
							}
						}
						if (courses.size() == 1) {
							return courses;
						}
					}
				}
			}
		}

		// 地点
		// 2.时间没有问题，则跟所有老师的课程进行比较，相同的时间是否在相同的教师上课
		// 更新专业和专业方向
		effect = comaMapper.updateMajorAndFieldByDto(dto);
		// 更新时间和地点
		effect = comaMapper.updateCourseTimeAndAddressByDto(dto);
		// 更新上课班级
		effect = comaMapper.updateCourseClassesByDto(dto);
		// 返回
		List<CourseInTeaCourseTableDto> ret = new ArrayList<CourseInTeaCourseTableDto>();
		ret.add(dto);
		return ret;
	}

}
