package com.jeasyframeworks.extentions.shiro.authc;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.jeasyframeworks.core.constants.MessageConsts;
import com.jeasyframeworks.exception.CaptchaException;
import com.jfinal.i18n.I18N;

/**
 * Shiro登录验证重写，增加验证码 验证机制
 * 
 * @author cao.yong
 *
 */
public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter {
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	public String getCaptchaParam() {
		return captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	/**
	 * 重写登录
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		UsernamePasswordCaptchaToken token = createToken(request, response);
		try{
			doCaptchaValidate(request, token);
			return super.executeLogin(request, response);
		} catch (AuthenticationException aex) {
			return onLoginFailure(token, aex, request, response);
		}
	}
	
    // 验证码校验  
    protected void doCaptchaValidate(ServletRequest request, UsernamePasswordCaptchaToken token) {  
    	//session中的图形码字符串  
        String captcha = this.getCaptcha(request);  
        //比对  
        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {  
            throw new CaptchaException(I18N.getText(MessageConsts.LOGIN_CAPTCHA_ERR.getMsgKey()));
        }  
    } 

	protected UsernamePasswordCaptchaToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new UsernamePasswordCaptchaToken(username, password, rememberMe, host, captcha);
	}
}
