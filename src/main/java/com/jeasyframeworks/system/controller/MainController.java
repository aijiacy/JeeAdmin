package com.jeasyframeworks.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.jeasyframeworks.extentions.route.annotation.AnnoController;
import com.jfinal.core.Controller;

@AnnoController(actionKey = "/system/main", view= "")
public class MainController extends Controller {

	public void index() {
		render("index.html");
	}

	public void header() {
		render("header.html");
	}

	public void footer() {
		render("footer.html");
	}

	public void help() {
		render("help.html");
	}

	public void content() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			render("main.html");
		} else {
			redirect("/system/login");
		}
	}
}
