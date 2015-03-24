/**
 * Copyright (c) 2011-2013, dafei 李飞 (myaniu AT gmail DOT com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeasyframeworks.extentions.shiro;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;


/**
 * ShiroKit. (Singleton, ThreadSafe)
 *
 * @author dafei
 */
public class ShiroKit {

	/**
	 * 用来记录那个action或者actionpath中是否有shiro认证注解。
	 */
	private static ConcurrentMap<String, AuthzHandler> authzMaps = null;
	/**
	 * 用来记录数据权限
	 */
	private static Map<String, AuthzHandler> dbAuthzMaps = null;
	
	private static DBAuthzLoader dbAuthzLoader = null;

	/**
	 * 禁止初始化
	 */
	private ShiroKit() {}

	/**
	 * 初始化 Shiro 权限
	 * @param maps
	 * @param dbAuthzLoader 改造，增加数据权限加载器.
	 */
	public static void init(ConcurrentMap<String, AuthzHandler> maps, DBAuthzLoader injectLoader) {
		authzMaps = maps;
		dbAuthzLoader = injectLoader;
		loadAuthzFormDB();
	}

	public static AuthzHandler getAuthzHandler(String actionKey){
		/*
		if(authzMaps.containsKey(controllerClassName)){
			return true;
		}*/
		AuthzHandler auth = null;
		if(authzMaps.containsKey(actionKey)){
			auth = authzMaps.get(actionKey);
		} else {
			auth = dbAuthzMaps.get(actionKey);
		}
		return auth;
	}
	
	private static void loadAuthzFormDB(){
		dbAuthzMaps = dbAuthzLoader.getDBAuthz();
	}
}
