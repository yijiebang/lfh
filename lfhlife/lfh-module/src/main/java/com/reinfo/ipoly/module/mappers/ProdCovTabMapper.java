package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.ProdCountryMod;
import com.reinfo.ipoly.module.models.ProdCovTab;

@Repository("prodCovTabDao")
public class ProdCovTabMapper extends BaseMapperImpl<ProdCovTab, Object> {
	
	public List<ProdCovTab> getList(ProdCovTab covTab) {
        return this.getSqlSession().selectList(getMapperFullName("getList"), covTab);
  }

     //关联rid查询tab
    public List<ProdCovTab> getTabList(ProdCovTab covTab) {
        return this.getSqlSession().selectList(getMapperFullName("getTabList"), covTab);
    }
}
