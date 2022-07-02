package com.zensar.ide.exceptions;

public class CouponAlreadyExistsException extends RuntimeException{
	
	private String message;

	public CouponAlreadyExistsException() {
		super();
		
	}

	public CouponAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
	
}
