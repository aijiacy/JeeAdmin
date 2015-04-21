package com.jeasyframeworks.system.interceptor;

import org.apache.shiro.SecurityUtils;

import com.jeasyframeworks.system.model.Account;
import com.jeasyframeworks.system.model.Log;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class LogInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		Controller ctrl = ai.getController();
		Log log = new Log();
		log.put(Log.OP_NAME, ctrl.getClass().getSimpleName());
		log.put(Log.OP_ACTION, ai.getActionKey());
		if(SecurityUtils.getSubject().isAuthenticated()){
			String opUser = ((Account)SecurityUtils.getSubject().getPrincipal()).getStr(Account.NAME) + "(" + SecurityUtils.getSubject().getSession().getHost()+ ")";
			log.put(Log.OP_USER, opUser);
		} else {
			String hostAddr = ai.getController().getRequest().getRemoteHost();
			log.put(Log.OP_USER, "NONE(" + hostAddr + ")");
		}
		log.put(Log.OP_DESC, ctrl.getClass().getName());
		log.save();
		ai.invoke();
	}

}
