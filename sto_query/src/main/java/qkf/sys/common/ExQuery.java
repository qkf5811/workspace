package qkf.sys.common;

import org.springframework.stereotype.Service;

import qkf.sto.main.StoExpress;
import qkf.sto.main.ZtoExpress;
 
public class ExQuery {

	private String exCode;

	public String getExCode() {
		return this.exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public ExQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExQuery(String exCode) {
		super();
		this.exCode = exCode;
	}

	@Override
	public String toString() {
		return "ExQuery [exCode=" + exCode + "]";
	}
	
	public synchronized String query() {
		if (exCode.length() == 13)
			return new StoExpress().getInfo(this.getExCode());
		else if (exCode.length() == 12)
			return new ZtoExpress().getInfo(this.getExCode());
		else
			return "{}";
	}
	
}
