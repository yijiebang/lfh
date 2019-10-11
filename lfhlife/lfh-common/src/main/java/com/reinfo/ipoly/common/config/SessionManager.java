package com.reinfo.ipoly.common.config;

import javax.servlet.http.HttpSession;

import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.redis.CacheGroup;
import com.reinfo.ipoly.common.redis.RedisCached;

public class SessionManager {

    public final static String CACHE_LOGIN_USER_KEY = "ipoly.loginUser.";

    /**
     * get login user.
     * 
     * @param session
     * @return
     * @throws ApplicationException
     */
    public static <T> T getUser(HttpSession session) throws ApplicationException {
        RedisCached redisCached = IpolyConfig.getInstance().getBean("redisCached", RedisCached.class);
        if (redisCached.isInitSucess()) {
            Object obj = redisCached.get(CACHE_LOGIN_USER_KEY + session.getId(), CacheGroup.OPERATOR_SESSION);
            if (obj == null) {
                throw new ApplicationException(SystemCode.LOGIN_TIME_OUT.getCode(), "login timeout");
            }
            redisCached.expire(CACHE_LOGIN_USER_KEY + session.getId(), CacheGroup.OPERATOR_SESSION);
            return (T) obj;
        } else {
            return (T) session.getAttribute(CACHE_LOGIN_USER_KEY);
        }
    }

    public static void setUser(HttpSession session, Object user) {
        RedisCached redisCached = IpolyConfig.getInstance().getBean("redisCached", RedisCached.class);
        if (redisCached.isInitSucess()) {
            redisCached.set(CACHE_LOGIN_USER_KEY + session.getId(), user, CacheGroup.OPERATOR_SESSION);
        } else {
            session.setAttribute(CACHE_LOGIN_USER_KEY, user);
        }
    }

    /**
     * loginout
     * 
     * @param session
     */
    public static <T> T loginout(HttpSession session) {
        RedisCached redisCached = IpolyConfig.getInstance().getBean("redisCached", RedisCached.class);
        if (redisCached.isInitSucess()) {
            Object obj = redisCached.get(CACHE_LOGIN_USER_KEY + session.getId(), CacheGroup.OPERATOR_SESSION);
            redisCached.del(CACHE_LOGIN_USER_KEY + session.getId());
            return (T) obj;
        } else {
            Object obj = session.getAttribute(CACHE_LOGIN_USER_KEY);
            session.removeAttribute(CACHE_LOGIN_USER_KEY);
            return (T) obj;
        }
    }

}
