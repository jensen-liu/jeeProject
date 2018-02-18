package com.jensen.jeeproject.common.exception;

/**
 * 自定义业务逻辑验证异常
 * 
 * @author Jensen
 * @date 下午10:59:19
 * @version V1.0
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String msg) {
		super(msg);
	}

}
