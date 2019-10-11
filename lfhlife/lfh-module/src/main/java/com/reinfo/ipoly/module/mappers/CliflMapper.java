package com.reinfo.ipoly.module.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.Clifl;

@Repository("cliflDao")
public class CliflMapper extends BaseMapperImpl<Clifl, Object> {

    public long getListCount(Clifl clifl) {
        return (Long) this.getSqlSession().selectOne(getMapperFullName("getListCount"), clifl);
    }

    public List<Clifl> getList(Clifl clifl) {
        return this.getSqlSession().selectList(getMapperFullName("getList"), clifl);
    }
    
    public List<Clifl> getReportList(Clifl clifl) {
        return this.getSqlSession().selectList(getMapperFullName("getReportList"), clifl);
    }
}
