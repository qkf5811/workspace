package qkf.sto.model;

public class ExpressInfo {

	private String date;
	private String send;
	private String to;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "ExpressInfo [date=" + date + ", send=" + send + ", to=" + to + "]";
	}
	public ExpressInfo(String date, String send, String to) {
		super();
		this.date = date;
		this.send = send;
		this.to = to;
	}
	public ExpressInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
