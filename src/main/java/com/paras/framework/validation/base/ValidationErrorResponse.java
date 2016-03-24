package com.paras.framework.validation.base;

import java.util.Map;

import com.paras.framework.validation.exception.ValidationException;
import com.paras.framework.web.base.Response;

/**
 * Response to be used in case of validation error.
 * 
 * @author Gaurav
 */
public class ValidationErrorResponse extends Response {
	
	/**
	 * Operation status, N, has failed.
	 */
	private static final String N = "N";
	
	/**
	 * Message to the user.
	 */
	private static String ERROR_MESSAGE = "Please remove errors.";
	
	/**
	 * List of errors that caused validation failure.
	 */
	private Map<String, String> errors;
	
	/**
	 * Set new error message.
	 * @param message New Error Message
	 */
	public static void setErrorMessage( String message ) {
		ValidationErrorResponse.ERROR_MESSAGE = message;
	}

	/**
	 * Create new ValidationErrorResponse.
	 */
	public ValidationErrorResponse(){
		super( N, ERROR_MESSAGE, null );
	}
	
	/**
	 * Create new ValidationErrorResponse.
	 * @param errors List of errors/
	 */
	public ValidationErrorResponse( Map<String, String> errors ) {
		super( N, ERROR_MESSAGE, null );
		this.errors = errors;
	}
	
	/**
	 * Create new ValidationErrorResponse from ValidationException.
	 * @param ex ValidationException.
	 */
	public ValidationErrorResponse( ValidationException ex ) {
		super( N, ERROR_MESSAGE, null );
		this.errors = ex.getErrors();
	}
	
	public void setErrors( Map<String, String> errors ) {
		this.errors = errors;
	}
	
	public Map<String, String> getErrors() {
		return this.errors;
	}
}
