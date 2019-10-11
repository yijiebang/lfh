package com.reinfo.ipoly.module.report.utils;

import com.reinfo.ipoly.module.models.Rider;
import com.reinfo.ipoly.module.models.RiderWlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Jerry Yi
 * 2019年10月10日
 * 抽取出公共的方法，减少代码冗余
 */
public class FunctionUtil {
    private static DecimalFormat iFormat = new DecimalFormat("#,##0");

    //MED M001-M006 PDF-保障摘要

    /**
     * 提供對外方法
     * @param code
     * @param ccy
     * @param type
     * @return
     */
    public static  String getValue(String code,String ccy,String type){
        if ("m001".equals(code) || "m004".equals(code)){//基本
            switch (ccy){
                case "MOP":
                case "HKD":
                    return iFormat.format(Integer.parseInt(get001_004MopHKD(type)));
                case "USD":
                    return iFormat.format(Integer.parseInt(get001_004USD(type)));
            }
        }
        if ("m002".equals(code)  || "m005".equals(code)){//优越
            switch (ccy){
                case "MOP":
                case "HKD":
                    return iFormat.format(Integer.parseInt(get002_005MopHKD(type)));
                case "USD":
                    return iFormat.format(Integer.parseInt(get002_005USD(type)));
            }
        }
        if ("m003".equals(code) || "m006".equals(code)){//至尊
            switch (ccy){
                case "MOP":
                case "HKD":
                    return iFormat.format(Integer.parseInt(get003_006MopHKD(type)));
                case "USD":
                    return iFormat.format(Integer.parseInt(get003_006USD(type)));
            }
        }
        return "";
    }

    //私有化，基本
    private static  String get001_004MopHKD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "600";
            case "hs03SA":
                return "7200";
            case "hs04SA":
            case "hs08SA":
                return "2000";
            case "hs05SA1":
                return "36000";
            case "hs05SA2":
                return "28800";
            case "hs05SA3":
                return "14400";
            case "hs05SA4":
                return "5400";
            case "hs06SA":
            case "hs07SA":
                return "40";
            case "hs09SA":
                return "200";
            case "m10SA":
            case "m11SA":
                return "10000";
            case "m12SA":            //M001-M003没有这个m12SA,单独用于M004
                return "60000";
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }

        return "0";
    }
    //私有化，基本
    private static String get001_004USD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "75";
            case "hs03SA":
                return "900";
            case "hs04SA":
            case "hs08SA":
                return "250";
            case "hs05SA1":
                return "4500";
            case "hs05SA2":
                return "3600";
            case "hs05SA3":
                return "1800";
            case "hs05SA4":
                return "675";
            case "hs06SA":
            case "hs07SA":
                return "40";
            case "hs09SA":
                return "25";
            case "m10SA":
            case "m11SA":
                return "1250"; //M001-M003没有这个m12SA,单独用于M004
            case "m12SA":
                return "7500";
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }
        return "0";
    }
    //私有化，优越
    private static String get002_005MopHKD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "1200";
            case "hs03SA":
                return "12000";
            case "hs04SA":
                return "3600";
            case "hs05SA1":
                return "56000";
            case "hs05SA2":
                return "44800";
            case "hs05SA3":
                return "22400";
            case "hs05SA4":
                return "8400";
            case "hs06SA":
            case "hs07SA":
                return "40";
            case "hs08SA":
                return "4000";
            case "hs09SA":
                return "320";
            case "m10SA":
            case "m11SA":
                return "10000";
            case "m12SA":
                return "110000";//M001-M003没有这个m12SA,单独用于M005
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }

        return "0";
    }
    //私有化，优越
    private static String get002_005USD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "150";
            case "hs03SA":
                return "1500";
            case "hs04SA":
                return "450";
            case "hs05SA1":
                return "7000";
            case "hs05SA2":
                return "5600";
            case "hs05SA3":
                return "2800";
            case "hs05SA4":
                return "1050";
            case "hs06SA":
            case "hs07SA":
            case "hs09SA":
                return "40";
            case "hs08SA":
                return "500";
            case "m10SA":
            case "m11SA":
                return "1250";
            case "m12SA":
                return "13750";//M001-M003没有这个m12SA,单独用于M005
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }
        return "0";
    }
    //私有化，至尊
    private static String get003_006MopHKD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "2400";
            case "hs03SA":
                return "19200";
            case "hs04SA":
                return "5000";
            case "hs05SA1":
                return "80000";
            case "hs05SA2":
                return "64000";
            case "hs05SA3":
                return "32000";
            case "hs05SA4":
                return "12000";
            case "hs06SA":
            case "hs07SA":
                return "40";
            case "hs08SA":
                return "6000";
            case "hs09SA":
                return "520";
            case "m10SA":
            case "m11SA":
                return "10000";
            case "m12SA":
                return "220000";//M001-M003没有这个m12SA,单独用于M006
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }

        return "0";
    }
    //私有化，至尊
    private static String get003_006USD(String type) {
        switch (type) {
            case "hs01SA":
            case "hs02SA":
                return "300";
            case "hs03SA":
                return "2400";
            case "hs04SA":
                return "625";
            case "hs05SA1":
                return "10000";
            case "hs05SA2":
                return "8000";
            case "hs05SA3":
                return "4000";
            case "hs05SA4":
                return "1500";
            case "hs06SA":
            case "hs07SA":
                return "40";
            case "hs08SA":
                return "750";
            case "hs09SA":
                return "65";
            case "m10SA":
            case "m11SA":
                return "1250";
            case "m12SA":
                return "27500";//M001-M003没有这个m12SA,单独用于M006
            case "hs01D":
            case "hs02D":
                return "90";
            case "hs04D":
                return "15";
            case "hs09D":
                return "30";
            default:
                break;
        }
        return "0";
    }


    /**
     * 根據code
     * @param code 得到 m001-m006 pdf中的mPlan
     * @return
     */
    public static String getMplanName(String code) {

        switch(code){
            case "m001":
            case "m004":

                return "基本";
            case "m002":
            case "m005":

                return "優越";
            default:
                return "至尊";
        }
    }
    //得到Hi的class注釋
    public static String getHiClassName(String classType) {

        switch(classType){
            case "1":

                return "基本";
            case "2":

                return "優越";
            default:
                return "至尊";
        }
    }



    /***
     * 根據payMode代碼，得到中文注釋
     * @param paymode
     * @return
     */
    public static String getPaymode(String paymode){
        switch(paymode){
            case "A" :
                //语句
                return  "年缴";
            case "S" :
                //语句
                return "半年繳";
            case "Q" :
                //语句
                return "季繳";
            case "M" :
                //语句
                return "月繳";
            default : //可选
        }
        return "";
    }

    /***
     * 根據ccy貨幣，得到中文注釋
     * @param ccy
     * @return
     */
    public static String getCcyNameOth(String ccy) {
        String ccy_name = "";
        if ("MOP".equals(ccy)) {
            ccy_name = "澳門元";
        } else if ("USD".equals(ccy)) {
            ccy_name = "美元";
        } else if ("HKD".equals(ccy)) {
            ccy_name = "港元";
        } else {
            ccy_name = "人民幣";
        }
        return ccy_name;
    }

    //小数参数，格式化
    public static String formatDECIMAL(BigDecimal money){
        //格式化字符串金額
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        return   decimalFormat.format(money) ; //会返回格式化后的金额
    }
    //整数参数，格式化
    public   static String formatDECIMAL(int money){
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
    /**
     * 沒有附加的，默認返回一個空的對象，這樣在PDF中不會顯示如：«ridLab1».
     * @return
     */
    public static LinkedList<Rider> buildPpsRiderNoData() {
        // TODO Auto-generated method stub
        LinkedList<Rider> riders = new LinkedList<>();

        RiderWlp rider = new RiderWlp();
        rider.setRidLab1("附加保障");
        rider.setRidLab2("附加保障");
        rider.setRiderPlan("");
        rider.setRidAPm("");
        rider.setRidMPm("");
        rider.setPayMode("");
        rider.setRidPTm(0);
        rider.setRidLvlp("");
        rider.setRidGrtRt("");
        rider.setRiderSA("");//投保额
        rider.setRiderSAcover("");
        rider.setRidAPm("");
        riders.add(rider);
        return riders;
    }
}
