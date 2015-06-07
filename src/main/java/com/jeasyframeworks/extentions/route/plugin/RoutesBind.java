/**
 * Copyright (c) 2011-2013.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeasyframeworks.extentions.route.plugin;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.jeasyframeworks.extentions.route.annotation.AnnoController;
import com.jeasyframeworks.toolkit.SeachClassKit;
import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Logger;

public class RoutesBind extends Routes {

	private boolean autoScan = true;

	private List<Class<? extends Controller>> excludeClasses = Lists.newArrayList();
	private List<Class<? extends Controller>> includeClasses = Lists.newArrayList();

	private List<String> includeClassPaths = Lists.newArrayList();
	private List<String> excludeClassPaths = Lists.newArrayList();

	private boolean includeAllJarsInLib = false;

	private List<String> includeJars = Lists.newArrayList();

	protected final Logger logger = Logger.getLogger(getClass());

	private String suffix = "Controller";

	public RoutesBind autoScan(boolean autoScan) {
		this.autoScan = autoScan;
		return this;
	}
	
	public RoutesBind includeAllJarsInLib(boolean includeAllJarsInLib) {
		this.includeAllJarsInLib = includeAllJarsInLib;
		return this;
	}

	@SuppressWarnings("unchecked")
	public RoutesBind addExcludeClasses(Class<? extends Controller>... clazzes) {
		if (clazzes != null) {
			for (Class<? extends Controller> clazz : clazzes) {
				excludeClasses.add(clazz);
			}
		}
		return this;
	}

	public RoutesBind addExcludeClasses(List<Class<? extends Controller>> clazzes) {
		excludeClasses.addAll(clazzes);
		return this;
	}

	public RoutesBind addExcludePaths(String... paths) {
		for (String path : paths) {
			excludeClassPaths.add(path);
		}
		return this;
	}

	public RoutesBind addIncludeJars(String... jars) {
		if (jars != null) {
			for (String jar : jars) {
				includeJars.add(jar);
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public RoutesBind addIncludeClasses(Class<? extends Controller>... clazzes) {
		for (Class<? extends Controller> clazz : clazzes) {
			includeClasses.add(clazz);
		}
		return this;
	}

	public RoutesBind addIncludeClasses(List<Class<? extends Controller>> clazzes) {
		if (clazzes != null) {
			includeClasses.addAll(clazzes);
		}
		return this;
	}

	public RoutesBind addIncludePaths(String... paths) {
		for (String path : paths) {
			includeClassPaths.add(path);
		}
		return this;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void config() {
		List<Class<? extends Controller>> controllerClasses = SeachClassKit.of(Controller.class).includeAllJarsInLib(includeAllJarsInLib).injars(includeJars).search();
		AnnoController controller = null;
		for (Class clazz : controllerClasses) {
			if (excludeClasses.contains(clazz)) {
				continue;
			}
			controller = (AnnoController) clazz.getAnnotation(AnnoController.class);
			if (controller == null) {
				if (!autoScan) {
					continue;
				}
				this.add(getAction(clazz), clazz);
				logger.debug("routes.add(" + getAction(clazz) + ", " + clazz.getName() + ")");
			} else if (StrKit.isBlank(controller.view())) {
				this.add(controller.actionKey(), clazz);
				logger.debug("routes.add(" + controller.actionKey() + ", " + clazz.getName() + ")");
			} else {
				this.add(controller.actionKey(), clazz, controller.view());
				logger.debug("routes.add(" + controller.actionKey() + ", " + clazz + "," + controller.view() + ")");
			}
		}
	}

	private String getAction(Class<Controller> clazz) {
		Preconditions.checkArgument(clazz.getSimpleName().endsWith(suffix), clazz.getName() + " is not annotated with @ControllerKey and not end with " + suffix);
		String action = "/" + StrKit.firstCharToLowerCase(clazz.getSimpleName());
		action = action.substring(0, action.indexOf(suffix));
		return action;
	}

	public RoutesBind suffix(String suffix) {
		this.suffix = suffix;
		return this;
	}

}
