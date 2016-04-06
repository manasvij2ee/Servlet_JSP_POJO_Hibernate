package com.home.exception;

public class UserAlreadyExistsException extends Exception {
	 
	String errorMessage = null;
		
    public UserAlreadyExistsException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	 

}
