package com.demo.Constants;

public enum SSTAErrorConstants {
	
	A1001("A1001","PERSISTENCE_ERROR"),
	A1002("A1002","RESOURCE_NOT_FOUND"),
	A1003("A1003","FORMAT_ERROR");

	private String errorCode;
    private String errorMessage;
    
    SSTAErrorConstants(String errorCode,String errorMessage) {
    	this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}
