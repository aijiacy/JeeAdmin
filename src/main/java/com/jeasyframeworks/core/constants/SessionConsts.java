package com.jeasyframeworks.core.constants;

public enum SessionConsts {
	SESSION_USER("SESSION_USER"), SESSION_CAPTCHA("SESSION_CAPTCHA");

	private final String value;

	private SessionConsts(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
