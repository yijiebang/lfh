package com.reinfo.ipoly.module.services;

import com.reinfo.ipoly.module.services.IlfQuotService;

import java.util.List;

import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.IlfQuotMapper;
import com.reinfo.ipoly.module.models.IlfQuot;


@Service("ilfQuotService")
public class IlfQuotService extends BaseServiceImpl<IlfQuot, String, IlfQuotMapper>{
	
	 public List<IlfQuot> getList(IlfQuot plan) {
	        return this.getDao().getList(plan);
	 }

}
