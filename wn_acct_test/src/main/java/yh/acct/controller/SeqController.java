package yh.acct.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import net.pri.j9.async.remote.ModuleRemoteResetLoader;
import net.pri.j9.framework.core.exception.LogicException;
import net.pri.j9.framework.loader.config.ConfigAbs;
import net.pri.j9.framework.remote.RemoteGateWayApi;

@Controller
@RequestMapping("/seq")
public class SeqController {
	
	@RequestMapping("/goSeq")
	public String goSeq() {
		return "seq";
	}
	
	@ResponseBody
	@RequestMapping("/getSeqJson")
	public String getSeqJson() throws LogicException {
		ModuleRemoteResetLoader n = new ModuleRemoteResetLoader();
		n.start(null, ConfigAbs.getConfig());
		
		Map<String, Object> actionResult = RemoteGateWayApi.doAction("seq.getJson", null, "seqApiUrl");
		Object map = actionResult.get("data");
		System.out.println(new Gson().toJson(map));
		List<Map<String, Object>> child = getChild(actionResult);
		
		JsonArray ja = new Gson().toJsonTree(child, List.class).getAsJsonArray();
		JsonObject resultJson = new JsonObject();
		resultJson.add("rows", ja);
		resultJson.addProperty("total", child.size());
		
		return resultJson.toString();
	}
	
	@ResponseBody
	@RequestMapping("/setSeqJson")
	public String setSeqJson(String key, Long value) throws LogicException {
		ModuleRemoteResetLoader n = new ModuleRemoteResetLoader();
		n.start(null, ConfigAbs.getConfig());
		
//		Map<String, Object> paraMap = new HashMap<String, Object>();
//		paraMap.put("key", key);
//		paraMap.put("value", value);
//		JsonObject keyObj = new JsonObject();
//		keyObj.addProperty("key", key);
//		JsonObject valObj = new JsonObject();
//		valObj.addProperty("val", value);
//		List<JsonObject> jList = new ArrayList<JsonObject>();
//		jList.add(keyObj);
//		jList.add(valObj);
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("data", paraMap);
		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("data", jList);
		data.put("key", key);
		data.put("val", value);
		System.out.println("param: " + data);
		RemoteGateWayApi.doAction("seq.setVal", data, "seqApiUrl");
//		Object map = actionResult.get("data");
//		System.out.println(new Gson().toJson(map));
//		List<Map<String, Object>> child = getChild(actionResult);
//		System.out.println("result: " + actionResult);
		
//		JsonArray ja = new Gson().toJsonTree(child, List.class).getAsJsonArray();
//		JsonObject resultJson = new JsonObject();
//		resultJson.add("rows", ja);
//		resultJson.addProperty("total", child.size());
		
		return "1";
	}
	
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getChild(Map<String, Object> doAction) {
		List<Map<String, Object>> resultList= new ArrayList<Map<String, Object>>();
		Object object = doAction.get("data");
		String json = new Gson().toJson(object);
		json = json.substring(1);
		json = json.substring(0, json.length()-1);
		json = json.replaceAll("\\\\", "");
		Map<String, Object> map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
		List<Map<String, Object>> allChild= (List<Map<String, Object>>) map.get("child");
/*		for (int i = 0; i < allChild.size(); ++i) {
			List<Map<String, Object>> tmpList = (List<Map<String, Object>>) allChild.get(i).get("child");
			for (int j = 0; j < tmpList.size(); ++j) {
				List<Map<String, Object>> finalList = (List<Map<String, Object>>) tmpList.get(j).get("child");
	//			String edit = "<a class='easyui-linkbutton' iconCls='icon-edit' id='enableEdit' data-options='plain:true' style='z-index: -100' onclick='enableEdit()'>编辑</a>";
	//			String update = "<a class='easyui-linkbutton' iconCls='icon-add' id='updateEdit' data-options='plain:true' style='z-index: -100' onclick='updateEdit()'>更新</a>";
	//			finalList.get(0).put("fun", edit + update);
				resultList.add(finalList.get(0));
			}
		}*/
		childTree(allChild, resultList);
		
		return resultList;
 	}
	
	@SuppressWarnings("unchecked")
	public void childTree(List<Map<String, Object>> list, List<Map<String, Object>> resultList) {
		for (int i = 0; i < list.size(); ++i) {
			List<Map<String, Object>> cList = (List<Map<String, Object>>) list.get(i).get("child");
			if (cList != null) {
				childTree(cList, resultList);
			} else {
				resultList.add(list.get(i));
			}
		}
	}
}
