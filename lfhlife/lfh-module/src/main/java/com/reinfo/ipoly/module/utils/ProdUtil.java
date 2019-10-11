package com.reinfo.ipoly.module.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 不同類型金額的格式化
 * 正則表達式
 */
public class ProdUtil {

    //小数参数，格式化
    public static String formatDECIMAL(BigDecimal money){

        //格式化字符串金額
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return   decimalFormat.format(money) ; //会返回格式化后的金额

    }
    //整数参数，格式化
    public static String formatDECIMAL(int money){
        //格式化字符串金額
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return   "0".equals(decimalFormat.format(money))?"":decimalFormat.format(money); //会返回格式化后的金额
    }
    //四舍五入，不要小数
    public static String FormatUptDECIMAL(BigDecimal money){
        BigDecimal mData = money.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String a=decimalFormat.format(mData) ;
        return  a;
    }
    // 判断一个字符串是否含有数字
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
