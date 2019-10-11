package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.IlfQuot;

@Repository("ilfQuotDao")
public class IlfQuotMapper extends BaseMapperImpl<IlfQuot, String> {
	
	 public List<IlfQuot> getList(IlfQuot quot) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), quot);
	  }
}
