package com.reinfo.ipoly.module.base.enums;

import com.reinfo.ipoly.common.config.ConstantContext;
import com.reinfo.ipoly.common.exception.ApplicationException;

public enum AuthorityEnum {


    /**
     * can view, add, modify and print/download client list (pdf)
     */
    FULL_ACCESS(99l, new Integer[] {ConstantContext.AUTHORITY_TYPE_VIEW, ConstantContext.AUTHORITY_TYPE_ADD, ConstantContext.AUTHORITY_TYPE_MODIFY,
            ConstantContext.AUTHORITY_TYPE_PRINT}),

    /**
     * can view only
     */
    VIEW(10l, new Integer[] {ConstantContext.AUTHORITY_TYPE_VIEW}),

    /**
     * can view and print only
     */
    VIEW_PRINT(30l, new Integer[] {ConstantContext.AUTHORITY_TYPE_VIEW, ConstantContext.AUTHORITY_TYPE_PRINT}),

    /**
     * can view modify and print only
     */
    VIEW_modify_PRINT(50l, new Integer[] {ConstantContext.AUTHORITY_TYPE_VIEW, ConstantContext.AUTHORITY_TYPE_MODIFY, ConstantContext.AUTHORITY_TYPE_PRINT}),

    /**
     * can view add, modify and print only
     */
    VIEW_add_PRINT(70l, new Integer[] {ConstantContext.AUTHORITY_TYPE_VIEW, ConstantContext.AUTHORITY_TYPE_ADD, ConstantContext.AUTHORITY_TYPE_MODIFY,
            ConstantContext.AUTHORITY_TYPE_PRINT});

    private long code;
    private Integer[] value;

    private AuthorityEnum(long code, Integer[] value) {
        this.code = code;
        this.value = value;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Integer[] getValue() {
        return value;
    }

    public void setValue(Integer[] value) {
        this.value = value;
    }


    public static boolean exist(long code, int authorityType){
        for (AuthorityEnum authorityEnum : AuthorityEnum.values()) {
            if (authorityEnum.getCode() == code) {
                Integer[] values = authorityEnum.getValue();
                for (int va : values) {
                    if (va == authorityType) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

}
