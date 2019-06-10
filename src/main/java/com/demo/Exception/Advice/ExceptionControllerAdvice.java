package com.demo.Exception.Advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import com.demo.Constants.SSTAErrorConstants;
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

	// gets enclosed Exception messages
	@ExceptionHandler(SSTAControllerException.class)
	public final ResponseEntity<SSTAServiceResponse> handleException(
			SSTAControllerException ex, WebRequest request) {
		ResponseEntity<SSTAServiceResponse> response = null;
		if (ex.getE() instanceof ResourceNotFoundException) {
			/*
			 * Handles ResourceNotFoundException
			 */
			SSTAServiceResponse exceptionResponse = new SSTAServiceResponse(
					new Date(), ex.getE().getMessage(),
					HttpStatus.NOT_FOUND.getReasonPhrase());
			response = new ResponseEntity<SSTAServiceResponse>(
					exceptionResponse, HttpStatus.NOT_FOUND);
		} else if (ex.getE() instanceof NumberFormatException) {
			/*
			 * Handles NumberFormatException
			 */
			SSTAServiceResponse exceptionResponse = new SSTAServiceResponse(
					new Date(), ex.getErrMsg(),
					HttpStatus.BAD_REQUEST.getReasonPhrase());
			response = new ResponseEntity<SSTAServiceResponse>(
					exceptionResponse, HttpStatus.BAD_REQUEST);
		} else {
			/*
			 * Handles All Other Errors
			 */
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			SSTAServiceResponse exceptionResponse = new SSTAServiceResponse(
					new Date(), SSTAErrorConstants.A1010.getErrorMessage(),
					status.getReasonPhrase());
			response = handleExceptionInternal(ex, exceptionResponse, status,
					request);
		}
		return response;
	}

	// GlobalExceptionHandler remaining
	/** A single place to customize the response body of all Exception types. */
	protected ResponseEntity<SSTAServiceResponse> handleExceptionInternal(
			Exception ex, SSTAServiceResponse responseBody, HttpStatus status,
			WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex,
					WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(responseBody, status);
	}

}
