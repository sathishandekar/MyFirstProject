package com.rest.webservices.webservices1.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.webservices1.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAlExceptions(Exception ex, WebRequest request) throws Exception
	{
		ErrorDetials errorD = new ErrorDetials(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorD,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception
	{
		ErrorDetials errorD = new ErrorDetials(LocalDateTime.now(),
				ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(errorD,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetials errorD = new ErrorDetials(LocalDateTime.now(),
				"Total error count "+ex.getErrorCount()+" "+ ex.getFieldError().getDefaultMessage()
				,request.getDescription(false));
		return new ResponseEntity(errorD,HttpStatus.BAD_REQUEST);
	}

}
