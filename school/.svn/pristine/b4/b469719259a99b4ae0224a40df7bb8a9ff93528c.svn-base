package com.dkt.school.fin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.edu.dto.CourseTeacherDto;
import com.dkt.school.edu.dto.TeachCourseDto;
import com.dkt.school.edu.dto.TeachTaskDto;
import com.dkt.school.equ.controller.EquipmentController;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.fin.dto.StudentAccountDto;
import com.dkt.school.fin.service.StudentAccountService;
import com.dkt.school.sch.model.Grade;
import com.dkt.school.sch.model.Major;
import com.dkt.school.sch.model.StudyYear;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.system.model.EnumerationValue;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/fin")
public class StudentAccountController {
	private final static Logger logger = LoggerFactory
			.getLogger(StudentAccountController.class);
	
	private StudentAccountService studentAccountService;
	
	
	private GradeService gradeService;
	private MajorService majorService;
	
	
	public MajorService getMajorService() {
		return majorService;
	}

	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}


	public StudentAccountService getStudentAccountService() {
		return studentAccountService;
	}


	public GradeService getGradeService() {
		return gradeService;
	}
	
	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	@Autowired
	public void setStudentAccountService(StudentAccountService studentAccountService) {
		this.studentAccountService = studentAccountService;
	}


	//跳转到设置学生账号首页
	@RequestMapping("/studentAccountList")
	public String studentAccountList(Model model) {
		List<Major> majorList = majorService.getAllMajor();
		List<Grade> gradeList = gradeService.getAllGrade();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("majorList", majorList);
		return "fin/studentAccountList";
	}

	
	/**
	 * 查询所有学生账号记录
	 */
	@ResponseBody
	@RequestMapping("/getStudentAccountList")
	public String toAddStudentAccount(String finStuName, Integer finGrade,String finClassName, Integer finMajor, Integer finField, PaginationCustom page) {
		int total = studentAccountService.getStudentAccountCount(finStuName,finGrade,finClassName,finMajor,finField);
		// 设置当前页面所选择的每页记录数
		page.setPageRecorders(page.getRows());
		page.setCurrentPage(page.getPage());
		page.setTotalRows(total);
		List<StudentAccountDto> studentAccountDto = studentAccountService.getStudentAccountsByPage(finStuName,finGrade,finClassName,finMajor,finField,page);
		Gson gson = new Gson();
		JsonArray studentAccountListJa = gson.toJsonTree(studentAccountDto, List.class)
				.getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", studentAccountListJa);
		resultJson.addProperty("total", total);

		return resultJson.toString();
	}
	
	/**
	 * 编辑学生账号信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toEditStudentAccount")
	public String toEditStudentAccount(StudentAccountDto studentAccountDto,
			Model model) {
		model.addAttribute("studentAccountId", studentAccountDto.getId());
		model.addAttribute("studentId", studentAccountDto.getStudentId());
		model.addAttribute("name", studentAccountDto.getName());
		model.addAttribute("account", studentAccountDto.getAccount());
		model.addAttribute("finGrade", studentAccountDto.getFinGrade());
		model.addAttribute("finClassName", studentAccountDto.getFinClassName());
		model.addAttribute("finMajor", studentAccountDto.getFinMajor());
		model.addAttribute("finField", studentAccountDto.getFinField());
		model.addAttribute("finStuName", studentAccountDto.getFinStuName());
		model.addAttribute("finStuCode", studentAccountDto.getFinStuCode());
		return "fin/editStudentAccount";
	}
	
	/**
	 * 保存编辑学生账号信息的数据
	 * 
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editStudentAccount")
	public String editStudentAccount(StudentAccountDto studentAccountDto) {
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("data", studentAccountService.updateStudentAccount(studentAccountDto));
		return jsonObject.toString();
	}
	
	/**
	 * 跳转到添加学生银行记录的页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddStudentAccount")
	public String toAddStudentAccount() {	
		return "fin/newStudentAccount";
	}
	
	//添加学生账号记录
	@ResponseBody
	@RequestMapping("/addStudentAccount")
	public String addStudentAccount(StudentAccountDto saDto) {
		JsonObject resultJo = new JsonObject();
		logger.info(new Gson().toJson(saDto));
		resultJo.addProperty("result", studentAccountService.addStudentAccount(saDto));
		return resultJo.toString();
	}	
	
	//取得所有未录入的学生的id
	@ResponseBody
	@RequestMapping("/getStudentIdsByNotSettingStudentAccount")
	public String getStudentIdsByNotSettingStudentAccount() {
		/*List<StudentAccountDto> studentAccountDto = studentAccountService.getStudentAccounts();
		List<StudentDto> studentDto = studentAccountService.findAllStudent();
		List<StudentDto> stuDto = new  ArrayList<StudentDto>();
		int count = 0;
		for(StudentDto sDto : studentDto) {
			for(StudentAccountDto saDto:studentAccountDto) {
				if(sDto.getId()!=saDto.getStudentId()) {
					count++;
					if(count==studentAccountDto.size()) {
						stuDto.add(sDto);
					}
				}
			}
			count=0;
		}*/

		List<Integer> stuIds = studentAccountService.getStudentIdsByNotSettingStudentAccount();
		
		JsonArray json = new Gson().toJsonTree(stuIds, List.class).getAsJsonArray();
		
		logger.info(new Gson().toJson(json));
		return json.toString();
	}		
	
	
	/**
	 * 下载学生账号信息录入模板
	 * 
	 * @param response
	 */
	@RequestMapping("/downloadStudentAccountModelExcel")
	public void downloadStudentAccountModelExcel(String stuId, HttpServletResponse response) {

		String[] tmp = stuId.split(",");
		Integer[] stuIds = new Integer[tmp.length];
		for (int i = 0; i < tmp.length; ++i) 
			stuIds[i] = Integer.parseInt(tmp[i]);
		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "学生银行账号信息批量录入模板.xls");

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
			studentAccountService.getStudentAccountExcel(stuIds, dir);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 下载
		InputStream in = null;
		OutputStream 
		out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dir.getParent()
					+ "/学生银行账号信息批量录入模板(填充).xls"));
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
	 * 上传文件
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/importStudentAccountByExcel")
	public String importStudentAccountByExcel(
			@RequestParam("studentAccountFile") CommonsMultipartFile file) {
		System.out.println("文件已经上传!");
		JsonObject resultJson = new JsonObject();
		logger.info("---------通过excel导入学生银行信息-----------");
		try {
			System.out.println("文件使用前:");
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
						studentAccountService.addStudentAccountByExcel(in, format));
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
}
