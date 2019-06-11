package com.guusto.exception;

public class GuustoException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuustoException(String message) {
		super(message);
	}
	
	public GuustoException(String message, Throwable cause) {
		super(message, cause);
	}

}
