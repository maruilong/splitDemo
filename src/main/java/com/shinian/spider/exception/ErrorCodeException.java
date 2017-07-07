package com.shinian.spider.exception;

/**
 * 
 * @ClassName: ErrorCodeException
 * @Description:错误变量
 * @author shinian
 * @date 2017年7月7日 下午11:53:35
 * 
 */
public class ErrorCodeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private Integer code = 200;

	public ErrorCodeException(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "错误编码为:" + code;
	}
}
