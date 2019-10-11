package com.reinfo.ipoly.module.services;

import java.util.List;

import com.reinfo.ipoly.module.services.IlfQuotPlanService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.IlfQuotPlanMapper;
import com.reinfo.ipoly.module.models.IlfQuotPlan;
import com.reinfo.ipoly.module.models.QuotPlanDetail;

@Service("ilfQuotPlanService")
public class IlfQuotPlanService extends BaseServiceImpl<IlfQuotPlan, Object, IlfQuotPlanMapper>{
	
	 public List<IlfQuotPlan> getList(IlfQuotPlan plan) {
	        return this.getDao().getList(plan);
	 }
	 
	 public List<QuotPlanDetail> getQuotPlanDetailList(IlfQuotPlan plan) {
	        return this.getDao().getQuotPlanDetailList(plan);
	 }
	 
}
