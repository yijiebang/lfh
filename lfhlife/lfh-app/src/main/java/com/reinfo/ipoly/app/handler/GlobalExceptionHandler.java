package com.reinfo.ipoly.app.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reinfo.ipoly.common.config.ConstantContext;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;

/**
 * 统一异常处理 主要处理ApplicationException,IllegalArgumentException类型处理，其它异常统一为系统异常
 * 
 * @author 李则意
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(HttpServletRequest req, Exception e) {
        LOG.error(e.getMessage(), com.reinfo.ipoly.common.exception.ExceptionHandler.getCause(e));
        Map<String, Object> result = new HashMap<>();
        if (e instanceof ApplicationException) {
            result.put(ConstantContext.RESPONSE_CODE, ((ApplicationException) e).getErrorCode());
            if (e.getMessage() != null && e.getMessage().length() > 0) {
                String[] message = e.getMessage().split("\\[");
                result.put(ConstantContext.MESSAGE, message[0]);
            }
        } else if (e instanceof IllegalArgumentException) {
            result.put(ConstantContext.RESPONSE_CODE, SystemCode.REQUEST_PARAMETER_FAILURE);
            if (e.getMessage() != null && e.getMessage().length() > 0) {
                String[] message = e.getMessage().split("\\[");
                result.put(ConstantContext.MESSAGE, message[0]);
            }
        } else {
            result.put(ConstantContext.RESPONSE_CODE, SystemCode.SYSTEM_EXCEPTION);
            result.put(ConstantContext.MESSAGE, e.getMessage());
        }
        return result;
    }
}
