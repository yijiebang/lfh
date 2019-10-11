package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ClgflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ClgflMapper;
import com.reinfo.ipoly.module.models.Clgfl;

@Service("clgflService")
public class ClgflService extends BaseServiceImpl<Clgfl, Object, ClgflMapper>{
}
