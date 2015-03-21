package com.jeasyframeworks.platform.controller;

import java.util.UUID;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.platform.model.Account;
import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/init")
public class InitialController extends Controller {
	public void index() {
		try {
			Account account = new Account();
			account.put(Account.PK_ID, 
					UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
			account.put(Account.NAME, "admin");
			account.put(Account.PASSWORD, MD5EncryptKit.encrypt("123456"));
			account.put(Account.MOBILE, "18999284959");
			account.put(Account.EMAIL, "cymsn81@126.com");
			account.put(Account.FK_USERID, null);
			account.put(Account.SUPER, 1);
			Account.dao.setAttrs(account);
			Account.dao.save();
		} catch (Exception ex) {
			ex.fillInStackTrace();
		}
	}
}
