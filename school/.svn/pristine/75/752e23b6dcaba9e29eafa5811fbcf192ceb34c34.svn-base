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
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.StudentChargeOfArrearsDto;
import com.dkt.school.fin.service.StudentChargeService;
import com.dkt.school.sch.service.GradeService;
import com.dkt.school.sch.service.MajorService;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 学生欠费信息
 * @author 冯其康
 *
 */
@Controller
@RequestMapping("/fin")
public class StudentArrearsInfoController {
	
	private static final Logger logger = Logger.getLogger(StudentArrearsInfoController.class);
	
	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private StudentChargeService scService;
	
	/**
	 * 打开学生欠费信息tab
	 * @param model
	 * @return
	 */
	@RequestMapping("openArrearsInfoTab")
	public String openArrearsInfoTab(Model model) {
		
		model.addAttribute("grade", gradeService.getAllGrade());
		model.addAttribute("major", majorService.getAllMajor());
		return "/fin/arrearsInfo";
	}
	
	/**
	 * 根据条件查询学生欠费信息
	 * @param gradeId
	 * @param fieldId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findStudentArrearsInfo")
	public String findStudentArrearsInfo(int gradeId, int majorId, int fieldId, PaginationCustom page) {
	
		logger.info("-----------查询学生欠费信息----------------");
		JsonObject resultJson = new JsonObject();
		
		System.out.println("gradeId: " + gradeId);
		System.out.println("fieldId : " + fieldId);
		
		//数量
		int total = scService.findCountOfStudentChargeOfArrears(gradeId, majorId, fieldId, page);
		System.out.println("数量: " + total);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		//记录
		List<StudentChargeOfArrearsDto> list = scService.findOfStudentChargeOfArrears(gradeId, majorId, fieldId, page);
		
		System.out.println("记录: " + list);
		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create()
				.toJsonTree(list, List.class).getAsJsonArray();
				
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		
		return resultJson.toString();
		
	}
	
	/**
	 * 导出学生欠费信息
	 * @param gradeId
	 * @param fieldId
	 */
	@RequestMapping("exportStudentArrearsInfo")
	public void exportStudentArreasInfo(int gradeId, int majorId, int fieldId, HttpServletResponse response) {
		
		logger.info("---------------导出学生欠费信息-------------");
		JsonObject resultJson = new JsonObject();

		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "学生欠费信息.xls");
		
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
			scService.getArreasInfoExcel(gradeId, majorId, fieldId, dir);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//下载
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dir.getParent()
					+ "/学生欠费信息(填充).xls"));
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
}
