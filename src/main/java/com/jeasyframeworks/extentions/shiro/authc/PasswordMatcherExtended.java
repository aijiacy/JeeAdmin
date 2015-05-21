package com.jeasyframeworks.extentions.shiro.authc;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.PasswordMatcher;

public class PasswordMatcherExtended extends PasswordMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken submitToken,
			AuthenticationInfo storeInfo) {
		// TODO Auto-generated method stub
		return super.doCredentialsMatch(submitToken, storeInfo);
	}
}
