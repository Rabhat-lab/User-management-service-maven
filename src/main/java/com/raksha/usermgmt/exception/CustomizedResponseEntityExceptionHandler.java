package com.raksha.usermgmt.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler 
				extends ResponseEntityExceptionHandler {
	
	//to handle all the exceptions
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		//when exception happens we want a exception response created by us back
		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(),
						request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//to handle user not found exceptions
		@ExceptionHandler(UserNotFoundException.class)
		public final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
			//when exception happens we want a exception response created by us back
			
			ExceptionResponse exceptionResponse = 
					new ExceptionResponse(new Date(), ex.getMessage(),
							request.getDescription(false));
			
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
		}
		
	//for validations specific message for the client
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed for names",
					ex.getBindingResult().toString());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		}

}
