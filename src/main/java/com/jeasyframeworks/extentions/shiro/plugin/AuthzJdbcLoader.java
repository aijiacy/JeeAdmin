package com.jeasyframeworks.extentions.shiro.plugin;


import java.util.Map;

import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;

public interface AuthzJdbcLoader {
	public Map<String, AuthzHandler> getJdbcAuthz();
}
