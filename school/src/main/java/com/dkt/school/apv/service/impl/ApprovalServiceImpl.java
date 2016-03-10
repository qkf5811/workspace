package com.dkt.school.apv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkt.school.apv.dao.ApplicationCustomMapper;
import com.dkt.school.apv.dao.ApprovalCustomMapper;
import com.dkt.school.apv.dao.ApprovalNodeCustomMapper;
import com.dkt.school.apv.dto.ApprovalNodeDto;
import com.dkt.school.apv.model.Application;
import com.dkt.school.apv.model.Approval;
import com.dkt.school.apv.model.ApprovalNode;
import com.dkt.school.apv.service.ApprovalService;
import com.dkt.school.equ.dao.RoomApplicationCustomMapper;
import com.dkt.school.equ.dao.RoomUseRecordMapper;
import com.dkt.school.equ.model.RoomApplication;
import com.dkt.school.equ.model.RoomUseRecord;
import com.dkt.school.user.service.UserRoleService;

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	private ApprovalCustomMapper acMapper;
	
	@Autowired
	private ApplicationCustomMapper appMapper;
	
	@Autowired
	private UserRoleService urService;
	
	@Autowired 
	private ApprovalNodeCustomMapper ancMapper;
	
	@Autowired
	private RoomApplicationCustomMapper raMapper;
	
	@Autowired
	private RoomUseRecordMapper rrMapper;
	
	@Override
	public int addApprovalByDto(Approval dto) {
		// TODO Auto-generated method stub
		
		//先设置roleId
		int roleId = urService.getRoleIdByUserId(dto.getUserId());
		dto.setRoleId(roleId);
		int result = acMapper.insert(dto);
		if (result == 1) {
			
			//得到所有该类型的申请
			Application application = appMapper.selectByPrimaryKey(dto.getApplicationId());
			List<ApprovalNodeDto> list = ancMapper.selectApproveNodeByApplicationType(application.getApplicationType(), null);
			ApprovalNode seq = ancMapper.selectByPrimaryKey(dto.getNodeId());
			
			int i = 1;
			for (ApprovalNodeDto tmp : list) {
				//如果还不是最后一个步骤,则更新请求的node_id（审批环节），否则更新审批结果
				if (seq.getSeq() < list.size() && seq.getSeq() == tmp.getSeq()) {
					
					System.out.println("找到nodeid!");
					application.setNodeId(list.get(i).getId());
					
					
					appMapper.updateNodeIdById(dto.getApplicationId(), list.get(i).getId());
					break;
				} else if (seq.getSeq() == list.size() && seq.getSeq() == tmp.getSeq()){
					//更新申请表的申请状态
					application.setNodeId(tmp.getId());
					appMapper.updateNodeIdById(dto.getApplicationId(), tmp.getId());
					int tmp1 = 0;
					if (dto.getApprovalStatus() == 43002) {
						//功能室插入使用记录
						if(application.getApplicationType() == 41004) {
							RoomApplication ra =  raMapper.getRoomApplicationByAppId(application.getId());
							RoomUseRecord record = new RoomUseRecord();
							record.setRemark(ra.getRemark());
							record.setFunctionRoomId(ra.getFunctionRoomId());
							record.setUseUserId(ra.getUseUserId());
							record.setUseFromDate(ra.getUseFromDate());
							record.setUseToDate(ra.getUseToDate());
							rrMapper.insert(record);
						}
						//通过
						tmp1 = 42003;
					} else if (dto.getApprovalStatus() == 43003) {
						//不通过
						tmp1 = 42004;
					}
					appMapper.updateApplicationStatus(dto.getApplicationId(), tmp1);
					break;
				}
				++i;
			}
			
		}
		return result;
	}

}
