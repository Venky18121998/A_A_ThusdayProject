package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub

		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, status, LocalDateTime.now());

		return ResponseEntity.status(status).body(edd);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionDetails> handleUserNotFoundException(UserNotFoundExceptio ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(edd);

	}

	@ExceptionHandler
	public ResponseEntity<ExceptionDetails> handlePersonNotAvailableOnThisId(PersonNotAvailableOnThisId ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("please check once u r urls and inputs and method names and etc");
		ExceptionDetails edd = new ExceptionDetails(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(edd);
	}

}
