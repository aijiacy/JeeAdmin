package com.jeasyframeworks.system.authc.realm;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.jeasyframeworks.exception.UsernamePasswordException;
import com.jeasyframeworks.extentions.shiro.authc.UsernamePasswordCaptchaToken;
import com.jeasyframeworks.system.model.Account;
import com.jeasyframeworks.system.model.Function;
import com.jeasyframeworks.system.model.Group;
import com.jeasyframeworks.system.model.Menu;
import com.jeasyframeworks.system.model.Permission;
import com.jeasyframeworks.system.model.Platform;
import com.jeasyframeworks.system.model.Role;
import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;

public class SystemAuthRealm extends AuthorizingRealm {

	/**
	 * 登录认证
	 *
	 * @param authToken
	 * @return
	 * @throws org.apache.shiro.authc.AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		// TODO Shiro登录认证
		try {
			UsernamePasswordCaptchaToken userToken = (UsernamePasswordCaptchaToken) authToken;
			Account account = null;
			String username = userToken.getUsername();
			String password = String.valueOf(userToken.getPassword());
			account = Account.me.findByName(username);
			if (account != null) {
				if (MD5EncryptKit.isEqual(password, account.getStr(Account.PASSWORD))) {
					SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(account, password, getName());
					return authInfo;
				} else {
					throw new UsernamePasswordException("密码错误");
				}

			} else {
				throw new UsernamePasswordException("用户名不存在");
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new UsernamePasswordException("密码加密比对异常");
		}

	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 *
	 * @param principals
	 *            用户信息
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principal) {
		// TODO 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
		String loginName = ((Account) principal.fromRealm(getName()).iterator().next()).getStr(Account.USERNAME);
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		Set<String> setRoles = new LinkedHashSet<String>(); // 角色集合
		Set<String> setPermissions = new LinkedHashSet<String>(); // 权限集合
		List<Role> userRoles = null;
		Account account = Account.me.findByName(loginName);
		if (account == null) {
			SecurityUtils.getSubject().logout();
		} else {
			userRoles = Role.me.findByAccId(account.getStr(Account.PK_ID));
			List<Group> groups = Group.me.findByAccId(account
					.getStr(Account.PK_ID));
			if (groups != null && !groups.isEmpty()) {
				String[] gIds = new String[groups.size()];
				int i = 0;
				for (Group group : groups) {
					gIds[i] = group.getStr(Group.PK_ID);
					i++;
				}
				List<Role> groupRoles = Role.me.findByGroupIds(gIds);
				userRoles.removeAll(groupRoles);
				userRoles.addAll(groupRoles);
			}
		}
		loadRoles(setRoles, setPermissions, userRoles);
		authInfo.setRoles(setRoles);
		authInfo.setStringPermissions(setPermissions);
		return authInfo;
	}

	private void loadRoles(Set<String> setRoles, Set<String> setPermissions,
			List<Role> roles) {
		List<Permission> permissions = null;
		for (Role role : roles) {
			setRoles.add(role.getStr(Role.CODE));
			permissions = Permission.me.findByRoleId(role.getStr(Role.PK_ID));
			loadPermissions(setPermissions, permissions);
		}
	}

	private void loadPermissions(Set<String> setPermissions,
			List<Permission> permissions) {
		List<Platform> platforms = null;
		List<Menu> menus = null;
		List<Function> functions = null;
		for (Permission permission : permissions) {
			platforms = Platform.me.findByPermissionId(permission
					.getStr(Permission.PK_ID));
			for (Platform platform : platforms) {
				setPermissions.add(platform.getStr(Platform.CODE));
			}
			menus = Menu.me.findByPermissionId(permission
					.getStr(Permission.PK_ID));
			for (Menu menu : menus) {
				setPermissions.add(menu.getStr(Menu.CODE));
			}
			functions = Function.me.findByPermissionId(permission
					.getStr(Permission.PK_ID));
			for (Function function : functions) {
				setPermissions.add(function.getStr(Function.CODE));
			}
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(Object principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
}
