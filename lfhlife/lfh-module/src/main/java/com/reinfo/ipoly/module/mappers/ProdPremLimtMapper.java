package com.reinfo.ipoly.module.mappers;
import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdPremLimt;

@Repository("prodPremLimtDao")
public class ProdPremLimtMapper extends BaseMapperImpl<ProdPremLimt, Object> {
	
	public ProdPremLimt getOne(ProdPremLimt prodPremLimt) {
        return this.getSqlSession().selectOne(getMapperFullName("getOne"), prodPremLimt);
    }
}
