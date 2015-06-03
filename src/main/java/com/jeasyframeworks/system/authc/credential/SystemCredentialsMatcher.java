package com.jeasyframeworks.system.authc.credential;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.CodecSupport;

/**
 * 
 * @author cao.yong
 *
 */
public class SystemCredentialsMatcher extends CodecSupport implements CredentialsMatcher {

	private PasswordService passwordService;

	public SystemCredentialsMatcher() {
		passwordService = new MD5PasswordService();
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		PasswordService service = ensurePasswordService();
		String tokenCredentials = getTokenCredentials(token);
		String infoCredentials = getInfoCredentials(info);
		return service.passwordsMatch(tokenCredentials, infoCredentials);
	}
	
	private String getTokenCredentials(AuthenticationToken token){
		Object credentials = token.getCredentials();
		return toString(credentials);
	}
	
	private String getInfoCredentials(AuthenticationInfo info){
		Object credentials = info.getCredentials();
		return toString(credentials);
	}

	private PasswordService ensurePasswordService() {
		PasswordService service = getPasswordService();
		if (service == null) {
			String msg = "Required PasswordService has not been configured.";
			throw new IllegalStateException(msg);
		}
		return service;
	}

	public PasswordService getPasswordService() {
		return passwordService;
	}

	public void setPasswordService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

}
