package com.jeasyframeworks.system.authc.credential;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.authc.credential.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeasyframeworks.toolkit.encrypt.MD5EncryptKit;

public class MD5PasswordService implements PasswordService {
	
	private static final Logger log = LoggerFactory.getLogger(MD5PasswordService.class);
	
	@Override
	public String encryptPassword(Object tokenPassword) throws IllegalArgumentException {
		String encrypted = null;
		try {
			encrypted = MD5EncryptKit.encrypt((String)tokenPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrypted;
	}

	@Override
	public boolean passwordsMatch(Object submitPlaintext, String saveEncrypted) {
		return equal((String)submitPlaintext, saveEncrypted);
	}
	
	private boolean equal(String plaintext, String saveEncrypted){
		boolean isEqual = false;
		try {
			isEqual = MD5EncryptKit.isEqual(plaintext, saveEncrypted);
		} catch (NoSuchAlgorithmException e) {
			String msg = "MD5PasswordService Encrypt Not Found Such Algorithm:";
			log.error(msg, e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			String msg = "MD5PasswordService Encrypt Unsupport Encoding:";
			log.error(msg, e);
		} 
		return isEqual;
	}
}
