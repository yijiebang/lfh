package com.reinfo.ipoly.module.services;

import java.util.List;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ProdCountryModService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCountryModMapper;
import com.reinfo.ipoly.module.models.ProdCountryCcy;
import com.reinfo.ipoly.module.models.ProdCountryMod;

@Service("prodCountryModService")
public class ProdCountryModService extends BaseServiceImpl<ProdCountryMod, Object, ProdCountryModMapper>{
	
	 public List<ProdCountryMod> getList(ProdCountryMod mode) {
	        return this.getDao().getList(mode);
	 }
}
