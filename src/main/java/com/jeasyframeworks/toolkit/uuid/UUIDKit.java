package com.jeasyframeworks.toolkit.uuid;

import java.util.UUID;

public class UUIDKit {
	public static String generate(){
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
	}
}
