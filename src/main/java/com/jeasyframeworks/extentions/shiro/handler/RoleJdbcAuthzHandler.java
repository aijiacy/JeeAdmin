package com.jeasyframeworks.extentions.shiro.handler;

import org.apache.shiro.authz.AuthorizationException;

public class RoleJdbcAuthzHandler extends AbstractAuthzHandler {
	private final String jdbcRole;

	public RoleJdbcAuthzHandler(String jdbcRole) {
		this.jdbcRole = jdbcRole;
	}

	@Override
	public void assertAuthorized() throws AuthorizationException {
		if (jdbcRole != null) {
			getSubject().checkRole(jdbcRole);
			return;
		}
	}

}
