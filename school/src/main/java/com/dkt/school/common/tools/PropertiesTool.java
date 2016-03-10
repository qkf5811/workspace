package com.dkt.school.common.tools;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;


/*
 *@Title: PropertiesTool.java
 *@Package com.dkt.huaQiao.common.tools
 *@Description: TODO添加描述
 *@author Harry
 *@date 2015年4月14日下午3:23:51
 */
public enum PropertiesTool {

	INSTANCE;
	
	private PropertiesConfiguration config;
	
	public String getProperties(){
		
		if(config==null){
		try {
			
			config=new PropertiesConfiguration("/conf/fileUploadPath.properties");
			//在tomcat没有开启自动部署的情况下，修改配置文件之后会自动加载新修改的配置文件。
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
			config.setAutoSave(true);
			return config.getString("fileUploadPath");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}else{
			
			return config.getString("fileUploadPath");
		}
	}

	
	
}

