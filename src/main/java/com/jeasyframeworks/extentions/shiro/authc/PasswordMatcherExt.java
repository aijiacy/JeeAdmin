package com.jeasyframeworks.extentions.shiro.authc;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.PasswordMatcher;

public class PasswordMatcherExt extends PasswordMatcher {
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken submitToken,
			AuthenticationInfo storeInfo) {
		return super.doCredentialsMatch(submitToken, storeInfo);
	}
	
	/**
	 * 重写将Shiro存储的char[]类型密码 转换成String类型
	 * @see org.apache.shiro.authc.credential.PasswordMatcher#getStoredPassword(org.apache.shiro.authc.AuthenticationInfo)
	 */
	@Override
	protected Object getStoredPassword(AuthenticationInfo storedAccountInfo) {
		Object stored = super.getStoredPassword(storedAccountInfo);
		if(stored instanceof char[]){
			stored = String.valueOf(stored);
		}
		return stored;
	}
}
