package qkf.utils;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.management.InstanceAlreadyExistsException;

public class ExpressMail {

	private static Properties properties = new Properties();
	
	public static void sendMail(String toAddr, String message) {
		
		try {
			properties.load(ExpressMail.class.getResourceAsStream("../../mail.properties"));
			
			//创建授权信息，用于smtp验证
			Authenticator authenticator = new Authenticator(){
				 @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					 String username = properties.getProperty("mail.user");
					 String password = properties.getProperty("mail.password");
					return new PasswordAuthentication(username, password);
				}
			};
			
			//创建邮件会话
			Session mailSession = Session.getInstance(properties, authenticator);
			
			//创建邮件消息
			MimeMessage mailMessge = new MimeMessage(mailSession);
			
			//设置发件人
			InternetAddress from = new InternetAddress(properties.getProperty("mail.user"));
			mailMessge.setFrom(from);
			
			 // 设置收件人
	        InternetAddress to = new InternetAddress(toAddr);
	        mailMessge.setRecipient(RecipientType.TO, to);
	        
	     // 设置抄送
//	        InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
//	        mailMessge.setRecipient(RecipientType.CC, cc);
	        
	        // 设置密送，其他的收件人不能看到密送的邮件地址
//	        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
//	        mailMessge.setRecipient(RecipientType.CC, bcc);

	        // 设置邮件标题
	        mailMessge.setSubject("您的快递有新的信息!");

	        // 设置邮件的内容体
	        mailMessge.setContent(message, "text/html;charset=UTF-8");

	        // 发送邮件
	        Transport.send(mailMessge);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
