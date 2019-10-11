package com.reinfo.ipoly.module.controllers;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reinfo.ipoly.common.config.SessionManager;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.common.util.MD5;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.models.Stafl;
import com.reinfo.ipoly.module.services.StaflService;
import com.reinfo.ipoly.module.services.YusrgrpsecuService;

@RestController
@RequestMapping(value = "user")
public class UserController extends BaseWebController {
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    protected StaflService staflService;

    @Autowired
    protected YusrgrpsecuService yusrgrpsecuService;


    /**
     * login
     * 
     * @param stafl
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "login.json")
    public Map<String, Object> login(@RequestBody Stafl stafl, HttpSession session) throws ApplicationException {
        Assert.notNull(stafl, "The request parameter cannot be empty");
        Assert.hasLength(stafl.getStaUser(), "User name cannot be empty");
        Assert.hasLength(stafl.getStaPassd(), "Password cannot be empty");
        Stafl dbStafl = staflService.getOneBy(Stafl.DBStrStaUser, stafl.getStaUser());
        if (dbStafl == null) {
            throw new ApplicationException(SystemCode.USER_NAME_INCORRECT.getCode(), "Incorrect user name[StaUser={}]", stafl.getStaUser());
        }
        if (!dbStafl.getStaPassd().equals(MD5.toMD5(stafl.getStaPassd()))) {
            throw new ApplicationException(SystemCode.PASSWORD_INCORRECT.getCode(), "Incorrect password[StaUser={},StaPassd={}]", stafl.getStaUser(),
                    stafl.getStaPassd());
        }
        dbStafl.setStaLastlogon(new Date());
        staflService.updateBy(dbStafl, Criteria.newCriteria().addWhere(Stafl.DBStrStaCode, dbStafl.getStaCode()));
        SessionManager.setUser(session, dbStafl);
        LOG.info("User[{}] login success.", stafl.getStaUser());
        return success();
    }


    /**
     * loginOut
     * 
     * @param userInfo
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "loginOut.json")
    public Map<String, Object> loginOut(HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.loginout(session);
        if (stafl != null) {
            Stafl dbStafl = new Stafl();
            dbStafl.setStaLastlogout(new Date());
            staflService.updateBy(dbStafl, Criteria.newCriteria().addWhere(Stafl.DBStrStaCode, stafl.getStaCode()));
        }
        LOG.info("User[{}] loginOut.", stafl.getStaUser());
        return success();
    }

    /**
     * User Authority info.
     * 
     * @param session
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getAuthorityInfo.json")
    public Map<String, Object> getAuthorityInfo(HttpSession session) throws ApplicationException {
        Stafl stafl = SessionManager.getUser(session);
        return success(yusrgrpsecuService.getAuthorityInfo(stafl.getStaUser()));
    }


}
