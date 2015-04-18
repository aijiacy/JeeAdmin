package com.jeasyframeworks.system.model;

import com.jeasyframeworks.core.model.BaseModel;
import com.jeasyframeworks.extentions.table.annotation.TableBind;

@TableBind(tableName = "sys_logs", pkName = "uuid")
public class Log extends BaseModel<Log> {

	private static final long serialVersionUID = 1L;

	public static final String PK_ID = "uuid",
			OP_NAME = "op_name",
			OP_ACTION = "op_action",
			OP_USER = "op_user",
			OP_DESC = "op_desc";

	public static final Log dao = new Log();
}
