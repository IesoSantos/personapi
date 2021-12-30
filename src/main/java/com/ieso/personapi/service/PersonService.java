/**
 * 
 */
package com.ieso.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ieso.personapi.dto.response.MessageResponseDTO;
import com.ieso.personapi.entity.Person;
import com.ieso.personapi.repository.PersonRepository;

import lombok.AllArgsConstructor;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
@AllArgsConstructor
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public MessageResponseDTO createPerson(Person person) {
		personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Create person with id: "+person.getId())
				.build();
	}
}
