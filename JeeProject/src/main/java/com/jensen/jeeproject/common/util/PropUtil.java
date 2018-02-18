package com.jensen.jeeproject.common.util;

public class PropUtil {

	private static final String MESSAGE_PROP_NAME = "message";

	public static String getPropMessage(String key) {

		PropertyConfigurer configurer = (PropertyConfigurer) SpringContextUtil.getBean("propertyConfigurer");
		return configurer.getPropertyValue(MESSAGE_PROP_NAME, key);
	}

}
