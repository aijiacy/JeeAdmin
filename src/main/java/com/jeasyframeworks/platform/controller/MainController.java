package com.jeasyframeworks.platform.controller;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.platform.interceptor.AuthInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/main")
@Before(AuthInterceptor.class)
public class MainController extends Controller{
	
	public void index(){
		render("index.html");
	}
	
	public void header(){
		render("header.html");
	}
	
	public void footer(){
		render("footer.html");
	}
	
	public void help(){
		render("help.html");
	}
	
	public void main(){
		render("main.html");
	}
}
