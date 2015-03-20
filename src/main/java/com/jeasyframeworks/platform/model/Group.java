package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_groups", pkName="uuid")
public class Group extends Model<Group>{

	private static final long serialVersionUID = 1L;

	public static final Group dao = new Group();
	
	
}
