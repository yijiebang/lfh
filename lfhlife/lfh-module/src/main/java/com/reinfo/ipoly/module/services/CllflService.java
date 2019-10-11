package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.CllflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.CllflMapper;
import com.reinfo.ipoly.module.models.Cllfl;

@Service("cllflService")
public class CllflService extends BaseServiceImpl<Cllfl, Object, CllflMapper>{
}
