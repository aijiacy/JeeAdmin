package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_dictionaries",pkName="uuid")
public class Dictionary extends Model<Dictionary> {

	private static final long serialVersionUID = 1L;
	
	public static final Dictionary dao = new Dictionary();

}
