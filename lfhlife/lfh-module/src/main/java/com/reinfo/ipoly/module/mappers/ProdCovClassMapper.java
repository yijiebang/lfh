package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdCovClass;

@Repository("prodCovClassDao")
public class ProdCovClassMapper extends BaseMapperImpl<ProdCovClass, Object> {
 
	 public List<ProdCovClass> getList(ProdCovClass covCode ) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), covCode);
	  }
}
