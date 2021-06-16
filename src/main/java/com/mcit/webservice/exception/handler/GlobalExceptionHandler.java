package com.mcit.webservice.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mcit.webservice.exception.ExceptionResponse;
import com.mcit.webservice.exception.InvalidDataException;
import com.mcit.webservice.exception.ResouceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	// Resource Not Found Exception
	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resouceNotFound(ResouceNotFoundException ex) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setStatus("NOT_FOUND");		
		response.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	//Invalid Data Exception
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ExceptionResponse> invalidData(InvalidDataException ex) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setStatus("BAD_REQUEST");		
		response.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}

}
