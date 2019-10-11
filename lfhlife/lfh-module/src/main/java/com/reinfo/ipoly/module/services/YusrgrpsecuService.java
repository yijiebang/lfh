package com.reinfo.ipoly.module.services;

import org.springframework.stereotype.Service;

import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.services.BaseServiceImpl;
import com.reinfo.ipoly.module.base.enums.AuthorityEnum;
import com.reinfo.ipoly.module.mappers.YusrgrpsecuMapper;
import com.reinfo.ipoly.module.models.Yusrgrpsecu;

@Service("yusrgrpsecuService")
public class YusrgrpsecuService extends BaseServiceImpl<Yusrgrpsecu, Object, YusrgrpsecuMapper> {

    public Yusrgrpsecu getAuthorityInfo(String staUser) {
        return this.getDao().getAuthorityInfo(staUser);
    }

    /**
     * 判断是有权限操作
     * 
     * @param staUser
     * @param authorityType
     * @throws ApplicationException
     */
    public void authority(String staUser, int authorityType) throws ApplicationException {
        boolean allow = false;
        Yusrgrpsecu yusrgrpsecu = this.getAuthorityInfo(staUser);
        if (yusrgrpsecu != null && yusrgrpsecu.getUgsCli() != null) {
            allow = AuthorityEnum.exist(yusrgrpsecu.getUgsCli(), authorityType);
        }
        if (!allow) {
            throw new ApplicationException(SystemCode.PERMISSION_DENIED.getCode(), "permission denied[staUser={},authorityType={}]", staUser, authorityType);
        }
    }
}
