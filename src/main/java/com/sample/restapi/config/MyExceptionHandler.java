package com.sample.restapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.restapi.utils.AccessDeniedException;
import com.sample.restapi.utils.ValidationException;

@Component
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value=AccessDeniedException.class)
	public ResponseEntity<?> handleHttpcodeExceptions(AccessDeniedException ex, WebRequest request){

		return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value=ValidationException.class)
	public ResponseEntity hanldeValidationException(ValidationException e, WebRequest req) {
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
