package com.reinfo.ipoly.common.redis;

/**
 * Redis分组定义
 */
public enum CacheGroup {
    OPERATOR_SESSION("msid", 30 * 60),
    SAVEPONT("spoint", 10 * 60),;

    private String groupName;
    private int timeOut;

    CacheGroup(String groupName, int timeOut) {
        this.groupName = groupName;
        this.timeOut = timeOut;
    }

    public String getGroupName() {
        return groupName;
    }


    public int getTimeOut() {
        return timeOut;
    }
}
