package com.reinfo.ipoly.module.controllers;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinfo.ipoly.common.config.SessionManager;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.common.util.MD5;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.models.LoginProfile;
import com.reinfo.ipoly.module.services.LoginProfileService;

@Controller
@RequestMapping(value = "login")
public class LoginController extends BaseWebController {

	@Autowired
	LoginProfileService loginService;

	@ResponseBody
	@RequestMapping(value = "login.json")
	public Map<String, Object> login(@RequestBody LoginProfile login, HttpSession session) {

		int code = 1000;
		String message = "";

		login.setLoginId(login.getLoginId().toUpperCase());
		login.setLoginPwd(MD5.toMD5(login.getLoginPwd()));
		LoginProfile user = loginService.login(login);

		if (user != null) {
			message = "login success";
		} else {
			message = "login error";
			code = SystemCode.USER_OR_PASSWORD_INCORRECT.getCode();
		}

		SessionManager.setUser(session, user);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("body", "");
		map.put("responseCode", code);
		return map;
	}

	
	@ResponseBody
	@RequestMapping(value = "updatepwd.json")
    public Map<String, Object> updatePasw(@RequestBody LoginProfile login, HttpSession session){
		
		int code = 1280;
		login.setLoginPwd(MD5.toMD5(login.getLoginPwd()));
		String message = "";
		if( StringUtils.isBlank(login.getLoginPwd()) ||  StringUtils.isBlank(login.getLoginNewPswd())){
            message = "password can not be blank";
        }
		
		try {
			LoginProfile sessionLogin = SessionManager.getUser(session) ;
			if(sessionLogin != null){
				login.setLoginId(sessionLogin.getLoginId().toUpperCase());
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		LoginProfile user = loginService.login(login);
		if(user == null){
			 message = "Login ID or password is incorrect";
	    }else{
	    	 LoginProfile profile = new LoginProfile();
	    	 profile.setLoginPwd(MD5.toMD5(login.getLoginNewPswd()));
	    	 int cnt = loginService.updateBy(profile, Criteria.newCriteria().addWhere("upper(login_id)",login.getLoginId().toUpperCase()));
	    	 if(cnt > 0){
	    		 message = "Update password successfully.";
	    		 code = 1000;
	    	 }else{
	    		 message = "Update password failed." ;
	    	 }
	    }
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("message", message);  

		return this.success(message,"",code);
	}
	
	@ResponseBody
	@RequestMapping(value = "authority.json")
	public Map<String, Object> authority(HttpSession session) {
		LoginProfile login = null;
		int code = 7777;
		try {
			login = SessionManager.getUser(session);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		Map<String, Object> body = new HashMap<String, Object>();
		if (login != null) {
			code = 1000;
			body.put("loginId", login.getLoginId());
			body.put("loginUsername", login.getLoginUsername());
		}
		return this.success("", body, code);
	}
	
	@ResponseBody
    @RequestMapping(value = "getdefaultdate.json")
    private Map<String, Object> getDefaultDate() {
		String date= new SimpleDateFormat("MM/dd/YYYY").format(Calendar.getInstance().getTime());   
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("date", date);
		return success(body);
	}
	
}
