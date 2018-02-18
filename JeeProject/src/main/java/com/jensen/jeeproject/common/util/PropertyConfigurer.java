package com.jensen.jeeproject.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	private Resource[] resources;
	private PropertiesPersister propertiesPersister;
	private Map<String, Properties> propMap;

	{
		propertiesPersister = new DefaultPropertiesPersister();
		propMap = new HashMap<String, Properties>();
	}

	@Override
	protected void loadProperties(Properties props) throws IOException {

		InputStream is = null;
		if (null != resources) {
			for (Resource location : resources) {
				is = location.getInputStream();
				this.propertiesPersister.load(props, is);
				propMap.put(FilenameUtils.getBaseName(location.getFilename()), props);
			}
		}
	}

	public Properties getProperty(String propName) {

		return propMap.get(propName);
	}

	public String getPropertyValue(String propName, String key) {

		return getProperty(propName).getProperty(key);
	}

	public Resource[] getResources() {
		return resources;
	}

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

}
