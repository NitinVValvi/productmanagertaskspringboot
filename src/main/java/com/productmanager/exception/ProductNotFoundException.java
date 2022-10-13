package com.productmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.OK)
public class ProductNotFoundException extends RuntimeException{


	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
