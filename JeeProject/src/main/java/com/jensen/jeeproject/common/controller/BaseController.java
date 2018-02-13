package com.jensen.jeeproject.common.controller;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.jensen.jeeproject.common.util.PropertyConfigurer;
import com.jensen.jeeproject.common.util.SpringContextUtil;

public abstract class BaseController {

	private static final String MESSAGE_PROP_NAME = "message";

	protected String getPropMessage(String key) {

		PropertyConfigurer configurer = (PropertyConfigurer) SpringContextUtil.getBean("propertyConfigurer");
		return configurer.getPropertyValue(MESSAGE_PROP_NAME, key);
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {

				setValue(filterDangerString(text));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
	}

	/**
	 * 1、过滤参数中的非法字符，防止XSS攻击 <br/>
	 * 2、过滤空格换行等字符
	 * 
	 * @param value
	 * @return
	 */
	protected String filterDangerString(String value) {

		if (value == null) {
			return null;
		}
		value = value.replaceAll("\t", "    ");
		value = value.replaceAll("\r\n", "\n");
		value = value.replaceAll("\n", "<br/>");
		return StringEscapeUtils.escapeHtml4(value.trim());
	}
	
}