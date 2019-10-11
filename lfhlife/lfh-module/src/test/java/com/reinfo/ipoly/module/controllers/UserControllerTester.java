package com.reinfo.ipoly.module.controllers;

import org.junit.Test;

import com.reinfo.ipoly.base.BaseControllerTest;

public class UserControllerTester extends BaseControllerTest {

    @Test
    public void test_Login() {
        String url = "user/login.json";
        String parameter = "{'staUser':'Z113','staPassd':'test1234'}";
        post(url, parameter);
    }

    @Test
    public void test_getAuthorityInfo() {
        String url = "user/getAuthorityInfo.json";
        get(url);
    }

    @Test
    public void test_loginOut() {
        String url = "user/loginOut.json";
        post(url, null);
    }
}
