/**
 * 
 */
package com.ieso.personapi.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieso.personapi.dto.PersonDTO;
import com.ieso.personapi.dto.response.MessageResponseDTO;
import com.ieso.personapi.entity.Person;
import com.ieso.personapi.exception.PersonNotFounException;
import com.ieso.personapi.mapper.PersonMapper;
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
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Create person with ID: "+savedPerson.getId())
				.build();
	}
	
	
	public List<PersonDTO> listAll(){
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}


	public PersonDTO findById(Long id) throws PersonNotFounException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
		/*
		Optional<Person> optionalPerson =  personRepository.findById(id);
		if(optionalPerson.isEmpty()) {
			throw new PersonNotFounException(id);
		}
		return personMapper.toDTO(optionalPerson.get());
		*/
	}


	private Person verifyIfExists(Long id) throws PersonNotFounException {
		return personRepository.findById(id)
		.orElseThrow(() -> new PersonNotFounException(id) );
	}


	public void delete(Long id) throws PersonNotFounException {
		verifyIfExists(id);
		personRepository.deleteById(id);;		
	}
	
	
}
