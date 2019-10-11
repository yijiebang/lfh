package com.reinfo.ipoly.module.services;

import java.util.List;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ProdCovLineService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCovLineMapper;
import com.reinfo.ipoly.module.models.Clifl;
import com.reinfo.ipoly.module.models.ProdCovLine;

@Service("prodCovLineService")
public class ProdCovLineService extends BaseServiceImpl<ProdCovLine, Object, ProdCovLineMapper>{
	
	 public List<ProdCovLine> getList(ProdCovLine prodline) {
	        return this.getDao().getList(prodline);
	 }
	
}
