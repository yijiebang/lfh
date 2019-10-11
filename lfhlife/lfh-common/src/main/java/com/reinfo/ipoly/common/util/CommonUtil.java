package com.reinfo.ipoly.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.springframework.stereotype.Service;

@Service
public class CommonUtil {
	protected String[][] codeAndCity;
	private static String[] cityCode = { "11", "12", "13", "14", "15", "21",
			"22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42",
			"43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
			"63", "64", "65", "71", "81", "82", "91" };
	private int[] power;
	private String[] verifyCode;

	public CommonUtil() {
		this.codeAndCity = new String[][] { { "11", "北京" }, { "12", "天津" },
				{ "13", "河北" }, { "14", "山西" }, { "15", "内蒙古" },
				{ "21", "辽宁" }, { "22", "吉林" }, { "23", "黑龙江" },
				{ "31", "上海" }, { "32", "江苏" }, { "33", "浙江" }, { "34", "安徽" },
				{ "35", "福建" }, { "36", "江西" }, { "37", "山东" }, { "41", "河南" },
				{ "42", "湖北" }, { "43", "湖南" }, { "44", "广东" }, { "45", "广西" },
				{ "46", "海南" }, { "50", "重庆" }, { "51", "四川" }, { "52", "贵州" },
				{ "53", "云南" }, { "54", "西藏" }, { "61", "陕西" }, { "62", "甘肃" },
				{ "63", "青海" }, { "64", "宁夏" }, { "65", "新疆" }, { "71", "台湾" },
				{ "81", "香港" }, { "82", "澳门" }, { "91", "国外" } };
		this.power = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8,
				4, 2 };
		this.verifyCode = new String[] { "1", "0", "X", "9", "8", "7", "6",
				"5", "4", "3", "2" };
	}

	public static boolean isValidate18Idcard(String idcard) {
		return true;
	}

	public static boolean isValidate18IdcardDate(String idcard) {
		if (idcard.length() != 18) {
			return false;
		}

		if (!(isDigital(idcard.substring(0, 17)))) {
			return false;
		}

		String provinceid = idcard.substring(0, 2);
		boolean flag = false;
		for (String id : cityCode) {
			if (id.equals(provinceid)) {
				flag = true;
				break;
			}
		}
		if (!(flag)) {
			return false;
		}

		String birthday = idcard.substring(6, 14);
		int year = Integer.parseInt(idcard.substring(6, 10));
		int month = Integer.parseInt(idcard.substring(10, 12));
		int day = Integer.parseInt(idcard.substring(12, 14));

		Date birthdate = null;
		try {
			birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if ((birthdate == null) || (new Date().before(birthdate))) {
			return false;
		}

		GregorianCalendar curDay = new GregorianCalendar();

		if ((month < 1) || (month > 12)) {
			return false;
		}

		boolean mflag = false;
		curDay.setTime(birthdate);
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			mflag = (day >= 1) && (day <= 31);
			break;
		case 2:
			if (curDay.isLeapYear(curDay.get(1)))
				mflag = (day >= 1) && (day <= 29);
			else {
				mflag = (day >= 1) && (day <= 28);
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			mflag = (day >= 1) && (day <= 30);
		}

		return (mflag);
	}

	public boolean isIdcard(String idcard) {
		return (((idcard == null) || ("".equals(idcard))) ? false : Pattern
				.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard));
	}

	public boolean is15Idcard(String idcard) {
		return (((idcard == null) || ("".equals(idcard))) ? false
				: Pattern
						.matches(
								"^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$",
								idcard));
	}

	public boolean is18Idcard(String idcard) {
		return Pattern
				.matches(
						"^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$",
						idcard);
	}

	public static boolean isDigital(String str) {
		return (((str == null) || ("".equals(str))) ? false : str
				.matches("^[0-9]*$"));
	}

	public int getPowerSum(int[] bit) {
		int sum = 0;

		if (this.power.length != bit.length) {
			return sum;
		}

		for (int i = 0; i < bit.length; ++i) {
			for (int j = 0; j < this.power.length; ++j) {
				if (i == j) {
					sum += bit[i] * this.power[j];
				}
			}
		}
		return sum;
	}

	public String getCheckCodeBySum(int sum17) {
		String checkCode = null;
		switch (sum17 % 11) {
		case 10:
			checkCode = "2";
			break;
		case 9:
			checkCode = "3";
			break;
		case 8:
			checkCode = "4";
			break;
		case 7:
			checkCode = "5";
			break;
		case 6:
			checkCode = "6";
			break;
		case 5:
			checkCode = "7";
			break;
		case 4:
			checkCode = "8";
			break;
		case 3:
			checkCode = "9";
			break;
		case 2:
			checkCode = "x";
			break;
		case 1:
			checkCode = "0";
			break;
		case 0:
			checkCode = "1";
		}

		return checkCode;
	}

	public int[] converCharToInt(char[] c) throws NumberFormatException {
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[(k++)] = Integer.parseInt(String.valueOf(temp));
		}
		return a;
	}

	public static boolean isBlankRow(HSSFRow row) {
		if (row == null)
			return true;
		boolean result = true;
		for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); ++i) {
			HSSFCell cell = row.getCell(i, HSSFRow.RETURN_BLANK_AS_NULL);
			String value = "";
			if (cell != null) {
				switch (cell.getCellType()) {
				case 1:
					value = cell.getStringCellValue();
					break;
				case 0:
					value = String.valueOf((int) cell.getNumericCellValue());
					break;
				case 4:
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				case 2:
					value = String.valueOf(cell.getCellFormula());
				case 3:
				}

				if (!(value.trim().equals(""))) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^(1+\\d{10})$");
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	public static boolean isNewMobile(String phone) {
		String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
		if (phone.trim().length() != 11) {
			return false;
		} else {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone.trim());
			boolean isMatch = m.matches();
			return isMatch;
		}
	}

	public static String transMapToString(Map map) {
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			sb.append(entry.getKey().toString())
					.append(":")
					.append((entry.getValue() == null) ? "" : entry.getValue()
							.toString())
					.append((iterator.hasNext()) ? "#" : "");
		}
		return sb.toString();
	}

	public static final <T> T jsonReSerializer(String jsonStr, Class<T> calzz)
			throws Exception {
		ObjectMapper mapperNoType = new ObjectMapper();

		ObjectReader reader = mapperNoType.reader(calzz);
		Object result = reader.readValue(jsonStr);
		return (T) result;
	}

	/**
	 * 根据身份编号获取年龄
	 * 
	 * @param idCard
	 *            身份编号
	 * @return 年龄
	 */
	public static int getAgeByIdCard(String idCard) {
		int iAge = 0;
		Calendar cal = Calendar.getInstance();
		String year = idCard.substring(6, 10);
		int iCurrYear = cal.get(Calendar.YEAR);
		iAge = iCurrYear - Integer.valueOf(year);
		return iAge;
	}

	public static void main(String[] args) throws Exception {
		String idcard15 = "142431199001145";
		String idcard18 = "350524201302304050";
		String idcard22 = "441522201508271039";

		String phone = "14025140882";
		CommonUtil iv = new CommonUtil();

		// System.out.println(isNewMobile(phone));
		System.out.println(iv.getAgeByIdCard(idcard22));
	}
}