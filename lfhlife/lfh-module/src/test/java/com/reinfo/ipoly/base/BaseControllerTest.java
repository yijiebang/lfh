package com.reinfo.ipoly.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

import com.reinfo.ipoly.common.httprequest.HttpRequest;


public class BaseControllerTest {
    public Map<String, String> requestProperty = new HashMap<>();
 // public static final String hostName = "http://localhost:8899/ipoly/";
   public static final String hostName = "http://120.79.42.164:81/ipoly/";
    public static final String cookieKey = "cookieKey";

    @Before
    public void setUp() {
        requestProperty.put("Content-Type", "application/json");

        String url = "user/login.json";
        String parameter = "{'staUser':'Z113','staPassd':'test1234'}";
        post(url, parameter);
    }

    protected String get(String url) {
        String html =  HttpRequest.sendHttpRequestProxy(false, cookieKey, "GET", hostName + url, null, null, null, requestProperty);
        System.out.println("Response html : \n"+ html);
        return html;
    }

    protected String post(String url, String parameter) {
        String html =  HttpRequest.sendHttpRequestProxy(false, cookieKey, "POST", hostName + url, replaceChar(parameter), null, null, requestProperty);
        System.out.println("Response html : \n"+ html);
        return html;
    }

    public String replaceChar(String str) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        return str.replaceAll("'", "\"");
    }
}
