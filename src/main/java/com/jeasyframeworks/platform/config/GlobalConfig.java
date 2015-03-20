package com.jeasyframeworks.platform.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jeasyframeworks.extentions.plugin.sql.AutoScanSqlPlugin;
import com.jeasyframeworks.extentions.plugin.table.AutoBindTablePlugin;
import com.jeasyframeworks.extentions.route.AutoBindRoutes;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.cache.EhCache;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.druid.IDruidStatViewAuth;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;

/**
 * 全局配置文件
 * 
 * @author caoyong
 *
 */
public class GlobalConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
		me.setBaseViewPath("WEB-INF/views/");
	}

	@Override
	public void configRoute(Routes me) {
//		me.add(new AdminRoutes());// 后端路由
//		me.add(new FrontRoutes());// 前端路由
		AutoBindRoutes abr = new AutoBindRoutes();
		abr.autoScan(false);
		me.add(abr);
	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("config.properties");
		// 数据连接配置
		DruidPlugin druidPlugin = new DruidPlugin(
				getProperty("mysql.jdbc.url"), getProperty("mysql.jdbc.user"),
				getProperty("mysql.jdbc.password"),
				getProperty("mysql.jdbc.driverClass"));
		// 初始化配置
		initDruidConfig(druidPlugin);
		// 增加状态监控
		druidPlugin.addFilter(new StatFilter());
		// 指定数据库类型
		WallFilter wallFilter = new WallFilter();
		wallFilter.setDbType("mysql");
		druidPlugin.addFilter(wallFilter);
		me.add(druidPlugin);

		AutoBindTablePlugin atbp = new AutoBindTablePlugin(druidPlugin);
		atbp.autoScan(false);
		atbp.setDialect(new MysqlDialect());
		atbp.setShowSql(true);
		atbp.setCache(new EhCache());
		me.add(atbp);
		
		AutoScanSqlPlugin sxp = new AutoScanSqlPlugin();
		sxp.start();
		me.add(sxp);
		
		EhCachePlugin ehcachePlugin = new EhCachePlugin();
		me.add(ehcachePlugin);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
	}

	@Override
	public void configHandler(Handlers me) {
		DruidStatViewHandler dsv = new DruidStatViewHandler("/moniter",
				new IDruidStatViewAuth() {
					@Override
					public boolean isPermitted(HttpServletRequest request) {
						// TODO 系统数据库监控页面权限设置
						HttpSession hs = request.getSession(false);
						return (hs != null && hs.getAttribute("UserAgent") != null);
					}
				});
		me.add(dsv);
	}

	/**
	 * initialization connect configuration.
	 * 
	 * @param druidPlugin
	 */
	private void initDruidConfig(DruidPlugin druidPlugin) {
		int initialSize = Integer.parseInt(getProperty("jdbc.druid.initialSize"));
		int minIdle = Integer.parseInt(getProperty("jdbc.druid.minIdle"));
		int maxActive = Integer.parseInt(getProperty("jdbc.druid.maxActive"));
		druidPlugin.set(initialSize, minIdle, maxActive);
		long timeBetweenEvictionRunsMillis = Long.parseLong(getProperty("jdbc.druid.timeBetweenEvictionRunsMillis"));
		long minEvictableIdleTimeMillis = Long.parseLong(getProperty("jdbc.druid.minEvictableIdleTimeMillis"));
		int maxPoolPreparedStatementPerConnectionSize = Integer.parseInt(getProperty("jdbc.druid.maxPoolPreparedStatementPerConnectionSize"));
		druidPlugin.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		druidPlugin.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		druidPlugin.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
	}
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8080, "/", 50);
	}
}
