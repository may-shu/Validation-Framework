package com.paras.framework.validation;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paras.framework.validation.base.Validation;

/**
 * Bean to read a config file and create appropriate Validation type and add it to a map.
 * 
 * @author Paras
 */
public class ValidationMap {
	
    /**
     * Validation map to contain key value of validations.
     * */
	private static Map<String, Validation> validationMap;
	
	private static Logger LOGGER = Logger.getLogger( ValidationMap.class );
	
	/**
	 * JSON file path.
	 * File should contain key value pair of validations.
	 */
	private String configFilePath;
	
    /**
     * Init method to read a JSON file and create a map automatically.
     */
	public void init() {
		
		try{
			InputStream confStream = getClass().getClassLoader().getResourceAsStream( configFilePath );
			
			JsonFactory factory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper( factory );
			
			TypeReference<HashMap<String, Validation>> typeRef = new TypeReference<HashMap<String, Validation>>() {};
			validationMap = mapper.readValue( confStream, typeRef );
		}
		catch( IOException ex ){ 
			LOGGER.error( "In ValidationsMap | IOException Caught | " + ex.getMessage() );
		}		
	}
	
    /**
     * Get A Validation Type for key.
     */
	public static Validation getValidation( String key ) {
		return validationMap.get( key );
	}
	
    /**
     * Add a validation to map.
     */
	public static void setValidation( String key, Validation validation ) {
		validationMap.put( key,  validation );
	}

	public String getConfigFilePath() {
		return configFilePath;
	}

	public void setConfigFilePath(String configFilePath) {
		this.configFilePath = configFilePath;
	}
}
