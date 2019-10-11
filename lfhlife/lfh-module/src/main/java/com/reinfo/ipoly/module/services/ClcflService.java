package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ClcflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ClcflMapper;
import com.reinfo.ipoly.module.models.Clcfl;

@Service("clcflService")
public class ClcflService extends BaseServiceImpl<Clcfl, Object, ClcflMapper>{
}
