/**
 * 
 */
package com.ieso.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieso.personapi.dto.PersonDTO;
import com.ieso.personapi.dto.response.MessageResponseDTO;
import com.ieso.personapi.exception.PersonNotFoundException;
import com.ieso.personapi.service.PersonService;

import lombok.AllArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
	
	private PersonService personService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) 
			throws PersonNotFoundException {
		return personService.updateById(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);
	}
}
