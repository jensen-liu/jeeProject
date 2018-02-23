package com.jensen.jeeproject.common.util;

import java.util.UUID;

/**
 * ID工具类
 * 
 * @author Jensen
 * @date 下午12:35:43
 * @version V1.0
 */
public class IdUtil {
	/**
	 * 生成ID
	 * 
	 * @return
	 * @author Jensen
	 * @date 2018年2月23日
	 * @since 1.0
	 */
	public static String getId() {

		return UUID.randomUUID().toString().replace("-", "");
	}

}
