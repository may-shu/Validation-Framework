package com.paras.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.paras.framework.validation.base.Error;
import com.paras.framework.validation.base.Validation;
import com.paras.framework.validation.base.ValidationCriteria;

/**
 * Validator will validate a value against passed validation type.
 * 
 * @author Paras.
 * 
 */
public class Validator {
    
    private static final String GENERIC_MAX_LENGTH_ERROR_MESSAGE = "Value must be less than {{0}} characters.";
    private static final String GENERIC_MIN_LENGTH_ERROR_MESSAGE = "Value must be more than {{0}} characters.";
    private static final String PLACEHOLDER = "{{0}}";
    /**
     * Value to be validated.
     */
    private String value;
    
    /**
     * Form field name or, in case of angular, key for the ng-model.
     */    
    private String fieldNameInForm;
    
    /**
     * Validation type against which passed value will be validated.
     */
    private Validation validation;
    
    /**
     * Create a new Validator.
     
     * @param value Value to be validated.
     * @fieldName Form field name or, in case of angular, key for the ng-model.
     * @validation Validation type against which passed value will be validated.
     */
    public Validator( String value, String fieldName, Validation validation ) {
        this.value = value;
        this.fieldNameInForm = fieldName;
        this.validation = validation;
    }
    
    /**
     * Validate value against passed validation.
     */
    public Error validate() {
    	Error error = null;
        
        int minLengthAllowed = validation.getMinLength();
        int maxLengthAllowed = validation.getMaxLength();
        
        /* Mandatory Check */
        if( validation.isMandatory() && StringUtils.isEmpty( value )) {
            error = new Error( fieldNameInForm, ValidationCriteria.MANDATORY, validation.getMandatoryErrorMessage());
        }
        /* Regex Check */
        else if( StringUtils.isNotEmpty( value ) && null != validation.getRegex() ) {
        	
        	Pattern pattern = validation.getRegex();
        	Matcher matcher = pattern.matcher( value );
        	
        	if( !matcher.find() ) {
                error = new Error( fieldNameInForm, ValidationCriteria.REGEX, validation.getRegexErrorMessage() );
            }        	
        }
        
        /* Max And Min Length Check */
        if( StringUtils.isNotEmpty( value )) {
            
            if( maxLengthAllowed != 0 && value.length() > maxLengthAllowed ) {
                error = new Error( fieldNameInForm, ValidationCriteria.MAX_LENGTH, getMaxLengthErrorMessage( maxLengthAllowed ));
            }
            
            if( minLengthAllowed != 0 && value.length() < minLengthAllowed ) {
                error = new Error( fieldNameInForm, ValidationCriteria.MIN_LENGTH, getMinLengthErrorMessage( minLengthAllowed ));
            }
            
        } else {
            
            /* We have an empty string here. */
            if( minLengthAllowed != 0 )  {
                error = new Error( fieldNameInForm, ValidationCriteria.MIN_LENGTH, getMinLengthErrorMessage( minLengthAllowed ));
            }

        }
    	
    	return error;
    }
                                  
    private static String getMaxLengthErrorMessage( int maxLength ) {
        return StringUtils.replace( GENERIC_MAX_LENGTH_ERROR_MESSAGE, PLACEHOLDER, String.valueOf( maxLength ));
    }
    
    private static String getMinLengthErrorMessage( int minLength ) {
    	return StringUtils.replace( GENERIC_MIN_LENGTH_ERROR_MESSAGE, PLACEHOLDER, String.valueOf( minLength ));
    }

	public String getFieldNameInForm() {
		return fieldNameInForm;
	}
	
	public String getValue() {
		return value;
	}
}
