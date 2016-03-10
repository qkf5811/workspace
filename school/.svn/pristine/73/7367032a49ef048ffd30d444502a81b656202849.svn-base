package com.dkt.school.common.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/*
 *@Title: ClientInfoTool.java
 *@Package com.dkt.huaQiao.common.tools
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年2月4日下午5:17:45
 */
public enum ClientInfoTool {
	
	//通过INSTANCE来获得一个ClientInfoTool单例
	INSTANCE;
	
	//定义http请求头
	private static final String[] PROXY_REMOTE_IP_ADDRESS = { "X-Forwarded-For", "X-Real-IP" };
	
	private String clientInfo=null;
	private String explorerInfo=null;
	private String osInfo=null;

	public String getExplorerInfo() {
		return explorerInfo;
	}


	public void setExplorerInfo(String explorerInfo) {
		this.explorerInfo = explorerInfo;
	}


	public String getOsInfo() {
		return osInfo;
	}


	public void setOsInfo(String osInfo) {
		this.osInfo = osInfo;
	}


	/**
	 * 获取客户端系统和浏览器信息
	 */
	public void getOsAndExplorerInfo(HttpServletRequest request){
		clientInfo=request.getHeader("User-Agent");
		
		String explorerName=null;
		String explorerVersion=null;
		String osName=null;
		String osVersion=null;
		
		Pattern pattern=Pattern.compile("");
		Matcher matcher;
		
		//获取浏览器信息(浏览器名字和版本号)
		if(clientInfo.indexOf("MSIE") != -1){   
			explorerName = "MSIE"; //微软IE   
             pattern = Pattern.compile(explorerName + "\\s([0-9.]+)");   
        }else if(clientInfo.indexOf("Firefox") != -1){   
        	explorerName = "Firefox"; //火狐   
             pattern = Pattern.compile(explorerName + "\\/([0-9.]+)");   
        }else if(clientInfo.indexOf("Chrome") != -1){   
        	explorerName = "Chrome"; //Google   
            pattern = Pattern.compile(explorerName + "\\/([0-9.]+)");   
        }else if(clientInfo.indexOf("Opera") != -1){   
        	explorerName = "Opera"; //Opera   
            pattern = Pattern.compile("Version\\/([0-9.]+)");   
        }else if(clientInfo.indexOf("Safari") != -1){   
        	explorerName = "Safari"; //Safari   
            pattern = Pattern.compile("Version\\/([0-9.]+)");   
        }else if(clientInfo.indexOf("Mozilla") != -1){
        	if(clientInfo.indexOf("rv")!=-1){
        	explorerName = "MSIE"; //IE10-IE11   
            pattern = Pattern.compile("Trident/.*rv:([0-9]{1,}[\\/.0-9]{0,})");
        	}
        }
		matcher=pattern.matcher(clientInfo);
		
		if(matcher.find()){
			explorerVersion=matcher.group(1);
			
		}
		explorerInfo=explorerName+" "+explorerVersion;
		
		//获取系统名字和系统版本
		if(clientInfo.indexOf("Windows") != -1){   
			osName = "Windows"; //Windows NT
            pattern = Pattern.compile(osName + "\\s([a-zA-Z0-9]+\\s[0-9.]+)");   
        
		matcher=pattern.matcher(clientInfo);
		if(matcher.find()){
			osVersion= matcher.group(1);
			if(osVersion.indexOf("NT 6.3")!=-1){
				osVersion=" 8.1/Windows Server 2012 R2";
			}else if(osVersion.indexOf("NT 6.2")!=-1){
				osVersion=" 8/Windows Server 2012";
			}else if(osVersion.indexOf("NT 6.1")!=-1){
				osVersion=" 7/Windows Server 2008 R2";
			}else if(osVersion.indexOf("NT 6.0")!=-1){
				osVersion=" Vista/Windows Server 2008";
			}else if(osVersion.indexOf("NT 5.2")!=-1){
				osVersion=" Server 2003/Windows Server 2003 R2";
			}else if(osVersion.indexOf("NT 5.1")!=-1){
				osVersion=" XP";
			}
		}
		osInfo=osName+osVersion;
		
		}else if(clientInfo.indexOf("Linux") != -1){   
			osName = "Linux"; //Linux  
            pattern = Pattern.compile(osName + "\\s([a-zA-Z0-9]+\\s[0-9.]+)");   
        
		matcher=pattern.matcher(clientInfo);
		if(matcher.find()){
			osVersion= matcher.group(1);
		}
		osInfo=osName+osVersion;
		
		}else if(clientInfo.indexOf("Mac") != -1){   
			osName = "Mac"; //Mac  
            pattern = Pattern.compile(osName + "\\s([a-zA-Z0-9]+\\s[0-9.]+)");   
        
		matcher=pattern.matcher(clientInfo);
		if(matcher.find()){
			osVersion= matcher.group(1);
		}
		osInfo=osName+osVersion;
		}
	}
	
	

	
	
	/**
	 * 获取发出请求的客户端ip地址
	 * @param request
	 * @return
	 */
	public static String getRemoteIp( HttpServletRequest request ) {
		
	    for ( int i = 0 ; i < PROXY_REMOTE_IP_ADDRESS.length ; i++ ) {  
	        String ip = request.getHeader( PROXY_REMOTE_IP_ADDRESS[i] );  
	        if ( ip != null && ip.trim().length()> 0 ) {  
	            return getRemoteIpFromForward( ip.trim() );  
	        }  
	    }  
	    return request.getRemoteHost();  
	}  
	
	/**
	 * 假如使用了反向代理服务器，从http header中截取客户端连接的ip地址,返回客户端的源ip地址
	 * @param xforwardIp
	 * @return
	 */
	private static String getRemoteIpFromForward( String xforwardIp ) {  
	    int commaOffset = xforwardIp.indexOf( ',' );  
	    if ( commaOffset < 0 ) {  
	        return xforwardIp;  
	    }  
	    return xforwardIp.substring( 0 , commaOffset );  
	}  
}

