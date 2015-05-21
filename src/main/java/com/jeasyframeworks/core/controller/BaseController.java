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

	protected abstract T getModelDAO();
	
	public void save() {
		AjaxMsg msg = new AjaxMsg(true, 1, "保存数据成功!");
		try {
			getModel(getModelClass()).save();
		} catch (Exception ex) {
			msg.setOpResult(false);
			msg.setOpCode(0);
			msg.setOpDesc("保存数据失败");
			logger.error(msg.getOpDesc(), ex);
		}
		this.renderJson(msg);
	}
	
	public void edit(){
		setAttr(getModelClass().getSimpleName(), getModelDAO().findById(getPara()));
	}
	
	public void delete(){
		String id = getPara(0);
		AjaxMsg msg = new AjaxMsg(true, 1, "删除数据成功!");
		try{
			this.getModelDAO().deleteById(id);
		} catch (Exception ex){
			msg.setOpResult(false);
			msg.setOpCode(0);
			msg.setOpDesc("删除数据失败");
			logger.error("Id:[" + id + "]，" + msg.getOpDesc(), ex);
		}
		this.renderJson(msg);
	}
	
	public void update(){
		AjaxMsg msg = new AjaxMsg(true, 1, "更新数据成功!");
		try{
			this.getModel(getModelClass()).update();
		} catch (Exception ex){
			msg.setOpResult(false);
			msg.setOpCode(0);
			msg.setOpDesc("更新数据失败");
			logger.error(msg.getOpDesc(), ex);
		}
		this.renderJson(msg);
	}

}
