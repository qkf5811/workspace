package qkf.center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qkf.utils.ExpressMail;

@Controller
@RequestMapping("/center")
public class CenterController {

	@ResponseBody
	@RequestMapping("/sendMail")
	public String sendMain(String json) {
		System.out.println(json);
		StringBuilder sb = new StringBuilder();

		if (json.contains("failure"))
			return "{\"result\": \"success\"}";
		else {
			String[] strs = json.replaceAll("[{\\[\\]]|\\r\\n\\t\\t\\t\\t\\t", "").split("},");
			for (int i = 0; i < strs.length; ++i) {
				String[] info = strs[i].split(",");
				sb.append("<i><font color=\"red\">日期:</font><i> " + info[0].replaceAll("\"date\":|\"", "") + "\t");
				sb.append("<font color=\"purple\">" + info[1].replaceAll("\"send\":|\"", "") + "</font>\t");
				sb.append("<font color=\"purple\">" + info[2].replaceAll("\"to\":|\"|}", "")
						+ "</font><br><HR style=\"FILTER: alpha(opacity=100,finishopacity=0,style=3)\" width=\"80%\" color=#987cb9 SIZE=3><br>");
			}
			ExpressMail.sendMail("1713369104@qq.com", sb.toString());
			return "{\"result\": \"success\"}";
		}
	}
}
