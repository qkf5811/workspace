package qkf.sto.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import qkf.sto.model.ExpressInfo;
import qkf.sys.common.ExPattern;

public class YunDaExpress implements Express {

	private String yundaUrl = ExPattern.StoUrl;

	private long sleepTime = 0;

	@Override
	public String getInfo(String code) {

		System.out.println("韵达快递单号: " + code);
		String resultJson = "";
		List<ExpressInfo> expList = new ArrayList<ExpressInfo>();

		String queryUrl = yundaUrl + code + "&id=1&valicode=&temp=0.4808979509398341";
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpGet get = new HttpGet(queryUrl);
			get.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/48.0.2564.82 Chrome/48.0.2564.82 Safari/537.36");
			get.setHeader("Upgrade-Insecure-Requests", "1");
			get.setHeader("Host", "www.kuaidi100.com");
			response = client.execute(get);
			String html = EntityUtils.toString(response.getEntity(), "UTF-8");
			// System.out.println(html);
			// 解析
	//		Pattern allInfoPattern = Pattern.compile(ExPattern.StoInfoPattern);
	//		Matcher matcher1 = allInfoPattern.matcher(html);
	//		matcher1.find();
			// 测试用
			// System.out.println(matcher1.group());
	//		String allInfo = matcher1.group();
			// 解析每个结果
	//		Pattern infoPattern = Pattern.compile("<li[^>]+?>([^~]*?)</li>");
	//		Matcher matcher2 = infoPattern.matcher(allInfo);
			// 解析每个field
	//		Pattern fieldPattern = Pattern.compile("<[^>]+?>", Pattern.DOTALL);
//			while (matcher2.find()) {
//	//			String[] split = fieldPattern.split(matcher2.group());
//				int size = split.length;
//				// 测试用, 生成快递信息对象,并装入list
//				// for (String s : split) {
//				// System.out.print(s + ",");
//				// }
//				String date = split[2].trim();
//				String send = split[5].trim() + split[6].trim();
//				String to = split[size - 3].trim() + split[size - 2].trim() + split[size - 1].trim();
//				expList.add(new ExpressInfo(date, send, to));
//			}
			System.out.println(html);
			JsonArray ja = new Gson().toJsonTree(expList, List.class).getAsJsonArray();
			System.out.println(new Date().toLocaleString() + ": 单号" + code + "信息获取:");
			// System.out.println(ja.toString());
			// resultJson = ja.toString();
			return ja.toString();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("快递信息获取失败!");
		} finally {
			try {
				Thread.sleep(sleepTime);
				response.close();
				client.close();
			} catch (Exception e) {
				System.out.println("关闭链接发生异常.");
				return "{\"result\": \"关闭链接发生异常\"}";
			}
		}
		return "{\"result\": \"failure!\"}";
	}

}
