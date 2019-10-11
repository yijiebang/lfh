package com.reinfo.ipoly.module.services;

import com.reinfo.ipoly.module.services.LoginProfileService;

import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.LoginProfileMapper;
import com.reinfo.ipoly.module.models.LoginProfile;

@Service("loginProfileService")
public class LoginProfileService extends BaseServiceImpl<LoginProfile, String, LoginProfileMapper> {

	public LoginProfile login(LoginProfile login) {
		return this.getDao().login(login);
	}
}
