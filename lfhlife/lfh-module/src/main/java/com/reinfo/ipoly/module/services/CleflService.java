package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.CleflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.CleflMapper;
import com.reinfo.ipoly.module.models.Clefl;

@Service("cleflService")
public class CleflService extends BaseServiceImpl<Clefl, Object, CleflMapper>{
}
