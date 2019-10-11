package com.reinfo.ipoly.module.services;

import java.util.List;

import javax.annotation.Resource;
import com.reinfo.ipoly.module.services.CliflService;
import org.springframework.stereotype.Service;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.CliflMapper;
import com.reinfo.ipoly.module.models.Clifl;

@Service("cliflService")
public class CliflService extends BaseServiceImpl<Clifl, Object, CliflMapper> {

    public long getListCount(Clifl clifl) {
        return this.getDao().getListCount(clifl);
    }

    public List<Clifl> getList(Clifl clifl) {
        return this.getDao().getList(clifl);
    }
    
    public List<Clifl> getReportList(Clifl clifl) {
        return this.getDao().getReportList(clifl);
    }
}
