package org.homecontrolweb.rest.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.homecontrolweb.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({RestControllerException.class})
	public ResponseEntity<ErrorResponse> handle(RestControllerException e) {
		ErrorResponse response = new ErrorResponse();
		response.setHttpStatus(HttpStatus.PRECONDITION_FAILED);
		response.setMessage(ExceptionUtils.getRootCauseMessage(e));

		return new ResponseEntity<ErrorResponse>(response, HttpStatus.PRECONDITION_FAILED);
	}
}
