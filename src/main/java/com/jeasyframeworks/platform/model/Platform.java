package com.jeasyframeworks.platform.model;

import com.jeasyframeworks.extentions.annotation.table.TableBinding;
import com.jfinal.plugin.activerecord.Model;

@TableBinding(tableName="sys_platforms", pkName="uuid")
public class Platform extends Model<Platform> {

	private static final long serialVersionUID = 1L;
	
	public static final Platform dao = new Platform();

}
