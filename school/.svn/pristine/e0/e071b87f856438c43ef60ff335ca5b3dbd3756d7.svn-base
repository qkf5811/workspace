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
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.binding.BindingException;
import org.apache.log4j.Logger;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.NewStudentPaymentOfExcelDto;
import com.dkt.school.fin.service.NewStudentPaymentService;
import com.dkt.school.sch.dao.MajorCustomMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 学生缴费资料导入
 * @author 冯其康
 *
 */
@Controller
@RequestMapping("/fin")
public class NewStudentPaymentController {

	private static final Logger logger = Logger.getLogger(NewStudentPaymentController.class);
	
	@Autowired
	private NewStudentPaymentService nspService;
	
	@Autowired
	private MajorCustomMapper majorMapper;
	
	/**
	 * 打开导入页面
	 * @return
	 */
	@RequestMapping("importStudentPayment")
	public String importStudentPayment(Model model) {
		
		model.addAttribute("major", majorMapper.getAllMajor());
		return "fin/importNewStudentPayment";
	}
	
	/**
	 * 下载新生缴费资料模板
	 * @param response
	 */
	@RequestMapping("downloadNewStudentPaymentExcel")
	public void downloadNewStudentPaymentExcel(HttpServletResponse response) {
		
		// 得到文件路径
				String basePath = this.getClass().getResource("/").toString()
						.substring(6);
				basePath = URLDecoder.decode(basePath);
				File file = new File(basePath);
				File dir = new File(file.getParent() + "/files/" + "新生缴费资料模板.xls");

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
	 * 批量导入新生缴费资料ByExcel
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("importNewStudentPaymentByExcel")
	public String importNewStudentPaymentByExcel(
			@RequestParam("newStudentPaymentExcel") CommonsMultipartFile file) {
		
		System.out.println("上传的文件名:" + file.getOriginalFilename());
		long result = 0;
		if (!file.isEmpty() && file != null) {
			
			if (file.getOriginalFilename().endsWith("xls")) {
				
				try {
					//导入
					InputStream in = file.getInputStream();
					result = nspService.importNewStudentPaymentByExcel(in);
					System.out.println("导入结果:" + result);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "-1";//文件读取出错
				} catch(IllegalStateException e) {
					e.printStackTrace();
					return "-5"; //格式错误
				} catch (BindingException e) {
					e.printStackTrace();
					return result + "";
				}
			} else {
				return "-3";//非模板文件
			}
		} else {
			return "-2";//文件上传出错
		}
		System.out.println(result + "");
		return result + "";
	}
	
	/**
	 * 查询新生缴费资料信息
	 * @param name
	 * @param admissionNumber
	 * @param idCard
	 * @param fieldId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findNewStudentPayment")
	public String searchNewStudentPayment(String name, String admissionNumber, String idCard, int fieldId, PaginationCustom page) {
		
		logger.info("-------------查询新生缴费资料信息---------------");
		JsonObject resultJson = new JsonObject();
		
		if (name != null)
			name = name.trim();
		if (idCard != null)
			idCard = idCard.trim();
		if (admissionNumber != null)
			admissionNumber = admissionNumber.trim();
		
		//查询记录数量
		int total = nspService.findNewStudentPaymentCountByPage(name,admissionNumber, idCard, fieldId, page);
		System.out.println("数量: " + total);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(total);
		
		//查询记录
		List<NewStudentPaymentOfExcelDto> list = nspService.findNewStudentPaymentByPage(name,admissionNumber, idCard, fieldId, page);
		System.out.println("记录: " + list);
		// 设置日期str属性
		JsonArray ja = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create()
				.toJsonTree(list, List.class).getAsJsonArray();
				
		resultJson.add("rows", ja);
		resultJson.addProperty("total", total);
		return resultJson.toString();
	}
}
