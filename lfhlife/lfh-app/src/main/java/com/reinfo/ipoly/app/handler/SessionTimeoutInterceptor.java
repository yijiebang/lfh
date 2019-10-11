package com.reinfo.ipoly.app.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.reinfo.ipoly.common.config.SessionManager;

public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

    private static List<String> allowUrls = new ArrayList<>();

    static {
        allowUrls.add("user/login.json");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 如果是所配置的URL，就不需要检验是否登录
         */
        String requestUrl = request.getRequestURI();

        if (count(requestUrl, "/") > 3 || !requestUrl.trim().endsWith(".json")) {
            return true;
        }

        for (String url : allowUrls) {
            if (requestUrl.contains(url)) {
                return true;
            }
        }

        /**
         * 剩下所有URL都要检验是否登录
         */
        SessionManager.getUser(request.getSession());

        return super.preHandle(request, response, handler);
    }

    private static int count(String str, String value) {
        int count = 0;
        int index = -1;
        do {
            index = str.indexOf(value, index + 1);
            if (-1 != index) {
                count++;
            }
        } while (index != -1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("fbi_common/aa/getList.json", "/"));
    }


}
