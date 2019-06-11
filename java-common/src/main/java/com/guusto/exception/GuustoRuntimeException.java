package com.guusto.exception;

public class GuustoRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuustoRuntimeException(String message) {
		super(message);
	}
	
	public GuustoRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
