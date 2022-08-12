package com.policyapp.exception;

public class PolicyNotFoundException extends Exception {

	private static final long serialVersionUID=1L;
	public PolicyNotFoundException() {
		super();
	}

	public PolicyNotFoundException(String message) {
		super(message);
	}

}
