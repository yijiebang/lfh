package com.reinfo.ipoly.module.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.SecflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.SecflMapper;
import com.reinfo.ipoly.module.models.Secfl;

@Service("secflService")
public class SecflService extends BaseServiceImpl<Secfl, Object, SecflMapper>{
    
    public List<Secfl> getReportStatistics(Integer startYear, Integer endYear) {
        return this.getDao().getReportStatistics(startYear, endYear);
    }
}
