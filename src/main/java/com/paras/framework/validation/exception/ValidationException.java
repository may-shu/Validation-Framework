package com.paras.framework.validation.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.paras.framework.validation.base.Error;

/**
 * Exception to be used for passing errors occurred in any procedure.
 *
 * @author Paras.
 */
public class ValidationException extends Exception {
    

	private static final long serialVersionUID = -7714340804183651046L;
	
	/**
     * List of Errors that caused this exception.
     */
	private List<Error> errors;
    
    /**
     * Create a new Validation Exception.
     */
    public ValidationException() {
        super();
    }
    
    /**
     * Create a new Validation Exception. 
     *
     * @param message Cause of the exception.
     */
    public ValidationException( String message ) {
        super( message );
    }
    
    /**
     * Create a new Validation Exception.
     *
     * @param message Cause of the exception.
     * @param errors List of Validation Failures that caused this exception.
     */
    public ValidationException( String message, List<Error> errors ) {
        super( message );
    
        this.errors = errors;
    }
    
    /**
     * Create a new Validation Exception.
     * @param errors List of Validation Failures that caused this exception.
     */
    public ValidationException( List<Error> errors ) {
    	super();
    	
    	this.errors = errors;
    }
    
    /**
     * Get Validation Error Map.
     */
    public Map<String, String> getErrors() {
        if( null == errors || errors.isEmpty() ) {
            return null;
        } else {
            
            Map<String, String> errMap = new HashMap<String, String>();
            
            for( Error error : errors ) {
                errMap.put( error.getField(), error.getMessage());
            }
            
            return errMap;
            
        }
    }
    
    /**
     * Get Error List.
     */
    public List<Error> getErrorList() {
    	return errors;
    }
}
