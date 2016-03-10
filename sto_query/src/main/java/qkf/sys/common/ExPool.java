package qkf.sys.common;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 容器启动是创建一个实例
 */
import org.springframework.stereotype.Service;
@Service
public class ExPool  {

	private static Map<String, ExQuery> exMap = new WeakHashMap<>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static ExQuery getQuery(String code) {
		return exMap.get(code);
	}
	
	public static ExQuery pool(String code) {
		ExQuery q = new ExQuery(code);
		exMap.put(code, q);
		return q;
	}

}
