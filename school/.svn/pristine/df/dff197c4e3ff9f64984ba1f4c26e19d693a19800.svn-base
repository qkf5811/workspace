package com.dkt.school.apv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.apv.dao.ApprovalNodeCustomMapper;
import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.apv.model.ApprovalNode;
import com.dkt.school.apv.service.ApprovalSettingService;
import com.dkt.school.common.enumeration.EnumerationType;
import com.dkt.school.common.page.PaginationCustom;
import com.dkt.school.system.model.EnumerationValue;
import com.dkt.school.system.service.EnumerationService;
@Service
public class ApprovalSettingServiceImpl implements ApprovalSettingService {

	@Autowired
	private ApprovalNodeCustomMapper ancMapper;
	
	@Autowired
	private EnumerationService enService;
	
	@Override
	public List<ApprovalNodeDto> findApproveSettingByApplicationType(
			int applicationType, PaginationCustom page) {
		// TODO Auto-generated method stub
		return ancMapper.selectApproveNodeByApplicationType(applicationType, page.getLimitation());
	}

	@Override
	public int findApproveSettingCountByApplicationType(
			int applicationType, PaginationCustom page) {
		// TODO Auto-generated method stub
		return ancMapper.selectApproveNodeCountByApplicationType(applicationType, page.getLimitation());
	}

	@Override
	public String addNewApprivalNode(ApprovalNodeDto dto) {
		// TODO Auto-generated method stub
		
		String result = "-1";
		
		boolean isBiggest = false;  //最大
		boolean isSmallest = false;  //最小
		boolean isEqual = false;    //之间
		List<ApprovalNodeDto> list = this.findApproveSettingByApplicationType(dto.getApplicationType(), new PaginationCustom());
		List<ApprovalNodeDto> tmp = new ArrayList<ApprovalNodeDto>();
		
		if (list == null || list.size() == 0) { //如果没有该类型的审批节点,直接添加返回
			
			return ancMapper.insertNewApprovalNode(dto) + "";
		}
		if (dto.getSeq() > list.get(list.size()-1).getSeq()) { //最大
			isBiggest = true;
		} else if (dto.getSeq() < list.get(0).getSeq()) { //最小
			 isSmallest = true;
		} else {
			isEqual = true;
		}
		
		if (isBiggest) {  //最大，则添加到最后
			result = ancMapper.insertNewApprovalNode(dto) + "";
			//更新之前最后一个节点的isLast
			ApprovalNode record = new ApprovalNode();
			record.setId(list.get(list.size()-1).getId());
			record.setApplicationType(list.get(list.size()-1).getApplicationType());
			record.setIsLast(0);
			record.setNodeName(list.get(list.size()-1).getNodeName());
			record.setRemark(list.get(list.size()-1).getRemark());
			record.setRoleId(list.get(list.size()-1).getRoleId());
			record.setSeq(list.get(list.size()-1).getSeq());
			ancMapper.updateByPrimaryKey(record);
			
		} else if (isSmallest) { //最小，则添加到最前面
			
			//设置到前面，所以不会是最后一个
			int value = 0;
			List<EnumerationValue> t = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
			for (int i =0; i < t.size(); ++i) {
				if (t.get(i).getName().equals("否")) {
					value = t.get(i).getId();
				}
			}
			dto.setIsLast(value);
			//插入
			result = ancMapper.insertNewApprovalNode(dto) + "";
		} else if (isEqual) {  //在中间
			//得到大于等于dto的顺序的所有节点
			for (int i = 0; i < list.size(); ++i) {
				
				if (dto.getSeq() <= list.get(i).getSeq()) {
					//全部自加1
					list.get(i).setSeq(list.get(i).getSeq()+1);
					tmp.add(list.get(i));
				}
			}
			//批量更新
			int s = this.updateApprovalNodeSeqByList(tmp);
			result = ancMapper.insertNewApprovalNode(dto) + "";
		} 
		
		//添加完之后，查询，更新所有节点的顺序和isLast
		int value1 = 0; //否
		int value2 = 0; //是
		List<EnumerationValue> t1 = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
		for (int i =0; i < t1.size(); ++i) {
			if (t1.get(i).getName().equals("否")) {
				value1 = t1.get(i).getId();
			} else {
				value2 = t1.get(i).getId();
			}
		}
		List<ApprovalNodeDto> list1 = this.findApproveSettingByApplicationType(dto.getApplicationType(), new PaginationCustom());
		for (int i = 0; i < list1.size(); ++i) {
					
			list1.get(i).setSeq(i+1);
			if (i != list1.size() - 1) {
						
				list1.get(i).setIsLast(value1);
			} else {
						
				list1.get(i).setIsLast(value2);
			}
		}
//		System.out.println("批量更新顺序和isList");
		this.updateApprovalNodeSeqByList(list1);
		return result;
	}

	public int updateApprovalNodeSeqByList(List<ApprovalNodeDto> tmp) {
		
		return ancMapper.updateApprovalNodeSeqByList(tmp);
	}

	@Override
	public Object findApproveNodeById(int id) {
		// TODO Auto-generated method stub
		return ancMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateApprovalNodeByDto(ApprovalNodeDto dto) {
		// TODO Auto-generated method stub
		int result = 0;
		boolean isBiggest = false;  //最大
		boolean isSmallest = false;  //最小
		boolean isEqual = false;    //之间
		
		//设置isLast的值
		int value = 0;
		List<EnumerationValue> t = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
		for (int i =0; i < t.size(); ++i) {
			if (t.get(i).getName().equals(dto.getIsLastStr())) {
				value = t.get(i).getId();
				break;
			} 
		}
				
		dto.setIsLast(value);
				
		List<ApprovalNodeDto> list = this.findApproveSettingByApplicationType(dto.getApplicationType(), new PaginationCustom());
		List<ApprovalNodeDto> tmp = new ArrayList<ApprovalNodeDto>();
		
		if (list.size() == 1) { //只有一个，直接更新返回
			
			ApprovalNode record = new ApprovalNode();
			record.setId(dto.getId());
			record.setApplicationType(dto.getApplicationType());
			record.setIsLast(dto.getIsLast());
			record.setNodeName(dto.getNodeName());
			record.setRemark(dto.getRemark());
			record.setRoleId(dto.getRoleId());
			record.setSeq(dto.getSeq());
			ancMapper.updateByPrimaryKey(record);
			result = ancMapper.updateByPrimaryKey(record);
			
			return result;
		}
		if (dto.getSeq() > list.get(list.size()-1).getSeq()) { //最大
			isBiggest = true;
		} else if (dto.getSeq() < list.get(0).getSeq()) { //最小
			 isSmallest = true;
		} else {
			isEqual = true;
		}
		
		if (isBiggest) {
			
			int value1 = 0;
			List<EnumerationValue> t1 = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
			for (int i =0; i < t.size(); ++i) {
				if (t1.get(i).getName().equals("否")) {
					value1 = t.get(i).getId();
				}
			}
			//更新之前最后一个节点的isLast
			ApprovalNode record = new ApprovalNode();
			record.setId(list.get(list.size()-1).getId());
			record.setApplicationType(list.get(list.size()-1).getApplicationType());
			record.setIsLast(value1);
			record.setNodeName(list.get(list.size()-1).getNodeName());
			record.setRemark(list.get(list.size()-1).getRemark());
			record.setRoleId(list.get(list.size()-1).getRoleId());
			record.setSeq(list.get(list.size()-1).getSeq());
			ancMapper.updateByPrimaryKey(record);
			
		} else if (isSmallest) {
			
			//设置到前面，所以不会是最后一个
			int value1 = 0;
			List<EnumerationValue> t1 = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
			for (int i =0; i < t.size(); ++i) {
				if (t1.get(i).getName().equals("否")) {
					value1 = t.get(i).getId();
				}
			}
			dto.setIsLast(value1);
		} else if (isEqual) {
			
			//得到大于等于dto的顺序的所有节点
			for (int i = 0; i < list.size(); ++i) {
				
				if (dto.getSeq() <= list.get(i).getSeq()) {
					//全部自加1
					list.get(i).setSeq(list.get(i).getSeq()+1);
					tmp.add(list.get(i));
				}
			}
			//批量更新
			int s = this.updateApprovalNodeSeqByList(tmp);
		}
		
		//更新自己 
		ApprovalNode record = new ApprovalNode();
		record.setId(dto.getId());
		record.setApplicationType(dto.getApplicationType());
		record.setIsLast(dto.getIsLast());
		record.setNodeName(dto.getNodeName());
		record.setRemark(dto.getRemark());
		record.setRoleId(dto.getRoleId());
		record.setSeq(dto.getSeq());
		ancMapper.updateByPrimaryKey(record);
		result = ancMapper.updateByPrimaryKey(record);
		
		//更新完之后，查询，更新所有节点的顺序和isLast
		int value1 = 0; //否
		int value2 = 0; //是
		List<EnumerationValue> t1 = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
		for (int i =0; i < t1.size(); ++i) {
			if (t1.get(i).getName().equals("否")) {
				value1 = t1.get(i).getId();
			} else {
				value2 = t1.get(i).getId();
			}
		}
		List<ApprovalNodeDto> list1 = this.findApproveSettingByApplicationType(dto.getApplicationType(), new PaginationCustom());
		for (int i = 0; i < list1.size(); ++i) {
			
			list1.get(i).setSeq(i+1);
			if (i != list1.size() - 1) {
				
				list1.get(i).setIsLast(value1);
			} else {
				
				list1.get(i).setIsLast(value2);
			}
		}
//		System.out.println("批量更新顺序和isList");
		this.updateApprovalNodeSeqByList(list1);
		
		return result;
	}

	@Override
	public int deleteApprovalNodeById(int id) {
		// TODO Auto-generated method stub
		
		ApprovalNode node = ancMapper.selectByPrimaryKey(id);
		int result = ancMapper.deleteByPrimaryKey(id);
		
		//删除完之后，查询，更新所有节点的顺序和isLast
		int value1 = 0; //否
		int value2 = 0; //是
		List<EnumerationValue> t1 = enService.getEnumValueListByEnumId(EnumerationType.BOOLEAN_TYPE);
		for (int i =0; i < t1.size(); ++i) {
			if (t1.get(i).getName().equals("否")) {
				value1 = t1.get(i).getId();
			} else {
				value2 = t1.get(i).getId();
			}
		}
		List<ApprovalNodeDto> list1 = this.findApproveSettingByApplicationType(node.getApplicationType(), new PaginationCustom());
		for (int i = 0; i < list1.size(); ++i) {
					
			list1.get(i).setSeq(i+1);
			if (i != list1.size() - 1) {
						
				list1.get(i).setIsLast(value1);
			} else {
						
				list1.get(i).setIsLast(value2);
			}
		}
//		System.out.println("批量更新顺序和isList");
		this.updateApprovalNodeSeqByList(list1);
		return result;
	}

}
