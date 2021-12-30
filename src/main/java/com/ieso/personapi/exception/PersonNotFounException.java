/**
 * 
 */
package com.ieso.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Anderson dos Reis Santos
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFounException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFounException(Long id) {
		super("Person not found with ID: "+id);
	}

}
