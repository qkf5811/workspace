package com.dkt.school.equ.controller;

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

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.BuyDetailDto;
import com.dkt.school.equ.dto.EquipmentItemDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.BuyDetail;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.model.Equipment;
import com.dkt.school.equ.model.Storage;
import com.dkt.school.equ.service.BuyDetailService;
import com.dkt.school.equ.service.CategoryService;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.equ.service.EquipmentService;
import com.dkt.school.equ.service.StorageService;
import com.dkt.school.equ.service.impl.CategoryServiceImpl;
import com.dkt.school.equ.service.impl.EquipmentServiceImpl;
import com.dkt.school.system.service.EnumerationService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/equ")
public class EquipmentController {

	private final static Logger logger = LoggerFactory
			.getLogger(EquipmentController.class);

	private CategoryService categoryService;

	private EquipmentService equipmentService;

	private EquipmentItemService itemService;

	private StorageService storageService;

	private BuyDetailService buyDetailService;
	
	@Autowired
	private EnumerationService enumerationService;

	public BuyDetailService getBuyDetailService() {
		return buyDetailService;
	}

	@Autowired
	public void setBuyDetailService(BuyDetailService buyDetailService) {
		this.buyDetailService = buyDetailService;
	}

	public StorageService getStorageServce() {
		return storageService;
	}

	@Autowired
	public void setStorageServce(StorageService storageServce) {
		this.storageService = storageServce;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Autowired
	public void setCategoryService(CategoryServiceImpl categoryService) {
		this.categoryService = categoryService;
	}

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	@Autowired
	public void setEquipmentService(EquipmentServiceImpl equipmentService) {
		this.equipmentService = equipmentService;
	}

	public EquipmentItemService getItemService() {
		return itemService;
	}

	@Autowired
	public void setItemService(EquipmentItemService itemService) {
		this.itemService = itemService;
	}

	/*------------------设备入库的两种情况-------------------------*/
	/**
	 * 设备入库(新添加) 
	 * 
	 * @param category
	 * @param equipment
	 * @param equipmentItem
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEquItem")
	public String addEquipmentItem(EquipmentItemDto equipmentItem) {
		
		JsonObject resultJson = new JsonObject();
		logger.info("-----------------新添加的设备------------------");
/*		//设置使用状态为未使用
		int useStatus = 16001;
		equipmentItem.setUseStatus(useStatus);*/
		logger.info(new Gson().toJson(equipmentItem));
		
		/*
		if (equipmentItem.getEquipmentId() == 0
				|| equipmentItem.getEquipmentId() == null) {
			resultJson.addProperty("success", -1);
			return resultJson.toString();
		}*/
		if (equipmentItem.getCategoryId() == 0
				|| equipmentItem.getCategoryId() == null) {
			resultJson.addProperty("success", -1);
			return resultJson.toString();
		}
		
		// 将buyDateString 转换后赋值给buyDate
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		Date buyDate;
		try {
			buyDate = dateFormat.parse(equipmentItem.getBuyDateString());
			equipmentItem.setBuyDate(buyDate);
			logger.info(new Gson().toJson(equipmentItem));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// success = 1 表示入库成功，0表示入库失败
		resultJson.addProperty("success",
				itemService.addEquipmentItem(equipmentItem));

		return resultJson.toString();
	}

	/**
	 * 设备入库(归还)
	 * 
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/returnEqu")
	public String retEquipment(@RequestParam String codes) {
		JsonObject resultJson = new JsonObject();
		logger.info(codes);

		int count = 0;
		String[] code = codes.split(",");
		for (int i = 1; i < code.length; ++i) {
			int tmp = itemService.returnEquipmentItem(code[i]);
			if (tmp == 1)
				++count;
		}
		resultJson.addProperty("result", count);
		return resultJson.toString();
	}

	/**
	 * 设备出库(领用)
	 * 
	 * @param useRecordDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/useEqu")
	public String useEquipment(UseRecordDto useRecordDto) {
		JsonObject resultJson = new JsonObject();
		System.out.println("------------------输出领用记录表单信息-------------------");
		logger.info(new Gson().toJson(useRecordDto));
		// System.out.println(useRecordDto.getUseDealinneStr());
		// System.out.println(useRecordDto.getCodes());
		// System.out.println(useRecordDto.getUseUserId());

		// success: 1-->操作成功 , 0-->输入的设备编号不存在, -1 --> 通过前台获取的设备编号为空
		int[] result = itemService.useEquipmentItem(useRecordDto);
		resultJson.addProperty("result", new Gson().toJson(result));

		return resultJson.toString();
		// return "";
	}

	/**
	 * 设备出库(借用)
	 * 
	 * @param borrowRecordDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/borrowEqu")
	public String borrowEquipment(BorrowRecordDto borrowRecordDto) {
		JsonObject resultJson = new JsonObject();
		System.out.println("------------------输出领用记录表单信息-------------------");
		logger.info(new Gson().toJson(borrowRecordDto));
		// System.out.println(useRecordDto.getUseDealinneStr());
		// System.out.println(useRecordDto.getCodes());
		// System.out.println(useRecordDto.getUseUserId());

		// success: 1-->操作成功 , 0-->输入的设备编号不存在, -1 --> 通过前台获取的设备编号为空
		int[] result = itemService.borrowEquipmentItem(borrowRecordDto);
		resultJson.addProperty("result", new Gson().toJson(result));

		return resultJson.toString();
	}

	/**
	 * 总设备价值统计
	 * 
	 * @return
	 */
	@RequestMapping("/totalPrice")
	public String totalPriceOfEquipment(Model model) {
		JsonObject resultJson = new JsonObject();
		logger.info("-----------#get Total Price Of Equipment#------------");
		List<Category> cList = categoryService.getCategorysInfo();
		model.addAttribute("totalPriceCategory", cList);

		return "equ/equipmentTotalPrice";
	}

	// /**
	// * 获取设备分类信息
	// * @return
	// */
	// @ResponseBody
	// @RequestMapping("/getCategoryInfo")
	// public String getCategoryInfo() {
	// JsonObject resultJson = new JsonObject();
	// logger.info("-------------------获取设备分类信息--------------");
	// List<Category> cList = categoryService.getCategorysInfo();
	// Gson gson = new Gson();
	// logger.info(gson.toJson(cList));
	//
	// resultJson.addProperty("infoArr", gson.toJson(cList));
	// return resultJson.toString();
	// }
	/**
	 * 获取设备种类信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEquInfo")
	public String getEquipmentByCategoryId(@RequestParam int categoryId) {
		JsonObject resultJson = new JsonObject();
		logger.info("--------------------获取设备信息----------------");
		System.out.println("category id: " + categoryId);
		List<Equipment> eList = equipmentService
				.getEquipmentsByCategoryId(categoryId);
		System.out.println(eList);
		Gson gson = new Gson();
		// System.out.println(gson.toJson(eList));
		// resultJson.addProperty("", gson.toJson(eList));

		// return resultJson.toString();
		return gson.toJson(eList);
	}

	/**
	 * 获取所有仓库信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getStorageInfo")
	public String getStorageInfo() {
		JsonObject resultJson = new JsonObject();
		logger.info("------------获取存放地点信息----------------");

		Gson gson = new Gson();
		System.out.println(gson.toJson(storageService.getAllStoragesInfo()));
		resultJson.addProperty("info",
				gson.toJson(storageService.getAllStoragesInfo()));

		return resultJson.toString();
	}

	/**
	 * 获取某种类设备的所有记录
	 * 
	 * @param equipmentId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEquipmentItemCount")
	public String getEquipmentItemCountByEquId(int equipmentId, boolean isFree,
			PaginationCustom page) {
		int count = 0;
		if (!isFree)
			count = itemService.getEquipmentItemCount(equipmentId);
		else
			count = itemService.getEquipmentItemCountWith(equipmentId);

		System.out.println("------------------设备种类" + equipmentId + "有 "
				+ count + "条记录!-----------------");
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		// System.out.println("-------------------Page---------------------");
		// System.out.println(page.getPage() + ", " + page.getRows());
		page.setTotalRows(count);
		// 获取设备项目信息
		List<EquipmentItemDto> list = itemService.getEquipmentItemByPage(
				equipmentId, isFree, page);

		itemService.getEquipmentItemDtoList(list, storageService);

		// System.out.println(list);
		Gson gson = new Gson();
		JsonArray jArr = gson.toJsonTree(list, List.class).getAsJsonArray();

		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", jArr);
		resultJson.addProperty("total", count);
		return resultJson.toString();
	}

	@RequestMapping("/equipmentItemIn")
	public String equipmentIn() {

		return "equ/equipmentItemIn";
	}

	@RequestMapping("/equipmentItemOut")
	public String equipmentOut() {

		return "equ/equipmentItemOut";
	}

	@RequestMapping("/toAddEquipmentItem")
	public String addEquipmentItem(Model model) {
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------获取设备分类信息--------------");
		List<Category> cList = categoryService.getCategorysInfo();
		List<Storage> sList = storageService.getAllStoragesInfo();
//		List<BuyDetail> buyList = buyDetailService.findAllBuyDetail();
		Gson gson = new Gson();
		logger.info(gson.toJson(cList));
		logger.info(gson.toJson(sList));

		model.addAttribute("addCategoryList", cList);
		model.addAttribute("storageList", sList);
//		model.addAttribute("buyList", buyList);
		model.addAttribute("sourceList", enumerationService.getEnumValueListByEnumId(EnumerationType.SOURCE));
		return "equ/addEquipmentItem";
	}

	@RequestMapping("/toUseEquipmentItem")
	public String toUseEquipmentItem(Model model) {
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------获取设备分类信息--------------");
		List<Category> cList = categoryService.getCategorysInfo();
		Gson gson = new Gson();
		logger.info(gson.toJson(cList));

		model.addAttribute("useCategoryList", cList);
		return "equ/useEquipmentItem";
	}

	@RequestMapping("/toBorrowEquipmentItem")
	public String toBorrowEquipmentItem(Model model) {
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------获取设备分类信息--------------");
		List<Category> cList = categoryService.getCategorysInfo();
		Gson gson = new Gson();
		logger.info(gson.toJson(cList));

		model.addAttribute("borrowCategoryList", cList);
		return "equ/borrowEquipmentItem";
	}

	@RequestMapping("/toReturnEquipmentItem")
	public String toReturnEquipmentItem(Model model) {
		JsonObject resultJson = new JsonObject();
		logger.info("-------------------获取设备分类信息--------------");
		List<Category> cList = categoryService.getCategorysInfo();
		Gson gson = new Gson();
		logger.info(gson.toJson(cList));

		model.addAttribute("returnCategoryList", cList);
		return "equ/returnEquipmentItem";
	}

	@ResponseBody
	@RequestMapping("/getEquipmentItemByConditions")
	public String getEquipmentItemByConditions(int equipmentId, String code,
			int userId, PaginationCustom page) {
		System.out.println("设备id: " + equipmentId + ", 设备编号: " + code
				+ ", 用户id: " + userId);

		JsonObject resultJson = new JsonObject();
		code = code.trim();
		if (code.equals(""))
			code = null;
		if (userId == -99999)
			userId = 0;
		int count = itemService.getEquipmentItemCountByCondition(equipmentId,
				code, userId);
		logger.info("-----------根据条件获取(将要归还de)设备信息------------");
		System.out.println("-----------Count-----------------:" + count);
		System.out.println("设备id: " + equipmentId + ", 设备编号: " + code
				+ ", 用户id: " + userId);
		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalRows(count);

		List<EquipmentItemDto> list = itemService.getEquipmentItemByConditions(
				equipmentId, code, userId, page);

		System.out.println("list size: " + list.size());
		itemService.getEquipmentItemDtoList(list, storageService);

		// System.out.println(list);
		Gson gson = new Gson();
		JsonArray jArr = gson.toJsonTree(list, List.class).getAsJsonArray();

		resultJson.add("rows", jArr);
		resultJson.addProperty("total", count);
		return resultJson.toString();
	}

	@ResponseBody
	@RequestMapping("/getPriceListWithEquipmentId")
	public String getPriceListWithEquipmentId(int equipmentId) {
		if (new Integer(equipmentId) == null || equipmentId == 0) {
			return "";
		} else {
			Gson gson = new Gson();
			JsonObject resultJson = new JsonObject();
			// 获取设备项目信息
			BuyDetailDto dto = buyDetailService
					.getPriceListWidthEquipmentId(equipmentId);
			logger.info(gson.toJson(dto));
			resultJson.addProperty("data", gson.toJson(dto));

			return resultJson.toString();
		}
	}

	@ResponseBody
	@RequestMapping("/getAllPriceList")
	public String getAllPrice(PaginationCustom page) {
		JsonObject resultJson = new JsonObject();
		int count = equipmentService.getEquipmentCount();

		page.setCurrentPage(page.getPage());
		page.setPageRecorders(page.getRows());
		page.setTotalPages(count);

		List<BuyDetailDto> list = buyDetailService.getAllPrice(page);

		Gson gson = new Gson();
		JsonArray jArr = gson.toJsonTree(list, List.class).getAsJsonArray();

		resultJson.add("rows", jArr);
		resultJson.addProperty("total", count);
		return resultJson.toString();
	}

	@ResponseBody
	@RequestMapping("/getEquipmentItemByCode")
	public String getEquipmentItemByCode(String code, PaginationCustom page) {
		JsonObject resultJson = new JsonObject();
		EquipmentItemDto dto = null;
		if (code == null || "".equals(code.trim())) {
			return null;
		} else {
			page.setCurrentPage(page.getPage());
			page.setPageRecorders(page.getRows());
			page.setTotalPages(1);
			dto = itemService.getEquipmentItemByCode(code, page);
			if (dto != null) {
				List<EquipmentItemDto> list = new ArrayList<EquipmentItemDto>();
				list.add(dto);
				itemService.getEquipmentItemDtoList(list, storageService);
				Gson gson = new Gson();

				JsonArray jArr = gson.toJsonTree(list, List.class)
						.getAsJsonArray();

				resultJson.add("rows", jArr);
				resultJson.addProperty("total", 1);
				return resultJson.toString();
			} else
				return null;
		}
	}
	
	//下载导入模板
	@RequestMapping("downloadEquItemExcel.do")
	public void downloadEquItemExcel(HttpServletResponse response) {
		
		// 得到文件路径
		String basePath = this.getClass().getResource("/").toString()
				.substring(6);
		basePath = URLDecoder.decode(basePath);
		File file = new File(basePath);
		File dir = new File(file.getParent() + "/files/" + "设备批量录入模板.xls");

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
	 * 上传设备信息excel表
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/importEquItemByExcel")
	public String importEquItemByExcel(
			@RequestParam("equItemFile") CommonsMultipartFile file) {

		System.out.println("文件已经上传!/n文件名:" + file.getOriginalFilename());
		JsonObject resultJson = new JsonObject();
		logger.info("---------通过excel导入设备信息-----------");
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
				//批量导入
				resultJson.addProperty("result", itemService.addEquipmentItemsByExcel(in, format));
		//		resultJson.addProperty("result",
		//				teaService.addTeacherTotalInfoByExcel(in, format));
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
