package com.reinfo.ipoly.module.mappers;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdCovLim;

@Repository("prodCovLimDao")
public class ProdCovLimMapper extends BaseMapperImpl<ProdCovLim, Object> {
	
	public ProdCovLim getOne(ProdCovLim prodCovLim) {
        return this.getSqlSession().selectOne(getMapperFullName("getOne"), prodCovLim);
    }
}
