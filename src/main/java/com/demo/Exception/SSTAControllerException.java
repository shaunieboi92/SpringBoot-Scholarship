package com.demo.Exception;

import org.springframework.stereotype.Component;

@Component
public class SSTAControllerException extends Exception{
	private static final long serialVersionUID = 1L;
 
    private String errCode;
    private String errMsg;
    public Exception e;

	public SSTAControllerException() {
    }
 
    public SSTAControllerException(String errCode, String errMsg, Exception e) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.e = e;
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
