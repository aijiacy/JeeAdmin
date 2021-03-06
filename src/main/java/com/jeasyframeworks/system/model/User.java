package com.jeasyframeworks.system.model;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName="sys_user", pkName="uuid")
public class User extends BaseModel<User>{

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	public static final String REAL_NAME = "realname";
	public static final String NICK_NAME = "nickname";
	public static final String FACE_PIC = "pic";
	public static final String IDCARD = "idcard";
	public static final String TELPHONE = "telphone";
	public static final String ADDRESS = "address";
	
	public static final User me = new User();
	
	public Account getAccount(){
		return Account.me.findFirst(SqlKit.sql("Acount.findByUserId"), this.getStr(PK_ID));
	}
}
