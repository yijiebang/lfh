package com.reinfo.ipoly.module.services;

import org.springframework.stereotype.Service;

import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdPolFeeMapper;
import com.reinfo.ipoly.module.models.ProdPolFee;
/**
 * 保單費用
 * @author jerry
 *
 */
@Service("prodPolFeeService")
public class ProdPolFeeService extends BaseServiceImpl<ProdPolFee, Object, ProdPolFeeMapper>{
}
