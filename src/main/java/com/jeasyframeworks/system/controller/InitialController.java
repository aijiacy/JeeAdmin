package com.jeasyframeworks.system.controller;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.extentions.shiro.annotation.ClearShiro;
import com.jeasyframeworks.system.model.Account;
import com.jeasyframeworks.system.model.Group;
import com.jeasyframeworks.system.model.Role;
import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey = "/system/init")
public class InitialController extends Controller {

	@ClearShiro
	public void index() {
		initData();
		this.renderNull();
	}

	private void initData() {
		try {
			//初始化账户
			Account account = new Account();
			account.put(Account.NAME, "admin");
			account.put(Account.PASSWORD, MD5EncryptKit.encrypt("123456"));
			account.put(Account.MOBILE, "18999284959");
			account.put(Account.EMAIL, "cymsn81@126.com");
			account.put(Account.FK_USERID, null);
			account.put(Account.SUPER, 1);
			account.put(Account.LOCK_STATUS, 0);
			account.save();
			String accId = account.getStr(Account.PK_ID);
			//初始化一个角色
			Role role = new Role();
			role.put(Role.NAME, "系统管理员");
			role.put(Role.CODE, "Adminstrator");
			role.save();
			String roleId = role.getStr(Role.PK_ID);
			
			Group coreGroup = new Group();
			coreGroup.put(Group.NAME, "核心平台");
			coreGroup.put(Group.PID, null);
			coreGroup.save();
			String coreGroupId = coreGroup.getStr(Group.PK_ID);
			
			Group sysGroup = new Group();
			sysGroup.put(Group.NAME, "系统管理组");
			sysGroup.put(Group.PID, coreGroupId);
			sysGroup.save();
			//分配角色
			sysGroup.allocRole(roleId);
			//分配账户
			sysGroup.allocAccount(accId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
