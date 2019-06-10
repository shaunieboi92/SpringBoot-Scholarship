package com.demo.Exception.Advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.Exception.ResourceNotFoundException;
import com.demo.Exception.SSTAControllerException;
import com.demo.Payload.Response.SSTAServiceResponse;

/**
 * 
 * @author shaun.lee Customized error Response
 */
@ControllerAdvice
@RestController
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	
	//gets enclosed Exception messages
	@ExceptionHandler(SSTAControllerException.class)
	public final ResponseEntity<SSTAServiceResponse> handleException(
			SSTAControllerException ex) {
		ResponseEntity<SSTAServiceResponse> response = null;
		if(ex.getE() instanceof ResourceNotFoundException) {
			/*
			 * Handles ResourceNotFoundException
			 */
			SSTAServiceResponse exceptionResponse = new SSTAServiceResponse(
					new Date(), ex.getE().getMessage(),
					HttpStatus.NOT_FOUND.getReasonPhrase());
			response = new ResponseEntity<SSTAServiceResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
		}else if(ex.getE() instanceof NumberFormatException){
			/*
			 * Handles NumberFormatException
			 */
			SSTAServiceResponse exceptionResponse = new SSTAServiceResponse(
					new Date(), ex.getErrMsg(),
					HttpStatus.BAD_REQUEST.getReasonPhrase());
			response = new ResponseEntity<SSTAServiceResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
