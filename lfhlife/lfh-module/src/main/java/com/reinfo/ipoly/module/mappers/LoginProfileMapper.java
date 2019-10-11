package com.reinfo.ipoly.module.mappers;
import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.LoginProfile;

@Repository("loginProfileDao")
public class LoginProfileMapper extends BaseMapperImpl<LoginProfile, String> {
	
	public LoginProfile login(LoginProfile login) {
		 return this.getSqlSession().selectOne(getMapperFullName("login"), login);
	}
}
