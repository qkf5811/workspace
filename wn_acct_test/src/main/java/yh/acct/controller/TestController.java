package yh.acct.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.pri.j9.framework.core.exception.LogicException;
import net.pri.j9.framework.util.ConvertUtil;
import net.pri.j9.framework.util.DateUtil;
import yh.acct.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService tService;
	@ResponseBody
	@RequestMapping("/action")
	public String remoteAction(String param) {
		System.out.println("param: " + param);
		Map<String, String> infoMap = new Gson().fromJson(param, new TypeToken<Map<String, String>>() {
		}.getType());
		try {
			return tService.doAction(infoMap);
		} catch (LogicException e) {
			return e.getMessage();
		}
	}
	
	@ResponseBody
	@RequestMapping("/dateTime")
	public String getDateTimeInDb(String dateTime) throws ParseException {
		if (dateTime != null && !dateTime.trim().equals("")) {
	//		System.out.println(dateTime);
			SimpleDateFormat format = new SimpleDateFormat(dateTime);
			String result = "";
			if (dateTime.contains(":") || dateTime.contains("：")) {
				result = ConvertUtil.toString(DateUtil.timeStringToInt(dateTime));
			} else if (dateTime.contains("-") || dateTime.contains("-")) {
				result = ConvertUtil.toString(DateUtil.dateToInteger(format.parse(dateTime)));
			}
			return result;
		} else {
			return "";
		}
	}
}
