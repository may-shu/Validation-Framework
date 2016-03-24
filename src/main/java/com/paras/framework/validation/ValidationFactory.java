package com.paras.framework.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.paras.framework.validation.base.Error;

/**
 * Validation Factory to accept a list of Validators and return list of errors in case of any error.
 * 
 * @author Paras.
 */
public class ValidationFactory {

	private static Logger LOGGER = Logger.getLogger( ValidationFactory.class );
	
	/**
	 * List of validators.
	 */
	private List<Validator> validators;

	/**
	 * Validate a list of validators.
	 * @return list of errors if there are any.
	 */
	public static List<Error> validate( List<Validator> validators ) {

		List<Error> errors = null;

		if( null == validators || validators.isEmpty() ) {
			return errors;
		} else {

			errors = new ArrayList<Error>();
			
			for( Validator validator : validators ) {
				LOGGER.info( "In ValidationFactory | Starting validation for " + validator.getFieldNameInForm());
				Error error = validator.validate();
				
				if( null != error ) {
					LOGGER.info( "In ValidationFactory | Caught Validation Error for " + validator.getFieldNameInForm() + " with value " + validator.getValue() + " | Failed In " + error.getCriteria().toString() );
					errors.add( error );
				}
				
				LOGGER.info( "In ValidationFactory | Finished validation for " + validator.getFieldNameInForm());
			}
			
			if( errors.isEmpty() ) {
				return null;
			}

		}

		if( errors.isEmpty() ) {
			return null;
		}
		
		return errors;

	}
	
	/**
	 * Add Validators to factory to be validated.
	 * @param validators
	 */
	public void add( Validator ... validators ) {
		
		if( this.validators == null ) {
			this.validators = new ArrayList<Validator>();
		}
		
		for( Validator validator : validators ) {
			this.validators.add( validator );
		}
	}
	
	/**
	 * Validate the entries passed.
	 */
	public List<Error> validate() {
		return ValidationFactory.validate( this.validators );
	}
}