package com.fastworks.core.controller;


import com.fastworks.core.interceptor.AuthInterceptor;
import com.fastworks.jfinal.annotation.route.ControllerBind;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerBind(controllerKey="/account")
@Before(AuthInterceptor.class)
public class AccountController extends Controller {
		
	public void index(){
		
	}
	
}
