package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdCountryCcy;
import com.reinfo.ipoly.module.models.ProdCovLine;

@Repository("prodCountryCcyDao")
public class ProdCountryCcyMapper extends BaseMapperImpl<ProdCountryCcy, Object> {
	
	 public List<ProdCountryCcy> getList(ProdCountryCcy countryCcy) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), countryCcy);
	  }
}
