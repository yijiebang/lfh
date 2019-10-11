package com.reinfo.ipoly.module.services;

import com.reinfo.ipoly.module.services.StaflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.StaflMapper;
import com.reinfo.ipoly.module.models.Stafl;

@Service("staflService")
public class StaflService extends BaseServiceImpl<Stafl, Object, StaflMapper>{
}
