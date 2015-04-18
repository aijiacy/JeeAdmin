package com.jeasyframeworks.extentions.table.model;

import java.util.UUID;

import com.jeasyframeworks.extentions.table.annotation.TableBind;
import com.jfinal.plugin.activerecord.Model;

public class KeyModel<T extends Model<?>> extends Model<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6351065395207183910L;

	@Override
	public boolean save() {
		TableBind tb = (TableBind) getClass().getAnnotation(TableBind.class);
		this.getAttrs().put(tb.pkName(), UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
		return super.save();
	}

}
