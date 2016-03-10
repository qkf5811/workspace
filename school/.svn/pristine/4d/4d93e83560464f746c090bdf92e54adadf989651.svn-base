package com.dkt.school.edu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseInTeaCourseTableDto;
import com.dkt.school.edu.dto.CoursePlanOfCourseScheduleDto;
import com.dkt.school.edu.dto.CourseScheduleDto;
import com.dkt.school.edu.model.CourseSchedule;
import com.dkt.school.edu.service.CourseScheduleService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.CampusService;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.model.Clazz;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.service.TeacherService;
import com.dkt.school.user.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@Controller
@RequestMapping("/edu")
public class CourseScheduleController {
	
	private static final Logger logger =
				LoggerFactory.getLogger(CourseScheduleController.class);
	@Autowired
	private GradeService gradeService;
	@Autowired
	private EnumerationService emSerivce;
	@Autowired
	private CourseScheduleService csService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CampusService campusService;
	
	@RequestMapping("/toImportSchedulePage")
	public String toImportSchedulePage(){
		return "edu/importScheduleXLS";
	}
	
	/**
	 * 下载幼师课表模板文件
	 * @param filename
	 * @param response
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/toDownloadCourseBaseFile")
	public void toDownloadCourseBaseFile(String filename,HttpServletResponse response){
		logger.info("------------文件下载--------------");
		String MIDDLE_PATH = "/WEB-INF/files/"; 
		InputStream in = null;
		OutputStream out = null;
		try{
			if (filename.endsWith("xlsx")){
				filename = filename.substring(0, filename.length()-5);
			} else if (filename.endsWith("xls")){
				filename = filename.substring(0, filename.length()-4);
			}
			String filenames[] = filename.split("%u");
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < filenames.length; ++i) {
				System.out.println("%u" + filenames[i]);
				sb.append((char)Integer.parseInt(filenames[i], 16));
			}
			//logger.info("-----------sb------------"+sb.toString());
			if (filename.endsWith("xlsx")){
				filename = sb.toString()+".xlsx";
			}
			else {
				filename = sb.toString()+".xls";
			}
			//System.out.println("文件名:" + filename);
			
//			String path = this.getClass().getResource("/").toString();
//			logger.warn("------------path----------------"+path);
			String basePath = this.getClass().getResource("/").toString().substring(6);
			basePath = URLDecoder.decode(basePath);
			logger.info("------------basePath----------------"+basePath);
			File realfile = new File(basePath);
			File dir = new File(new File(realfile.getParent()).getParent());
			realfile = new File(dir.getAbsoluteFile() +MIDDLE_PATH+ filename);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));
			in = new BufferedInputStream(new FileInputStream(realfile));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] bytes = new byte[in.available()];
			int len = 0;
			while (-1 != (len = in.read(bytes))) {
				out.write(bytes, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (in != null){
					in.close();
				}
				if (out != null){
					out.close();
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 导入excel课表
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadSchedule")
	public String uploadSchedule(@RequestParam("courseFileXls")CommonsMultipartFile file){
		JsonObject json = new JsonObject();
		if (file != null && !file.isEmpty()){
			String originalFileName = file.getOriginalFilename();
			String ext = null;
			if (originalFileName.endsWith("xls")){
				ext = "xls";
			} 
			else if (originalFileName.endsWith("xlsx")){
				ext = "xlsx";
			} else{
				//文件格式错误
				json.addProperty("result", -1);
				return json.toString();
			}
			try {
				json.addProperty("result", csService			//根据返回值来弹出信息
						.importCourseScheduleByExcel(file.getInputStream(),ext));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return json.toString();
	}
	/**
	 * 手动排课
	 * @param model
	 * @return
	 */
	@RequestMapping("/toImportScheduleManual")
	public String toImportScheduleManual(Model model){
		List<Major> majorList = majorService.getAllMajor();
		List<Grade> gradeList = gradeService.getAllGrade();
		model.addAttribute("majorList", majorList);
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("weekDay", emSerivce.getEnumValueListByEnumId(EnumerationType.WEEK_DAY));
		model.addAttribute("sections", emSerivce.getEnumValueListByEnumId(EnumerationType.SECTION_TYPE));
		model.addAttribute("majorId", majorService.getAllMajorInfo());
		model.addAttribute("campusId", campusService.getAllCampus());
		model.addAttribute("courseType", emSerivce.getEnumValueListByEnumId(EnumerationType.COURSE_TYPE));
		model.addAttribute("examineType", emSerivce.getEnumValueListByEnumId(EnumerationType.EXAMINE_TYPE));
		return "edu/importScheduleManual";
	}
	
	@ResponseBody
	@RequestMapping("/importScheduleManual")
	public String importScheduleManual(){
		return "";
	}
	
	/**
	 * 转到我的课程表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMyCourseSchedule")
	public String toMyCourseSchedule(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null){
			//判断用户是否是老师(班主任)
			Integer userId = user.getId();
			Integer teacherId = teacherService.getTeacherIdByUserId(userId);
			model.addAttribute("teacherId", teacherId);
			Integer classId = teacherService.getClassIdByTeacherId(teacherId);
			if (classId != null){
				Integer gradeId = teacherService.getGradeIdByClassId(classId);
				model.addAttribute("gradeId",gradeId);
				model.addAttribute("classId",classId);
			}
		}
		return "edu/myCourseSchedule";
	}
	
	/**
	 * 我的课程表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/myCourseSchedule")
	public String myCourseSchedule(HttpServletRequest request){
		JsonObject json = new JsonObject();
		HttpSession session = request.getSession();
		//Integer userId = ((User)session.getAttribute("user")).getId();
		User user = (User) session.getAttribute("user");
		if (null != user){
			Integer	userId = user.getId();
			List<CourseScheduleDto> list = csService.getPersonalCourseScheduleByUserId(userId);
			//model.addAttribute("schedule", list);	
			JsonArray jsArr = new Gson().toJsonTree(list,List.class).getAsJsonArray();
			json.add("rows", jsArr);
		}
		return json.toString();
	}
	/**
	 * 专业和专业方向的二级联动
	 * @param majorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getFieldByMajorId")
	public String getFieldByMajorId(Integer majorId){
		List<MajorField> list = majorService.getFieldByMajorId(majorId);
		JsonArray jsArr = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		return jsArr.toString();
	}
	
	/**
	 * 年级和班级的二级联动
	 * @param gradeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassByGradeId")
	public String getClassByGradeId(Integer gradeId){
		List<Clazz> list = gradeService.getClassByGradeId(gradeId);
		JsonArray jsArr = new Gson().toJsonTree(list,List.class).getAsJsonArray();
		return jsArr.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getClassByGradeIdAndFieldId")
	public String getClassByGradeId(Integer gradeId, Integer fieldId){
		System.out.println(gradeId);
		List<Clazz> list = gradeService.getClassByGradeIdAndFieldId(gradeId, fieldId);
		JsonArray jsArr = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		return jsArr.toString();
	}
	/**
	 * 查询班级课表
	 * @param model
	 * @return
	 */
	@RequestMapping("/toFindCourseSchedule")
	public String toFindCourseSchedule(Model model){
		List<Grade> list = gradeService.getAllGrade();
		model.addAttribute("gradeList", list);
		return "edu/findCourseSchedule";
	}
	
	/**
	 * 查询教师课表
	 * @return
	 */
	@RequestMapping("/toFindTeacherSchedule")
	public String toFindTeacherSchedule(){
		return "edu/findTeacherSchedule";
	}
	/**
	 * 按照条件查询课表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findCourseSchedule")
	public String findCourseSchedule(Integer gradeId,String classes,String teacherName){
		List<CourseScheduleDto> list = csService.findCourseSchedule(gradeId,classes,teacherName);
		logger.warn(""+list.size());
		JsonObject json = new JsonObject();
		JsonArray jsArr = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsArr);
		return json.toString();
	}

	/**
	 * 查询班级课表
	 * @param gradeId
	 * @param classId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showClassSchedule")
	public String showClassSchedule(Integer gradeId,Integer classId){
		JsonObject json = new JsonObject();
		List<CourseScheduleDto> list = csService.showClassSchedule(gradeId,classId);
		JsonArray jsonArray = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsonArray);
		return json.toString();
	}
	
	/**
	 * 导出课程表到临时excel
	 * @param gradeId
	 * @param classId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping("/exportSchedule")
	public String exportSchedule(Integer gradeId,String classes,String teacherName){
		logger.info("------------------导出课表到excel----------------------");
		String basepath = this.getClass().getResource("/").toString().substring(6);
		basepath = URLDecoder.decode(basepath);
		logger.info("--------------基本路径:"+basepath+"-----------------------");
		String filename = "江门幼师课表.xls";
		File file = new File(basepath);
		String timeExt = "/" + new Date().getTime();
		File dir = new File(new File(file.getParent()).getParent() + timeExt);
		file = new File(dir.getAbsoluteFile() + "/" + filename);
		List<CourseScheduleDto> list = csService.findCourseSchedule(gradeId, classes, teacherName);
		if (null == list || list.size() == 0){
			//根据所给条件查出的课表不存在
			return "-1";
		}
		for (CourseScheduleDto dto : list){
			System.out.println(dto);
		}
		try {
			dir.mkdir();
			file.createNewFile();
			csService.exportSchedule2Xls(file,list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("file:" + timeExt + "/" + filename);
		return timeExt + "/" + filename;
	}
	
	/**
	 * 弹出下载excel表格窗口
	 * @param file
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/toDownloadExportSchedule")
	public void toDownloadExportSchedule(HttpServletResponse response,String filename){
		
		System.out.println("file:" +filename);
		if (filename.endsWith("xls")){
			filename = filename.substring(0, filename.length() - 4);
		}
		else if (filename.endsWith("xlsx")){
			filename = filename.substring(0, filename.length() - 5);
		}
		String[] filenames = filename.split("%u");
		String head = filenames[0];
		StringBuilder sb = new StringBuilder();
		for (int i = 1;i < filenames.length; i++){
			//文件名转码
			sb.append((char)Integer.parseInt(filenames[i], 16));
		}
		//重新拼接文件名
		if (filename.endsWith("xlsx")){
			filename = head + sb.toString() + ".xlsx";
		} else {
			filename = head + sb.toString() + ".xls";
		}
		System.out.println("file:" +filename);
		//获得文件路径
		String basepath = this.getClass().getResource("/").toString().substring(6);
		basepath = URLDecoder.decode(basepath);
		//logger.info("------下载导出文件中的basepath-----"+basepath);
		File file = new File(basepath);
		File dir = new File(new File(file.getParent()).getParent());
		file = new File(dir.getAbsoluteFile() + filename);
		System.out.println("file:" +file.getAbsolutePath());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/msexcel");
		try {
			response.setHeader("Content-Disposition", "attachment;filename=" + 
						new String(file.getName().getBytes(),"iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			int len = 0;
			byte[] bytes = new byte[in.available()];
			while ((len = in.read(bytes)) != -1 ){
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
		} catch(Exception ex){
			ex.printStackTrace();
		} finally{
			//删除临时文件
			String dirpath = file.getParent();
			File dirFile = new File(dirpath);
			file.delete();
			dirFile.delete();
		}
		
	}

	/**
	 * 根据班级id查询课程
	 * @author 冯其康
	 * @param majorId
	 * @param fieldId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findCourseByClassId")
	public String findTeachCourseByMajorIdAndFieldId(int classId) {
		
		logger.info("----------------根据班级id查询课程--------------");
		List<CourseInTeaCourseTableDto> list = csService.findCourseByClassId(classId);
		return new Gson().toJsonTree(list, List.class).getAsJsonArray().toString();
	}
	
	/**
	 * 根据排课表id删除课程记录
	 * @author 冯其康
	 * @param scheduleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toDeleteCourseScheduleByScheduleIdAndCourseSeq")
	public String toDeleteCourseScheduleByScheduleId(int scheduleId) {
		
		logger.info("-------------根据排课表id删除课程记录-----------------");
		
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("result", csService.removeCourseScheduleById(scheduleId));
		
		return resultJson.toString();
	}
	
	/**
	 * 查询课程计划
	 * @author 冯其康
	 * @param majorId
	 * @param fieldId
	 * @param courseName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findCoursePlanOfCourseSchedule")
	public String findCoursePlanOfCourseSchedule(int majorId, int fieldId, String courseName, String className,PaginationCustom page) {
		
		logger.info("------------查询课程计划---------------");
		JsonObject resultJson = new JsonObject();
		courseName = courseName.trim();
		System.out.println(majorId + ", " + fieldId + ", " + courseName);
		int total = csService.findCountOfCoursePlanInCourseSchedule(majorId, fieldId, courseName, className);
		System.out.println("总记录数: " + total);		
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<CoursePlanOfCourseScheduleDto> list = csService.findCoursePlanInCourseSchedule(majorId, fieldId, courseName,className, page);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	/**
	 * 添加排课记录（手动排课）
	 * @author 冯其康
	 * @param cs
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toAddCourseScheduleByManual")
	public String toAddCourseScheduleByManual(CourseSchedule cs, int classId) {
		
		System.out.println("cs: " + cs.toString() + ", classId: " + classId);
		logger.info("-----------插入排课表记录-----------------");
		JsonObject resultJson = new JsonObject();
		System.out.println("插入前先判断各种冲突!\nT_T");
		int flag = csService.isConflit(cs, classId);
		if (flag == -10) {
			
			int effect = csService.addCourseSchedule(cs);
			if (effect == 1)
				resultJson.addProperty("result", flag);
			else 
				resultJson.addProperty("result", -100);
		} else {
			
			resultJson.addProperty("result", flag);
		}	
		
		return resultJson.toString();
	}

}
