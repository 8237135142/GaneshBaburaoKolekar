package com.train.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getConstraintViolations().forEach(cv -> {
			errors.put("message", cv.getMessage());
			errors.put("path", (cv.getPropertyPath()).toString());
		});

		return errors;
	}
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourseNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserExist.class)
	public ResponseEntity<?> userExist(UserExist us, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), us.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(TicketAlreadyExist.class)
	public ResponseEntity<?> TickedAlreadyExist(TicketAlreadyExist ts, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ts.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
