package com.jeasyframeworks.core.messages;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 消息国际化
 * @author cao.yong
 *
 */
public class I18nMessage implements Message {
	private static final long serialVersionUID = 1L;

	private static final String I18N_LANGUAGE_FILE = "i18n.messages";

	private static final I18nMessage i18n = new I18nMessage();
	
	private ResourceBundle resource;

	private I18nMessage() {
		Locale locale = new Locale("zh", "CN");
		resource = ResourceBundle.getBundle(I18N_LANGUAGE_FILE, locale);
	}

	public static I18nMessage me() {
		return i18n;
	}
	
	public String getString(String key){
		return resource.getString(key);
	}

}
