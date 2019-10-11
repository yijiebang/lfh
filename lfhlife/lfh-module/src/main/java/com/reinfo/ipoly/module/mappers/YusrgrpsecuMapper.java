package com.reinfo.ipoly.module.mappers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.reinfo.ipoly.common.mappers.BaseMapperImpl;
import com.reinfo.ipoly.module.models.Clifl;
import com.reinfo.ipoly.module.models.Yusrgrpsecu;

@Repository("yusrgrpsecuDao")
public class YusrgrpsecuMapper extends BaseMapperImpl<Yusrgrpsecu, Object> {

    public Yusrgrpsecu getAuthorityInfo(String staUser) {
        return this.getSqlSession().selectOne(getMapperFullName("getAuthorityInfo"), staUser);
    }
}
