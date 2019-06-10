package com.demo.Exception;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Resource not found.";

//	public ResourceNotFoundException(String message) {
//		super(message);
//	}
	
	/**
	 * Display in Postman
	 * @param resourceId
	 */
	public ResourceNotFoundException(Object resourceId) {
		super(!ObjectUtils.isEmpty(resourceId)? "ID " + resourceId.toString() + ", field is not found" : null);
		
	}
	
}
