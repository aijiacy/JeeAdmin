package com.fastworks.exam;

import java.text.MessageFormat;

import com.jeasyframeworks.core.constants.MsgConsts;
import com.jeasyframeworks.core.messages.I18nMessage;

public class exam {
	
	public static void main(String[] args) {
		String str = I18nMessage.me().getString(MsgConsts.OPER_SAVE_FAILED.getMsg());
		String[] names = new String[]{"账户"};
		System.out.println(MessageFormat.format(str, (Object[])names));
	}
	
}
