package org.homecontrolweb.error;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private HttpStatus httpStatus;
	private String message;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getHttpCode() {
		return this.httpStatus.value();
	}
}
