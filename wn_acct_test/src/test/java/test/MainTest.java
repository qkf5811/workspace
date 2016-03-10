package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.pri.j9.async.remote.ModuleRemoteResetLoader;
import net.pri.j9.framework.core.exception.LogicException;
import net.pri.j9.framework.loader.config.ConfigAbs;
import net.pri.j9.framework.remote.RemoteGateWayApi;

public class MainTest {
	
	public static void main(String[] args) throws LogicException {
		ModuleRemoteResetLoader n = new ModuleRemoteResetLoader();
		n.start(null, ConfigAbs.getConfig());
		
		Map<String, Object> actionResult = RemoteGateWayApi.doAction("seq.getJson", null, "seqApiUrl");
		Object map = actionResult.get("data");
		System.out.println(new Gson().toJson(map));
		
		String json = new Gson().toJson(map);
		json = json.substring(1);
		json = json.substring(0, json.length()-1);
		json = json.replaceAll("\\\\", "");
		System.out.println(json);
		Map<String, Object> map1 = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
		List<Map<String, Object>> allChild= (List<Map<String, Object>>) map1.get("child");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		childTree(allChild, result);
		System.out.println("size: " + result.size());
	}
	
	private List<Map<String, Object>> getChild(Map<String, Object> doAction) {
		List<Map<String, Object>> resultList= new ArrayList<Map<String, Object>>();
		Object object = doAction.get("data");
		String json = new Gson().toJson(object);
		json = json.substring(1);
		json = json.substring(0, json.length()-1);
		json = json.replaceAll("\\\\", "");
		Map<String, Object> map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
		List<Map<String, Object>> allChild= (List<Map<String, Object>>) map.get("child");
		for (int i = 0; i < allChild.size(); ++i) {
			List<Map<String, Object>> tmpList = (List<Map<String, Object>>) allChild.get(i).get("child");
			for (int j = 0; j < tmpList.size(); ++j) {
				List<Map<String, Object>> finalList = (List<Map<String, Object>>) tmpList.get(j).get("child");
	//			String edit = "<a class='easyui-linkbutton' iconCls='icon-edit' id='enableEdit' data-options='plain:true' style='z-index: -100' onclick='enableEdit()'>编辑</a>";
	//			String update = "<a class='easyui-linkbutton' iconCls='icon-add' id='updateEdit' data-options='plain:true' style='z-index: -100' onclick='updateEdit()'>更新</a>";
	//			finalList.get(0).put("fun", edit + update);
				resultList.add(finalList.get(0));
			}
		}
		return resultList;
 	}
	
	@SuppressWarnings("unchecked")
	public static void childTree(List<Map<String, Object>> list, List<Map<String, Object>> resultList) {
		for (int i = 0; i < list.size(); ++i) {
			List<Map<String, Object>> cList = (List<Map<String, Object>>) list.get(i).get("child");
			if (cList != null) {
				childTree(cList, resultList);
			} else {
			//	System.out.println(list.get(i));
				resultList.add(list.get(i));
			}
		}
	}
}
