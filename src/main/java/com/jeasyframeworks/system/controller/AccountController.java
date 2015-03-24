package com.jeasyframeworks.system.controller;


import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.system.interceptor.AuthInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/account")
@Before(AuthInterceptor.class)
public class AccountController extends Controller {
		
	public void index(){
		
	}
	
}
