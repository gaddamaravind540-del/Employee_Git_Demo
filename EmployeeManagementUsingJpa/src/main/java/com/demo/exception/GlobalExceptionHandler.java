package com.demo.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponser> employeeNotFoundException(EmployeeNotFoundException ex) {
		ExceptionResponser exception = new ExceptionResponser(ex.getMessage(), LocalDate.now(), 404);
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> validationException(MethodArgumentNotValidException ex) {
		StringBuilder errors = new StringBuilder();
		ex.getBindingResult().getFieldErrors().forEach(
				error -> errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; "));
		return new ResponseEntity<>("Validation error(s): " + errors.toString(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ExceptionResponser> validationException(Exception ex) {
		return null;
	}
}
