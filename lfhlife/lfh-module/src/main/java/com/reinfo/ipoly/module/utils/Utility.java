package com.reinfo.ipoly.module.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	public static boolean HasDigit(String content) {
		boolean flag = false;
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(content);
		if (m.matches()) {
			flag = true;
		}
		return flag;
	}
}
