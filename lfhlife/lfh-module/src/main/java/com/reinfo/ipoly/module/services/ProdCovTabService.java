package com.reinfo.ipoly.module.services;

import java.util.List;

import com.reinfo.ipoly.module.services.ProdCovTabService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCovTabMapper;
import com.reinfo.ipoly.module.models.ProdCovTab;

@Service("prodCovTabService")
public class ProdCovTabService extends BaseServiceImpl<ProdCovTab, Object, ProdCovTabMapper>{
	
	public List<ProdCovTab> getList(ProdCovTab tab) {
        return this.getDao().getList(tab);
    }
    public List<ProdCovTab> getTabList(ProdCovTab tab) {
        return this.getDao().getTabList(tab);
    }
}
