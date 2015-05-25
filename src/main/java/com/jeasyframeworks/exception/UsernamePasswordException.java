package com.jeasyframeworks.exception;

import org.apache.shiro.authc.AuthenticationException;

public class UsernamePasswordException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public UsernamePasswordException() {
		super();
	}

	public UsernamePasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernamePasswordException(String message) {
		super(message);
	}

	public UsernamePasswordException(Throwable cause) {
		super(cause);
	}
	
}
