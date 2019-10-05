package com.cg.web;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exception.ProductNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidProduct(ProductNotFoundException prod){
		System.out.println("Exception: "+prod.getMessage());
		return new ResponseEntity<>(prod.getMessage(), HttpStatus.NOT_FOUND);
	}
}
