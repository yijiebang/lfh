package com.reinfo.ipoly.module.services;

import java.util.List;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ProdCountryCcyService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCountryCcyMapper;
import com.reinfo.ipoly.module.models.ProdCountryCcy;
import com.reinfo.ipoly.module.models.ProdCovLine;

@Service("prodCountryCcyService")
public class ProdCountryCcyService extends BaseServiceImpl<ProdCountryCcy, Object, ProdCountryCcyMapper>{
	
	 public List<ProdCountryCcy> getList(ProdCountryCcy ccy) {
	        return this.getDao().getList(ccy);
	 }
}
