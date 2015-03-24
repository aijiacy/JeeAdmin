package com.jeasyframeworks.extentions.shiro;


import java.util.Map;

import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;

public interface DBAuthzLoader {
	public Map<String, AuthzHandler> getDBAuthz();
}
