package com.reinfo.ipoly.module.services;

import com.reinfo.ipoly.module.services.ProdCovLimService;

import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCovLimMapper;
import com.reinfo.ipoly.module.models.ProdCovLim;

@Service("prodCovLimService")
public class ProdCovLimService extends BaseServiceImpl<ProdCovLim, Object, ProdCovLimMapper>{
	
	public ProdCovLim getOne(ProdCovLim prodCovLim) {
		return this.getDao().getOne(prodCovLim);
	}
}
