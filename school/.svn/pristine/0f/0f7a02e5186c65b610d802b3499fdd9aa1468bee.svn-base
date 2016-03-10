package com.dkt.school.equ.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.Pagination;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.equ.dao.BorrowRecordMapper;
import com.dkt.school.equ.dao.CategoryCustomMapper;
import com.dkt.school.equ.dao.EquipmentCustomMapper;
import com.dkt.school.equ.dao.EquipmentItemCustomMapper;
import com.dkt.school.equ.dao.StorageCustomMapper;
import com.dkt.school.equ.dao.UseRecordMapper;
import com.dkt.school.equ.dto.BorrowRecordDto;
import com.dkt.school.equ.dto.EquipmentDto;
import com.dkt.school.equ.dto.EquipmentItemDto;
import com.dkt.school.equ.dto.EquipmentUseDto;
import com.dkt.school.equ.dto.UseRecordDto;
import com.dkt.school.equ.model.Category;
import com.dkt.school.equ.model.Equipment;
import com.dkt.school.equ.model.EquipmentItem;
import com.dkt.school.equ.model.EquipmentItemExample;
import com.dkt.school.equ.model.Storage;
import com.dkt.school.equ.service.EquipmentItemService;
import com.dkt.school.equ.service.StorageService;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;

@Service
@Transactional
public class EquipmentItemServiceImpl implements EquipmentItemService {

	@Autowired
	private EquipmentCustomMapper equipMapper;
	@Autowired
	private EquipmentItemCustomMapper itemMapper;
	@Autowired
	private UseRecordMapper useRecordMapper;
	@Autowired
	private BorrowRecordMapper borrowRecordMapper;
	@Autowired
	private CategoryCustomMapper categoryMapper;
	@Autowired
	private EnumerationService enService;
	@Autowired
	private StorageCustomMapper storageMapper;
	
	/**
	 * 设备入库：添加新设备
	 */
	@Override
	public int addEquipmentItem(EquipmentItemDto item) {
		// 判断设备种类是否存在，
		Equipment equip = equipMapper.getEquipmentByName(item.getCategoryId(), item.getName());
		// 如果设备种类不存在，则添加新的设备种类
		if (equip == null) {
			equip = new Equipment();
			equip.setCategoryId(item.getCategoryId());
			equip.setName(item.getName());
			equip.setBrand(item.getBrand());
			equip.setModel(item.getModel());
			equipMapper.insert(equip);
		}
		
		item.setEquipmentId(equip.getId());
		// 新添加设备，使用状态为1：未使用

//		record.setUseStatus(16001);

		item.setUseStatus(16001);

		// 判断设备项信息是否完整
		if (item.getCode() == null || "".equals(item.getCode().trim())
				|| item.getEquipmentId() == null
				|| item.getSource() == null)
			return -1;
		else
			return itemMapper.insert(item);
	}

	/**
	 * 设备入库：归还设备 (修改记录的各种状态)
	 * 
	 * @param code
	 *            具体设备项目的设备编号
	 * @return
	 */
	@Override
	public int returnEquipmentItem(String code) {

		int result = 1;
		EquipmentItem item = itemMapper.selectByCode(code);

		// 表里不存在该标号的设备
		if (item == null) {
			result = 0;
		} else {
			// 修改归还日期时间戳
			item.setReturnDate(new java.sql.Date(new java.util.Date().getTime()));
			// 使用状态修改为：未使用
			item.setUseStatus(16001);
			// 清空使用者id
			item.setUseUserId(null);
			// 清空使用日期
			item.setUseDate(null);
			// //清空使用期限
			item.setUseDealine(null);

			itemMapper.updateByPrimaryKey(item);

		}
		return result;
	}

	// 使用状态 1: 未使用， 2：已领用 ， 3:已借用 ， 4：作废
	/**
	 * 设备出库 (领用)
	 * 
	 * @param record
	 *            UseRecord
	 * @return
	 */
	public int[] useEquipmentItem(UseRecordDto record) {

		// result: 1:操作成功 , 0: 该设备不存在
		int result[] = { -1, 0 }; // 分别是操作成功与否，实际操作的记录数
		// 得到codes
		String[] codes = record.getCodes().split(",");
		System.out.println("=========================数组长度:" + codes.length
				+ "-------------------------");
		// 设备编号为空
		if (codes == null || codes.length == 0) {
			result[0] = -1;
			return result;
		}

		// 是否需要判断设备是否已被使用
		// EquipmentItem item = itemMapper.selectByCode(record.getCode());
		int updateCount = 0;
		for (int i = 1; i < codes.length; ++i) {
			System.out.println(codes[i]);
			EquipmentItem item = itemMapper.selectByCode(codes[i]);

			// 使用状态不等于16001（未使用）
			if (item.getUseStatus() != 16001) {
				continue; // 跳过，执行下一个循环
			} else {

				// 设置UseRecord的item_id(not null)
				record.setItemId(item.getId());
				// 使用状态为：领用
				item.setUseStatus(16002);
				// 设置使用者id
				item.setUseUserId(record.getUseUserId());

				// 设置使用日期
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				Date useDate = null;
				try {
					useDate = format.parse(record.getUseDateStr());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (useDate == null) {
					result[0] = 0;
					return result;
				} else
					item.setUseDate(new java.sql.Date(useDate.getTime()));

				// 设置使用期限
				Date useDealine = null;
				String dealineStr = record.getUseDealineStr();
				if (dealineStr == null || "".equals(dealineStr)) {
					item.setUseDealine(null);
				} else {
					try {
						useDealine = format.parse(record.getUseDealineStr());
						item.setUseDealine(new java.sql.Date(useDealine.getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// 清空归还时间???????????
				item.setReturnDate(null);

				itemMapper.updateByPrimaryKey(item);

				useRecordMapper.insert(record);

				result[0] = 1;
				updateCount += 1;
			}
			result[1] = updateCount;
		}

		return result;
	}

	/**
	 * 设备出库(借用)
	 * 
	 * @param record
	 *            BorrowRecord
	 */
	public int[] borrowEquipmentItem(BorrowRecordDto record) {

		// result: 1:操作成功 , 0: 该设备不存在
		int result[] = { -1, 0 }; // 分别是操作成功与否，实际操作的记录数
		// 得到codes
		String[] codes = record.getCodes().split(",");
		System.out.println("=========================数组长度:" + codes.length
				+ "-------------------------");
		// 设备编号为空
		if (codes == null || codes.length == 0) {
			result[0] = -1;
			return result;
		}

		// 是否需要判断设备是否已被使用
		// EquipmentItem item = itemMapper.selectByCode(record.getCode());
		int updateCount = 0;
		for (int i = 1; i < codes.length; ++i) {
			System.out.println(codes[i]);
			EquipmentItem item = itemMapper.selectByCode(codes[i]);

			// 使用状态不等于1（未使用）
			if (item.getUseStatus() != 16001) {
				continue; // 跳过，执行下一个循环
			} else {

				// 设置UseRecord的item_id(not null)
				record.setItemId(item.getId());
				// 使用状态为：借用
				item.setUseStatus(16003);
				// 设置使用者id
				item.setUseUserId(record.getBorrowUserId());

				// 设置借用日期
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				Date useDate = null;
				try {
					useDate = format.parse(record.getBorrowDateStr());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (useDate == null) {
					result[0] = 0;
					return result;
				} else
					item.setUseDate(new java.sql.Date(useDate.getTime()));

				// 设置借用期限
				Date borrowDealine = null;
				String dealineStr = record.getBorrowDealineStr();
				if ( dealineStr == null || "".equals(dealineStr.trim()) )
					item.setUseDealine(null);
				else {
					try {
						borrowDealine = format.parse(dealineStr);
						item.setUseDealine(new java.sql.Date(borrowDealine.getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				// 清空归还时间???????????
				item.setReturnDate(null);

				itemMapper.updateByPrimaryKey(item);

				borrowRecordMapper.insert(record);

				result[0] = 1;
				updateCount += 1;
			}
			result[1] = updateCount;
		}

		return result;
	}

	/**
	 * 获取该种类的设备的记录数
	 */
	@Override
	public int getEquipmentItemCount(int equipmentId) {

		return itemMapper.getEquipmentItemCount(equipmentId);
	}

	@Override
	public List<EquipmentItemDto> getEquipmentItemByPage(int equipmentId,boolean isFree,
			Pagination page) {

		return itemMapper.getEquipmentItemByPage(equipmentId, isFree,
				page.getLimitation());
	}

	@Override
	public List<EquipmentItemDto> getEquipmentItemByConditions(int equipmentId,
			String code, int userId, Pagination page) {

		return itemMapper.getEquipmentItemByConditions(equipmentId, code, userId, page.getLimitation());
	}
	
	@Override
	public int getEquipmentItemCountByCondition(int equipmentId, String code,
			int userId) {
		
		return itemMapper.getEquipmentItemCountByConditions(equipmentId, code, userId);
	}

	@Override
	public void getEquipmentItemDtoList(List<EquipmentItemDto> list, StorageService storageService) {
		// TODO Auto-generated method stub
		for ( EquipmentItemDto tmp : list ) {
			//根据useStatus得到页面显示的useStatusString
			if (tmp.getUseStatus() == 16001)
				tmp.setUseStatusStr("未使用");
			else if (tmp.getUseStatus() == 16002)
				tmp.setUseStatusStr("已领用");
			else if (tmp.getUseStatus() == 16003) 
				tmp.setUseStatusStr("已借用");
			else if (tmp.getUseStatus() == 16004)
				tmp.setUseStatusStr("报废");
			else if (tmp.getUseStatus() == null) {
				tmp.setUseStatusStr("无状态");
			}
			
			//得到页面显示的仓库名称(storageName)
			String storageName = storageService.getStorageNameById(tmp.getStorageId());
			if (storageName == null || "".equals(storageName.trim()))
				storageName = "未记录";
			tmp.setStorageName(storageName);
			
			//得到页面显示的日期字符串
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
			Date useDate = tmp.getUseDate();
			Date dealine = tmp.getUseDealine();
			System.out.println("useDate " + useDate + ", dealine " + dealine);
			if (useDate == null)
				tmp.setDateOfOutStr("未记录");
			else
				tmp.setDateOfOutStr(dateFormat.format(useDate));
			if ( dealine == null )
				tmp.setDateOfDealineStr("未记录");
			else
				tmp.setDateOfDealineStr(dateFormat.format(dealine));
		}
	}

	@Override
	public int getEquipmentItemCountWith(int equipmentId) {
		return itemMapper.getEquipmentItemCountWithFree(equipmentId);
	}

	@Override
	public EquipmentItemDto getEquipmentItemByCode(String code, PaginationCustom page) {
		EquipmentItemDto dto = itemMapper.getEquipmentItemByCode(code, page.getLimitation());
		return dto;
	}
	
	
	@Override
	public List<EquipmentItemDto> findEquipmentItemDtoByCondition(String category,Integer useStatus,Integer source,String buyTime,PaginationCustom page) {
		if ((null == category || "".equals(category)) && null == useStatus && null == source && (null == buyTime && "".equals(buyTime))){
			return null;
		} else if (null == page){
			List<EquipmentItemDto> elist = itemMapper.selectEquipmentItemDtoByLimit(category, useStatus,source,buyTime,null);
			return elist;			
		}
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/*for (EquipmentItemDto edto : elist){
			edto.setBuyTime(sdf.format(edto.getBuyDate()));
		}*/
		List<EquipmentItemDto> elist = itemMapper.selectEquipmentItemDtoByLimit(category, useStatus,source,buyTime, page.getLimitation());
		//System.out.println(elist);
		for (EquipmentItemDto eiDto : elist){
			if (eiDto.getSource() != null && !"".equals(eiDto.getSource())){
				if (eiDto.getSource().equals(15001)){
					eiDto.setSourceStr("购买");
				} else if (eiDto.getSource().equals(15002)){
					eiDto.setSourceStr("租借");
				} else if (eiDto.getSource().equals(15003)){
					eiDto.setSourceStr("捐赠");
				} else if (eiDto.getSource().equals(15005)){
					eiDto.setSourceStr("奖励");
				} else if (eiDto.getSource().equals(15004)){
					eiDto.setSourceStr("上级下拨");
				} else if (eiDto.getSource().equals(15006)){
					eiDto.setSourceStr("其他");
				}
			}
			
			if (eiDto.getUseStatus() != null && !"".equals(eiDto.getUseStatus())){
				if (eiDto.getUseStatus().equals(16002)){
					eiDto.setUseStatusStr("已领用");
				} else if (eiDto.getUseStatus().equals(16001)){
					eiDto.setUseStatusStr("未使用");
				} else if (eiDto.getUseStatus().equals(16003)){
					eiDto.setUseStatusStr("已借用");
				} else if (eiDto.getUseStatus().equals(16004)){
					eiDto.setUseStatusStr("作废");
				} 
			}
		}
		return elist;
	
	}
	
	@Override
	public List<EquipmentItem> findAllEquipmentItem() {
		// TODO Auto-generated method stub
		return itemMapper.selectByExample(new EquipmentItemExample());
	}
	
	@Override
	public Integer selectEquipmentItemCount(String category, Integer useStatus,Integer source,String buyTime) {
		
		return itemMapper.selectEquipmentItemCount(category, useStatus,source,buyTime);
		
	}
	
	@Override
	public EquipmentUseDto getEquipmentUseDtoById(Integer id) {
		if (id != null){
			EquipmentUseDto euDto = itemMapper.getEquipmentUseDtoById(id);
			//System.out.println(euDto);
			if (euDto != null){
				if (euDto.getUseStatus() != null && !"".equals(euDto.getUseStatus())){
					
					if (euDto.getUseStatus().equals(16002)||euDto.getUseStatus().equals(16003)){
						/*euDto.setEquUseStatus("已使用");*/
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						euDto.setUseDateStr(sdf.format(euDto.getUseDate()));
						if(euDto.getReturnDate()!=null){
							euDto.setReturnDateStr(sdf.format(euDto.getReturnDate()));
						}
						euDto.setUseDealineStr(sdf.format(euDto.getUseDealine()));
						
					} else if (euDto.getUseStatus().equals(16001)){
						/*euDto.setEquUseStatus("未使用");*/
					}
					
				}
			}
			return euDto;
		}
		return null;
	}

	@Override
	public String addEquipmentItemsByExcel(InputStream in, String format) {
		// TODO Auto-generated method stub
		
		//所有设备分类
		List<Category> cateList = categoryMapper.selectAllCategory();
		//设备种类
		List<EquipmentDto> equipList = equipMapper.selectTotalInfoOfEquipment(new EquipmentDto(), null);
		//设备来源
		List<EnumerationValue> sourceList = enService.getEnumValueListByEnumId(EnumerationType.SOURCE);
		//存放地点
		List<Storage> storageList = storageMapper.getAllStoragesInfo();
		
//		System.out.println("设备分类:" + cateList.toString());
//		for (Category c : cateList) {
//			System.out.println(c.getId() + ":" + c.getName());
//		}
//		System.out.println("设备种类:" + cateList.toString());
//		for (EquipmentDto c : equipList) {
//			System.out.println(c.getId() + ":" + c.getName());
//		}
//		System.out.println("设备来源:" + sourceList.toString());
//		for (EnumerationValue v : sourceList) {
//			System.out.println(v.getId() + ":" + v.getName());
//		}
//		System.out.println("存放地点:" + storageList.toString());
//		for (Storage v : storageList) {
//			System.out.println(v.getId() + ":" + v.getName());
//		}
		// 创建workbook
		Workbook wb = null;
		if (format.equalsIgnoreCase("xls"))
			try {
				wb = new HSSFWorkbook(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if (format.equalsIgnoreCase("xlsx")){

			try {
				wb = new XSSFWorkbook(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		boolean flag = false; //空行,忽略
		boolean exit = false;  //工号已存在，更新
		
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		System.out.println("总行数: " + sheet.getLastRowNum());
		int rowIndex = 1;
		List<EquipmentItemDto> totalList = new ArrayList<EquipmentItemDto>();
	//	while (rows.hasNext()) {
		String code1 = "";
		String code2 = "";
		for (int k = 1; k <= sheet.getLastRowNum(); ++k)	{
	//		Row row = rows.next();
			Row row = sheet.getRow(k);
			System.out.println("lastCellNumber:" + row.getLastCellNum() + ", ");
			if (row.getRowNum() == 0) {
				continue;
			}
			
			boolean equExist = false;  //设备类型是否存在
			int categoryId = 0;  //设备分类id
			int equipmentId = 0; //设备总类id
			String equName = "";
			String branch = "";  //品牌
			String model = "";   //型号
			EquipmentItemDto item = new EquipmentItemDto();
			for (int index = 0; index < row.getLastCellNum(); ++index) {
				
				Cell cell = row.getCell(index);
				
				
				
				if (index == 0) { //设备分类
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {

							boolean exist = false;
							String name = cell.getStringCellValue().trim();
							System.out.println("设备分类: " + name);
							for (Category c : cateList) {
								
								if (name.equals(c.getName())) {
									exist = true;
									categoryId = c.getId();
									System.out.println("设备分类id: " + categoryId);
								}
							}
							
							if (!exist) {  //该设备分类不存在
								return -10000 - k +  "";
							}
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
					
				} else if (index == 1) {//设备名称 (种类)
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							System.out.println("设备种类: " + name);
							for (EquipmentDto e : equipList) {
								
								if (e.getName().equals(name)) {
									equExist = true;
									//equipmentId = e.getId();
									
									System.out.println("设备种类: " + name);
									item.setEquipmentId(e.getId());
								} else {
									System.out.println(name + "种类不存在");
									equName = name;
								}
							} 
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
				} else if (index == 2) { //设备品牌
					 
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							branch = name;
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
				} else if (index == 3) { //设备型号
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							model = name;
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
				} else if (index == 4) { //设备来源
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							for (EnumerationValue e : sourceList) {
								
								if (e.getName().equals(name)) {
									item.setSource(e.getId());
								}
							}
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
				} else if (index == 5) { //购买日期
					
					if (cell != null) {
						
				//		cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (cell.getDateCellValue() != null) {
							
							Date date = cell.getDateCellValue();
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							String name  = "";
							try {
								name = dateFormat.format(date);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			///				item.setBuyDate(d);
							item.setBuyDateString(name);
					//	}
						} else {
							return -100000 - k + "";//填写不完整
						}
					} else {
						return -100000 - k + "";//填写不完整
					}
				} else if (index == 6) { //存放地点
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							boolean storageExist = false;
							for (Storage s : storageList) {
								
								if (s.getName().equals(name)) {
									storageExist = true;
									item.setStorageId(s.getId());
								}
							}
							if (!storageExist) {
								return -1000 - k + ""; //仓库不存在
							}
						} else {
							return -100000 - k + "";//填写不完整
						}
					}
				} else if (index == 7) { //备注
					
					if (cell != null) {
						
						cell.setCellType(Cell.CELL_TYPE_STRING);
						
						if (!cell.getStringCellValue().trim().equals("") && cell.getStringCellValue() != null) {
							
							String name = cell.getStringCellValue().trim();
							item.setRemark(name);
						}
					}
				}
			}
			
			//设置使用状态为未使用
			item.setUseStatus(16001);
			//设置设备编号
			Date tem = new Date();
			code1 = tem.getYear()+1990 + "" + tem.getTime();
			if (code1.equals(code2)) {
				int end = Integer.parseInt(code1.substring(code1.length()-1, code1.length()));
				end ++;
				code1 = code1.subSequence(0, code1.length()-1) + "" + end;
			}
			item.setCode(code1);
			//判断该种类的设备是否存在，不存在则添加
			if (!equExist) {
				
				// 判断设备种类是否存在，
				System.out.println("cateId: " + categoryId + ", name: " + equName);
				Equipment equip = equipMapper.getEquipmentByName(categoryId, equName);
			//	System.out.println("设备信息:" + equip.getCategoryId() + ", " + equip.getName());
				// 如果设备种类不存在，则添加新的设备种类
				if (equip == null) {
					equip = new Equipment();
					equip.setCategoryId(categoryId);
					equip.setName(equName);
					equip.setBrand(branch);
					equip.setModel(model);
					equipMapper.insert(equip);
				}
				equExist = false;
				Equipment tempEqu = equipMapper.getEquipmentByName(categoryId, equName);
				//设置种类id
				item.setEquipmentId(tempEqu.getId());
			}
			code2 = tem.getYear()+1990 + "" + tem.getTime();
			//检查设备信息是否完整
//			if (item.getBrand() == null || item.getBrand().trim().equals("") || 
//					item.getModel() == null || item.getModel().trim().equals("") ||
//					item.getSourceStr() == null || item.getSourceStr().trim().equals("") ||
//					item.getBuyDate() == null) {
//				return -100000 - k + "";
//			}
			//添加到集合保存
			totalList.add(item);
		}
		
		//批量导入
		int result = itemMapper.insertByList(totalList);
		return result + "";
	}
}
