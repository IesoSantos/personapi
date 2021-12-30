/**
 * 
 */
package com.ieso.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieso.personapi.dto.PersonDTO;
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
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		personRepository.save(personDTO);
		return MessageResponseDTO
				.builder()
				.message("Create person with id: "+personDTO.getId())
				.build();
	}
}
