package com.jeasyframeworks.extentions.shiro.constants;

public enum HttpMethod {
	GET("GET"), POST("POST");
	
	private final String value;

	private HttpMethod(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
