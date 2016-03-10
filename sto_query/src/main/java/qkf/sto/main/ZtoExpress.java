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

public class ZtoExpress implements Express {

	private String url = ExPattern.ZtoUrl;

	private long sleepTime = 0;

	@Override
	public String getInfo(String code) {
		System.out.println("中通快递单号: " + code);
		String resultJson = "";
		List<ExpressInfo> expList = new ArrayList<ExpressInfo>();

		String queryUrl = url + code;
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		try {
			client = HttpClients.createDefault();
			HttpGet get = new HttpGet(queryUrl);
			
			get.addHeader("Host", "www.zto.com");
			get.addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0");
			get.addHeader("Acept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			get.addHeader("Accept-Encoding", "deflate");
			get.addHeader("Cookie", "Hm_lvt_53a93979e64ab8e76c06653f6830c385=1454122218,1454124076,1454124091,1454124168; Hm_lpvt_53a93979e64ab8e76c06653f6830c385=1454124178; UserBills=[" + code + "]");
			get.addHeader("Connection", "keep-alive");
			get.addHeader("Parama", "no-cache");
			get.addHeader("Cache-Control", "no-cache");
			
		//	System.out.println("queryUrl: " + queryUrl);
			response = client.execute(get);
	//		System.out.println(EntityUtils.getContentCharSet(response.getEntity()));
			String html = //new String(EntityUtils.toByteArray(response.getEntity()), "gbk"); 
					EntityUtils.toString(response.getEntity(), "utf-8");
		//	 System.out.println(html);
			// 解析
			Pattern allInfoPattern = Pattern.compile(ExPattern.ZtoInfoPattern);
			Matcher matcher1 = allInfoPattern.matcher(html);
			matcher1.find();
			// 测试用
	//		System.out.println("matcher1: " + matcher1.group(1));
			String allInfo = matcher1.group(1);
			// 解析每个结果
			Pattern infoPattern = Pattern.compile(ExPattern.ZtoPerInfoPattern);
			Matcher matcher2 = infoPattern.matcher(allInfo);
			// 解析每个field
			Pattern fieldPattern = Pattern.compile("<[^>]+?>", Pattern.DOTALL);
			while (matcher2.find()) {
		//		System.out.println("resultSet: " + matcher2.group());
				String[] split = fieldPattern.split(matcher2.group());
				int size = split.length;
				// 测试用, 生成快递信息对象,并装入list
		//		System.out.println("split:");
		//		 for (String s : split) {
		//		 System.out.print(s + ",");
		//		 }
				String date = split[size-2].trim();
				String send = split[size-9].trim() + split[size-8].trim() +  split[size-7].trim();
				String to = split[size-6].trim() + split[size-5].trim() + split[size-4].trim() + split[size-3].trim();
				expList.add(new ExpressInfo(date, send, to));
			}

			JsonArray ja = new Gson().toJsonTree(expList, List.class).getAsJsonArray();
			System.out.println(new Date().toLocaleString() + ": 单号" + code + "信息获取:");
		//	System.out.println(ja.toString());
			// resultJson = ja.toString();
			return ja.toString();
		} catch (Exception e) {
			e.printStackTrace();
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
		// return resultJson;
	}

}
