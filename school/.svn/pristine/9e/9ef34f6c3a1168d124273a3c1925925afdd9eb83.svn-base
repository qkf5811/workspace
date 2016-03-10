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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.stu.dto.StudentDto;
import com.dkt.school.stu.model.Student;
import com.dkt.school.stu.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/fin")
public class TuitionSettingController {

	private final static Logger logger = LoggerFactory.getLogger(TuitionSettingController.class);
	
    @Autowired
    private StudentService studentService;
  
    //打开学费设置首页
    @RequestMapping("/tuitionSetting")
    public String openTuitionSettingPage(){
	    return "fin/tuitionSetting";
    }
  
   /**
    * 根据班级、姓名、学号模糊分页查询所有学生表信息
    * @param studentDto
    * @param page
    * @return String
    */
    @ResponseBody
    @RequestMapping("/getStudentList")
    public String getStudentList(StudentDto studentDto,PaginationCustom page){
        int total=studentService.getStudentCount(studentDto);
      //设置当前页面所选择的每页记录数
        page.setPageRecorders(page.getRows());
        page.setCurrentPage(page.getPage());
        page.setTotalRows(total);
        List<Student> studentList=studentService.getStudentByPage(studentDto, page);
        Gson gson=new Gson();
        JsonArray studentListJa=gson.toJsonTree(studentList, List.class).getAsJsonArray();
        JsonObject resultJo=new JsonObject();
        resultJo.add("rows",studentListJa);
        resultJo.addProperty("total", total);
        return resultJo.toString();
    }
    
    /**
     * 一键设置学费免费
     * @param setFreeIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/setTuitionFree")
    public String setTuitionFree(String setFreeIds){
    	JsonObject resultJson = new JsonObject();
		String[] tmp = setFreeIds.split(",");
		int[] allIds = new int[tmp.length];
		for (int i = 0; i < tmp.length; ++i) {
			allIds[i] = Integer.parseInt(tmp[i]);
		}
		int result = studentService.setTuitionFree(allIds);
		resultJson.addProperty("result", result);
		return resultJson.toString();
    }
    
    /**
     * 一键取消学费免费
     * @param cancelFreeIds
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancelTuitionFree")
    public String cancelTuitionFree(String cancelFreeIds){
    	JsonObject resultJson = new JsonObject();
		String[] tmp = cancelFreeIds.split(",");
		int[] allIds = new int[tmp.length];
		for (int i = 0; i < tmp.length; ++i) {
			allIds[i] = Integer.parseInt(tmp[i]);
		}
		int result = studentService.cancelTuitionFree(allIds);
		resultJson.addProperty("result", result);
		return resultJson.toString();
    }

	
	/**
	 * 下载免学费学生信息录入模板
	 * 
	 * @param response
	 */
	@RequestMapping("/downloadFreeTuitionStudentModelExcel")
	public void downloadFreeTuitionStudentModelExcel(HttpServletResponse response) {

		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "免学费学生信息批量录入模板.xls");

		// 设置响应头
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msexcel");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(dir.getName().getBytes(), "iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}// URLEncoder.encode(filename, "utf-8")

		// 下载
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(dir.getParent()
					+ "/免学费学生信息批量录入模板(填充).xls"));
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
	@RequestMapping("/importFreeTuitionStudentByExcel")
	public String importFreeTuitionStudentByExcel(
			@RequestParam("freeTuitionStudentFile") CommonsMultipartFile file) {
		System.out.println("文件已经上传!");
		JsonObject resultJson = new JsonObject();
		logger.info("---------通过excel导入免学费学生信息-----------");
		try {
			System.out.println("文件使用前:");
			if (file == null || file.getSize() == 0 || file.getInputStream() == null) {
				System.out.println("文件使用中...");
				resultJson.addProperty("result", -4);
				return resultJson.toString();
			}
		} catch (IOException e1) {
			
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
				String returnCode = studentService.addFreeTuitionStudentByExcel(in, format);
				String[ ] can = returnCode.split(",");
				int count=Integer.parseInt(can[0]);
				String errorStr ="无";
				if(can.length>1){
					errorStr = can[1];
				}
				
				resultJson.addProperty("result",count);
				resultJson.addProperty("errorStr",errorStr);
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
