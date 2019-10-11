package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdCountryCcy;
import com.reinfo.ipoly.module.models.ProdCountryMod;

@Repository("prodCountryModDao")
public class ProdCountryModMapper extends BaseMapperImpl<ProdCountryMod, Object> {
	
	 public List<ProdCountryMod> getList(ProdCountryMod countryMod) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), countryMod);
	  }
}
