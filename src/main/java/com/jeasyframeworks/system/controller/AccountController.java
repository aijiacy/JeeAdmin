package com.jeasyframeworks.system.controller;

import com.jeasyframeworks.core.controller.BaseController;
import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.system.model.Account;

@ControllerKey(controllerKey="/system/account")
public class AccountController extends BaseController<Account> {
		
	public void index(){
		
	}

	@Override
	protected Account getModelDAO() {
		// TODO Auto-generated method stub
		return Account.me;
	}

	@Override
	protected String[] getOperName() {
		return new String[]{"账户"};
	}
	
}
