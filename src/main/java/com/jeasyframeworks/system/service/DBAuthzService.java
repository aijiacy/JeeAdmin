package com.jeasyframeworks.system.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

import com.jeasyframeworks.extentions.shiro.DBAuthzLoader;
import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;

public class DBAuthzService implements DBAuthzLoader {

	@Override
	public ConcurrentMap<String, AuthzHandler> getDBAuthz() {
		// TODO 
		//按长度倒序排列url
		Map<String, AuthzHandler> dbAuthzMaps = Collections.synchronizedMap(new TreeMap<String, AuthzHandler>(
	        new Comparator<String>() {
	          public int compare(String firstKey, String secondKey) {
	            int result = secondKey.length() - firstKey.length();
	            if (result == 0) {
	              return firstKey.compareTo(secondKey);
	            }
	            return result;
	          }
	        }));
		/**
		 * 权限表必须包含 name code url 字段 url作为key
		 * 例如 platform /system
		 * 例如 menu     /system/menus
		 * 例如 function /system/menus/add
		 */
		
		return null;
	}

}
