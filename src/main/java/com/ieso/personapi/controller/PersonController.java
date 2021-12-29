/**
 * 
 */
package com.ieso.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@GetMapping
	public String getBook() {
		return "Api test";
	}

}
