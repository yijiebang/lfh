package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ProdCovRidService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ProdCovRidMapper;
import com.reinfo.ipoly.module.models.ProdCovRid;

@Service("prodCovRidService")
public class ProdCovRidService extends BaseServiceImpl<ProdCovRid, Object, ProdCovRidMapper>{
}
