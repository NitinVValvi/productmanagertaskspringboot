package com.productmanager.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExxceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ApiError> ProductNotFoundExceptionHandler(ProductNotFoundException e,HttpServletRequest req)
	{
		ApiError apierror = new ApiError(HttpStatus.NOT_FOUND.value(),new Date(),HttpStatus.NOT_FOUND,e.getMessage(),req.getRequestURI());
		return new ResponseEntity<>(apierror,HttpStatus.NOT_FOUND);
	}
	
	
}
