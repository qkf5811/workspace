<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div data-options="region:'west',title:'菜单',split:true"
	style="width: 180px;">
	<ul class="easyui-tree" data-options="animate:true,onSelect:function(node){$(this).tree('toggle',node.target);}">
		<li data-options="state:'closed'"><span>账户基本信息服务</span>
			<ul>
				<li><a onclick="openTab('std.jsp', '所有账户相关的服务')">所有</a></li>
				<li><a onclick="openTab('test/queryMerchant.do', '商户查询')">商户查询</a></li>
				<li><a onclick="openTab('std/saveMerchant.do', '商户修改保存服务')">商户修改保存服务</a></li>
				<li><a onclick="openTab('std/queryDepartment.do','商户部门查询服务')">商户部门查询服务</a></li>
				<li><a onclick="openTab('std/saveDepartment.do','商户部门修改保存服务')">商户部门修改保存服务</a></li>
				<li><a onclick="openTab('std/queryEmployees.do','职员查询服务')">职员查询服务</a></li>
				<li><a onclick="openTab('std/saveEmployees.do','职员修改保存服务')">职员修改保存服务</a></li>
			</ul>
		</li>
		
		<li data-options="state:'closed'"><span>卡相关服务</span>
			<ul>
				<li><a onclick="openTab('std/saveCardInfo.do', '建卡服务')">建卡服务</a></li>
				<li><a onclick="openTab('std/updateCardInfo.do', '修改卡信息')">修改卡信息</a></li>
				<li><a onclick="openTab('std/actionRecharge.do','充值服务')">充值服务</a></li>
				<li><a onclick="openTab('std/cancelRecharge.do','退充值服务')">退充值服务</a></li>
				<li><a onclick="openTab('std/queryTranstionMaster.do','账户交易汇总查询')">账户交易汇总查询</a></li>
				<li><a onclick="openTab('std/queryTranstionDetail.do','账户交易明细查询')">账户交易明细查询</a></li>
				<li><a onclick="openTab('std/actionPreDaily.do','预交金预日结服务')">预交金预日结服务</a></li>
				<li><a onclick="openTab('std/actionDaily.do','预交金日结服务')">预交金日结服务</a></li>
				<li><a onclick="openTab('std/queryDailyMaster.do','预交金日结记录查询')">预交金日结记录查询</a></li>
				<li><a onclick="openTab('std/queryDailyMaster.do','预交金日结明细查询')">预交金日结明细查询</a></li>
				<li><a onclick="openTab('std/actionConsum.do','消费服务')">消费服务</a></li>
				<li><a onclick="openTab('std/actionReversalConsum.do','消费冲正服务')">消费冲正服务</a></li>
				<li><a onclick="openTab('std/actionAdjustCredit.do','调整账户信用额')">调整账户信用额</a></li>
				<li><a onclick="openTab('std/actionRepayment.do','信用额还款')">信用额还款</a></li>
				<li><a onclick="openTab('std/actionImpBankData.do','银行对账数据导入')">银行对账数据导入</a></li>
				<li><a onclick="openTab('std/actionImpAlipayData.do','支付宝对账数据导入')">支付宝对账数据导入</a></li>
				<li><a onclick="openTab('std/queryCheckingMaster.do','对账汇总查询服务')">对账汇总查询服务</a></li>
				<li><a onclick="openTab('std/queryCheckingDetail.do','对账明细查询服务')">对账明细查询服务</a></li>
			</ul>
		</li>
		<li><a onclick="openTab('seq/goSeq.do', 'seq')">seq</a></li>
</div>