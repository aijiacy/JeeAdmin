package com.jeasyframeworks.core.controller;

import java.lang.reflect.ParameterizedType;

import com.jeasyframeworks.core.constants.AjaxMsg;
import com.jeasyframeworks.core.model.BaseModel;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;

public abstract class BaseController<T extends BaseModel<?>> extends Controller {

	public static Logger logger = Logger.getLogger(BaseController.class);

	@SuppressWarnings("unchecked")
	private Class<T> getModelClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public abstract T getModelDAO();
	
	public void save() {
		AjaxMsg msg = new AjaxMsg(1, "保存数据成功!");
		try {
			getModel(getModelClass()).save();
		} catch (Exception ex) {
			msg.setRetCode(0);
			msg.setRetMsg("保存数据失败");
			logger.error(msg.getRetMsg(), ex);
		}
		this.renderJson(msg);
	}
	
	public void edit(){
		setAttr(getModelClass().getSimpleName(), getModelDAO().findById(getPara()));
	}
	
	public void delete(){
		String id = getPara(0);
		AjaxMsg msg = new AjaxMsg(1, "删除数据成功!");
		try{
			this.getModelDAO().deleteById(id);
		} catch (Exception ex){
			msg.setRetCode(0);
			msg.setRetMsg("删除数据失败");
			logger.error("Id:[" + id + "]，" + msg.getRetMsg(), ex);
		}
		this.renderJson(msg);
	}
	
	public void update(){
		AjaxMsg msg = new AjaxMsg(1, "更新数据成功!");
		try{
			this.getModel(getModelClass()).update();
		} catch (Exception ex){
			msg.setRetCode(0);
			msg.setRetMsg("更新数据失败");
			logger.error(msg.getRetMsg(), ex);
		}
		this.renderJson(msg);
	}

}
