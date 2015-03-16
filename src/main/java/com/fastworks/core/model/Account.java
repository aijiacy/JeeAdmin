package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinding;
import com.jfinal.extentions.kit.SqlKit;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName = "sys_accounts", pkName = "uuid")
public class Account extends Model<Account> {

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String MOBILE = "mobile";
	public static final String FK_USERID = "userid";
	public static final String SUPER = "super";
	
	public static final Account dao = new Account();
	
	public Account findByName(String name){
		return this.findFirst(SqlKit.sql("Account.findByName"), name);
	}
	
	public User getUser(){
		return User.dao.findById(getStr(FK_USERID));
	}
}
