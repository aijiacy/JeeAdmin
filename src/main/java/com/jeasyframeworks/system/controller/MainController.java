package com.jeasyframeworks.system.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;

import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jfinal.core.Controller;

@ControllerKey(controllerKey="/portail")
public class MainController extends Controller{
	
	@RequiresRoles("Adminstrator")
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
