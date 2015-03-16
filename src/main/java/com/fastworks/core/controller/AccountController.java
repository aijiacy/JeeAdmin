package com.fastworks.core.controller;


import com.fastworks.core.interceptor.AuthInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.extentions.annotation.route.ControllerBinding;

@ControllerBinding(controllerKey="/account")
@Before(AuthInterceptor.class)
public class AccountController extends Controller {
		
	public void index(){
		
	}
	
}
