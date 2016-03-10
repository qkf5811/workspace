package com.dkt.school.fin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.fin.dto.StudentPaymentDto;
import com.dkt.school.fin.service.StudentPaymentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 处理批扣文件导入并更新学生缴费信息的Controller
 * @author JanGin Chan
 * 2015年8月28日
 */
@Controller
@RequestMapping("/fin")
public class StudentPaymentController {

	//文件下载中间路径
	private String MIDDLE_PATH = "/files/"; 
	@Autowired
	private StudentPaymentService spService;

	private static final Logger logger 
			= LoggerFactory.getLogger(StudentPaymentController.class);
	
	/**
	 * 跳转到批扣文件导入页面
	 * @return
	 */
	@RequestMapping("/toImportPaymentResult")
	public String toImportPaymentResult(){
		return "fin/importPaymentResult";
	}
	
	@RequestMapping("/toStudentPaymentList")
	public String toStudentPaymentList(){
		return "fin/studentPaymentList";
	}
	
	/**
	 * 导入数据到临时excel文件
	 * @param param
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@ResponseBody
	@RequestMapping("/exportStuPayList")
	public String exportStuPayList(@RequestParam("param")String param){
		System.out.println("请求参数-------"+param);
		List<StudentPaymentDto> list = spService.exportStuPayList(param);
		if (list != null && list.size() > 0){
			logger.info(list.toString());
			String basePath = this.getClass().getResource("/").toString()
					.substring(6);
			basePath = URLDecoder.decode(basePath);
			String filename = "批扣模板文件.xls";
			logger.info("------路径-----"+basePath);
			String directory = "/" + new Date().getTime();
			try{
				File file = new File(basePath);
				File dir = new File(new File(file.getParent()).getParent());
				logger.debug("-----上级目录-----"+dir.getAbsolutePath());
				file = new File(dir.getAbsoluteFile() + "/" + filename);
				dir.mkdir();
				file.createNewFile();
				spService.export2Excel(list,file);
			} catch(Exception e){
				e.printStackTrace();
			}
			return directory + "/" + filename;
		}
		return "-1";
	}
	
	/**
	 * 下载导出的批扣文件
	 * @param filename
	 * @param response
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/downloadExportExcel")
	public void downloadExportExcel(String filename,HttpServletResponse response){
		InputStream in = null;
		OutputStream out = null;
		if (filename.endsWith("xls")){
			filename = filename.substring(0,filename.length() - 4);
		} else if (filename.endsWith("xlsx")){
			filename = filename.substring(0,filename.length() - 5);
		}
		String[] filenames = filename.split("%u");
		StringBuilder sb = new StringBuilder();
		String head = filenames[0];
		for (int i = 1;i < filenames.length;i++){
			sb.append((char)Integer.parseInt(filenames[i],16));
		}
		logger.info("----文件名编码后----"+sb.toString());
		if (filename.endsWith("xls")){
			filename = head + sb.toString() + ".xls";
		} else if (filename.endsWith("xlsx")){
			filename = head + sb.toString() + ".xlsx";
		}
		String basePath = this.getClass().getResource("/")
				.toString().substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(new File(file.getParent()).getParent());
		file = new File(dir.getAbsoluteFile() + filename);
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] bytes = new byte[1024];
			int len = 0;
			while (-1 != (len = in.read(bytes))) {
				out.write(bytes, 0, len);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			String parentPath = file.getParent();
			file.delete();
			File diectory = new File(parentPath);
			diectory.delete();
		}
		
	}
	
	
	/**
	 * 获取学生缴费信息列表
	 * @param stuPayName
	 * @param stuPayCode
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStudentPaymentList")
	public String getStudentPaymentList(String stuPayName,
										String stuPayCode,
									PaginationCustom page){
		JsonObject json = new JsonObject();
		int totalRows = spService.getStudentPaymentCount(stuPayName, stuPayCode);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		List<StudentPaymentDto> list = 
					spService.getStudentPaymentList(stuPayName, 
							stuPayCode,page.getLimitation());
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total", totalRows);
		return json.toString();
	}
	
	/**
	 * 上传文件（已作废）
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadStuPayInfo")
	public String uploadStuPayInfo(@RequestParam("stuPayfileXls")CommonsMultipartFile file){
		JsonObject json = new JsonObject();
		if (file != null && !file.isEmpty()){
			String filename = file.getOriginalFilename();
			logger.info("-----初始文件名-------"+filename);
			String ext = "";
			if (filename.endsWith("xls")){
				ext = "xls";
			} else if (filename.endsWith("xlsx")){
				ext = "xlsx";
			} else{
				//非excel文件
				json.addProperty("result", -1);
				return json.toString();
			}
			try{
				spService.uploadStuPayInfoExcel(file.getInputStream(),ext);
			} catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		return json.toString();
	}
	/**
	 * 下载批扣模板文件
	 * @param filename
	 * @param response
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/downloadStuPayBaseFile")
	public void downloadStuPayBaseFile(String filename,HttpServletResponse response){
		logger.info("------------批扣模板文件下载--------------");
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
			logger.info("文件名:" + filename);
			String basePath = this.getClass().getResource("/").toString().substring(6);
			basePath = URLDecoder.decode(basePath);
			File dir = new File(new File(basePath).getParent());
			File file = new File(dir.getAbsolutePath() +MIDDLE_PATH+ filename);
			logger.info("------------basePath----------------"+dir.getAbsolutePath());
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));
			in = new BufferedInputStream(new FileInputStream(file));
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
	@InitBinder
    public void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
}
