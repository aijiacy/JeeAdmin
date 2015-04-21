package com.jeasyframeworks.system.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.jeasyframeworks.extentions.shiro.DBAuthzLoader;
import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;
import com.jeasyframeworks.extentions.shiro.handler.DBPermissionAuthzHandler;
import com.jeasyframeworks.system.model.Function;
import com.jeasyframeworks.system.model.Menu;
import com.jeasyframeworks.system.model.Permission;
import com.jeasyframeworks.system.model.Platform;
import com.jeasyframeworks.system.model.Role;
import com.jfinal.kit.StrKit;

public class DBAuthzService implements DBAuthzLoader {

	@Override
	public Map<String, AuthzHandler> getDBAuthz() {
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
		//获取所有角色
		List<Role> roles = Role.me.findAll();
		List<Permission> permissions = null;
		for (Role role : roles) {
			permissions = Permission.me.findByRoleId(role.getStr(Role.PK_ID));
			List<Platform> platforms = null;
			List<Menu> menus = null;
			List<Function> functions = null;
			for (Permission permission : permissions) {
				platforms = Platform.me.findByPermissionId(permission.getStr(Permission.PK_ID));
				for (Platform platform : platforms) {
					if(StrKit.notBlank(platform.getStr(Platform.URL))){
						dbAuthzMaps.put(platform.getStr(Platform.URL), new DBPermissionAuthzHandler(platform.getStr(Platform.CODE)));
					}
				}
				menus = Menu.me.findByPermissionId(permission.getStr(Permission.PK_ID));
				for (Menu menu : menus) {
					if(StrKit.notBlank(menu.getStr(Menu.URL)) && (menu.getInt(Menu.ACTIVATE) == 1)){
						dbAuthzMaps.put(menu.getStr(Platform.URL), new DBPermissionAuthzHandler(menu.getStr(Platform.CODE)));
					}
				}
				functions = Function.me.findByPermissionId(permission.getStr(Permission.PK_ID));
				for (Function function : functions) {
					if(StrKit.notBlank(function.getStr(Menu.URL))){
						dbAuthzMaps.put(function.getStr(Platform.URL), new DBPermissionAuthzHandler(function.getStr(Platform.CODE)));
					}
				}
			}
		}
		return dbAuthzMaps;
	}

}
