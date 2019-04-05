package org.homecontrolweb.rest.controller;

public class RestControllerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RestControllerException(String errorMessage){
		super(errorMessage);
	}	
}
