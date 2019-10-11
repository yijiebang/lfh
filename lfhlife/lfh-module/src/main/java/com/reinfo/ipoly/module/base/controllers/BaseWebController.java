package com.reinfo.ipoly.module.base.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import com.reinfo.ipoly.common.config.ConstantContext;
import com.reinfo.ipoly.common.config.SystemCode;
@Controller
public class BaseWebController {

    /**
     * 返回成功信息。
     * 
     * @param body
     * @return
     */
    protected Map<String, Object> success(Object body) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ConstantContext.RESPONSE_CODE, SystemCode.SUCCESS.getCode());
        map.put(ConstantContext.MESSAGE, "success");
        if (body != null) {
            map.put(ConstantContext.RESPONSE_BODY, body);
        }
        return map;
    }

    protected Map<String, Object> success() {
        return success(null);
    }
    
    
    public Map<String,Object> success(String message, Object body, int code){
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("body", body);
		map.put("responseCode", code);
		return map;
    }

}
