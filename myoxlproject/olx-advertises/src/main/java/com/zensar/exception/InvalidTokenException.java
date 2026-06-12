package com.zensar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTokenException extends RuntimeException { //Unchecked exception

	private String message;
	
	public InvalidTokenException() {
		this.message = "";
	}
	public InvalidTokenException(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Invalid token " + this.message;
	}
}

