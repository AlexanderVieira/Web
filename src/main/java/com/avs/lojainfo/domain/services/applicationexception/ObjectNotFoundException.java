package com.avs.lojainfo.domain.services.applicationexception;

/**
 * @author Alexander
 */
public class ObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);		
	}

	public ObjectNotFoundException(String message) {
		super(message);		
	}	

}
