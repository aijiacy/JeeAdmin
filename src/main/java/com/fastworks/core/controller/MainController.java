package com.fastworks.core.controller;

import com.fastworks.core.interceptor.AuthInterceptor;
import com.fastworks.jfinal.annotation.route.ControllerBind;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@ControllerBind(controllerKey="/main")
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
