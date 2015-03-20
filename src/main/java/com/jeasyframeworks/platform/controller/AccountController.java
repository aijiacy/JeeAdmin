package com.jeasyframeworks.platform.controller;


import com.jeasyframeworks.extentions.annotation.route.ControllerBinding;
import com.jeasyframeworks.platform.interceptor.AuthInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerBinding(controllerKey="/account")
@Before(AuthInterceptor.class)
public class AccountController extends Controller {
		
	public void index(){
		
	}
	
}
