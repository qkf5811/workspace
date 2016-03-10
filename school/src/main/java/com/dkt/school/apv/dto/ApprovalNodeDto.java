package com.dkt.school.apv.dto;

import com.dkt.school.apv.model.ApprovalNode;

public class ApprovalNodeDto extends ApprovalNode {
	
	//申请类型
	private String applicationTypeStr;
	
	//审批角色
	private String roleIdStr;
	
	//顺序(第n步)
	private String seqStr;
	
	//是否是最后一步
	private String isLastStr;

	public String getIsLastStr() {
		return isLastStr;
	}

	public void setIsLastStr(String isLastStr) {
		this.isLastStr = isLastStr;
	}

	public String getApplicationTypeStr() {
		return applicationTypeStr;
	}

	public void setApplicationTypeStr(String applicationTypeStr) {
		this.applicationTypeStr = applicationTypeStr;
	}

	public String getRoleIdStr() {
		return roleIdStr;
	}

	public void setRoleIdStr(String roleIdStr) {
		this.roleIdStr = roleIdStr;
	}

	public String getSeqStr() {
		return seqStr;
	}

	public void setSeqStr(String seqStr) {
		this.seqStr = seqStr;
	}
	
	
}
