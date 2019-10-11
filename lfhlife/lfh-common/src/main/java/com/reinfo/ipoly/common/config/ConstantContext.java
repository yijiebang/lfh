package com.reinfo.ipoly.common.config;

public final class ConstantContext {
    /**
     * 日期格式
     */
    public final static String DATE_FORMAT = "yyyyMMddHHmmss";
    public final static String DAY_DATE_FORMAT = "yyyy-MM-dd";
    public final static String MS_DATE_FORMAT = "yyyyMMddHHmmssSS";
    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String POINT_TIME_FORMAT = "yyyy.MM.dd HH:mm:ss";

    /**
     * 文件路径
     */
    public static final String RESOURCE_CLASSPATH = "classpath";

    public static final String RESPONSE_CODE = "responseCode";
    public static final String MESSAGE = "message";
    public static final String RESPONSE_BODY = "body";
    public static final String NO_LOGIN_MESSAGE = "Not logged in or logged out";

    public static final String RESPONSE_DATA_PAGE = "page";
    public static final String RESPONSE_DATA_LIST = "data";
    
    /**
     * AuthorityType
     */
    public static final int AUTHORITY_TYPE_VIEW = 10;
    public static final int AUTHORITY_TYPE_ADD = 20;
    public static final int AUTHORITY_TYPE_MODIFY = 30;
    public static final int AUTHORITY_TYPE_PRINT = 40;



}
