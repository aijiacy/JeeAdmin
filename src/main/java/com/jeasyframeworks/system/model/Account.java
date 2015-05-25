package com.jeasyframeworks.system.model;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName = "sys_accounts", pkName = "uuid")
public class Account extends BaseModel<Account> {

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	public static final String FK_USERID = "userid";
	public static final String SUPER = "super";
	public static final String LOCK_STATUS = "lockStatus";
	
	public static final Account me = new Account();
	
	public Account findByName(String username){
		return findFirst(SqlKit.sql("Account.findByName"), username);
	}
	
	public User getUser(){
		return User.me.findById(getStr(FK_USERID));
	}
}
