package com.jeasyframeworks.system.interceptor;

import com.jeasyframeworks.system.model.Account;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.log.Logger;

public class AuthInterceptor implements Interceptor {

	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	
	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		//
		Account account = controller.getSessionAttr("UserAgent");
		if(account == null){
			logger.debug("用户未登录系统.");
			controller.redirect("/admin/login");
		}else{
			try{
				ai.invoke();
			}catch(Exception ex){
				logger.error("业务访问发生异常:", ex);
				controller.renderText("业务访问发生异常:" + ex);
			}
		}
	}

}
