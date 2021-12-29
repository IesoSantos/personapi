/**
 * 
 */
package com.ieso.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ieso.personapi.entity.Person;
import com.ieso.personapi.repository.PersonRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	
	private PersonRepository repository;
	
	@Autowired
	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}


	@PostMapping
	public String createPerson(@RequestBody Person person) {
		repository.save(person);
		return "Api test";
	}

}
