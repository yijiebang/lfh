package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.PolflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.PolflMapper;
import com.reinfo.ipoly.module.models.Polfl;

@Service("polflService")
public class PolflService extends BaseServiceImpl<Polfl, Object, PolflMapper>{
}
