package com.shinian.spider;

public enum HttpCode {

	/**
	 * 200 成功
	 */
	SUCCESS(200, "连接成功"),
	/**
	 * 404, "找不到页面"
	 */
	PAGE_NOT_FOUND(404, "找不到页面");

	
	/**
	 * 值
	 */
	private int value;

	/**
	 * 描述
	 */
	private String text;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	HttpCode(int value, String text) {
		this.value = value;
		this.text = text;
	}
}
