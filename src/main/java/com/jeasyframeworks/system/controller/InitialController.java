package com.jeasyframeworks.system.controller;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.extentions.shiro.annotation.ClearShiro;
import com.jeasyframeworks.system.model.Account;
import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/system/init")
public class InitialController extends Controller {
	
	@ClearShiro
	public void index() {
		try {
			Account account = new Account();
			//account.put(Account.PK_ID, UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
			account.put(Account.NAME, "admin");
			account.put(Account.PASSWORD, MD5EncryptKit.encrypt("123456"));
			account.put(Account.MOBILE, "18999284959");
			account.put(Account.EMAIL, "cymsn81@126.com");
			account.put(Account.FK_USERID, null);
			account.put(Account.SUPER, 1);
			account.put(Account.LOCK_STATUS, 0);
			Account.dao.setAttrs(account);
			Account.dao.save();
			this.renderJson();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
