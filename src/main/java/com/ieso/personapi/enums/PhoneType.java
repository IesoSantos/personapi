/**
 * 
 */
package com.ieso.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Getter
@AllArgsConstructor
public enum PhoneType {

	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;
}
