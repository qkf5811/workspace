<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div
	style="background: rgb(238, 238, 238); margin: 0px; width: 100%; height: 100%">
	<form id="customForm">
		<table class="ctable">
			<thead>
				<tr>
					<td>参数名</td>
					<td>参数值</td>
					<td><a class="ca" onclick="addRow()">加一行</a></td>
				</tr>
			</thead>
			<tbody id="customTable">
				<tr>
					<td><input class="cbox" type="text" value="actionId"
						readonly="readonly"></td>
					<td><input class="cbox" type="text" name="actionId" id="actionId"></td>
					<td></td>
				</tr>
			</tbody>
			<tfoot>
				<tr style="margin: 0px auto;" align="center">
					<td>当前页:<input type="text" class="cbox"
						style="width: 80px" id="currentPage" value="1" placeholder="..."></td>
				<td>每页记录数:<input type="text" class="cbox" value="10" placeholder="..."
					style="width: 80px" id="pageSize"></td>

				<td><a class="ca" onclick="goTestByCustom()">查询</a><!-- <a class="ca" onclick="goTestByCustom('true')">修改</a> --></td>
				</tr>
			</tfoot>
		</table>
		
		<!-- 用例测试 -->
		<table class="ctable">
			<thead>
				<tr>
					<td colspan="3">用例</td>
				</tr>
			</thead>
			<tbody id="customTable">
				<tr>
					<td colspan="3">
						<textarea rows="3" cols="20" id="simpleText" spellcheck="false" style="width: 100%;height: 120px"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr style="margin: 0px auto;" align="center">
				<td colspan="3"><a class="ca" onclick="goTextBySimple()">用例</a><!-- <a class="ca" onclick="goTestByCustom('true')">修改</a> --></td>
				</tr>
			</tfoot>
		</table>
		
		<table class="ctable">
			<tbody>
				<tr>
					<td>日期:</td>
					<td><input type="text" class="cbox" id="dateTime"></td>
					<td>数据库日期:</td>
					<td><input type="text" class="cbox" id="dateTimeInDb"></td>
					<td><a class="ca" onclick="getDBDateTime()">获取</a></td>
				</tr>
			</tbody>
		</table>

	</form>

</div>

<script>
	function getDBDateTime() {
		$.post("test/dateTime.do",
			{
				dateTime: $('#dateTime').val()
			}, function(data) {
			$('#dateTimeInDb').val(data);
		});
	}

	function addRow() {
		var row = "<tr><td><input class='cbox' value='' type='text''></td><td><input class='cbox' type='text''></td><td><a   class='ca' onclick=deleteRow($(this).parent().parent())>删除</a></td></tr>";
		$('#customTable').append(row);
	}

	function deleteRow(self) {
		//	alert(self[0]);
		//	console.log(self[0]);
		self[0].remove();
	}

	function goTestByCustom(flag) {
		var tab = $("#customTable");
		var trs = tab.find('tr');
		//	alert(trs.length);
		var param = "{";
		for (var i = 0; i < trs.length; ++i) {
			var ins = trs[i].getElementsByTagName('input');
			param += '\"' + ins[0].value.trim() + '\":' + '\"'
					+ ins[1].value.trim() + '\"';
			if (i != trs.length - 1)
				param += ","
		}
		param += ',"currentPage":' + '"' + $("#currentPage").val().trim()
				+ '",';
		param += '"pageSize":' + '"' + $("#pageSize").val().trim() + '"'
		if (flag) {
			param += ',"isEdit":' + '"true"';
		} else {
			param += ',"isEdit":' + '"false"';
		}
		param += "}";
		//请求调用接口
		$.post("test/action.do", {
			param : param
		}, function(data) {
			//	alert(data);
			$("#console").val(data);
		});
	}

	function goTextBySimple() {
		var simpleText = $('#simpleText').val();
		if (simpleText.trim() != '') {
			var reg1 = new RegExp("[,，]");
			var arr = simpleText.split(reg1);
			//console.log(arr);
//			var param = "{" +  '\"actionId\":\"' + $('#actionId').val() + '\"' ;
			var tab = $("#customTable");
			var trs = tab.find('tr');
			//	alert(trs.length);
			var param = "{";
			for (var i = 0; i < trs.length; ++i) {
				var ins = trs[i].getElementsByTagName('input');
				param += '\"' + ins[0].value.trim() + '\":' + '\"'
						+ ins[1].value.trim() + '\"';
 				if (i != trs.length - 1)
 					param += ","
			}
			for (var i = 0; i < arr.length; ++i) {
				var arrs = arr[i].split("=");
		//		alert(arrs[0]);
			    var reg = new RegExp("\\([\\s\\S]*\\)|（[\\s\\S]*）");
				arrs[0] = arrs[0].replace(reg, "");
				console.log(arrs[0]);
				param += ',\"' + arrs[0].trim() + '\":' + '\"' + arrs[1].trim() + '\"'; 
			}
			param += ',"currentPage":' + '"' + $("#currentPage").val().trim() + '",';
			param += '"pageSize":' + '"' + $("#pageSize").val().trim() + '"'
			param += "}";
			console.log(param);
			//请求调用接口
			$.post("test/action.do", {
				param : param
			}, function(data) {
				//	alert(data);
				$("#console").val(data);
			});
		}
	}
</script>