package yh.acct.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import net.pri.j9.framework.core.exception.LogicException;
import net.pri.j9.framework.util.ConvertUtil;
import net.pri.j9.remote.RemoteApi;

public class IDUtil {

	public static void setPkid(Map<String, String> infoMap) throws LogicException, IOException {
		Properties pros = new Properties();
		
//		pros.load(IDUtil.class.getResourceAsStream("../../../actionId-schema.properties"));
		String actionId = infoMap.get("actionId");
		System.out.println("id: " + RemoteApi.nextVal("std.employees.key"));
		infoMap.put("pkid", 
				//账户基本信息的操作
				actionId.equals(pros.getProperty("std.merchant.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("std.merchant.key")) : //商户修改保存服务?
				actionId.equals(pros.getProperty("std.department.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("std.department.key")) :  //商户部门修改保存服务?
				actionId.equals(pros.getProperty("std.employees.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("std.employees.key")) :  //职员修改保存服务?
				//患者的操作
		//		actionId.equals("010202")?RemoteApi.nextVal("") :  //新增患者基本信息?
				//账户的操作
		//		actionId.equals("010301")?RemoteApi.nextVal("std.employees.key") :    //建卡服务
		//		actionId.equals("010302")?RemoteApi.nextVal("std.employees.key") :    //修改卡信息
				actionId.equals(pros.getProperty("pati.customer.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("pati.customer.key")):
				actionId.equals(pros.getProperty("pati.customerinfo.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("pati.customerinfo.key")):
				actionId.equals(pros.getProperty("pati.identitybinding.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("pati.identitybinding.key")) :
				actionId.equals(pros.getProperty("acct.lanudrylist.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.lanudrylist.key")) :   //账户流水
				actionId.equals(pros.getProperty("acct.capitaltransactionrecords.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.capitaltransactionrecords.key")) :  //资金交易记录
				actionId.equals(pros.getProperty("acct.accountlog.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.accountlog.key")) :   //账户日志
				actionId.equals(pros.getProperty("acct.balance.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.balance.key")) :       //患者账户结余表
				actionId.equals(pros.getProperty("acct.dailymaster.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.dailymaster.key")) :   //预交金日结单头
				actionId.equals(pros.getProperty("acct.dailydetail.key", "0"))?ConvertUtil.toString(RemoteApi.nextVal("acct.dailydetail.key")) : "0"   //预交金日结明细
						
				);   
	}
	
//	private boolean  returnActionId(String name) {
	//	return actionId.equals(pros.getProperty(name, "0"))?ConvertUtil.toString(RemoteApi.nextVal(name));
//	}
	public static void main(String[] args) {
		System.out.println(IDUtil.class.getResourceAsStream("../../../actionId-schema.properties"));
	}

}
