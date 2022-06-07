package com.shopping_consumer.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.shopping_consumer.model.response.RepuestaCreacion;

@ControllerAdvice
@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

		@Override
		protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			Throwable mostSpecificCause = ex.getMostSpecificCause();
			try {
				if (mostSpecificCause instanceof JsonParseException) {
					RepuestaCreacion repuesta = new RepuestaCreacion();
					repuesta.setTitle("Error  json");
					repuesta.setDescripcion("JSON INVALIDO REVISAR");
					
					return new ResponseEntity<Object>(repuesta, HttpStatus.CONFLICT);

				} else {
					RepuestaCreacion repuesta = new RepuestaCreacion();
					repuesta.setTitle("Error en json");
					repuesta.setDescripcion("Error json formato erroneo REVISAR");
					
					return new ResponseEntity<Object>(repuesta, HttpStatus.CONFLICT);
				}
			} catch (Exception e) {
				RepuestaCreacion repuesta = new RepuestaCreacion();
				repuesta.setTitle("Error en servicio");
				repuesta.setDescripcion("Servicio fuera de linea o error");
				
				return new ResponseEntity<Object>(repuesta, HttpStatus.BAD_REQUEST);
			}
		}

		
		
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) ->{
				
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		}




		
}
