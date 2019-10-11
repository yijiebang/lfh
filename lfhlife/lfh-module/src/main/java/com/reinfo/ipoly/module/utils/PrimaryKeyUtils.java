package com.reinfo.ipoly.module.utils;

public class PrimaryKeyUtils {

    public static String addOne1(String maxCode) {
        String[] strs = maxCode.split("[^0-9]");// 根据不是数字的字符拆分字符串
        String numStr = strs[strs.length - 1];// 取出最后一组数字
        if (numStr != null && numStr.length() > 0) {// 如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();// 取出字符串的长度
            int num = Integer.parseInt(numStr) + 1;// 将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            // 拼接字符串
            return maxCode.subSequence(0, maxCode.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    public static String addOne(String maxCode) {
        String[] strs = maxCode.split("[^0-9]");// 根据不是数字的字符拆分字符串
        String numStr = strs[strs.length - 1];// 取出最后一组数字
        if (numStr != null && numStr.length() > 0) {// 如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();// 取出字符串的长度
            int num = Integer.parseInt(numStr) + 1;// 将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            // 拼接字符串
            String en = maxCode.subSequence(0, maxCode.length() - n).toString();

            if (numStr.length() < added.length()) {
                if (!"".equals(en)) {
                    added = added.substring(1, added.length());
                    en = getNextUpEn(en);
                    if ("A".equals(en)) {
                        en += "0";
                    }
                }
            }

            return en + added;
        } else {
            throw new NumberFormatException();
        }
    }

    public static String getNextUpEn(String en) {
        char lastE = 'a';
        char st = en.toCharArray()[0];
        if (Character.isUpperCase(st)) {
            if (en.equals("Z")) {
                return "A";
            }
            if (en == null || en.equals("")) {
                return "A";
            }
            lastE = 'Z';
        } else {
            if (en.equals("z")) {
                return "a";
            }
            if (en == null || en.equals("")) {
                return "a";
            }
            lastE = 'z';
        }
        int lastEnglish = (int) lastE;
        char[] c = en.toCharArray();
        if (c.length > 1) {
            return null;
        } else {
            int now = (int) c[0];
            if (now >= lastEnglish)
                return null;
            char uppercase = (char) (now + 1);
            return String.valueOf(uppercase);
        }
    }

    public static void main(String[] args) {
        System.out.println(addOne("1"));
    }
}
