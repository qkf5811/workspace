package qkf.sys.common;

/**
 * 快递消息的pattern
 * @author qkf
 * 创建日期: 2016年1月30日 上午10:42:46
 */
public class ExPattern {
	
	/**
	 * 申通pattern
	 */
	public static final String StoInfoPattern = "<ul class=\"result-list-info\">([^~]+?)</ul>"; 
	
	/**
	 * 申通查询url
	 */
	public static final String StoUrl = "http://q1.sto.cn/chaxun/result?express_no=";
	/**
	 * 圆通pattern
	 */
	public static final String YtoInfoPattern = "";
	
	/**
	 * 中通pattern
	 */
	public static final String ZtoInfoPattern = "<div class=\"state\">[^~]*?<ul>([^~]+?)</ul>[^~]*?</div>";
	
	/**
	 * 中通没一个结果集pattern
	 */
	public static final String ZtoPerInfoPattern = "<li[^~]*?>([^~]+?)</li>";
	
	/**
	 * 中通查询url
	 */
	public static final String ZtoUrl = "http://www.zto.com/GuestService/Bill?txtBill=";
	
	/**
	 * 韵达pattern
	 */
	public static final String YundaInfoPattern = "http://www.kuaidi100.com/query?type=yunda&postid=";
}
