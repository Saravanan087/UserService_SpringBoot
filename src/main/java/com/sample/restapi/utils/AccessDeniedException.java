package com.sample.restapi.utils;

public class AccessDeniedException extends RuntimeException {
	
	public AccessDeniedException(String message) {
		super(message);
	}

}
