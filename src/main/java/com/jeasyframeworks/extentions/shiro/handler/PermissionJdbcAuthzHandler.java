package com.jeasyframeworks.extentions.shiro.handler;

import org.apache.shiro.authz.AuthorizationException;

public class PermissionJdbcAuthzHandler extends AbstractAuthzHandler {

	private final String jdbcPermission;

	public PermissionJdbcAuthzHandler(String jdbcPermission) {
		this.jdbcPermission = jdbcPermission;
	}

	@Override
	public void assertAuthorized() throws AuthorizationException {
		if (jdbcPermission != null) {
			getSubject().checkPermission(jdbcPermission);
			return;
		}
	}

}
