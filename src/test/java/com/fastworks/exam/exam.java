package com.fastworks.exam;

import java.text.MessageFormat;

import com.jeasyframeworks.core.constants.MessageConsts;
import com.jfinal.i18n.I18N;

public class exam {
	
	public static void main(String[] args) {
		I18N.init("i18n.messages", null, null);
		String str = I18N.getText(MessageConsts.OPER_SAVE_FAILED.getMsgKey());
		System.out.println(MessageFormat.format(str, "账户",""));
	}
}
