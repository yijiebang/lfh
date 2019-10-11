package com.reinfo.ipoly.module.utils;

import com.aspose.words.License;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.FileUtils;

public class LicenseManager {
	private final int offset = 5;
	private final byte[] salt = {76, 70, 72, 95, 80, 105, 114, 111, 112, 111, 115, 110, 97, 108, 95, 83, 121, 65, 115,
			116, 101, 109};

	private static LicenseManager instance = null;

	public static LicenseManager getInstance() {
		if (instance == null) {
			instance = new LicenseManager();
		}
		return instance;
	}

	private String extractSalt(byte[] salt) {
		byte[] bytes = new byte[salt.length];
		int index = 0;
		int count = 0;
		for (byte saltByte : salt) {
			if (count == 5)
				count = -1;
			else {
				bytes[(index++)] = saltByte;
			}
			++count;
		}
		return new String(bytes);
	}

	private char[] extractPassword(String secretPath) throws IOException {
		StringBuilder sb = new StringBuilder();
		String salt = FileUtils.readFileToString(new File(secretPath));
		String[] values = salt.split(",");
		for (String value : values) {
			int num = Integer.parseInt(value);
			sb.append((char) num);
		}
		return sb.toString().toCharArray();
	}

	private SecretKey prepareSecret(String secretPath) throws Exception {
		char[] password = extractPassword(secretPath);
		String saltText = extractSalt(this.salt);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		KeySpec spec = new PBEKeySpec(password, saltText.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		return new SecretKeySpec(tmp.getEncoded(), "AES");
	}

	private InputStream decryptLicense(SecretKey secret, String licensePath, String ivPath) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(2, secret, new IvParameterSpec(FileUtils.readFileToByteArray(new File(ivPath))));
		byte[] ciphertext = FileUtils.readFileToByteArray(new File(licensePath));
		return new ByteArrayInputStream(new String(cipher.doFinal(ciphertext), "UTF-8").getBytes("UTF-8"));
	}

	public void setLicense(String secretPath, String encryptedLicensePath, String ivPath) throws Exception {
		new License().setLicense(decryptLicense(prepareSecret(secretPath), encryptedLicensePath, ivPath));
	}
}
