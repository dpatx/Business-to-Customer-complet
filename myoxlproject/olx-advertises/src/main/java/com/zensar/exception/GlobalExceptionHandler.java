package com.zensar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(value = {InvalidTokenException.class})
	public ResponseEntity<Object> handleInvalidTokenException(Exception ex, WebRequest request) throws Exception {
		System.out.println("GlobalExceptionHandler.handleInvalidTokenException() is called");
		String clientMessage = ex.toString();
		String jsonMessage = "{\"error\": \"" + clientMessage + "\"}";
		return new ResponseEntity<Object>(jsonMessage, HttpStatus.BAD_REQUEST);
	}	
}
