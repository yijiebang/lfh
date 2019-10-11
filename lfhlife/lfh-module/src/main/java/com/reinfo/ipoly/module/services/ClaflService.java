package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.ClaflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.ClaflMapper;
import com.reinfo.ipoly.module.models.Clafl;

@Service("claflService")
public class ClaflService extends BaseServiceImpl<Clafl, Object, ClaflMapper>{
}
