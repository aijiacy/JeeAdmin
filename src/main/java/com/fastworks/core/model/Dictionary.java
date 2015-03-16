package com.fastworks.core.model;

import com.jfinal.extentions.annotation.table.TableBinder;
import com.jfinal.plugin.activerecord.Model;

@TableBinder(tableName="sys_dictionaries",pkName="uuid")
public class Dictionary extends Model<Dictionary> {

	private static final long serialVersionUID = 1L;
	
	public static final Dictionary dao = new Dictionary();

}
