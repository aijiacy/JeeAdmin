package com.jeasyframeworks.platform.controller;


import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.platform.interceptor.AuthInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/account")
@Before(AuthInterceptor.class)
public class AccountController extends Controller {
		
	public void index(){
		
	}
	
}
