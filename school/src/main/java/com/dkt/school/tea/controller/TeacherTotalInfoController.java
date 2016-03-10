package com.dkt.school.tea.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.BadSqlGrammarException;
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
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.system.model.Enumeration;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
import com.dkt.school.tea.dto.SelectedOfExportTeacher;
import com.dkt.school.tea.dto.TeacherEduExperienceDto;
import com.dkt.school.tea.dto.TeacherTotalInfoDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.model.TeacherEduExperience;
import com.dkt.school.tea.service.TeacherEduExperienceService;
import com.dkt.school.tea.service.TeacherService;
import com.dkt.school.tea.service.TeacherTotalInfoService;
import com.dkt.school.user.service.DepartmentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class TeacherTotalInfoController {

	private final static Logger logger = LoggerFactory
			.getLogger(TeacherInfoController.class);

	@Autowired
	EnumerationService enumerationService;

	@Autowired
	MajorService majorService;

	@Autowired
	TeacherTotalInfoService teaService;

	@Autowired
	DepartmentService deptService;

	@Autowired
	TeacherEduExperienceService teaEduExpService;
	
	@Autowired
	TeacherService teacherService;

	/**
	 * 跳转到教师信息页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/teaTotalInfo")
	public String teacherInfo(Model model) {

		logger.info("----------跳转到教师信息页面------------------");
		// 户籍类型
		model.addAttribute("householdType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE));
		// 政治面貌
		model.addAttribute(
				"politicalFeatureType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE));
		// 性别
		model.addAttribute("sex", enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE));
		// 专业list
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		// 民族
		model.addAttribute("nationType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE));
		// 职称
		model.addAttribute("titleType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE));
		// 部门
		model.addAttribute("department", deptService.findAllDepartment());
		// 学历
		model.addAttribute("degreeType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE));
		// 婚姻状况
		model.addAttribute("maritalStatus", enumerationService
				.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS));
		// 在职状态
		model.addAttribute("positionType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE));
		// 职工类型
		model.addAttribute("staffType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE));
		// 教育类型
		model.addAttribute(
				"educationType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE));
		// 证件类型
		model.addAttribute("idCardType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE));
		// 国籍
		model.addAttribute("countryId", enumerationService
				.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID));

		return "/tea/teaTotalInfo";
	}

	/**
	 * 打开教师信息录入tab
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/openInputTeacherInfoTab")
	public String openInputTeacherInfoTab(Model model) {

		logger.info("--------------打开教师信息录入tab-------------");
		// 专业list
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		// 职称
		model.addAttribute("titleType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE));
		// 教职工类型
		model.addAttribute("staffType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE));
		// 职位状态
		model.addAttribute("positionType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE));
		// 教育类型
		model.addAttribute(
				"educationType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE));
		// 学历
		model.addAttribute("degreeType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE));
		// 性别list
		model.addAttribute("sexType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE));
		// 证件类型
		model.addAttribute("idCardType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE));
		// 国籍
		model.addAttribute("countryId", enumerationService
				.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID));
		// 政治面貌
		model.addAttribute(
				"politicalFeature",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE));
		// 民族
		model.addAttribute("nationType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE));
		// 户籍类型
		model.addAttribute("householdType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE));
		// 婚姻状况
		model.addAttribute("maritalStatus", enumerationService
				.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS));
		// 部门
		model.addAttribute("department", deptService.findAllDepartment());

		return "/tea/inputTeacherInfo";
	}

	@RequestMapping("/openTeacherInfoTab")
	public String openTeacherInfoTab(int id, Model model) {

		model.addAttribute("id", id);
		return "/tea/showTeacherTotalInfo";
	}

	/**
	 * 显示教师完整信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherTotalInfoListByTeacherId")
	public String getTeacherTotalInfoListByTeacherId(int id) {

		logger.info("--------显示教师信息-----------");
		TeacherTotalInfoDto dto = teaService.searchTeacherTotalInfoDtoById(id);
		List<TeacherTotalInfoDto> dtoList = new ArrayList<TeacherTotalInfoDto>();
		dtoList.add(dto);
		teaService.dtoListToDtoStrList(dtoList);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(dto);
	}
	
	/**
	 * 显示教师个人完整信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherAllInfoListByTeacherId")
	public String getTeacherAllInfoListByTeacherId(int id) {

		logger.info("--------显示教师信息-----------");
		TeacherTotalInfoDto dto = teaService.searchTeacherAllInfoDtoById(id);
		List<TeacherTotalInfoDto> dtoList = new ArrayList<TeacherTotalInfoDto>();
		dtoList.add(dto);
		teaService.dtoListChangeToDtoStrList(dtoList);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(dto);
	}
	
	/**
	 * 教育信息录入
	 * @param teacherId
	 * @param model
	 * @return
	 */
	@RequestMapping("/openInputTeacherEduExpTab")
	public String openInputTeacherEduExpTab(int teacherId, Model model) {
		
		logger.info("------------教育信息录入--------------");
		model.addAttribute("name", teacherService.selectByPrimaryKey(teacherId).getName());
		model.addAttribute("id", teacherId);
		//教育类型
		model.addAttribute(
				"educationType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE));
		//学历
		model.addAttribute("degreeType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE));
		
		return "tea/inputTeacherEduExp";
	}
	
	/**
	 * 添加教育经历信息
	 * @param eduExp
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTeacherEduExpInfo")
	public String addTeacherEduExpInfo(TeacherEduExperienceDto eduExp) {
		
		logger.info("----------添加教育经历信息----------");
		JsonObject resultJson = new JsonObject();
		resultJson.addProperty("result", teaService.addTeacherEduExp(eduExp));
		return resultJson.toString();
	}
	/**
	 * 打开教育经历信息列表
	 * @return
	 */
	@RequestMapping("/openTeacherEduExpPage")
	public String openTeacherEduExpPage(@RequestParam("id")int id,  Model model) {
		
		logger.info("----------跳转到教师教育经历信息------------");
		Teacher tea = teacherService.selectByPrimaryKey(id);
		String name = tea.getName();
		model.addAttribute("name", name);
		model.addAttribute("teacherId", id);
		return "tea/teacherEduExpList";
	}
	/**
	 * 得到教师教育经历信息列表
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchTeacherEduExpList")
	public String searchTeacherEduExpList(PaginationCustom page) {
	
		logger.info("--------------教师教育经历信息列表--------------");
		JsonObject resultJson = new JsonObject();
		
		int total = teacherService.getTeacherCount();
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<TeacherTotalInfoDto> dtoList = teaService.searchTeacherTotalInfo(null, page);
		
		JsonArray ja = new Gson().toJsonTree(dtoList, List.class).getAsJsonArray();
		
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
	
	/**
	 * 根据teacherId得到教师教育经历datagrid
	 * @param id
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTeacherEduExpInfoList")
	public String getTeacherEduExpInfoList(int id, PaginationCustom page) {
		
		logger.info("------------教师教育经历--------------");
		JsonObject resultJson = new JsonObject();
		
		int total = teaEduExpService.getAllTeaEduExpCountByTeacherId(id);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		List<TeacherEduExperienceDto> list = teaEduExpService.getAllTeaEduExpByTeacherId(id);
		teaEduExpService.dtoListToDtoStrList(list);
		JsonArray ja = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteEduExpById")
	public String deleteEduExpById(int id) {
		
		logger.info("--------------删除教育经历记录------------");
		JsonObject resultJson = new JsonObject();
		
		resultJson.addProperty("result", teaEduExpService.deleteById(id));
		
		return resultJson.toString();
	}
	
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/importTeacherTotalInfoByExcel", method = RequestMethod.POST)
	public String importTeacherTotalInfoByExcel(
			@RequestParam("teaFile") CommonsMultipartFile file) {
		System.out.println("文件已经上传!");
		JsonObject resultJson = new JsonObject();
		logger.info("---------通过excel导入教师信息-----------");
		try {
		//	System.out.println("文件使用前:");
			if (file == null || file.getSize() == 0 || file.getInputStream() == null) {
				System.out.println("文件使用中...");
				resultJson.addProperty("result", -4);
				return resultJson.toString();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if ( file != null && !file.isEmpty()) {
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
				InputStream in = file.getInputStream();
				resultJson.addProperty("result",
						teaService.addTeacherTotalInfoByExcel(in, format));
			} catch(IOException e) {
				resultJson.addProperty("result", -3);
				e.printStackTrace();
			} catch(BadSqlGrammarException e) {
				resultJson.addProperty("result", -3);
				e.printStackTrace();
			} catch (IllegalStateException e) {
				resultJson.addProperty("result", -5);
				e.printStackTrace();
			}
			
		}
		return resultJson.toString();
		
	}
	/**
	 * 打开教师编辑tab
	 * @param teacherId
	 * @param model
	 */
	@RequestMapping("/openEditTeacherTotalInfo")
	public String openEditTeacherTotalInfo(int teacherId, Model model) {


		
		model.addAttribute("teacherId", teacherId);
		// 专业list
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		// 职称
		model.addAttribute("titleType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_TITLE_TYPE));
		// 教职工类型
		model.addAttribute("staffType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_STAFF_TYPE));
		// 职位状态
		model.addAttribute("positionType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.POSITION_TYPE));
		// 教育类型
		model.addAttribute(
				"educationType",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.TEACHER_EDUCATION_TYPE));
		// 学历
		model.addAttribute("degreeType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.TEACHER_DEGREE_TYPE));
		// 性别list
		model.addAttribute("sexType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.SEX_TYPE));
		// 证件类型
		model.addAttribute("idCardType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.ID_CARD_TYPE));
		// 国籍
		model.addAttribute("countryId", enumerationService
				.getEnumValueListByEnumId(EnumerationType.COUNTRY_ID));
		// 政治面貌
		model.addAttribute(
				"politicalFeature",
				enumerationService
						.getEnumValueListByEnumId(EnumerationType.POLITICAL_FEATURE_TYPE));
		// 民族
		model.addAttribute("nationType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.NATION_TYPE));
		// 户籍类型
		model.addAttribute("householdType", enumerationService
				.getEnumValueListByEnumId(EnumerationType.HOUSEHOLD_TYPE));
		// 婚姻状况
		model.addAttribute("maritalStatus", enumerationService
				.getEnumValueListByEnumId(EnumerationType.MARITAL_STATUS));
		// 部门
		model.addAttribute("department", deptService.findAllDepartment());
		
		return "tea/editTeacherTotalInfo";
	}

	@ResponseBody
	@RequestMapping("/getTeacherTotalInfo")
	public String getTeacherTotalInfo(int teacherId) {
		
		JsonObject resultJson = new JsonObject();
		Gson gson = new Gson();
		
		TeacherTotalInfoDto dto = teaService
				.searchTeacherTotalInfoDtoById(teacherId);
		
		resultJson.addProperty("result", gson.toJson(dto));
		return resultJson.toString();
	}
	/**
	 * 根据TeacherTotalInfoDto查询教师完整信息
	 * 
	 * @param dto
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchTeacherInfo")
	public String searchTeacherInfo(TeacherTotalInfoDto dto,
			PaginationCustom page) {

		logger.info("-----------查询教师信息---------------");
		JsonObject resultJson = new JsonObject();

		// total:所有记录数并设置page的属性
		int total = teaService.searchCountOfTeacherTotalInfo(dto);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);

		// 查询记录
		List<TeacherTotalInfoDto> list = teaService.searchTeacherTotalInfo(dto,
				page);
		
		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
				.toJsonTree(list, List.class).getAsJsonArray();
		
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}

	/**
	 * 添加教师完整信息
	 * 
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addNewTeacher")
	public String addNewTeacher(TeacherTotalInfoDto dto) {

		logger.info("------------------添加教师信息----------------");
		JsonObject resultJson = new JsonObject();


		int result = 0;
		try {
			result = teaService.addNewTeacher(dto);
		} catch (Exception e) {
			result = 0;
		}
		resultJson.addProperty("result", result);
		return resultJson.toString();
	}

	/**
	 * 修改教师完整信息
	 * 
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("editTeacherTotalInfo")
	public String editTeacherTotalInfo(TeacherTotalInfoDto dto) {

		logger.info("---------修改教师完整信息------------");
		JsonObject resultJson = new JsonObject();
		int result = 0;
		try {
			result = teaService.editTeacherTotalInfo(dto);
		} catch (Exception e) {
			result = 0;
		}
		resultJson.addProperty("result", result);
		return resultJson.toString();
	}

	/**
	 * 导出花名册(得到临时路径)
	 * 
	 * @param dto
	 * @param idArr
	 * @Param response
	 */
	@ResponseBody
	@RequestMapping("/exportRoster")
	public String exportRoster(SelectedOfExportTeacher dto,
			@RequestParam("idArr[]") int idArr[]) {

		logger.info("---------------导出花名册-------------");
		JsonObject resultJson = new JsonObject();

		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		logger.info("-----------------"+basePath);
		basePath = URLDecoder.decode(basePath);
		String filename = "教师花名册.xls";
		File file = new File(basePath);
		// file = new File(file.getParent() + "/files/" + filename);
		String dirStr = "/" + new Date().getTime();
		File dir = new File(new File(file.getParent()).getParent() + dirStr);

		file = new File(dir.getAbsoluteFile() + "/" + filename);

		try {
			// response.setCharacterEncoding("utf-8");
			// response.setContentType("application/msexcel");
			// response.setHeader("Content-Disposition", "attachment;filename="
			// +
			// new String(filename.getBytes(),
			// "iso-8859-1"));//URLEncoder.encode(filename, "utf-8")
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream in;
		OutputStream out;

		try {
			dir.mkdir();
			file.createNewFile();
			teaService.exportRoster(idArr, dto, file);
			// File f1 = new File(file);
			// in = new BufferedInputStream(new FileInputStream(file));
			// out = new BufferedOutputStream(response.getOutputStream());

			// byte[] bytes = new byte[1024];
			// int len = 0;
			// while ((len = in.read(bytes)) > 0) {
			// out.write(bytes, 0, len);
			// }
			// out.close();
			// in.close();
			return dirStr + "/" + filename;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return "0";

	}

	/**
	 * 得到花名册路径，下载
	 * 
	 * @param file
	 * @param response
	 */
	@RequestMapping("/toDownloadExportRoster")
	public void toDownloadExportRoster(String file, HttpServletResponse response) {

		if (file.endsWith("xlsx"))
			file = file.substring(0, file.length() - 5);
		else
			file = file.substring(0, file.length() - 4);
		String filenames[] = file.split("%u");
		StringBuilder tmp = new StringBuilder();
		String head = filenames[0];
		for (int i = 1; i < filenames.length; ++i) {
			tmp.append((char) Integer.parseInt(filenames[i], 16));
		}
		if (file.endsWith("xlsx"))
			file = head + tmp.toString() + ".xlsx";
		else
			file = head + tmp.toString() + ".xls";

		// 拼成完整路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		logger.info("------------------"+basePath);
		basePath = URLDecoder.decode(basePath);
		File file1 = new File(basePath);
		File dir = new File(new File(file1.getParent()).getParent());
		file1 = new File(dir.getAbsoluteFile() + file);
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(file1.getName().getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// URLEncoder.encode(filename, "utf-8")
		InputStream in;
		OutputStream out;
		try {
			in = new BufferedInputStream(new FileInputStream(file1));
			out = new BufferedOutputStream(response.getOutputStream());

			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			String dirStr = file1.getParent();
			file1.delete();
			File f = new File(dirStr);
			f.delete();
		}
	}

	/**
	 * 导出完整信息前先检查教育经历表是否已有记录
	 * 
	 * @param TeacherId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isAddTeacherEduExp")
	public String isAddTeacherEduExp(int teacherId) {

		JsonObject resultJson = new JsonObject();
		TeacherEduExperience result = teaEduExpService
				.getTeaEduExpByTeacherId(teacherId);
		if (result == null) {
			resultJson.addProperty("result", 0);
		} else {
			resultJson.addProperty("result", 1);
		}
		return resultJson.toString();
	}

	/**
	 * 导出完整个人信息
	 * 
	 * @param teacherId
	 * @param response
	 */
	@RequestMapping("/exportPersonalInfo")
	public void exportPersonalInfo(int teacherId, HttpServletResponse response) {

		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "教职工个人信息.xls");

		// 设置响应头
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(dir.getName().getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// URLEncoder.encode(filename, "utf-8")
			// 填充模板
		try {
			teaService.getTeacherInfoExcel(teacherId, dir);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 下载
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dir.getParent()
					+ "/教职工个人信息(填充).xls"));
			out = new BufferedOutputStream(response.getOutputStream());

			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 下载教职工信息录入模板
	 * 
	 * @param response
	 */
	@RequestMapping("/downloadTeaModelExcel")
	public void downloadTeaModelExcel(HttpServletResponse response) {

		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "教职工信息批量录入模板.xls");

		// 设置响应头
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(dir.getName().getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// URLEncoder.encode(filename, "utf-8")

		// 下载
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dir));
			out = new BufferedOutputStream(response.getOutputStream());

			byte[] bytes = new byte[1024];
			int len = 0;
			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 上传教职工信息excel表
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addTeacherByExcel")
	public String addTeacherByExcel(
			@RequestParam("teaFile") CommonsMultipartFile file) {

		JsonObject resultJson = new JsonObject();
		if (!file.isEmpty() && file != null) {
			// 导入
			resultJson.addProperty("result", 1);
			return resultJson.toString();
		} else {
			// 上传失败
			resultJson.addProperty("result", -2);
			return resultJson.toString();
		}
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
