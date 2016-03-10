package com.dkt.school.stu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.service.MajorFieldService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.dto.StudentInfoDto;
import com.dkt.school.stu.model.StudentInfo;
import com.dkt.school.stu.service.StudentInfoService;
import com.dkt.school.stu.service.StudentService;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 
 * @author feng qikang
 * 
 */
@Controller
@RequestMapping("/stu")
public class ManagementOfNewStuController {

	private final static Logger logger = LoggerFactory
			.getLogger(ManagementOfNewStuController.class);

	@Autowired
	private MajorService majorService;

	@Autowired
	private MajorFieldService majorFieldService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentInfoService studentInfoService;

	@Autowired
	private EnumerationService enumerationService;

	/**
	 * 打开新生录入页面
	 * 
	 * @return
	 */
	@RequestMapping("/managementOfNewStu")
	public String inputNewStu(Model model) {

		logger.info("------------打开新生录入界面-------------");
		// model.addAttribute("major", "");
		return "stu/managementOfNewStu";
	}

	/**
	 * 打开招生信息录入页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/enrollStudent")
	public String ZhaoSheng(Model model) {

		logger.info("----------------得到专业信息-----------------");
		model.addAttribute("major", majorService.getAllMajorInfo());
		model.addAttribute("examineeType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.EXAMINEE_TYPE));
		model.addAttribute("sexType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE));
		model.addAttribute(
				"politicalFeatureType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE));
		model.addAttribute("healthTypeList", enumerationService
				.getEnumValueListByEnumId(EnumerationType.HEALTH_TYPE));
		model.addAttribute("booleanType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE));
		model.addAttribute("houseHoldType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE));
		model.addAttribute("examineeTypeList", enumerationService
				.getEnumValueListByEnumId(EnumerationType.EXAMINEE_TYPE));
		model.addAttribute("studyType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.STUDY_TYPE));
		model.addAttribute("studyMethodList", enumerationService
				.getEnumValueListByEnumId(EnumerationType.STUDY_METHOD_TYPE));
		model.addAttribute("enterSchoolType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.ENTER_SCHOOL_TYPE));
		model.addAttribute("eduStageType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.EDU_STAGE_TYPE));
		model.addAttribute("nationType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE));
		return "stu/enrollStudent";
	}

	@RequestMapping("/addSchoolRoll")
	public String addSchoolRoll() {

		return "stu/addSchoolRoll";
	}

	/**
	 * 新生录入的招生信息表格 (查询学生基本信息表)
	 * 
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchNewStudentInfo")
	public String searchNewStudentInfo(String studentName,
			PaginationCustom page) {

		JsonObject resultJson = new JsonObject();
		logger.info("-----------新生录入的招生信息表格-----------------");

		int total = studentInfoService.getCountOfNewStudentInfo(studentName);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);

		List<StudentInfoDto> list = studentInfoService.getNewStudentInfo(studentName, page);
		studentInfoService.getStudentInfoDtoList(list);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();

		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}

	/**
	 * 新生录入的招生信息table(查询学生表)
	 * 
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchStuOfTable")
	public String searchStuOfTable(@RequestParam("className")String className, 
			@RequestParam("studentName")String studentName,
			@RequestParam("studentCode")String studentCode, PaginationCustom page) {

		logger.info("-----------新生录入的招生信息表格----------------");
		JsonObject resultJson = new JsonObject();

		int total = 0;
		List<StudentDto> list = null;

		/*
		 * if (condition.trim().equals("")) { //条件为空，查询所有
		 * 
		 * total = studentService.searchCountOfStudentByPage();
		 * page.setCurrentPage(page.getPage());
		 * page.setPageRecorders(page.getRows()); page.setTotalRows(total); list
		 * = studentService.searchStudentByPage(page.getLimitation());
		 * studentService.getStudentDto(list); } else { //否则按条件
		 */

//		total = studentService.searchCountOfStudentByConditionWithPage(condition);
		total = studentService.searchStudentCountByThreeCondition(className, studentName, studentCode);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
//		list = studentService.searchStudentByConditionWithPage(condition,page.getLimitation());
		list = studentService.searchStudentByThreeCondition(className, studentName, studentCode, page.getLimitation());
		studentService.getStudentDto(list);
		// }

		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}

	/**
	 * 学籍信息下载
	 * @param response
	 */
	@RequestMapping("/downloadStudentInfo")
	public void downloadStudentInfoByExcel(HttpServletResponse response) {
		
		String basePath = this.getClass().getResource("/").toString().substring(6);
		System.out.println(basePath);
		basePath = URLDecoder.decode(basePath);
		System.out.println(basePath);
		String filename = "学籍信息.xls";
		File file = new File(basePath);
		file = new File(file.getParent() + "/files/" + filename);
	//	file.createNewFile();
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename=" + 
					new String(filename.getBytes(), "iso-8859-1"));//URLEncoder.encode(filename, "utf-8")
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream in;
		OutputStream out;
		
		try {
			file.createNewFile();
			studentService.getStudentInfoByExcelFile(file);
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 学生注册
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/studentRegist")
	public String studentRegist(String ids) {

		logger.info("----------学生注册---------");
		JsonObject resultJson = new JsonObject();
		String[] tmp = ids.split(",");
		int[] allIds = new int[tmp.length];
		for (int i = 0; i < tmp.length; ++i) {
			allIds[i] = Integer.parseInt(tmp[i]);
		}
		int result = studentService.studentRegist(allIds);
		resultJson.addProperty("result", result);

		return resultJson.toString();
	}

	/**
	 * 二级联动， 根据专业id得到相应的专业方向信息
	 * 
	 * @param majorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMajorFieldInfo")
	public String getMajorFieldInfo(@RequestParam int majorId) {
		logger.info("-----------根据专业id得到专业方向信息-----------------");

		return new Gson().toJson(majorFieldService
				.getMajorFieldInfoByMajorId(majorId));
	}

	/**
	 * 招生信息手工录入
	 * 
	 * @param si
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEnrollStuInfo")
	public String addEnrollStuInfo(StudentInfo si) {
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------学生招生信息录入-------------------");
		si.setIsDivideClass(2002);
		si.setStudyStatus(45001);//设置学生基本信息的就读状态为"未入读"
		resultJson.addProperty("result", studentInfoService.addStudentInfo(si));
		return new Gson().toJson(resultJson);
	}

	/**
	 * 招生信息Excel表录入
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadStuInfoExcel", method = RequestMethod.POST)
	public String uploadStuInfoExcel(
			@RequestParam("fileField") CommonsMultipartFile file) {
		JsonObject resultJson = new JsonObject();
		logger.info("------------------上传Excel表录入学生招生信息----------------------");
		if (!file.isEmpty() || file != null) {
			String originalFilename = file.getOriginalFilename();

			String format = "";
			if (originalFilename.endsWith("xls"))
				format = "xls";
			else if (originalFilename.endsWith("xlsx"))
				format = "xlsx";
			else {
				resultJson.addProperty("result", -1);
				return new Gson().toJson(resultJson);
			}

			try {
				resultJson.addProperty(
						"result",
						studentInfoService.addStuInfoByExcel(
								file.getInputStream(), format));
			} catch(NullPointerException e) {
				resultJson.addProperty(
						"result", -4);
			} catch(IllegalStateException e) {
				resultJson.addProperty(
						"result", -3);
			} catch(FileNotFoundException e) {
				resultJson.addProperty(
						"result", -5);
			}catch (Exception e) {
				throw new RuntimeException(e);
				// resultJson.addProperty("result", e.toString());
			}
		}
		return new Gson().toJson(resultJson);
	}

	// 文件下载
	// @ResponseBody
	@RequestMapping("/downloadFile")
	public void downloadFile(String filename, HttpServletResponse response) {

		logger.info("------------文件下载--------------");
		// JsonObject resultJson = new JsonObject();
		// resultJson.addProperty("result", -1); //找不到文件
		// 解决文件名中文乱码
		String basePath = "";
		try {
		//	filename = new String(filename.getBytes("iso-8859-1"), "utf-8");
		//	filename = URLDecoder.decode(filename);
			if (filename.endsWith("xlsx"))
				filename = filename.substring(0, filename.length()-5);
			else
				filename = filename.substring(0, filename.length()-4);
			String filenames[] = filename.split("%u");
			StringBuilder tmp = new StringBuilder();
			for (int i = 1; i < filenames.length; ++i) {
				System.out.println("%u" + filenames[i]);
				tmp.append((char)Integer.parseInt(filenames[i], 16));
			}
			if (filename.endsWith("xlsx"))
				filename = tmp.toString()+".xlsx";
			else
				filename = tmp.toString()+".xls";
			
			System.out.println("文件名:" + filename);

			basePath = this.getClass().getResource("/").toString().substring(6);
			basePath = URLDecoder.decode(basePath);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));//URLEncoder.encode(filename, "utf-8")
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		InputStream in;
		OutputStream out;
		try {
			File tmp = new File(basePath);
			File file = new File(tmp.getParent() + "/files");
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; ++i) {
				if (filename.equalsIgnoreCase(files[i].getName())) {
					// 找到文件的话就下载
					// resultJson.addProperty("result", 1); //找到文件,下载
					in = new BufferedInputStream(new FileInputStream(
							files[i].getAbsoluteFile()));
					out = new BufferedOutputStream(response.getOutputStream());
					byte[] bytes = new byte[1024];
					int len = 0;
					while ((len = in.read(bytes)) > 0) {
						out.write(bytes, 0, len);
					}
					out.close();
					in.close();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

		}

		// return resultJson.toString();
	}

	/**
	 * 数据绑定，用于string类型转成date类型
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true)); // true:允许输入空值，false:不能为空值
	}
}
