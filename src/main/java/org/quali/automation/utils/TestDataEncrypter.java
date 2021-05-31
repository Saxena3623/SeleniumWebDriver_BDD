package org.quali.automation.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class TestDataEncrypter {

	static final String SECRET_KEY = "ABCDEFabcdef123456";

	public static String encrypt(String data) {
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(SECRET_KEY);
		System.out.print(encryptor.encrypt(data));
		return encryptor.encrypt(data);
	}

	public static String decrypt(String data) {
		try {
			BasicTextEncryptor encryptor = new BasicTextEncryptor();
			encryptor.setPassword(SECRET_KEY);
			return encryptor.decrypt(data);
		} catch (Exception e) {
			return data;
		}
	}

	public static void main(String args[]) throws Exception {
		if (args[0] == null) {
			throw new Exception("Invalid command line parameters");
		}
		switch (args[0]) {
		case "encrypt":
			System.out.println(TestDataEncrypter.encrypt(args[1]));
			break;
		case "decrypt":
			System.out.println(TestDataEncrypter.decrypt(args[1]));
			break;
		default:
			throw new Exception("Invalid command '" + args[0] + "'");
		}
	}
}
