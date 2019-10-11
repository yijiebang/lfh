package com.reinfo.ipoly.module.services;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.YpromptService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.YpromptMapper;
import com.reinfo.ipoly.module.models.Yprompt;

@Service("ypromptService")
public class YpromptService extends BaseServiceImpl<Yprompt, Object, YpromptMapper>{
}
