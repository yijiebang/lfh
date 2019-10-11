package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.Clifl;
import com.reinfo.ipoly.module.models.ProdCovLine;

@Repository("prodCovLineDao")
public class ProdCovLineMapper extends BaseMapperImpl<ProdCovLine, Object> {
	  public List<ProdCovLine> getList(ProdCovLine prodline) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), prodline);
	  }
}
