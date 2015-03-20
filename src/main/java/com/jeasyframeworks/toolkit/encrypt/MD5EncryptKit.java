package com.jeasyframeworks.toolkit.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MD5EncryptKit {
	//16进制字符串
	private static final String HEX_NUMS_STR = "0123456789ABCDEF";
	//盐值长度
	private static final int SALT_LENGTH = 8;
	//字符编码
	private static final String CHAR_ENCODING= "UTF-8";
	//加密类型
	private static final String ALGORITHM = "MD5";
	
	/**
	 * 比较明文和密文是否相等。
	 * @param srcStr 明文
	 * @param dstStr 密文
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static boolean isEqual(String srcStr, String dstStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		byte[] dstHexStr = hexStringToByte(dstStr);
		byte[] salt = new byte[SALT_LENGTH];
		System.arraycopy(dstHexStr, 0, salt, 0, SALT_LENGTH);
		MessageDigest md = MessageDigest.getInstance(ALGORITHM);
		md.update(salt);
		md.update(srcStr.getBytes(CHAR_ENCODING));
		byte[] digest = md.digest();
		byte[] dstByte = new byte[dstHexStr.length - SALT_LENGTH];
		System.arraycopy(dstHexStr, SALT_LENGTH, dstByte, 0, dstByte.length);
		if(Arrays.equals(digest, dstByte)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 加密指定的字符串
	 * @param encryptStr
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String encrypt(String encryptStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		byte[] encryptByte = null;
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[SALT_LENGTH];
		secureRandom.nextBytes(salt);
		
		MessageDigest md = MessageDigest.getInstance(ALGORITHM);
		md.update(salt);
		md.update(encryptStr.getBytes(CHAR_ENCODING));
		
		byte[] digest = md.digest();
		
		encryptByte = new byte[digest.length + SALT_LENGTH];
		
		System.arraycopy(salt, 0, encryptByte, 0, SALT_LENGTH);
		System.arraycopy(digest, 0, encryptByte, SALT_LENGTH, digest.length);
		
		return byteToHexString(encryptByte);
	}
	
	/**
	 * 将指定byte字节数组转换为16进制字符串
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte[] b){
		StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String hex = (java.lang.Integer.toHexString(b[i] & 0XFF));
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}
	
	/**
	 * 将指定16进制字符串转换为byte字节数组
	 * @param b
	 * @return
	 */
	private static byte[] hexStringToByte(String hex){
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] hexChars = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i]	=(byte)(HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			String md5Str = MD5EncryptKit.encrypt("123456");
			System.out.println("123456:" + md5Str);
//			String md5Str = "785DE56EFC100787C0EED48602296297CF104A95BEDF4";
			boolean flag = MD5EncryptKit.isEqual("123456", md5Str);
			System.out.println("Equal:" + flag);
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}