package com.reinfo.ipoly.common.exception;

public interface AssistException {

    /**
     * Get error code of a exception,.
     */
    int getErrorCode();

    /**
     * Get the meta data which will be used to assemble response message.
     */
    Object[] getMetaData();
}
