package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.YremarkService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.YremarkMapper;
import com.reinfo.ipoly.module.models.Yremark;

@Service("yremarkService")
public class YremarkService extends BaseServiceImpl<Yremark, Object, YremarkMapper>{
}
