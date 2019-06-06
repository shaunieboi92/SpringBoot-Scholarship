package com.demo.Exception;

import org.springframework.util.ObjectUtils;

public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public String message;

//	public ResourceNotFoundException(String message) {
//		super();
//		this.message = message;
//	}
	
	public ResourceNotFoundException(Object resourceId) {
		super(!ObjectUtils.isEmpty(resourceId)? resourceId.toString() : null);
	}
	
}
