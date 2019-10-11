package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ClhflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ClhflMapper;
import com.reinfo.ipoly.module.models.Clhfl;

@Service("clhflService")
public class ClhflService extends BaseServiceImpl<Clhfl, Object, ClhflMapper>{
}
