package com.ppdai.jiechu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropUtil {
	private Logger logger = Logger.getLogger(this.getClass());
	private Properties properties;

	public PropUtil(String path) {
		initialize(path);
	}

	private void initialize(String path) {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
		if (is == null) {
			logger.info("{} not exist"+path);
		}
		properties = new Properties();
		if (is != null) {
			try {
				properties.load(is);
			} catch (IOException e) {
				logger.error("initialize error", e);
			} finally {
				try {
					if (is != null)
						is.close();
				} catch (Exception e) {
					logger.error("initialize error", e);
				}
			}
		}
	}

	/**
	 * get specified key in config files
	 * 
	 * @param key
	 *            the key name to get value
	 */
	public String get(String key) {
		String keyValue = null;
		if (properties.containsKey(key)) {
			keyValue = (String) properties.get(key);
		}
		return keyValue;
	}

	/**
	 * get specified key in config files
	 * 
	 * @param key
	 *            the key name to get value
	 * @param defaultValue
	 *            key不存在时，返回缺省值
	 */
	public String get(String key, String defaultValue) {
		String keyValue = properties.getProperty(key, defaultValue);
		return keyValue;
	}
}
