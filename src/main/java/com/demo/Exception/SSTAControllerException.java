package com.demo.Exception;

import org.springframework.stereotype.Component;


public class SSTAControllerException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private final String logClass;
//	private final String logMethod;
    private String errCode;
    private String errMsg;
    public Exception e;
 
    public SSTAControllerException(String errCode, String errMsg, String className, Exception e) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.e = e;    
        this.logClass = className;
    }
 
    public String getErrCode() {
        return errCode;
    }
 
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
 
    public String getErrMsg() {
        return errMsg;
    }
 
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
