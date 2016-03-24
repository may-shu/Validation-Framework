package com.paras.framework.validation.base;

/**
 * Error Model for a validation failure.
 *
 * @Author Paras.
 */
public class Error {
    
    /**
     * Field name as declared in form.
     * 
     * For angular, is should be key of the corroponding ng-model value.
     */
    private String field;
    
    /**
     * Validation Criteria failed by value.
     */
    private ValidationCriteria criteria;
    
    /**
     * Message for the failed validation.
     */
    private String message;
    
    /**
     * Create a new Error.
     
     * @param field Form field name or ng-model key in case of angular.
     * @param criteria Validation Criteria failed.
     * @param message Message to be returned to client.
     */
    public Error( String field, ValidationCriteria criteria, String message ) {
        this.field = field;
        this.criteria = criteria;
        this.message = message;
    }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public ValidationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ValidationCriteria criteria) {
		this.criteria = criteria;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}    
}