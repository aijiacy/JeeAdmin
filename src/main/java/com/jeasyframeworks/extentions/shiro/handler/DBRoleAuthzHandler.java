package com.jeasyframeworks.extentions.shiro.handler;

import org.apache.shiro.authz.AuthorizationException;

public class DBRoleAuthzHandler extends AbstractAuthzHandler{

	private final String dbRole;
	
	public DBRoleAuthzHandler(String dbRole) {
		this.dbRole = dbRole;
	}
	
	@Override
	public void assertAuthorized() throws AuthorizationException {
		if(this.dbRole != null){
			getSubject().checkRole(this.dbRole);
			return;
		}
	}

}
