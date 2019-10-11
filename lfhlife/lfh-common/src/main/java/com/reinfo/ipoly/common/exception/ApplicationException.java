package com.reinfo.ipoly.common.exception;

import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.util.GenericParser;

/**
 * A checked exception, system can handle this type of exception.
 */
public class ApplicationException extends Exception implements AssistException {
    private int errorCode;

    private Object[] metaData;

    public ApplicationException(int code, Object[] metaData) {
        this.metaData = metaData;
        this.errorCode = code;
    }

    public ApplicationException(int code, String message) {
        super(message);
        this.errorCode = code;
    }

    public ApplicationException(int code, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = code;
    }

    public ApplicationException(int code, String message, Object... args) {
        super(GenericParser.parse(message, args), getCause(args));
        this.errorCode = code;
    }

    public ApplicationException(Throwable cause) {
        super(cause);
        this.errorCode = SystemCode.SYSTEM_EXCEPTION.getCode();
    }

    public ApplicationException(int code, Object[] metaData, Throwable cause) {
        super(cause);
        this.errorCode = code;
        this.metaData = metaData;
    }

    private static Throwable getCause(Object... args) {
        Throwable cause = null;
        for (Object obj : args) {
            if (obj instanceof Throwable) {
                cause = (Throwable) obj;
            }
        }
        return cause;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Object[] getMetaData() {
        return this.metaData;
    }
}
