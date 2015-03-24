package com.jeasyframeworks.extentions.shiro.handler;

import org.apache.shiro.authz.AuthorizationException;

public class DBPermissionAuthzHandler extends AbstractAuthzHandler {

	private final String dbPermission;
	
	public DBPermissionAuthzHandler(String dbPermission) {
		this.dbPermission = dbPermission;
	}
	
	@Override
	public void assertAuthorized() throws AuthorizationException {
		if(this.dbPermission != null){
			getSubject().checkPermission(this.dbPermission);
			return;
		}
	}
}
