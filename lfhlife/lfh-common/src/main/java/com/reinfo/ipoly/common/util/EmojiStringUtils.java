package com.reinfo.ipoly.common.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

public class EmojiStringUtils {

	public static boolean hasEmoji(String content) {

		Pattern pattern = Pattern.compile("[\ue000-\uefff]");
		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 含有特殊字符的nickname信息过滤掉
	 * 
	 * @param nickName
	 * @return
	 */
	public static String replaceEmoji(String str) {
		str = str.replaceAll("[\ue000-\uefff]", " ");
		return str;
	}

	/**
	 * 编码nickname
	 * 
	 * @param nickName
	 * @return
	 */
	public static String encodeEmojiStr(String nickName) {
		String tempStrNickName = null;
		try {
			tempStrNickName = Base64.encodeBase64String(nickName
					.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return tempStrNickName;
	}

	/**
	 * 解码nickname
	 * 
	 * @param nickName
	 * @return
	 */
	public static String decodeEmojiStr(String nickName) {
		String tempStrNickName = null;
		try {
			tempStrNickName = new String(Base64.decodeBase64(nickName), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return tempStrNickName;
	}

}
