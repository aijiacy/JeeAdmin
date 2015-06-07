package com.jeasyframeworks.system.controller;

import com.jeasyframeworks.extentions.route.annotation.AnnoController;
import com.jfinal.core.Controller;

@AnnoController(actionKey = "/")
public class SystemController extends Controller {
	public void index() {
		redirect("/system/main");
	}
}
