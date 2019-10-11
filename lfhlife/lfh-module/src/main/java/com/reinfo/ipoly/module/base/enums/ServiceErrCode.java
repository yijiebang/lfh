package com.reinfo.ipoly.module.base.enums;

public enum ServiceErrCode {
	SUCCESS(10000,"請求成功"),
    REQ_PARAM_ERR(10001,"請求参数异常"),
	NOTFOUND_RESULT_ERR(10004,"未找到结果");
	
	
	private int code;
	private String message;
	

    ServiceErrCode(int code,String message){
        this.code = code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

	public String getMessage() {
		return message;
	}

 
    
}
