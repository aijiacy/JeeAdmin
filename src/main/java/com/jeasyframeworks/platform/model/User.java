package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jeasyframeworks.extentions.kit.SqlKit;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_user", pkName="uuid")
public class User extends Model<User>{

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid";
	public static final String REAL_NAME = "realname";
	public static final String NICK_NAME = "nickname";
	public static final String FACE_PIC = "pic";
	public static final String IDCARD = "idcard";
	public static final String TELPHONE = "telphone";
	public static final String ADDRESS = "address";
	
	public static final User dao = new User();
	
	public Account getAccount(){
		return Account.dao.findFirst(SqlKit.sql("Acount.findByUserId"), this.getStr(PK_ID));
	}
}
