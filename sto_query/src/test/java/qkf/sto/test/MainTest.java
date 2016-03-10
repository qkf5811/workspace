package qkf.sto.test;

import org.junit.Test;

import qkf.sto.main.StoExpress;
import qkf.sto.main.YunDaExpress;
import qkf.sto.main.ZtoExpress;
import qkf.sto.service.impl.ExpressQueryImpl;

public class MainTest {

	
	@Test
	public void test() {
		new ExpressQueryImpl().queryJsonByCode("3304504730631");
	}
	
	@Test
	public void sendMail() {
//		ExpressMail.sendMail("1713369104@qq.com", "消息内容.");
	}
	
	@Test
	public void testSto() {
		new StoExpress().getInfo("3304504730631");
	}
	@Test
	public void testZto() {
		new ZtoExpress().getInfo("374018549183");
	}
	@Test
	public void testYunDa() {
		new YunDaExpress().getInfo("1231231231231");
	}
}
