package com.reinfo.ipoly.common.config;

public enum SystemCode {

	SUCCESS(1000, "success"), 
	REQUEST_PARAMETER_FAILURE(1210, "parameter error"),
	LOGIN_TIME_OUT(1250, "timeout or not logged in"), 
	NO_DATA(1260,"query no data"),
	USER_NAME_INCORRECT(1270,"Incorrect user name"),
	PASSWORD_INCORRECT(1280,"Incorrect password"),
	PERMISSION_DENIED(1290,"permission denied"),
	USER_OR_PASSWORD_INCORRECT(1300,"user or password error"),
	
	CLICODE_ALREADY_EXISTS(2010,"clicode already exists"),
	FILE_SIZE_TOO_LARGE(2020,"File size too large"),
	
	AMOUNT_INSURED_MIN_NOTGT(1001, "Insured Premium can't less than"),
	AMOUNT_INSURED_MAX_NOTGT(1002, "Insured Premium can't greater than"),
	AMOUNT_INSURED_IS_EMPTY(1003, "Insured Premium can't is empty"),
	
	AMOUNT_PREMIUM_MIN_NOTGT(1064, "Amount Premium can't less than"),
	AMOUNT_PREMIUM_MAX_NOTGT(1065, "Amount Premium can't greater than"),
	
	SYSTEM_EXCEPTION(5000, "unknown exception");

	private int code;

	private String message;

	private SystemCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
