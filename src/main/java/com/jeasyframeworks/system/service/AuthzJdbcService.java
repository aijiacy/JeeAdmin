package com.jeasyframeworks.system.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.jeasyframeworks.extentions.shiro.handler.AuthzHandler;
import com.jeasyframeworks.extentions.shiro.handler.PermissionJdbcAuthzHandler;
import com.jeasyframeworks.extentions.shiro.plugin.AuthzJdbcLoader;
import com.jeasyframeworks.system.model.Function;
import com.jeasyframeworks.system.model.Menu;
import com.jeasyframeworks.system.model.Permission;
import com.jeasyframeworks.system.model.Platform;
import com.jeasyframeworks.system.model.Role;
import com.jfinal.kit.StrKit;

public class AuthzJdbcService implements AuthzJdbcLoader {

	@Override
	public Map<String, AuthzHandler> getJdbcAuthz() {
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
		 * 例如 role     /system/
		 * 例如 platform /system/**
		 * 例如 menu     /system/menus/**
		 * 例如 function /system/menus/add**
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
						dbAuthzMaps.put(platform.getStr(Platform.URL), new PermissionJdbcAuthzHandler(platform.getStr(Platform.CODE)));
					}
				}
				menus = Menu.me.findByPermissionId(permission.getStr(Permission.PK_ID));
				for (Menu menu : menus) {
					if(StrKit.notBlank(menu.getStr(Menu.URL)) && (menu.getInt(Menu.ACTIVATE) == 1)){
						dbAuthzMaps.put(menu.getStr(Menu.URL), new PermissionJdbcAuthzHandler(menu.getStr(Menu.CODE)));
					}
				}
				functions = Function.me.findByPermissionId(permission.getStr(Permission.PK_ID));
				for (Function function : functions) {
					if(StrKit.notBlank(function.getStr(Function.ACTION_URL))){
						dbAuthzMaps.put(function.getStr(Function.ACTION_URL), new PermissionJdbcAuthzHandler(function.getStr(Function.CODE)));
					}
				}
			}
		}
		return dbAuthzMaps;
	}

}
