package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_dictionaries",pkName="uuid")
public class Dictionary extends Model<Dictionary> {

	private static final long serialVersionUID = 1L;
	
	public static final Dictionary dao = new Dictionary();

}
