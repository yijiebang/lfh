package com.reinfo.ipoly.module.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.mappers.K3uflMapper;
import com.reinfo.ipoly.module.models.Clafl;
import com.reinfo.ipoly.module.models.K3ufl;
import com.reinfo.ipoly.module.models.Stafl;
import com.reinfo.ipoly.module.utils.PrimaryKeyUtils;

@Service("k3uflService")
public class K3uflService extends BaseServiceImpl<K3ufl, Object, K3uflMapper> {

    public void batch(List<K3ufl> list, Stafl stafl) {
        List<K3ufl> addList = new ArrayList<>();
        List<K3ufl> updateList = new ArrayList<>();
//        String k3uSeq = getDao().getMaxBy(Criteria.newCriteria().addWhere(K3ufl.DBStrK3uCliCode, list.get(0).getK3uCliCode()).setMaxField(K3ufl.DBStrK3uSeq));
//        if (StringUtils.isBlank(k3uSeq)) {
//            k3uSeq = "1";
//        }
//        Long seq = Long.valueOf(k3uSeq);
        for (K3ufl k3ufl : list) {
            k3ufl.setK3uAdate(new Date());
            k3ufl.setK3uAuser(stafl.getStaUser());
            if (k3ufl.getK3uSeq() == null) {
                //k3ufl.setK3uSeq(++seq);
                k3ufl.setK3uLock(0l);
                k3ufl.setK3uCuser(stafl.getStaUser());
                k3ufl.setK3uCdate(new Date());
                addList.add(k3ufl);
            } else {
                updateList.add(k3ufl);
            }
        }

        if (!addList.isEmpty()) {
            this.getDao().insert(addList);
        }
        if (!updateList.isEmpty()) {
            for (K3ufl k3ufl : updateList) {
                this.getDao().updateBy(k3ufl,
                        Criteria.newCriteria().addWhere(K3ufl.DBStrK3uCliCode, k3ufl.getK3uCliCode()).addWhere(K3ufl.DBStrK3uSeq, k3ufl.getK3uSeq()));
            }
        }
    }
}
