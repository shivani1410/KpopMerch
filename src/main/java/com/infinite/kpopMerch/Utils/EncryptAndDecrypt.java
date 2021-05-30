package com.infinite.kpopMerch.Utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.infinite.kpopMerch.Constants.CommonConstants;

public class EncryptAndDecrypt implements PasswordEncoder {

	public static String decrypt(String encrypt) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String key = CommonConstants.KEY;
		String initVector = CommonConstants.IV;
		IvParameterSpec iv = new IvParameterSpec(Base64.decodeBase64(initVector));
		SecretKeySpec secret = new SecretKeySpec(Base64.decodeBase64(key), CommonConstants.ALGORITHM);
		Cipher cipher = Cipher.getInstance(CommonConstants.TYPE);
		cipher.init(Cipher.DECRYPT_MODE, secret, iv);
		byte[] original = cipher.doFinal(Base64.decodeBase64(encrypt.getBytes(StandardCharsets.UTF_8)));

		return new String(original);
	}

	@Override
	public String encode(CharSequence rawPassword) {
		String key = CommonConstants.KEY;
		String initVector = CommonConstants.IV;
		String encrypted = "";
		IvParameterSpec iv = new IvParameterSpec(Base64.decodeBase64(initVector));
		try {
			SecretKeySpec secret = new SecretKeySpec(Base64.decodeBase64(key), CommonConstants.ALGORITHM);
			Cipher cipher = Cipher.getInstance(CommonConstants.TYPE);
			cipher.init(Cipher.ENCRYPT_MODE, secret, iv);
			encrypted = Base64
					.encodeBase64String(cipher.doFinal((rawPassword.toString()).getBytes(StandardCharsets.UTF_8)));
			return encrypted;
		} catch (NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException
				| NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.equals(encodedPassword);

	}

	public static void main(String[] args) {
		EncryptAndDecrypt andDecrypt = new EncryptAndDecrypt();
		String ec = andDecrypt.encode("infinite");
		System.out.println(ec);
	}
}
