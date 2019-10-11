package com.reinfo.ipoly.module.mappers;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.IlfQuot;
import com.reinfo.ipoly.module.models.IlfQuotPlan;
import com.reinfo.ipoly.module.models.QuotPlanDetail;

@Repository("ilfQuotPlanDao")
public class IlfQuotPlanMapper extends BaseMapperImpl<IlfQuotPlan, Object> {
	
	 public List<IlfQuotPlan> getList(IlfQuotPlan plan) {
	        return this.getSqlSession().selectList(getMapperFullName("getList"), plan);
	  }
	 
	 public List<QuotPlanDetail> getQuotPlanDetailList(IlfQuotPlan plan) {
	        return this.getSqlSession().selectList(getMapperFullName("getQuotPlanDetailList"), plan);
	  }
}
