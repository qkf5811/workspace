<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="easyui-panel" style="padding: 30px 70px 50px 70px">
	<form id="addEquipmentItemForm">
		<table cellpadding="7">
			<tr>
				<div style="margin-bottom: 20px">
					<td>设备编号:</td>
					<td><input class="easyui-validatebox textbox" id="code"
						name="code"
						data-options="required:true,validType:'length[3,20]',missingMessage:'该处未填写',novalidate:true,invalidMessage:'字数范围为3-20' "
						style="width: 200px; height: 18px; padding: 5px" readonly /></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>设备类型:</td>
					<td><select class="easyui-combobox" id="addCategorySelect"
						name="addCategorySelect"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '212x',novalidate:true"
						validtype="selectRequired['addCategorySelect']"
						style="width: 212px; height: 33px; padding: 5px">
							<option>请选择分类</option>
							<c:forEach items="${addCategoryList }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
					</select></td>
					<!-- 
					<td><select class="easyui-combobox" id="addEquipmentSelect"
						name="addEquipmentSelect"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '212px',novalidate:true"
						validtype="selectRequired['addEquipmentSelect']"
						style="width: 212px; height: 33px; padding: 5px">
							<option value="0">请选择种类</option>
					</select></td> -->
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>设备名称:</td>
					<td><input class="easyui-validatebox textbox" id="name"	name="name"
						data-options="required:true, missingMessage:'该处未填写',novalidate:true"
						style="width: 200px; height: 18px; padding: 5px" /></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>设备品牌:</td>
					<td><input class="easyui-validatebox textbox" id="brand" name="brand"
						style="width: 200px; height: 18px; padding: 5px" /></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>设备型号:</td>
					<td><input class="easyui-validatebox textbox" id="model" name="model"
						style="width: 200px; height: 18px; padding: 5px" /></td>
				</div>
			</tr>

			<tr>
				<div style="margin-bottom: 20px">
					<td>设备来源:</td>
					<td><select class="easyui-combobox" id="source" name="source"
						data-options="editable:false,panelHeight: 'auto',panelWidth: '212px',novalidate:true"
						style="width: 212px; height: 33px; padding: 5px">

							<!--  				<option value="0">请选择来源</option>
							<option value="1">购买</option>
							<option value="2">租借</option>
							<option value="3">捐赠</option>
							<option value="4">上级下拨</option>
							<option value="5">奖励</option>
							<option value="6">其他</option>-->

							<option value="0">请选择来源</option>

							<c:forEach items="${sourceList }" var="item">
								<option value="${item.id }">${item.name }</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>

			<!-- 
			<tr>

				<td>购买明细:</td>
				 		<td><select class="easyui-combobox" id="buyDetail"
						name="buyDetail" data-options="editable:false,panelWidth:'212px',panelHeight:'auto'"
						style="height: 33px; width: 212px">
							<option value="0">购买明细</option>
							<c:forEach items="${buyList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td> 
			<!-- 	<td><a href="#" class="easyui-linkbutton"
					onclick="moreConditionsOfAddEquItem()" id="moreConditionsOfEquItem">显示∨</a></td> -->
			</tr>

	<!-- 		<tr>
				<td></td>
				<td><div class="easyui-panel" id="moreConditionsPanelOfEquItem">
						购买批次: <select class="easyui-combobox" id="buybatch"
							name="buybatch"
							data-options="editable:false,panelWidth:'153px',panelHeight:'auto',novalidate:true"
							validtype="selectRequired['buybatch']"
							style="height: 33px; width: 153px">
							<option value="0">请选择</option>
							<c:forEach items="${buyList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select> <br> <br> 
						单价:<input class="easyui-validatebox textbox"
							id="equItemPrice"
							data-options="required:true,missingMessage:'该处未填写',novalidate:true"
							style="width: 62px; height: 18px; padding: 5px"> 数量:<input
							class="easyui-validatebox textbox" id="equItemAmount"
							data-options="required:true,missingMessage:'该处未填写',novalidate:true"
							style="width: 62px; height: 18px; padding: 5px"> 单位:<select
							class="easyui-combobox" id="unitType" name="unitType"
							data-options="editable:false,panelWidth:'80px',panelHeight:'auto',novalidate:true"
							validtype="selectRequired['unitType']"
							style="height: 33px; width: 75px">
							<option value="0">请选择</option>
							<c:forEach items="${buyList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select>
					</div></td>

				<br>
				<td></td>
				<td>单位:<select class="easyui-combobox" id="unitType"
					name="unitType"
					data-options="editable:false,panelWidth:'80px',panelHeight:'auto',novalidate:true"
					validtype="selectRequired['unitType']"
					style="height: 33px; width: 75px">
						<option value="0">请选择</option>
						<c:forEach items="${buyList}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
				</select>
				</td>

			</tr> -->


			<tr>
				<div style="margin-bottom: 20px">
					<td>购买日期:</td>
					<td><input class="easyui-datetimebox" id="buyDate"
						name="buyDate" data-options="editable:false,novalidate:true"
						validtype="selectRequired['buyDate']"
						style="height: 33px; width: 212px">
				</div>
			</tr>
			<tr>
				<div style="margin-bottom: 20px">
					<td>存放地点:</td>
					<td><select class="easyui-combobox" id="storagePlace"
						name="storagePlace"
						data-options="editable:false,novalidate:true,panelWidth:'212px',panelHeight:'auto'"
						validtype="selectRequired['storagePlace']"
						style="height: 30px; width: 212px;">
							<option value="">请选择存放地点</option>
							<c:forEach items="${storageList }" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
					</select></td>
				</div>
			</tr>
		</table>
		<div style="margin-left: 10px">
			<span>备注:</span><br>
			<textArea class="textarea" id="addRemark" name="remark" rows="10"
				cols="100"></textArea>
		</div>
	</form>

	<div style="text-align: center; padding: 5px; margin: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="addCommit">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" id="addClear">重置</a>
	</div>
</div>

<script>
	$(function() {
		//页面载入后设置设备编号
		var tdate = new Date();
		var codeStr = tdate.getFullYear() + "" + (tdate.getMonth() + 1) + ""
				+ tdate.getDate() + "" + tdate.getTime();
		$('#addEquipmentItemForm').find('#code').val(codeStr);

		//页面载入后设置默认日期
		var addDate = new Date();
		var dateStr = addDate.getFullYear() + "-" + (addDate.getMonth() + 1)
				+ "-" + addDate.getDate() + " " + addDate.getHours() + ":"
				+ addDate.getMinutes() + ":" + addDate.getSeconds();
		$('#addEquipmentItemForm').find('#buyDate').datetimebox({
			value : dateStr
		});

		//设备分类select改变后
		var addcSelect = $('#addEquipmentItemForm').find('#addCategorySelect');

		addcSelect
				.combobox({
					onSelect : function() {
						var val = addcSelect.combobox('getValue');
						var txt = addcSelect.combobox('getText');
						//	alert("value:: " + val + ", " + "Text: " + txt);
						$('#addEquipmentItemForm')
								.find('#addEquipmentSelect')
								.combobox(
										{
											valueField : "id",
											textField : "name",
											url : "${contextPath}/equ/getEquInfo.do?categoryId="
													+ val,
											editable : false,
											value : "请选择种类"
										});
					}
				})	
			
		/*
		addcSelect.combobox({
			onSelect : function() {
				var val = addcSelect.combobox('getValue');
				var txt = addcSelect.combobox('getText');
			//	alert("value:: " + val + ", " + "Text: " + txt);
				$('#addEquipmentItemForm').find('#addEquipmentSelect').combobox({
					valueField : "id",
					textField : "name",
					url : "${contextPath}/equ/getEquInfo.do?categoryId=" + val,
					editable : false,
					value : "请选择种类"

				});
		*/
		//提交 新添加设备的表单
		$('#addCommit').click(
				function() {
					//在提交数据之前执行表单验证
					$('#addEquipmentItemForm').form('enableValidation').form(
							'validate');

					//判断表单验证是否通过
					if (!$('#addEquipmentItemForm').form('validate')) {
						return false;
					}
					//		alert("提交");
					var code = $('#addEquipmentItemForm').find('#code').val();
					var categoryId = $('#addEquipmentItemForm').find(
					'#addCategorySelect').combobox('getValue');
			//		var equipmentId = $('#addEquipmentItemForm').find(
			//			'#addEquipmentSelect').combobox('getValue');
					var name = $('#addEquipmentItemForm').find('#name').val();
					var brand = $('#addEquipmentItemForm').find('#brand').val();
					var model = $('#addEquipmentItemForm').find('#model').val();
					var source = $('#addEquipmentItemForm').find('#source')
							.combobox('getValue');
			//		var buyDetail = $('#addEquipmentItemForm').find(
			//				'#buyDetail').combobox('getValue');
					var buyDate = $('#addEquipmentItemForm').find('#buyDate')
							.datetimebox('getValue');
					var storagePlace = $('#addEquipmentItemForm').find(
							'#storagePlace').combobox('getValue');
					var remark = $('#addEquipmentItemForm').find('#addRemark')
							.val();

					var param = {
						"code" : code,
						"categoryId" : categoryId,
						//"equipmentId" : equipmentId,
						"name" : name,
						"brand" : brand,
						"model" : model,
						"source" : source,
						//"buyDetailId" : buyDetail,
						"buyDateString" : buyDate,
						"storageId" : storagePlace,
						"remark" : remark
					};
					//				console.log(param);
					$.post('equ/addEquItem.do', param, function(data, status) {
						var obj = eval('(' + data + ')');
						var result = obj.success;
						if (result == -1) {
							$.messager.alert('警告', "请填写必要的项目!");
						} else if (result == 1) {
							$.messager.alert('提示', '设备添加成功!');
							//		$('#addEquipmentItemForm').form('clear');
						} else if (result == 0) {
							$.messager.alert('警告', '添加设备失败!请稍后再试!');
						}
					});

					//提交记录后更新设备编号
					var date = new Date();
					var codeStr = date.getFullYear() + ""
							+ (date.getMonth() + 1) + "" + date.getDate() + ""
							+ date.getTime();
					$('#addEquipmentItemForm').find('#code').val(codeStr);
				});

		$('#addClear').click(function() {
			var tab = getCurrentTab();
			closeTab(tab);
			openTab('equ/toAddEquipmentItem.do', '添加新设备');
		});
	})

	//点击更多条件按钮
	function moreConditionsOfAddEquItem() {
		if ($('#moreConditionsOfEquItem').text() == '显示∨') { //折叠状态
			$('#moreConditionsOfEquItem').text("收起∧");
			//	$('#moreBtn').css({padding: '2px 5px'});
			$('#moreConditionsPanelOfEquItem').panel('expand', true);
		} else {
			$('#moreConditionsOfEquItem').text("显示∨");
			//	$('#moreBtn').css({padding: '2px'});
			$('#moreConditionsPanelOfEquItem').panel('collapse', true);
		}

	}
</script>