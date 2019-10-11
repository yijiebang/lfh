package com.reinfo.ipoly.module.services;

import com.reinfo.ipoly.module.services.ProdPremLimtService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdPremLimtMapper;
import com.reinfo.ipoly.module.models.ProdPremLimt;

@Service("prodPremLimtService")
public class ProdPremLimtService extends BaseServiceImpl<ProdPremLimt, Object, ProdPremLimtMapper>{
	
	public ProdPremLimt getOne(ProdPremLimt prodPremLimt) {
		return this.getDao().getOne(prodPremLimt);
	}
}
