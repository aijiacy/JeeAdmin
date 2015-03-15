package com.fastworks.core.model;

import com.fastworks.jfinal.annotation.table.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName="sys_platforms", pkName="uuid")
public class Platform extends Model<Platform> {

	private static final long serialVersionUID = 1L;
	
	public static final Platform dao = new Platform();

}
