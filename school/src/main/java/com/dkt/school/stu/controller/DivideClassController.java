package com.dkt.school.stu.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.sch.dto.MajorFieldDto;
import com.dkt.school.sch.model.MajorField;
import com.dkt.school.sch.service.MajorFieldService;
import com.dkt.school.sch.service.MajorService;
import com.dkt.school.stu.service.ClazzService;
import com.dkt.school.stu.service.StudentInfoService;
import com.dkt.school.stu.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/divideClass")
public class DivideClassController {
	
	private final static Logger logger = LoggerFactory.getLogger(DivideClassController.class);
	
	
	private MajorService majorService;
	@Autowired
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public MajorService getMajorService() {
		return majorService;
	}

	private MajorFieldService majorFieldService;
	@Autowired
	public void setMajorFieldService(MajorFieldService majorFieldService) {
		this.majorFieldService = majorFieldService;
	}
	public MajorFieldService getMajorFieldService() {
		return majorFieldService;
	}
	
	private ClazzService clazzService;
	@Autowired
	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}
	public ClazzService getClazzService() {
		return clazzService;
	}
	
	private StudentInfoService studentInfoService;
	@Autowired
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}	
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	/**
	 * 打开分班设置主页
	 * @return
	 */
	@RequestMapping("divideClassIndex")
	public String divideClassIndex(Model model){
		logger.info("----------------得到专业信息-----------------");
		model.addAttribute("majorList", majorService.getAllMajorInfo());
		return "stu/divideClass";
	}
	
	/**
	 * 根据专业id查找专业方向
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMajorFieldInfo")
	public String getMajorFieldByMajorId(@RequestParam int majorId ){
		//JsonObject resultJson = new JsonObject();
		logger.info("--------------------获取所有专业方向----------------");
		System.out.println("major id: " + majorId);
		List<MajorField> fieldList = majorFieldService.getMajorFieldInfoByMajorId(majorId);
		System.out.println(fieldList);
		Gson gson = new Gson();
		return gson.toJson(fieldList);
	}
	
	/**
	 * 根据专业方向id查询选择该专业的所有学生人数以及该专业的分班数
	 */
	@ResponseBody
	@RequestMapping("/getInfoByMarjorFieldId")
	public String getInfoByMarjorFieldId(int majorFieldId, PaginationCustom page,Model model){
		System.out.println("majorFieldId  :  "+majorFieldId);
		Integer classCount=clazzService.getClassCountByMajorFieldId(majorFieldId);
		System.out.println("classCount   :   "+classCount);
		Integer studentCount=studentInfoService.getStudentCountByMajorFieldId(majorFieldId);
		System.out.println("studentCount    :   "+studentCount);
		
		JsonObject resultJson = new JsonObject();
		MajorFieldDto dto = new MajorFieldDto();
		dto.setClassCount(classCount);
		dto.setMajorFieldStuCount(studentCount);
		Gson gson = new Gson();
		String str = gson.toJson(dto);
		resultJson.addProperty("classCount", gson.toJson(dto));
		System.out.println(resultJson.toString());
		System.out.println(str);
		model.addAttribute("dto", dto);
		return "[" + str + "]";
	}
	
	
	/**
	 * 通过手动进行分班
	 * @param majorFieldId
	 * @param majorFieldStuCount
	 * @param classCount
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toDoDivideClass")
	public String doDivideClassByCount(Integer majorFieldId,Integer majorFieldStuCount,Integer classCount){
		//System.out.println("专业id为："+majorFieldId+"平均每班"+eachClassStuCount+"人,剩下"+restCount+"人");
		
		Integer success=clazzService.toDivideClass(majorFieldId, majorFieldStuCount, classCount);
		System.out.println("success:"+success);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("success", success);
		return jsonObject.toString();
	}
	
	/**
	 * 导入Excel文件进行分班
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/divideClassByExcel",method=RequestMethod.POST)
	public String toDivideClassByUploadExcel(@RequestParam("fileField") CommonsMultipartFile file) throws IOException{
		JsonObject resultJson=new JsonObject();
		
		logger.info("\n---------------------解析Excel文件--------------------\n");
		int result;
		if(file!=null&&!file.isEmpty()){
			//获取文件名
			String originalFilename=file.getOriginalFilename();
			System.out.println("originalFilename= "+originalFilename);
			
			String format="";
			if(originalFilename.endsWith("xls")){
				format="xls";
			}else if(originalFilename.endsWith("xlsx")){
				format="xlsx";
			}else{
				resultJson.addProperty("result", 0);
				return new Gson().toJson(resultJson);
			}
			
			InputStream is=file.getInputStream();
			result=studentService.toDivideClassByUploadExcel(is, format);
			System.out.println("Result   为：  "+result);
			
		}else{
			result=0;
		}
		resultJson.addProperty("result", result);
		return new Gson().toJson(resultJson);
	}
	
	/**
	 * 
	 * @param filename
	 * @param response
	 */
	@RequestMapping("/downExcelFile")
	public void downloadDivideClassFile(String filename,HttpServletResponse response){
		logger.info("\n-----------------------文件下载测试-------------------");
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
					
					System.out.println("文件名称:" + filename);
					
					basePath = this.getClass().getResource("/").toString().substring(6);
					System.out.println("basePath:"+basePath);
					basePath = URLDecoder.decode(basePath);

					response.setCharacterEncoding("utf-8");
					response.setContentType("application/octet-stream");
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
						System.out.println("file[" + i + "]:" + files[i].getName());
						if (filename.equalsIgnoreCase(files[i].getName())) {
							// 找到文件的话就下载
							in = new BufferedInputStream(new FileInputStream(
									files[i].getAbsoluteFile()));
							System.out.println("download File:"
									+ files[i].getAbsoluteFile());
							out = new BufferedOutputStream(response.getOutputStream());
							byte[] bytes = new byte[1024];
							int len = 0;
							while ((len = in.read(bytes)) > 0) {
								out.write(bytes, 0, len);
							}
							out.close();
							in.close();
							System.out.println("下载完毕!");
						}
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {

				}
	}
}
