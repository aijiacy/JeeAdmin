package com.jeasyframeworks.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;

import com.jeasyframeworks.core.constants.MsgConsts;
import com.jeasyframeworks.core.controller.BaseController;
import com.jeasyframeworks.core.messages.AjaxMsg;
import com.jeasyframeworks.exception.CaptchaException;
import com.jeasyframeworks.exception.UsernamePasswordException;
import com.jeasyframeworks.extentions.captcha.CaptchaRender;
import com.jeasyframeworks.extentions.route.annotation.ControllerKey;
import com.jeasyframeworks.extentions.shiro.authc.UsernamePasswordCaptchaToken;
import com.jeasyframeworks.system.model.Account;
import com.jfinal.log.Logger;

/**
 * 登录处理
 * 
 * @author caoyong
 *
 */
@ControllerKey(controllerKey = "/system")
public class LoginController extends BaseController<Account> {

	private static final Logger logger = Logger
			.getLogger(LoginController.class);

	public void index() {
		render("login.html");
	}

	/**
	 * 用户登录
	 */
	public void login() {
		AjaxMsg msg = new AjaxMsg(true, MsgConsts.LOGIN_SUCCESS);
		try {
			Account reqAccount = getModel(Account.class);
			String captcha = getPara("captcha");
			boolean forgetPwd = getParaToBoolean("forgetPass");
			Subject currUser = SecurityUtils.getSubject();
			String username = reqAccount.getStr(Account.NAME);
			String password = reqAccount.getStr(Account.PASSWORD);
			UsernamePasswordCaptchaToken uToken = new UsernamePasswordCaptchaToken(username,
					password, forgetPwd, getRequest().getRemoteHost(), captcha);
			currUser.login(uToken);
			if (!currUser.isAuthenticated()) {
				msg = new AjaxMsg(true, 0, "验证未通过！");
				logger.error(msg.getOpDesc());
			}
		} catch (AuthenticationException aex) {
			if (aex instanceof UsernamePasswordException) {
				msg = new AjaxMsg(false, MsgConsts.LOGIN_NAMEANDPWD_ERR);
				logger.error(msg.getOpDesc(), aex);
			} else if (aex instanceof CaptchaException) {
				msg = new AjaxMsg(false, MsgConsts.LOGIN_CAPTCHA_ERR);
				logger.error(msg.getOpDesc(), aex);
			} else {
				msg = new AjaxMsg(false, MsgConsts.LOGIN_OTHER_ERR);
				logger.error(msg.getOpDesc(), aex);
			}
		} catch (Exception ex) {
			msg = new AjaxMsg(false, MsgConsts.LOGIN_OTHER_ERR);
			logger.error(msg.getOpDesc(), ex);
		}
		this.renderJson(msg);
	}

	/**
	 * 退出登录
	 */
	public void logout() {
		Subject currUser = SecurityUtils.getSubject();
		if (null != currUser) {
			currUser.logout();
		}
	}

	/**
	 * 修改密码
	 */
	public void change() {

	}

	/**
	 * 找回密码
	 */
	public void findPwd() {

	}

	public void captcha() {
		int width = 0, height = 0, minnum = 0, maxnum = 0, fontsize = 0;// , fontmin = 0, fontmax = 0;
		CaptchaRender captcha = new CaptchaRender();
		if (isParaExists("width")) {
			width = getParaToInt("width");
		}
		if (isParaExists("height")) {
			height = getParaToInt("height");
		}
		if (width > 0 && height > 0)
			captcha.setImgSize(width, height);
		if (isParaExists("minnum")) {
			minnum = getParaToInt("minnum");
		}
		if (isParaExists("maxnum")) {
			maxnum = getParaToInt("maxnum");
		}
		if (minnum > 0 && maxnum > 0)
			captcha.setFontNum(minnum, maxnum);
		if (isParaExists("fontsize")) {
			fontsize = getParaToInt("fontsize");
		}
		if (fontsize > 0) {
			captcha.setFontSize(fontsize, fontsize);
		}
		// 干扰线数量 默认0
		captcha.setLineNum(2);
		// 噪点数量 默认50
		captcha.setArtifactNum(30);
		// 使用字符 去掉0和o 避免难以确认
		// captcha.setCode("123456789");
		// 验证码在session里的名字 默认 captcha,创建时间为：名字_time
		// captcha.setCaptchaName("captcha");
		// 验证码颜色 默认黑色
		// captcha.setDrawColor(new Color(255,0,0));
		// 背景干扰物颜色 默认灰
		// captcha.setDrawBgColor(new Color(0,0,0));
		// 背景色+透明度 前三位数字是rgb色，第四个数字是透明度 默认透明
		// captcha.setBgColor(new Color(225, 225, 0, 100));
		// 滤镜特效 默认随机特效 //曲面Curves //大理石纹Marble //弯折Double //颤动Wobble //扩散Diffuse
		captcha.setFilter(CaptchaRender.FilterFactory.Curves);
		// 随机色 默认黑验证码 灰背景元素
		captcha.setRandomColor(true);
		// 验证码长度
		captcha.setFontNum(4, 6);
		render(captcha);
	}

	@Override
	protected Account getModelDAO() {
		// TODO Auto-generated method stub
		return Account.me;
	}
}
