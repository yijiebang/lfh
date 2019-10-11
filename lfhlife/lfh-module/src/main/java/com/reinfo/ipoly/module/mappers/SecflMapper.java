package com.reinfo.ipoly.module.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.Secfl;

@Repository("secflDao")
public class SecflMapper extends BaseMapperImpl<Secfl, Object> {

    public List<Secfl> getReportStatistics(Integer startYear, Integer endYear) {
        Map<String, Object> map = new HashMap<>();
        map.put("startYear", startYear);
        map.put("endYear", endYear);
        return this.getSqlSession().selectList(getMapperFullName("getReportStatistics"), map);
    }
}
