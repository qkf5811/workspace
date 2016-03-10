package com.dkt.school.tea.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.tea.dto.TeacherWorkExperienceDto;
import com.dkt.school.tea.model.Teacher;
import com.dkt.school.tea.model.TeacherWorkExperience;
import com.dkt.school.tea.service.TeacherResumeService;
import com.dkt.school.tea.service.TeacherService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/tea")
public class TeacherResumeController {

	private static final Logger logger = LoggerFactory.getLogger(TeacherResumeController.class);
	
	@Autowired
	private TeacherService teaService;
	@Autowired
	private TeacherResumeService trs;
	
	/*作废*/
	@RequestMapping("/toResumeList")
	public String toResumeList(@RequestParam("id")Integer id,Model model){
		Teacher teacher = teaService.selectByPrimaryKey(id);
		String name = teacher.getName();
		model.addAttribute("name", name);
		model.addAttribute("teacherId", id);
		return "/tea/resumeList";
	}
	
	@RequestMapping("/toAddResumeItem")
	public String toAddResumeInfo(Integer id,Model model){
		Teacher teacher = teaService.selectByPrimaryKey(id);
		model.addAttribute("t", teacher);
		return "/tea/addResumeItem";
	}
	
	@ResponseBody
	@RequestMapping("/addSingleResumeItem")
	public String addSingleResumeItem(TeacherWorkExperience record){
		JsonObject json = new JsonObject();
		json.addProperty("result", trs.addSingleResumeInfo(record));
		return json.toString();
	}
	
	/**
	 * 通过excel导入教职工履历信息
	 */
	@ResponseBody
	@RequestMapping("/importResumeInfoByXLS")
	public String importResumeInfoByXLS(@RequestParam("fileXls")CommonsMultipartFile file){
		logger.info("---------------------------------导入教职工简历excel-------------------------------");
		JsonObject json = new JsonObject();
		if (file != null && !file.isEmpty()){
			String originalFileName = file.getOriginalFilename();
			String ext = "";
			if (originalFileName.endsWith("xls")){
				ext = "xls";
			} 
			else if (originalFileName.endsWith("xlsx")){
				ext = "xlsx";
			} else{
				json.addProperty("result", -1);
				return json.toString();
			}
			try {
				json.addProperty("result", trs.importTeaResumeByXLS(file.getInputStream(),ext));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return json.toString();
		
	}
	

	
	@RequestMapping("/toUpdateResumeItem")
	public String toUpdateResumeItem(Integer id,Model model){
		TeacherWorkExperienceDto  dto  = trs.getTeacherWorkExperienceById(id);
		//System.out.println("\n\n\n"+dto+"\n\n\n");
		model.addAttribute("dto", dto);
		return "tea/updateResumeItem";
	}
	
	@ResponseBody
	@RequestMapping("/updateResumeItem")
	public String updateResumeItem(TeacherWorkExperience twe){
		
		JsonObject json = new JsonObject();
		json.addProperty("success",trs.updateResumeItem(twe));
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getResumeList")
	public String getResumeList(String code,String name,PaginationCustom page){
		int rows = trs.getTeacherWorkCount(code,name);
		page.setCurrentPage(page.getPage());
		page.setTotalRows(rows);
		page.setPageRecorders(page.getRows());
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		List<TeacherWorkExperienceDto> list = trs.getTeacherWorkList(code,name,page.getLimitation());
		JsonArray jsArr = gson.toJsonTree(list, List.class).getAsJsonArray();
		jsonObject.add("rows",jsArr);
		jsonObject.addProperty("total", rows);
		return jsonObject.toString();
	}
	
	@ResponseBody
	@RequestMapping("/deleteTeaWorkItem")
	public String deleteTeaWorkItem(Integer id){
		JsonObject json = new JsonObject();
		json.addProperty("success",trs.deleteTeaWorkItem(id));
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getAllTeacher")
	public String getAllTeacher(String name,String code,PaginationCustom page){
		int totalRows = trs.getTeahcerCount(name,code);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		List<Teacher> list = trs.getAllTeacher(name,code,page.getLimitation());
		JsonArray jsArr = gson.toJsonTree(list,List.class).getAsJsonArray();
		json.addProperty("total",totalRows);
		json.add("rows",jsArr);
		return json.toString();
	}

	/*新增修改后的*/
	@ResponseBody
	@RequestMapping("/getSingleResumeList")
	public String getSingleResumeList(Integer id,PaginationCustom page){
		Integer totalRows = trs.getSingleWorkExperienceCount(id);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(totalRows);
		List<TeacherWorkExperienceDto> list = trs.getSingleWorkExperienceById(id);
		JsonObject json = new JsonObject();
		JsonArray jsArr = new Gson().toJsonTree(list, List.class).getAsJsonArray();
		json.add("rows", jsArr);
		json.addProperty("total", totalRows);
		return json.toString();
	}
	@InitBinder
    public void initBinder(WebDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
	
	/*
	 * 基本Excel模板下载
	 * 
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/downloadBaseExcel")
	public void downloadBaseExcel(HttpServletResponse response,String filename){
		logger.info("------------文件下载--------------");
		final String MIDDLE_PATH = "/WEB-INF/files/"; 
		InputStream in = null;
		OutputStream out = null;
		try{
			String basePath = "";
			if (filename.endsWith("xlsx"))
				filename = filename.substring(0, filename.length()-5);
			else
				filename = filename.substring(0, filename.length()-4);
			String filenames[] = filename.split("%u");
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < filenames.length; ++i) {
				System.out.println("%u" + filenames[i]);
				sb.append((char)Integer.parseInt(filenames[i], 16));
			}
			if (filename.endsWith("xlsx"))
				filename = sb.toString()+".xlsx";
			else
				filename = sb.toString()+".xls";
			
			System.out.println("文件名:" + filename);
			
//			String path = this.getClass().getResource("/").toString();
//			logger.warn("------------path----------------"+path);
			basePath = this.getClass().getResource("/").toString().substring(6);
			logger.info("------------basePath----------------"+basePath);
			basePath = URLDecoder.decode(basePath);
			File realfile = new File(basePath);
			File dir = new File(new File(realfile.getParent()).getParent());
			//System.out.println("\n\n\n"+dir+"\n\n");
			
			realfile = new File(dir.getAbsoluteFile() +MIDDLE_PATH+ filename);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes(), "iso-8859-1"));//URLEncoder.encode(filename, "utf-8")
			
			in = new BufferedInputStream(new FileInputStream(realfile));
			out = new BufferedOutputStream(response.getOutputStream());
			//trs.downloadTeaResumeExcel(in,realfile);
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
}