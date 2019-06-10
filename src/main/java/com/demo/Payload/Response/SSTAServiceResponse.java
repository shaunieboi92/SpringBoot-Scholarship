package com.demo.Payload.Response;

import java.util.Date;

public class SSTAServiceResponse {
	private Date timeStamp;
	private String message;
	private String httpCodeMessage;
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}


	
	public SSTAServiceResponse(Date timeStamp, String message, String httpCodeMessage) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.httpCodeMessage = httpCodeMessage;
	}
	
}
