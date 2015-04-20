package com.jeasyframeworks.core.model;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jeasyframeworks.toolkit.uuid.UUIDKit;
import com.jfinal.plugin.activerecord.Model;

public abstract class BaseModel<T extends Model<?>> extends Model<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6351065395207183910L;

	/**
	 * 主键采用UUID生成策略
	 */
	@Override
	public boolean save() {
		TableBind tb = (TableBind) getClass().getAnnotation(TableBind.class);
		this.getAttrs().put(tb.pkName(), UUIDKit.generate());
		return super.save();
	}

}
