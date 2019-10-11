package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.TchflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.TchflMapper;
import com.reinfo.ipoly.module.models.Tchfl;

@Service("tchflService")
public class TchflService extends BaseServiceImpl<Tchfl, Object, TchflMapper>{
}
