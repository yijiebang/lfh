package com.reinfo.ipoly.module.services;

import org.springframework.stereotype.Service;

import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdPremRateMapper;
import com.reinfo.ipoly.module.models.ProdPremRate;
/**
 * 保單費率
 * @author jerry
 *
 */
@Service("prodPremRateService")
public class ProdPremRateService extends BaseServiceImpl<ProdPremRate, Object, ProdPremRateMapper>{
}
