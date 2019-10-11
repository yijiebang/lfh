package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ProductRatesService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProductRatesMapper;
import com.reinfo.ipoly.module.models.ProductRates;

@Service("productRatesService")
public class ProductRatesService extends BaseServiceImpl<ProductRates, Object, ProductRatesMapper>{
}
