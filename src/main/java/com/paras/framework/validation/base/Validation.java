package com.paras.framework.validation.base;

import java.util.regex.Pattern;

/**
 * Validation Model for a validation type.
 * Example -> EmailValidatin, PhoneNumber Validation.
 * 
 * @author Paras.
 */

public class Validation {
	
	private static final boolean MANDATORY = false;
    
    private static final int MAXIMUM_DEFAULT = 100;
    private static final int MINIMUM_DEFAULT = 0;
    
    private static final String MANDATORY_ERROR_MESSAGE = "Value must be provided.";
    private static final String REGEX_ERROR_MESSAGE = "Invalid value provided.";    

    /**
     * Is the provided field is mandatory.
     * If it is mandatory, it can neither be null or empty.
     */
    private boolean mandatory;
    
    
    /**
     * Regex to validate against.
     */
    private Pattern regex;
    
    /**
     * Minimum length required for the value.
     * Default to 0.
     */
    private int minLength;
    
    /**
     * Maximum length allowed for the value.
     */
    private int maxLength;
    
    /**
     * Error Message to be used when value is either null or empty.
     */
    private String mandatoryErrorMessage;
    
    /**
     * Error Message to be used when value has failed regex validation.
     */
    private String regexErrorMessage;
    
    /**
     * Create a blank validation type.
     */
    public Validation() {
        
    }
    
    /**
     * Create a new validation type with default settings for error messages, minimum length and maximum lengths.
     * 
     * @param mandatory Is field mandatory ?
     * @param regex Regex to validate against.
     */
    public Validation( boolean mandatory, Pattern regex ) {
        this( mandatory, MANDATORY_ERROR_MESSAGE, regex, REGEX_ERROR_MESSAGE, MINIMUM_DEFAULT, MAXIMUM_DEFAULT );
    }
    
    /**
     * Create a new Validatin type width default settings for mandatory, error messages and minimum length.
     * 
     * @param regex Regex to validate against.
     * @param maxLength Maximum Length allowed.
     */
    public Validation( Pattern regex, int maxLength ) {
    	this( MANDATORY, MANDATORY_ERROR_MESSAGE, regex, REGEX_ERROR_MESSAGE, MINIMUM_DEFAULT, maxLength );
    }
    
    /**
     * Create a new Validation type with default settings for minimum and maximum length.
     *
	 * @param mandatory Is field mandatory ?
     * @param mandatoryMessage Mandatory Error Message to be used.
     * @param regex Regex to validate against.
     * @param regexErrorMessage Error Message to be used in case of Regex Validation Failure.
     */
    public Validation( boolean mandatory, String mandatoryErrorMessage, Pattern regex, String regexErrorMessage ) {
    	this( mandatory, mandatoryErrorMessage, regex, regexErrorMessage, MINIMUM_DEFAULT, MAXIMUM_DEFAULT );
    }
    
    
    /**
     * Create a new validation type.
     * 
     * @param mandatory Is field mandatory ?
     * @param mandatoryMessage Mandatory Error Message to be used.
     * @param regex Regex to validate against.
     * @param regexErrorMessage Error Message to be used in case of Regex Validation Failure.
     * @param minLength Minimum Length required.
     * @param maxLength Maximum Length allowed.
     */
    public Validation( boolean mandatory, String mandatoryMessage, Pattern regex, String regexErrorMessage, int minLength, int maxLength ) {
        this.mandatory = mandatory;
        this.mandatoryErrorMessage = mandatoryMessage;
        
        this.regex = regex;
        this.regexErrorMessage = regexErrorMessage;
        
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Pattern getRegex() {
		return regex;
	}

	public void setRegex(Pattern regex) {
		this.regex = regex;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getMandatoryErrorMessage() {
		return mandatoryErrorMessage;
	}

	public void setMandatoryErrorMessage(String mandatoryErrorMessage) {
		this.mandatoryErrorMessage = mandatoryErrorMessage;
	}

	public String getRegexErrorMessage() {
		return regexErrorMessage;
	}

	public void setRegexErrorMessage(String regexErrorMessage) {
		this.regexErrorMessage = regexErrorMessage;
	}
}