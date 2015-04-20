package com.jeasyframeworks.system.model;

import java.util.List;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.sqlxml.SqlKit;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName="sys_dictionaries",pkName="uuid")
public class Dictionary extends BaseModel<Dictionary> {

	private static final long serialVersionUID = 1L;
	
	public static final String PK_ID = "uuid";
	public static final String NAME = "name";
	public static final String VALUE = "value";
	public static final String TYPE = "type";
	public static final String FK_PID = "pid";
	
	public static final Dictionary me = new Dictionary();
	
	public Dictionary getParent(){
		return findById(getStr(FK_PID));
	}
	
	public List<Dictionary> getChilden(){
		return find(SqlKit.sql("Dictionary.findByPid"), getStr(PK_ID));
	}

}
