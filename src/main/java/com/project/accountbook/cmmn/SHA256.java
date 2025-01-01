package com.project.accountbook.cmmn;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class SHA256 {
	public String getSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = new byte[20];
		secureRandom.nextBytes(salt);
		StringBuffer stringBuffer = new StringBuffer();
		
		for(byte b : salt) {
			stringBuffer.append(String.format("%02x", b));
		}
		
		return stringBuffer.toString();
	}
	
	public String getEncrypt(String plainText, String salt) {
		String encodeText = null;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update((plainText + salt).getBytes());
			byte[] plainTextSalt = messageDigest.digest();
			StringBuffer stringBuffer = new StringBuffer();
			
			for(byte b : plainTextSalt) {
				stringBuffer.append(String.format("%02x", b));
			}
			
			encodeText = stringBuffer.toString();
			
			return encodeText;
		} catch(NoSuchAlgorithmException e) {
			return null;
		}
	}
}
